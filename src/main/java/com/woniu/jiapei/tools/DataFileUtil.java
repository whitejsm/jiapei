/**
 * 文件上传下载工具类
 * @auther ytmzz
 * @since 2020/06/11
 */
package com.woniu.jiapei.tools;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

public class DataFileUtil {
    private static Map<String, Map<String, String>> dataMap = new HashMap<>();
    private static Map<String, Map<String, String>> templateMap = new HashMap<>();
    static  {
        OrderProperties pro = new OrderProperties();
        try {
            pro.load(new FileReader("src/main/resources/datafile.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 转换值编码 Latin1 ==> UTF-8
//         pro.setProperty("DataFile.i", new String(pro.getProperty("DataFile.i").getBytes("Latin1"), "UTF-8"));
        transToMap(dataMap, pro);

        // ---------导入---------
        pro = new OrderProperties();
        try {
            pro.load(new FileReader("src/main/resources/datafileImport.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        transToMap(templateMap, pro);
    }

    public static void transToMap(Map<String, Map<String, String>> map, OrderProperties pro) {
        //Map<String, Map<String, String>> map = new HashMap<>();
        String key = null;
        String value = null;
        String className = null;

        Set<Object> sets = pro.keySet();
        for(Object s : sets) {
            //Map.Entry<Object, Object> entry = it.next();
            key = (String) s;
            value = (String) pro.getProperty(key);
            int index = key.lastIndexOf('.');
            if(index == -1) {
                continue;
            }
            className = key.substring(0, index);
            key = key.substring(index + 1);
            if(map.get(className) != null) {
                map.get(className).put(key, value);
            } else {
                Map<String, String> m = new LinkedHashMap<>();
                m.put(key, value);
                map.put(className, m);
            }
        }
    }

    public static <T> XSSFWorkbook createScoreFile(Class<?> cls, List<T> list) {
        return createScoreFile(cls, list, null);
    }

    public static <T> XSSFWorkbook createScoreFile(Class<?> cls, List<T> list, List<String> outList) {
        // 1. 创建一个workbook
        XSSFWorkbook workbook = workbook = new XSSFWorkbook();
        try {
            // 2. 添加一个sheet
            XSSFSheet xssfSheet = workbook.createSheet("sheet1");
            // 3. 添加表头第0行
            XSSFRow row = xssfSheet.createRow(0);
            // 4. 创建单元格，设置表头
            XSSFCell xssfCell = null;

            Map<String, String> map = dataMap.get(cls.getSimpleName());
            // 移除不需要导出的列
            if(outList != null) {
                LinkedHashMap map1 = new LinkedHashMap();
                map1.putAll(map);
                map = map1;
                for (String s : outList) {
                    map.remove(s);
                }
            }

            int colNum = 0;
            List<String> ls = new ArrayList<>();
            Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
            while(iter.hasNext()) {
                Map.Entry<String, String> entry = iter.next();
//                System.out.println(entry.getKey() + "------" + entry.getValue());
                xssfCell = row.createCell(colNum++);
                xssfCell.setCellValue(entry.getValue());
                ls.add(entry.getKey());
            }
            int rowLength = 0;
            for(T t : list) {
                colNum = 0;
                rowLength++;
                row = xssfSheet.createRow(rowLength);
                for(int in = 0; in < ls.size(); in++) {
                    Method meth = cls.getMethod(transFieldToMethod(ls.get(in)));
                    Object val = meth.invoke(t);
                    xssfCell = row.createCell(colNum++);
                    if (val == null){
                        xssfCell.setCellValue("");
                    } else if (val instanceof String) {
                        xssfCell.setCellValue((String) val);
                    } else if (val instanceof Integer) {
                        xssfCell.setCellValue((Integer) val);
                    } else if (val instanceof Byte) {
                        xssfCell.setCellValue((Byte) val);
                    } else if (val instanceof Short) {
                        xssfCell.setCellValue((Short) val);
                    } else if (val instanceof Long) {
                        xssfCell.setCellValue((Long) val);
                    } else if (val instanceof Double) {
                        xssfCell.setCellValue((Double) val);
                    } else if (val instanceof Float) {
                        xssfCell.setCellValue((Float) val);
                    } else if (val instanceof Boolean) {
                        xssfCell.setCellValue((Boolean) val);
                    } else if (val instanceof Character) {
                        xssfCell.setCellValue((Character) val);
                    } else if (val instanceof Date) {
                        DataFormat format = workbook.createDataFormat();
                        XSSFCellStyle style = workbook.createCellStyle();
                        style.setDataFormat(format.getFormat("yyyy/MM/dd hh:mm:ss"));
                        xssfCell.setCellStyle(style);
                        xssfCell.setCellValue((Date) val);
                    }  else if (val instanceof BigDecimal) {
                        double doubleVal = ((BigDecimal) val).doubleValue();
//                        DataFormat format = workbook.createDataFormat();
//                        style.setDataFormat(format.getFormat("0.00"));
                        xssfCell.setCellValue(doubleVal);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return workbook;
    }

    private static String transFieldToMethod(String fieldName) {
        String ch = fieldName.substring(0, 1).toUpperCase();
        return "get" + ch + fieldName.substring(1);
    }


    //  ---------导入---------

    /**
     * 返回一个空xlsx
     * @param cls
     * @return
     */
    public static XSSFWorkbook createTemplateXlsxFile(Class<?> cls) {
        // 1. 创建一个workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 2. 添加一个sheet
        XSSFSheet xssfSheet = workbook.createSheet("sheet1");
        // 3. 添加表头第0行
        XSSFRow row = xssfSheet.createRow(0);
        XSSFCell xssfCell;

        Map<String, String> map1 = templateMap.get(cls.getSimpleName());
        List<String> ls = new ArrayList<>();
        int colNum = 0;

        Iterator<Map.Entry<String, String>> iter = map1.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            xssfCell = row.createCell(colNum++);
            xssfCell.setCellValue(entry.getKey());
            ls.add(entry.getKey());
        }

        return workbook;
    }

    private static String transFieldToSetMethod(String fieldName) {
        String ch = fieldName.substring(0, 1).toUpperCase();
        return "set" + ch + fieldName.substring(1);
    }

    public static <T> List<T> getObjectList(Class<T> cls, String path)
            throws IOException, IllegalAccessException, InstantiationException,
            NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        return getObjectList(cls, path, null, null);
    }

    public static <T> List<T> getObjectList(Class<T> cls, String path,
                                            IPrimaryKey primaryKey, String primaryKeyName)
            throws IOException, IllegalAccessException, InstantiationException,
            NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        FileInputStream fis = null;
        XSSFWorkbook wk = null;
        fis = new FileInputStream(path);
        wk = new XSSFWorkbook(fis);

        Map<String, String> map = templateMap.get(cls.getSimpleName());

        // 获取第一个sheet
        Sheet sheet = wk.getSheetAt(0);
        List<T> list = new ArrayList<>();

        // 获取第一行
        int firstRowNum = sheet.getFirstRowNum();
        // 获取最后一行
        int rowEnd = sheet.getLastRowNum();

        // 获取第一行
        Row row = sheet.getRow(0);
        // 获取列数
        int colNum = row.getLastCellNum();

        // 获取列信息
        String[] colNames = new String[colNum];
        for(int index = 0; index < colNum; index++) {
            Cell cell = row.getCell(index);
            String str = cell.getStringCellValue();
            colNames[index] = map.get(str);
        }

        for(int i = firstRowNum + 1; i <= rowEnd; i++) {
            T obj = cls.newInstance();
            // 获取行
            row = sheet.getRow(i);

            for(int index = 0; index < colNum; index++) {
                String fieldName = colNames[index];
                if(fieldName == null) {
                    continue;
                }
                Field field = cls.getDeclaredField(fieldName);
                Class<?> type = field.getType();
                String methodName = transFieldToSetMethod(fieldName);
                Method method = cls.getMethod(methodName, type);

                // 获取数据
                Cell cell = row.getCell(index);
                Object value = new Object();
                if (type == String.class) {
                    // 转换cell为string类型
                    DataFormatter formatter = new DataFormatter();
                    value = formatter.formatCellValue(cell);
                    if(primaryKey != null && primaryKeyName != null
                            && primaryKeyName.equals(fieldName)) {
                        value = primaryKey.generatePrimaryKey();
                    }
                } else if (type == Byte.class || type == byte.class) {
                    value = new Double(cell.getNumericCellValue()).byteValue();
                } else if (type == Short.class || type == short.class) {
                    value = new Double(cell.getNumericCellValue()).shortValue();
                } else if(type == Long.class || type == long.class) {
                    value = new Double(cell.getNumericCellValue()).longValue();
                } else if(type == Integer.class || type == int.class) {
                    value = new Double(cell.getNumericCellValue()).intValue();
                } else if(type == Float.class || type == float.class) {
                    value = new Double(cell.getNumericCellValue()).floatValue();
                } else if(type == Double.class || type == double.class) {
                    value = cell.getNumericCellValue();
                } else if (type == Boolean.class || type == boolean.class) {
                    value = cell.getBooleanCellValue();
                } else if (type == Character.class || type == char.class) {
                    value = (char) (new Double(cell.getNumericCellValue()).intValue());
                } else if (type == Date.class) {
                    value = cell.getDateCellValue();
                }  else if (type == BigDecimal.class) {
                    // 转换cell为string类型
                    DataFormatter formatter = new DataFormatter();
                    value = new BigDecimal(formatter.formatCellValue(cell));
                }
                method.invoke(obj, value);
            }
            list.add(obj);
        }
        fis.close();
        return list;
    }
}
