package cn.net.colin.common.utils;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * 导出excel2007封装类(解决了大数据报内存溢出的问题)
 * response设置如下：
 * 			String filename = "用户报表("+DateUtils.getDateStr(new Date(), "yyyyMMddHH")+").xlsx";
 * 			filename = new String(filename.getBytes("gbk"),"iso-8859-1");
 * 			response.setContentType("application/x-xls");//导出excel2007
 *			response.setHeader("Content-disposition", "attachement;filename="+filename);
 *			//重置输出流，该代码可以不加，但是一定要保证response缓冲区中不能存放任何数据，否则数据结果会有问题
 *			response.reset();
 *			response.setBufferSize(1024);
 *			
 * ClassName:ExcelExportSXXSSF
 *
 * @author   邵晓方
 * @version  
 * @since    Ver 1.1
 * @Date	 2015	2015-9-17		下午05:53:48
 *
 * @see
 */
public class ExcelExportSXXSSF {
	// 定义工作表
		private SXSSFWorkbook wb;

		/**
		 * 定义保存在内存中的数量,-1表示手动控制
		 */
		private int flushRows;
		/** 导出文件行数 */
		private int rownum;
		/** 导出文件列数 */
		private int colnum;

		/** 导出文件的存放路径 */
		private String filePath;
		/**文件名称前缀*/
		private String filePrefix;
		/**导出文件全路径*/
		private String fileAllPath;
		/** 导出文件列标题 */
		private List<String> fieldNames;
		/**导出文件每列代码，用于反射获取对象属性值*/
		private List<String> fieldCodes;

		private ExcelExportSXXSSF() {

		}
		
		
		/**
		 * 开始导出方法
		 * 
		 * @param filePath
		 *            导出文件存放物理路径
		 * @param filePrefix
		 *            导出文件名的前缀          
		 * @param fieldNames
		 *            导出文件列标题
		 * @param fieldCodes
		 * 			  导出数据对象的字段名称 
		 * @param flushRows
		 *            存放在内存的数据量    
		 * @param dataList
		 * 			要导出的数据集合
		 * @param sheetSize
		 * 			Excel每个工作簿的行数
		 * @return
		 */
		public static ExcelExportSXXSSF start(String filePath,String filePrefix,
				List<String> fieldNames,List<String> fieldCodes, int flushRows,List<Map<String, Object>> dataList,int sheetSize) throws Exception {
			ExcelExportSXXSSF excelExportSXXSSF = new ExcelExportSXXSSF();
			excelExportSXXSSF.setFilePath(filePath);
			excelExportSXXSSF.setFilePrefix(filePrefix);
			excelExportSXXSSF.setFieldNames(fieldNames);
			excelExportSXXSSF.setFieldCodes(fieldCodes);
			excelExportSXXSSF.setWb(new SXSSFWorkbook(flushRows));//创建workbook
			excelExportSXXSSF.writeDatasByMap(dataList, sheetSize, excelExportSXXSSF);
			return excelExportSXXSSF;
		}
		
		/**
		 * 设置导入文件的标题
		 * 开始生成导出excel的标题
		 * @throws Exception
		 */
		private void writeTitles(Sheet sh) throws Exception {
			rownum = 0;//第0行
			colnum = fieldNames.size();//根据列标题得出列数
			Row row = sh.createRow(rownum);
			//mod by sxf 给表头cell添加样式，设置自适应宽度
			CellStyle headerStyle = writeStyle(this.getWb(),sh,row);
			for (int cellnum = 0; cellnum < colnum; cellnum++) {
				Cell cell = row.createCell(cellnum);
				cell.setCellValue(fieldNames.get(cellnum));
				cell.setCellStyle(headerStyle);
				//sh.autoSizeColumn(cellnum);
				sh.setColumnWidth(cellnum,sh.getColumnWidth(cellnum)*30/10);
			}
		}

