package cn.net.colin.common.utils;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * excel读取工具类
 */
public class ImportExeclUtil
{

    private static int totalRows = 0;// 总行数

    private static int totalCells = 0;// 总列数

    private static String errorInfo;// 错误信息

    /** 无参构造方法 */
    public ImportExeclUtil()
    {
    }

    public static int getTotalRows()
    {
        return totalRows;
    }

    public static int getTotalCells()
    {
        return totalCells;
    }

    public static String getErrorInfo()
    {
        return errorInfo;
    }

    /**
     *
     * 根据流读取Excel文件
     *
     *
     * @param inputStream
     * @param isExcel2003
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<List<String>> read(InputStream inputStream, boolean isExcel2003)
            throws IOException
    {

        List<List<String>> dataLst = null;

        /** 根据版本选择创建Workbook的方式 */
        Workbook wb = null;

        if (isExcel2003)
        {
            wb = new HSSFWorkbook(inputStream);
        }
        else
        {
            wb = new XSSFWorkbook(inputStream);
        }
        dataLst = readDate(wb);

        return dataLst;
    }

    /**
     *
     * 读取数据
     *
     * @param wb
     * @return
     * @see [类、类#方法、类#成员]
     */
    private List<List<String>> readDate(Workbook wb)
    {

        List<List<String>> dataLst = new ArrayList<List<String>>();

        /** 得到第一个shell */
        Sheet sheet = wb.getSheetAt(0);

        /** 得到Excel的行数 */
        totalRows = sheet.getPhysicalNumberOfRows();

        /** 得到Excel的列数 */
        if (totalRows >= 1 && sheet.getRow(0) != null)
        {
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }

        /** 循环Excel的行 */
        for (int r = 0; r < totalRows; r++)
        {
            Row row = sheet.getRow(r);
            if (row == null)
            {
                continue;
            }

            List<String> rowLst = new ArrayList<String>();

            /** 循环Excel的列 */
            for (int c = 0; c < getTotalCells(); c++)
            {

                Cell cell = row.getCell(c);
                String cellValue = "";

                if (null != cell)
                {
                    // 以下是判断数据的类型
                    switch (cell.getCellType())
                    {
                        case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                            cellValue = cell.getNumericCellValue() + "";
                            break;

                        case HSSFCell.CELL_TYPE_STRING: // 字符串
                            cellValue = cell.getStringCellValue();
                            break;

                        case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                            cellValue = cell.getBooleanCellValue() + "";
                            break;

                        case HSSFCell.CELL_TYPE_FORMULA: // 公式
                            cellValue = cell.getCellFormula() + "";
                            break;

                        case HSSFCell.CELL_TYPE_BLANK: // 空值
                            cellValue = "";
                            break;

                        case HSSFCell.CELL_TYPE_ERROR: // 故障
                            cellValue = "非法字符";
                            break;

                        default:
                            cellValue = "未知类型";
                            break;
                    }
                }

                rowLst.add(cellValue);
            }

            /** 保存第r行的第c列 */
            dataLst.add(rowLst);
        }

        return dataLst;
    }

    /**
     *
     * 按指定坐标读取实体数据
     * <按顺序放入带有注解的实体成员变量中>
     *
     * @param wb 工作簿
     * @param t 实体
     * @param in 输入流
     * @param integers 指定需要解析的坐标
     * @return T 相应实体
     * @throws IOException
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    @SuppressWarnings("unused")
    public static <T> T readDateT(Workbook wb, T t, InputStream in, Integer[]... integers)
            throws IOException, Exception
    {
        // 获取该工作表中的第一个工作表
        Sheet sheet = wb.getSheetAt(0);

        // 成员变量的值
        Object entityMemberValue = "";

        // 所有成员变量
        Field[] fields = t.getClass().getDeclaredFields();
        // 列开始下标
        int startCell = 0;

        /** 循环出需要的成员 */
        for (int f = 0; f < fields.length; f++)
        {

            fields[f].setAccessible(true);
            String fieldName = fields[f].getName();
            boolean fieldHasAnno = fields[f].isAnnotationPresent(IsNeeded.class);
            // 有注解
            if (fieldHasAnno)
            {
                IsNeeded annotation = fields[f].getAnnotation(IsNeeded.class);
                boolean isNeeded = annotation.isNeeded();

                // Excel需要赋值的列
                if (isNeeded)
                {

                    // 获取行和列
                    int x = integers[startCell][0] - 1;
                    int y = integers[startCell][1] - 1;

                    Row row = sheet.getRow(x);
                    Cell cell = row.getCell(y);

                    if (row == null)
                    {
                        continue;
                    }

                    // Excel中解析的值
                    String cellValue = getCellValue(cell);
                    // 需要赋给成员变量的值
                    entityMemberValue = getEntityMemberValue(entityMemberValue, fields[f], cellValue);
                    // 赋值
                    PropertyUtils.setProperty(t, fieldName, entityMemberValue);
                    // 列的下标加1
                    startCell++;
                }
            }

        }

        return t;
    }
    /**
     * 对于导入的excel 进行反馈信息填写,并存入本地
     * @param backList
     * @return
     */
    public static Map<String,String> feedBackExcel(MultipartFile IFile,List<Map<String,String>> backList, String excelName, int beginLine, int totalcut, String realPath){

        //复制workbook
        Workbook wb = null;
        Workbook wbErro =null;
        File excelFile = null;
        //兼容windows,linux分隔符
        String fileSeperator = File.separator;
        Map<String,String> realpathMap = new HashMap<String,String>();
        try {
            wb = chooseWorkbook(IFile.getOriginalFilename(), IFile.getInputStream());
            wbErro = chooseWorkbook(IFile.getOriginalFilename(), IFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return realpathMap;
        }
        wb = operationWb(wb,backList,beginLine,totalcut,true);
        wbErro = operationWb(wbErro,backList,beginLine,totalcut,false);

        FileOutputStream out = null;
        FileOutputStream outErro = null;
        try{
            //保存成功excel
            File path = new File(realPath+fileSeperator+"uploadfile"+fileSeperator+"import");
            if(!path.exists()){
                path.mkdirs();
            }
            String datatime =DateUtils.date2Str(DateUtils.yyyymmddhhmmss);
            String filepath = realPath+fileSeperator+"uploadfile"+fileSeperator+"import"+fileSeperator+excelName+"导入成功数据结果反馈"+datatime+".xlsx";
            realpathMap.put("filepath",filepath);
            ExcelUtils.delLineNull(wb,filepath);
            /*realpathMap.put("filepath",filepath);
            File file = new File(filepath);
            out = new FileOutputStream(file);
            wb.write(out);
            out.close();*/

            //保存失败excel
            String filepathErro = realPath+fileSeperator+"uploadfile"+fileSeperator+"import"+fileSeperator+excelName+"导入失败数据结果反馈"+datatime+".xlsx";
            realpathMap.put("fileErropath",filepathErro);
            ExcelUtils.delLineNull(wbErro,filepathErro);
            /*realpathMap.put("fileErropath",filepathErro);
            File fileErro = new File(filepathErro);
            outErro = new FileOutputStream(fileErro);
            wbErro.write(outErro);
            outErro.close();*/
        }catch (Exception e){

        }
        return realpathMap;
    }

    /**
     * 操作wookbook 将成功，失败数据分别保存
     * @param wb
     * @param backList
     * @param beginLine
     * @param totalcut
     * @param flag  true 表示保存成功数据， false表示保存失败数据
     * @return
     */
    public static Workbook operationWb(Workbook wb,List<Map<String,String>> backList,int beginLine,int totalcut,boolean flag){

        /** 得到第一个shell */
        Sheet sheet = wb.getSheetAt(0);
        /** 得到Excel的行数 */
        int rows = sheet.getPhysicalNumberOfRows();

        /** 得到excel总列数*/
        int cells = sheet.getRow(0).getPhysicalNumberOfCells();
        // 设置样式1
        CellStyle cellStyle1 = wb.createCellStyle();
        cellStyle1.setAlignment(CellStyle.ALIGN_LEFT);
        cellStyle1.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        // 设置样式2
        CellStyle cellStyle2 = wb.createCellStyle();
        cellStyle2.setAlignment(CellStyle.ALIGN_LEFT);
        cellStyle2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        cellStyle2.setFillForegroundColor(IndexedColors.RED.getIndex());
        cellStyle2.setFillPattern(cellStyle2.SOLID_FOREGROUND);
        //给当前sheet创建两列
        sheet.getRow(0).createCell(cells).setCellValue("状态");
        sheet.setColumnWidth(20,8000);
        sheet.getRow(0).createCell(cells+1).setCellValue("信息");
        sheet.setColumnWidth(500,8000);
        //循环sheet的行给每行的最后两列赋与map中的值
        int i = 0;
        for (int r = beginLine - 1; r < rows - totalcut; r++){
            Row row = sheet.getRow(r);
            if(row == null){
                continue;
            }
            if(flag){
                //true 保留成功消息
                // map总数 == excel行总数 获取跟excel同行map信息
                Map<String,String> map = backList.get(i);
                if("-1".equals(map.get("code"))){
                    sheet.removeRow(row);
                    /*    sheet.shiftRows(r, rows - totalcut, -1);
                    r--;*/
                    i++;
                    continue;
                }
                    Cell cellstatus =  row.createCell(cells);
                    cellstatus.setCellValue(map.get("status"));
                    cellstatus.setCellStyle(cellStyle1);
                    Cell cellinfo =  row.createCell(cells+1);
                    cellinfo.setCellValue(map.get("msg"));
                    i++;
                    continue;
            }
            if(!flag){
                //false 保留错误信息
                // map总数 == excel行总数 获取跟excel同行map信息
                Map<String,String> map = backList.get(i);
                if("0".equals(map.get("code"))){
                    sheet.removeRow(row);
                    /*    sheet.shiftRows(r, rows - totalcut, -1);
                    r--;*/
                    i++;
                    continue;
                }
                    Cell cellstatus =  row.createCell(cells);
                    cellstatus.setCellValue(map.get("status"));
                    cellstatus.setCellStyle(cellStyle2);
                    Cell cellinfo =  row.createCell(cells+1);
                    cellinfo.setCellValue(map.get("msg"));
                    i++;
                    continue;
                }

        }
        return wb;
    }

    /**
     *
     * 读取列表数据
     * <按顺序放入带有注解的实体成员变量中>
     *
     * @param wb 工作簿
     * @param t 实体
     * @param beginLine 开始行数
     * @param totalcut 结束行数减去相应行数
     * @return List<T> 实体列表
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> readDateListT(Workbook wb, T t, int beginLine, int totalcut, Object ...colFields)
            throws Exception
    {
        List<T> listt = new ArrayList<T>();

        /** 得到第一个shell */
        Sheet sheet = wb.getSheetAt(0);

        /** 得到Excel的行数 */
        totalRows = sheet.getPhysicalNumberOfRows();
        //ceshi
        int a = sheet.getLastRowNum();

        /** 得到Excel的列数 */
        if (totalRows >= 1 && sheet.getRow(0) != null)
        {
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }

        /** 循环Excel的行 */
        for (int r = beginLine - 1; r < totalRows - totalcut; r++)
        {
            Object newInstance = t.getClass().newInstance();
            Row row = sheet.getRow(r);
            if (row == null)
            {
                continue;
            }

            // 成员变量的值
            Object entityMemberValue = "";

            // 所有成员变量
            Field[] fields = t.getClass().getDeclaredFields();
            Map<String,Field> fieldMap = new HashMap<String,Field>();
            for(Field field:fields){
                fieldMap.put(field.getName(),field);
            }
            Class superClass =t.getClass().getSuperclass();
            String allClassName = superClass.getName();
            if(!"java.lang.Object".equals(allClassName)){
                Field[] supperFields =superClass.getDeclaredFields();
                for(Field field:supperFields){
                    if(fieldMap.get(field.getName())==null){
                        fieldMap.put(field.getName(),field);
                    }
                }

            }
            // 列开始下标
            int startCell = 0;

            String [] cols = (String[])colFields;
            for (int f = 0; f < cols.length; f++)
            {

               // fields[f].setAccessible(true);
                String fieldName = cols[f];
                Field field = fieldMap.get(fieldName);
               // boolean fieldHasAnno = fields[f].isAnnotationPresent(IsNeeded.class);
                // 有注解
               // if (fieldHasAnno)
               // {
                //    IsNeeded annotation = fields[f].getAnnotation(IsNeeded.class);
               //     boolean isNeeded = annotation.isNeeded();
                    // Excel需要赋值的列
                 //   if (isNeeded)
                 //   {
                        Cell cell = row.getCell(startCell);
                        String cellValue = getCellValue(cell);
                        entityMemberValue = getEntityMemberValue(entityMemberValue, field, cellValue);
                        // 赋值
                        PropertyUtils.setProperty(newInstance, fieldName, entityMemberValue);
                        // 列的下标加1
                        startCell++;
                   // }
                //}

            }

            listt.add((T)newInstance);
        }

        return listt;
    }

    /**
     *
     * 根据Excel表格中的数据判断类型得到值
     *
     * @param cell
     * @return
     * @see [类、类#方法、类#成员]
     */
    private static String getCellValue(Cell cell)
    {
        String cellValue = "";

        if (null != cell)
        {
            // 以下是判断数据的类型
            switch (cell.getCellType())
            {
                case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell))
                    {
                        Date theDate = cell.getDateCellValue();
                        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        cellValue = dff.format(theDate);
                    }
                    else
                    {
                        DecimalFormat df = new DecimalFormat("#.########");
                        cellValue = df.format(cell.getNumericCellValue());

                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING: // 字符串
                    cellValue = cell.getStringCellValue();
                    break;

                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                    cellValue = cell.getBooleanCellValue() + "";
                    break;

                case HSSFCell.CELL_TYPE_FORMULA: // 公式
                    cellValue = cell.getCellFormula() + "";
                    break;

                case HSSFCell.CELL_TYPE_BLANK: // 空值
                    cellValue = "";
                    break;

                case HSSFCell.CELL_TYPE_ERROR: // 故障
                    cellValue = "非法字符";
                    break;

                default:
                    cellValue = "未知类型";
                    break;
            }

        }
        return cellValue;
    }

    /**
     *
     * 根据实体成员变量的类型得到成员变量的值
     *
     * @param realValue
     * @param f
     * @param cellValue
     * @return
     * @see [类、类#方法、类#成员]
     */
    private static Object getEntityMemberValue(Object realValue, Field f , String cellValue)
    {
        String type = f.getType().getName();
        switch (type)
        {
            case "char":
            case "java.lang.Character":
            case "java.lang.String":
                realValue = cellValue;
                break;
            case "java.util.Date":
                realValue = StringUtils.isBlank(cellValue) ? null : DateUtil.strToDate(cellValue, DateUtil.YYYY_MM_DDHHMMSS);
                break;
            case "java.lang.Integer":
                realValue = StringUtils.isBlank(cellValue) ? null : Integer.valueOf(cellValue);
                break;
            case "java.lang.Long":
                realValue = StringUtils.isBlank(cellValue) ? null : Long.valueOf(cellValue);
                break;
            case "float":
            case "java.lang.Float":
                realValue = StringUtils.isBlank(cellValue) ? null : Float.parseFloat(cellValue);
                break;
            case "int":
            case "double":
            case "java.lang.Double":


            case "java.lang.Short":
            case "java.math.BigDecimal":
                realValue = StringUtils.isBlank(cellValue) ? null : new BigDecimal(cellValue);
                break;
            default:
                break;
        }
        return realValue;
    }

    /**
     *
     * 根据路径或文件名选择Excel版本
     *
     *
     * @param filePathOrName
     * @param in
     * @return
     * @throws IOException
     * @see [类、类#方法、类#成员]
     */
    public static Workbook chooseWorkbook(String filePathOrName, InputStream in)
            throws IOException
    {
        /** 根据版本选择创建Workbook的方式 */
        Workbook wb = null;
        boolean isExcel2003 = ExcelVersionUtil.isExcel2003(filePathOrName);

        if (isExcel2003)
        {
            wb = new HSSFWorkbook(in);
        }
        else
        {
            wb = new XSSFWorkbook(in);
        }

        return wb;
    }

    static class ExcelVersionUtil
    {

        /**
         *
         * 是否是2003的excel，返回true是2003
         *
         *
         * @param filePath
         * @return
         * @see [类、类#方法、类#成员]
         */
        public static boolean isExcel2003(String filePath)
        {
            return filePath.matches("^.+\\.(?i)(xls)$");

        }

        /**
         *
         * 是否是2007的excel，返回true是2007
         *
         *
         * @param filePath
         * @return
         * @see [类、类#方法、类#成员]
         */
        public static boolean isExcel2007(String filePath)
        {
            return filePath.matches("^.+\\.(?i)(xlsx)$");

        }

    }

    public static class DateUtil
    {

        // ======================日期格式化常量=====================//

        public static final String YYYY_MM_DDHHMMSS = "yyyy-MM-dd HH:mm:ss";

        public static final String YYYY_MM_DD = "yyyy-MM-dd";

        public static final String YYYY_MM = "yyyy-MM";

        public static final String YYYY = "yyyy";

        public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

        public static final String YYYYMMDD = "yyyyMMdd";

        public static final String YYYYMM = "yyyyMM";

        public static final String YYYYMMDDHHMMSS_1 = "yyyy/MM/dd HH:mm:ss";

        public static final String YYYY_MM_DD_1 = "yyyy/MM/dd";

        public static final String YYYY_MM_1 = "yyyy/MM";

        /**
         *
         * 自定义取值，Date类型转为String类型
         *
         * @param date 日期
         * @param pattern 格式化常量
         * @return
         * @see [类、类#方法、类#成员]
         */
        public static String dateToStr(Date date, String pattern)
        {
            SimpleDateFormat format = null;

            if (null == date)
                return null;
            format = new SimpleDateFormat(pattern, Locale.getDefault());

            return format.format(date);
        }

        /**
         * 将字符串转换成Date类型的时间
         * <hr>
         *
         * @param s 日期类型的字符串<br>
         *            datePattern :YYYY_MM_DD<br>
         * @return java.util.Date
         */
        public static Date strToDate(String s, String pattern)
        {
            if (s == null)
            {
                return null;
            }
            Date date = null;
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            try
            {
                date = sdf.parse(s);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
            return date;
        }
    }



}