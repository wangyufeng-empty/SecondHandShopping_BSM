package cn.net.colin.common.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by sxf on 2019-6-28.
 */
public class ExcelUtils {
	private static int rownum = 0;  //当前行数
	
    //使用poi，用java实现清除excel工作簿内容之间空行
    public static void delLineNull(Workbook workbook, String Outpath) {
        System.out.println("开始移除空行操作");
        int key = 0;
        int MaxRowNum = 0,MaxCellNum = 0;
        try {
            FileOutputStream out = new FileOutputStream(Outpath);
                Sheet sheet = workbook.getSheetAt(0); //14
                MaxRowNum = 0;
                for (int k = 0; k <= sheet.getLastRowNum(); k++) {
                    Row hRow = sheet.getRow(k);
                    //System.out.println((k + 1) + "行");
                    if (isBlankRow(hRow)) // 找到空行索引
                    {
                        int m = 0;
                        for (m = k + 1; m <= sheet.getLastRowNum(); m++) {
                            Row nhRow = sheet.getRow(m);
                            if (!isBlankRow(nhRow)) {
                                //System.out.println("下一个非空行" + (m + 1));
                                sheet.shiftRows(m, sheet.getLastRowNum(), k - m);
                                break;
                            }
                        }
                        if (m > sheet.getLastRowNum())
                            break; // 此工作簿完成
                    } else { //非空行
                        MaxRowNum ++;
                        if(MaxCellNum < hRow.getLastCellNum())
                            MaxCellNum = hRow.getLastCellNum();
                    }
                }
                workbook.setPrintArea(0, 0, MaxCellNum, 0, MaxRowNum);
            workbook.write(out);
            out.close();
        }catch (IOException e) {
            System.out.println(key+" "+e.getMessage()+" ");
            e.printStackTrace();

        }
    }
    /**
     * 判断excel 空行
     */
    public static boolean isBlankRow(Row row) {
        if (row == null)
            return true;
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            Cell hcell = row.getCell(i);
            if (!isBlankCell(hcell))
                return false;
        }
        return true;
    }
    public static boolean isBlankCell(Cell hcell) {
        if (hcell == null)
            return true;
        hcell.setCellType(hcell.CELL_TYPE_STRING);
        String content = hcell.getStringCellValue().trim();
        if (content == null || "".equals(content)) // 找到非空行
        {
            return true;
        }
        return false;
    }
    
    
    /**
	 * 基本导出,直接将文件流写入前台
	 * @param titleList  每一列的标题 例如:[站点名,站号,要素]
	 * @param fileTitle  文件的大标题(合并单元格) 例如:xxx-xxx气温实况  为null的时候没有标题
	 * @param sortList   数据顺序,对应数据集合里map的key   [stationname,stationnum,element]
	 * @param dataList	  数据集合
	 * @param fileName   导出文件名(不加后缀)
	 * @param fixedPosition   固定位置的横纵坐标 (固定前一行坐标为 0,1,固定前一行前二列坐标为 2,1)  为null或""不固定
	 * @param response   
	 */
	public static void exportXls(List<String> titleList,String fileTitle,List<String> sortList,List<Map<String, Object>> dataList,
			String fileName,String fixedPosition,HttpServletResponse response){
		try {
			XSSFWorkbook book = createExcel(titleList,fileTitle,sortList,dataList,fixedPosition);
			rownum=0;
			response.setContentType("APPLICATION/OCTET-STREAM");
			response.setHeader(
					"Content-Disposition",
					"attachment; filename="
							+ new String((fileName).getBytes("gbk"),
									"iso-8859-1") + ".xls");
			book.write(response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 导出,直接将文件流写入前台(可设置每列的宽度和每列(除标题)是水平居中还是左对齐等)
	 * @param titleList  每一列的标题 例如:[站点名,站号,要素]
	 * @param fileTitle  文件的大标题(合并单元格) 例如:xxx-xxx气温实况  为null的时候没有标题
	 * @param sortList   数据顺序,对应数据集合里map的key   [stationname,stationnum,element]
	 * @param dataList	  数据集合
	 * @param fileName   导出文件名(不加后缀)
	 * @param fixedPosition   固定位置的横纵坐标 (固定前一行坐标为 0,1,固定前一行前二列坐标为 2,1)  为null或""不固定
	 * @param columnWidth 列宽  (每列的宽度  如:{3000,4000,8000,5000,3000})
	 * @param columnStyle 列样式(目前只有居中,左对齐,右对齐{center,center,left,center,right})
	 * @param response   
	 */
	public static void exportXls(List<String> titleList,String fileTitle,List<String> sortList,List<Map<String, Object>> dataList,
			String fileName,String fixedPosition,List<Integer> columnWidth,List<String> columnStyle,HttpServletResponse response){
		try {
			XSSFWorkbook book = createExcel(titleList,fileTitle,sortList,dataList,fixedPosition,columnWidth,columnStyle);
			rownum=0;
			response.setContentType("APPLICATION/OCTET-STREAM");
			response.setHeader(
					"Content-Disposition",
					"attachment; filename="
							+ new String((fileName).getBytes("gbk"),
									"iso-8859-1") + ".xls");
			book.write(response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static XSSFWorkbook createExcel(List<String> titleList,String fileTitle,List<String> sortList,List<Map<String, Object>> dataList,String fixedPosition) {

		try {
			XSSFWorkbook book = createExcelHead(titleList,fileTitle);
			if (dataList == null)
				return book;
			XSSFSheet sheet = book.getSheet("work");
			sheet.setColumnWidth(0, 5000);
			sheet.setColumnWidth(1, 4200);
			sheet.setColumnWidth(2, 2500);
			sheet.setColumnWidth(3, 2500);
			if(fixedPosition!=null&&!"".equals(fixedPosition)){
				String[] fixedPositionArr = fixedPosition.split(",");
				Integer x = Integer.parseInt(fixedPositionArr[0]);
				Integer y = Integer.parseInt(fixedPositionArr[1]);
				sheet.createFreezePane(x,y,x,y);
			}
			XSSFCellStyle style;
			style = book.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
//			style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
//			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
//			style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
//			style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
			XSSFCell cell_temp;
			XSSFRow row = null;
			//int i = rownum;
			for (Map<String, Object> ls : dataList) {
				/*row = sheet.createRow(i);
				cell_temp = row.createCell((short) 0);
				cell_temp.setCellValue(ls.get("dateString")+"");*/
				row = sheet.createRow(rownum);
				for (int j = 0; j < sortList.size(); j++) {
					cell_temp = row.createCell((short) j);
					// 应用样式
					cell_temp.setCellStyle(style);
					String meth = "";
					if(ls.get(sortList.get(j))!=null){
						meth = String.valueOf(ls.get(sortList.get(j)));
					}
					cell_temp.setCellValue(meth);
				}
				rownum++;
			}
			return book;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static XSSFWorkbook createExcelHead(List<String> titleList,String fileTitle) {
		// 创建工作空间
		XSSFWorkbook book = new XSSFWorkbook();
		// 创建excel页
		XSSFSheet sheet = book.createSheet("work");
		// 单元格样式
		XSSFCellStyle style;
		// 字体样式
		XSSFFont font;
		if(fileTitle!=null&&!"".equals(fileTitle)){
			// 创建excel标题
			XSSFRow title1 = sheet.createRow(rownum);
			title1.setHeight((short) 1000);
			style = book.createCellStyle();
			style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 水平居中
			style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			font = book.createFont();
//			style.setBorderBottom(XSSFCellStyle.BORDER_THIN); // 下边框
//			style.setBorderLeft(XSSFCellStyle.BORDER_THIN);// 左边框
//			style.setBorderTop(XSSFCellStyle.BORDER_THIN);// 上边框
//			style.setBorderRight(XSSFCellStyle.BORDER_THIN);// 右边框
			font.setFontHeightInPoints((short) 14);// 设置字体大小
			style.setFont(font);

			sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 0,
					(short) (titleList.size()-1)));
			XSSFCell cell_0_0 = title1.createCell((short) 0);
			// 应用样式
			cell_0_0.setCellStyle(style);
			cell_0_0.setCellValue(fileTitle);
			rownum++;  //行数加一
		}

		// 创建excel头
		XSSFRow head1 = sheet.createRow(rownum);
		head1.setHeight((short) 400);

		style = book.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
		font = book.createFont();
//		style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
//		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
//		style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
//		style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		font.setFontHeightInPoints((short) 12);// 设置字体大小
		style.setFont(font);
		// 为excel头的第一行设置列定义
		for (int i = 0; i < titleList.size(); i++) {
			XSSFCell cell = head1.createCell((short) i);
			// 应用样式
			cell.setCellStyle(style);
			cell.setCellValue(titleList.get(i));
		}
		rownum++;  //行数加一
		return book;
	}
	
	
	private static XSSFWorkbook createExcel(List<String> titleList,String fileTitle,List<String> sortList,
			List<Map<String, Object>> dataList,String fixedPosition,List<Integer> columnWidth,List<String> columnStyle) {

		try {
			XSSFWorkbook book = createExcelHead(titleList,fileTitle);
			if (dataList == null)
				return book;
			XSSFSheet sheet = book.getSheet("work");
			if(columnWidth!=null&&columnWidth.size()>0){
				for (int i = 0; i < columnWidth.size(); i++) {
					sheet.setColumnWidth(i, columnWidth.get(i));
				}
			}else{
				sheet.setColumnWidth(0, 5000);
				sheet.setColumnWidth(1, 4200);
				sheet.setColumnWidth(2, 2500);
				sheet.setColumnWidth(3, 2500);
			}
			if(fixedPosition!=null&&!"".equals(fixedPosition)){
				String[] fixedPositionArr = fixedPosition.split(",");
				Integer x = Integer.parseInt(fixedPositionArr[0]);
				Integer y = Integer.parseInt(fixedPositionArr[1]);
				sheet.createFreezePane(x,y,x,y);
			}
			if(columnStyle==null){ //如果传过来为null防止空指针在这里创建个空的集合
				columnStyle = new ArrayList<String>();
			}
			XSSFCell cell_temp;
			XSSFRow row = null;
			//int i = rownum;
			for (Map<String, Object> ls : dataList) {
				/*row = sheet.createRow(i);
				cell_temp = row.createCell((short) 0);
				cell_temp.setCellValue(ls.get("dateString")+"");*/
				row = sheet.createRow(rownum);
				for (int j = 0; j < sortList.size(); j++) {
					cell_temp = row.createCell((short) j);
					// 应用样式
					if(j>columnStyle.size()-1){//当前列数j比样式集合的长度要大,为了防止索引越界,给默认样式center
						cell_temp.setCellStyle(getXssStyle(book,"center"));
					}else{
						cell_temp.setCellStyle(getXssStyle(book,columnStyle.get(j)));
					}
					String meth = "";
					if(ls.get(sortList.get(j))!=null){
						meth = String.valueOf(ls.get(sortList.get(j)));
					}
					cell_temp.setCellValue(meth);
				}
				rownum++;
			}
			return book;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取列样式
	 * @param book
	 * @param type  样式类型   center:居中  ; left:左对齐 ;right:右对齐
	 * @return
	 */
	private static XSSFCellStyle getXssStyle(XSSFWorkbook book, String type){
		XSSFCellStyle style;
		style = book.createCellStyle();
		//因为jdk1.7之前,switch语句不支持String,所以在此用if
		if("center".equals(type)){  //居中
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			style.setWrapText(true); //单元格自动换行
		}else if("left".equals(type)){  //左对齐
			style.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 水平居中
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			style.setWrapText(true); //单元格自动换行
		}else if("right".equals(type)){  //右对齐
			style.setAlignment(HSSFCellStyle.ALIGN_RIGHT); // 水平居中
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			style.setWrapText(true); //单元格自动换行
		}else{
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
			style.setWrapText(true); //单元格自动换行
		}
		return style;
	}
    
}
