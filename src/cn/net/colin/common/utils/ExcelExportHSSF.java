package cn.net.colin.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 导出excel2003封装类
 * response设置如下：
 * 			String filename = "用户报表("+DateUtils.getDateStr(new Date(), "yyyyMMddHH")+").xls";//导出excel2003
 * 			filename = new String(filename.getBytes("gbk"),"iso-8859-1");
 * 			//重置输出流，该代码可以不加，但是一定要保证response缓冲区中不能存放任何数据，否则数据结果会有问题
 *			response.reset();
 *			//设置头信息
 *			response.setContentType("application/vnd.ms-excel");//导出excel2003
 *			response.setHeader("Content-disposition", "attachement;filename="+filename);
 *			response.setBufferSize(1024);
 * ClassName:ExcelExportHSSF
 *
 * @author   邵晓方
 * @version  
 * @since    Ver 1.1
 * @Date	 2015	2015-9-17		下午05:53:17
 *
 * @see
 */
public class ExcelExportHSSF {
	// 定义工作表
		private HSSFWorkbook  wb;

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

		private ExcelExportHSSF() {

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
		 *            存放在内存的数据量
		 * @param dataList
		 * 			要导出的数据集合
		 * @param sheetSize
		 * 			Excel每个工作簿的行数
		 * @return
		 */
		public static ExcelExportHSSF start(String filePath,String filePrefix,
				List<String> fieldNames,List<String> fieldCodes, List<Map<String, Object>> dataList,int sheetSize) throws Exception {
			ExcelExportHSSF excelExportSXXSSF = new ExcelExportHSSF();
			excelExportSXXSSF.setFilePath(filePath);
			excelExportSXXSSF.setFilePrefix(filePrefix);
			excelExportSXXSSF.setFieldNames(fieldNames);
			excelExportSXXSSF.setFieldCodes(fieldCodes);
			excelExportSXXSSF.setWb(new HSSFWorkbook ());//创建workbook
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
			for (int cellnum = 0; cellnum < colnum; cellnum++) {
				Cell cell = row.createCell(cellnum);
				cell.setCellValue(fieldNames.get(cellnum));
			}
		}
		
		/**
		 * 向导出文件写数据
		 * 
		 * @param datalist  需要导出的数据集合
		 * @param sheetSize 每页sheet行数
		 *            存放Object对象，仅支持单个自定义对象，不支持对象中嵌套自定义对象
		 * @return
		 */
		public void writeDatasByMap(List<Map<String, Object>> datalist,int sheetSize,ExcelExportHSSF excelExportSXXSSF) throws Exception {
			int rows = datalist.size();
			int sheetNum = 0;           //指定sheet的页数
			if (rows % sheetSize == 0) {
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
						cell.setCellValue(datalist.get(j).get(fieldCodes.get(cellnum)).toString());
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
			String filename = filePrefix+"_"+new Date().getTime() + ".xls";
			wb.write(out);
			out.flush();
			out.close();
			setFileAllPath(filePath + filename);
			return filePath + filename;
		}
		/**
		 * @author liwenjian 2017年4月1日 12:00:14
		 * @param excelPath 导入的excel的路径
		 * @param names excel内字段
		 * @return List<Map<String,Object>>
		 */
		public static List<Map<String,Object>> readXls(String excelPath,List<String>names){
			try{
				InputStream is=new FileInputStream(excelPath);
				XSSFWorkbook hssfWorkbook=new XSSFWorkbook(is);
				List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
				// 循环工作表Sheet
				for(int numSheet=0;numSheet<hssfWorkbook.getNumberOfSheets();numSheet++){
					XSSFSheet hssfSheet=hssfWorkbook.getSheetAt(numSheet);
					if(hssfSheet==null){
						continue;
					}
					// 循环行Row
					for(int numRow=1;numRow<=hssfSheet.getLastRowNum();numRow++){
						XSSFRow hssfRow=hssfSheet.getRow(numRow);
						if(hssfRow==null){
							continue;
						}
						Map<String,Object>map=new HashMap<String, Object>();
						for(int i=0;i<names.size();i++){
							map.put(names.get(i),hssfRow.getCell(i));
						}
//						Set<String> key=map.keySet();
//						for (String s : key) {
//							System.out.println(s+"----"+map.get(s));
//						}
						mapList.add(map);
					}
				}
				return mapList;
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * @author ygf
		 * @param excelPath 导入的excel的路径
		 * @param 
		 * @return excel信息内容
		 */
		public static List<Map<String,Object>> readXlsMessage(String excelPath) {
			List<String> listName=new ArrayList<String>();
			List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
			try{
				XSSFWorkbook workbook = new XSSFWorkbook(
						new FileInputStream(excelPath));
				
				
				if(new File(excelPath).exists()){
					for (int j = 0; j < 1; j++) {
						// 工作簿
						XSSFSheet sheet = workbook.getSheetAt(j);
						//String sheetName = sheet.getSheetName();
						
						XSSFRow row = sheet.getRow(j);
						for(int i=0;i<10;i++){
							Map<String,Object> map=new HashMap<String, Object>();
							XSSFCell cell = row.getCell(i);
		                    if(cell != null){      //错误就在这里,当单元格为空时抛出空指针...
		                    	String lable =String.valueOf(row.getCell(i).getStringCellValue());
								//System.out.println(name0);
								if(lable != null && lable.equals("#date#")){
									map.put("WORKDATE", i);
								}
								if(lable != null && lable.equals("#person#")){
									map.put("USERNAME", i);
								}
								if(lable != null && lable.equals("#posts#")){
									map.put("JOBNAME", i);
								}
							}
		                    if(map != null && map.size()>0){
		                    	mapList.add(map);
		                    }
		                 }
							
					}
					return mapList;
				}
				
				
			}catch (Exception e) {
				System.out.println("配置Excel");
			}
			return null;
		}
		
		public HSSFWorkbook  getWb() {
			return wb;
		}

		public void setWb(HSSFWorkbook  wb) {
			this.wb = wb;
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