	/**
	 * add by sxf 添加表头样式
	 * @param workbook
	 * @param sheet
	 * @param header
	 * @return
	 */
		public  CellStyle writeStyle(SXSSFWorkbook workbook,Sheet sheet,Row header ){
			//SXSSFWorkbook workbook = excelExportSXXSSF.getWb();
			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			// 字体样式
			Font font = workbook.createFont();
			font.setFontName("Arial");
			font.setFontHeightInPoints((short) 14);
			headerStyle.setFont(font);
			headerStyle.setBorderBottom((short)1); //下边框
			headerStyle.setBorderLeft((short)1);//左边框
			headerStyle.setBorderTop((short)1);//上边框
			headerStyle.setBorderRight((short)1);//右边框
			headerStyle.setFillForegroundColor((short)13);
			headerStyle.setFillPattern(HSSFCellStyle.SPARSE_DOTS);
			return headerStyle;
		}
		/**
		 * 向导出文件写数据
		 * 
		 * @param datalist  需要导出的数据集合
		 * @param sheetSize 每页sheet行数
		 *            存放Object对象，仅支持单个自定义对象，不支持对象中嵌套自定义对象
		 * @return
		 */
		public void writeDatasByMap(List<Map<String, Object>> datalist,int sheetSize,ExcelExportSXXSSF excelExportSXXSSF) throws Exception {
			int rows = datalist.size();
			int sheetNum = 0;           //指定sheet的页数
			//add by sxf 如果rows为0 则sheet默认为1
			if(rows == 0){
				sheetNum = 1;
			} else if (rows % sheetSize == 0) {
						sheetNum = rows / sheetSize;
					} else {
						sheetNum = rows / sheetSize + 1;
					}
			for (int i = 1; i <= sheetNum; i++) {
				Sheet sh = excelExportSXXSSF.getWb().createSheet("sheet"+i);//创建sheet
				excelExportSXXSSF.writeTitles(sh);
				for (int j = (i-1)*sheetSize; j < datalist.size(); j++) {
					rownum = rownum + 1;
					if (rownum > sheetSize) {//行数大于定义好的每个sheet的行数
						break;//跳出此循环，重新创建一个sheet写入记录
					}
					Row row = sh.createRow(rownum);
					for (int cellnum = 0; cellnum < fieldCodes.size(); cellnum++) {
						Cell cell = row.createCell(cellnum);
						if (datalist.get(j).get(fieldCodes.get(cellnum)) == null) {
							cell.setCellValue("");
						}else {
							cell.setCellValue(datalist.get(j).get(fieldCodes.get(cellnum)).toString());
						}
					}
					
				}
			}
		}
		
		/**
		 * 手动刷新方法,如果flushRows为-1则需要使用此方法手动刷新内存
		 * 
		 * @throws Exception
		 */
		public void flush(int flushNum,Sheet sh) throws Exception {
			((SXSSFSheet) sh).flushRows(flushNum);
		}

		/**
		 * 导出文件
		 * 
		 * @throws Exception
		 */
		public String exportFile(OutputStream out) throws Exception {			
			String filename = filePrefix+"_"+new Date().getTime() + ".xlsx";
			wb.write(out);
			out.flush();
			out.close();
			//wb.dispose();//清理临时文件
			setFileAllPath(filePath + filename);
			return filePath + filename;
		}

		public SXSSFWorkbook getWb() {
			return wb;
		}

		public void setWb(SXSSFWorkbook wb) {
			this.wb = wb;
		}

		public int getFlushRows() {
			return flushRows;
		}

		public void setFlushRows(int flushRows) {
			this.flushRows = flushRows;
		}

		public int getRownum() {
			return rownum;
		}

		public void setRownum(int rownum) {
			this.rownum = rownum;
		}

		public int getColnum() {
			return colnum;
		}

		public void setColnum(int colnum) {
			this.colnum = colnum;
		}

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}

		public String getFilePrefix() {
			return filePrefix;
		}

		public void setFilePrefix(String filePrefix) {
			this.filePrefix = filePrefix;
		}

		public String getFileAllPath() {
			return fileAllPath;
		}

		public void setFileAllPath(String fileAllPath) {
			this.fileAllPath = fileAllPath;
		}

		public List<String> getFieldNames() {
			return fieldNames;
		}

		public void setFieldNames(List<String> fieldNames) {
			this.fieldNames = fieldNames;
		}

		public List<String> getFieldCodes() {
			return fieldCodes;
		}

		public void setFieldCodes(List<String> fieldCodes) {
			this.fieldCodes = fieldCodes;
		}
		

}
