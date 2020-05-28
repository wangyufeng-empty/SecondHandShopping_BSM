package cn.net.colin.common.utils;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class ExportExcelKit {
    /**
     * 导出Excel工具包
     * 需要Map<String, String> title， Map<String, Integer> position, List<Map<String, Object>> data，
     * String sheetName, OutputStream outputStream
     * title: 表格列头
     * position: 表头列的位置
     * data: 数据集合，对象数据需要转为Map<k, v>
     * sheetName: 出数据后在excel表格中左下角显示的工作簿名称（注意：不是导出后的文件名）
     * outputStream: 输出流，通常在controller层以response.getOutputStream的形式获取
     * 三个Map集合key值保持一致
     */
        /**
         * 导出列表数据
         *
         * @param title        表头集合
         * @param position     表头字段位置集合
         * @param data         需要导出的数据
         * @param sheetName    导出数据后在excel表格中左下角显示的工作簿名称（注意：不是导出后的文件名）
         * @param outputStream 从controller层通过response获取到的输出流
         * @throws IOException
         */
        public static void exportDataToExcel(Map<String, String> title, Map<String, Integer> position, List<Map<String, Object>> data, String sheetName, OutputStream outputStream) throws IOException {
            if (data == null || data.size() < 1) {
                return;
            }
            try {
                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet(sheetName);
                Row header = sheet.createRow(0);
                CellStyle headerStyle = workbook.createCellStyle();
                headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                // 字体样式
                XSSFFont font = ((XSSFWorkbook) workbook).createFont();
                font.setFontName("Arial");
                font.setFontHeightInPoints((short) 14);
                headerStyle.setFont(font);
                int col = 0;
                for (String key : title.keySet()) {
                    sheet.setColumnWidth(col, 6000);
                    // 设置表格头部
                    Cell headerCell = header.createCell(Integer.parseInt(String.valueOf(position.get(key))));
                    headerCell.setCellValue(title.get(key) + "");
                    headerCell.setCellStyle(headerStyle);
                    col++;
                }
                CellStyle style = workbook.createCellStyle();
                style.setWrapText(true);
                /*
                 * 遍历要导出列表的数据data 并与title的key相比较， 确认后插入值
                 * 创建列时，根据title的key然后将值插入到对应的列中（position，dataMap，title三个集合的key值是一一对应的）
                 */
                if (data != null && data.size() > 0) {
                    int r = 0;
                    for (Map<String, Object> dataMap : data) {
                        Row row = sheet.createRow(r + 1);
                        for (String dkey : dataMap.keySet()) {
                            for (String key : title.keySet()) {
                                if (key.equals(dkey)) {
                                    Cell cell = row.createCell(Integer.parseInt(String.valueOf(position.get(key))));
                                    cell.setCellValue(dataMap.get(dkey) + "");
                                    cell.setCellStyle(style);
                                    break;
                                }
                            }
                        }
                        r++;
                    }
                }
                workbook.write(outputStream);
            } catch (Exception ex) {

                ex.printStackTrace();
            }
        }

    }


