package com.woniu.jiapei.tools;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

public class DataFileUtil {
    private static Map<String, Map<String, String>> dataMap = new HashMap<>();
    static  {
        OrderProperties pro = new OrderProperties();
        try {
            pro.load(new FileReader("src/main/resources/datafile.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 转换值编码 Latin1 ==> UTF-8
//         pro.setProperty("DataFile.i", new String(pro.getProperty("DataFile.i").getBytes("Latin1"), "UTF-8"));
        transToMap(pro);
    }

    public static void transToMap(OrderProperties pro) {
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
            if(dataMap.get(className) != null) {
                dataMap.get(className).put(key, value);
            } else {
                Map<String, String> m = new LinkedHashMap<>();
                m.put(key, value);
                dataMap.put(className, m);
            }
        }
    }

    public static <T> XSSFWorkbook createScoreFile(Class<?> cls, List<T> list) {
        // 1. 创建一个workbook
        XSSFWorkbook workbook = workbook = new XSSFWorkbook();
        try {
            // 2. 添加一个sheet
            XSSFSheet xssfSheet = workbook.createSheet("sheet1");
            // 3. 添加表头第0行
            XSSFRow row = xssfSheet.createRow(0);
            // 4. 创建单元格，设置表头
            XSSFCell xssfCell = null;

            Map<String, String> map1 = dataMap.get(cls.getSimpleName());

            int colNum = 0;
            List<String> ls = new ArrayList<>();
            Iterator<Map.Entry<String, String>> iter = map1.entrySet().iterator();
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
                    System.out.println(transFieldToMethod(ls.get(in)));
                    Method meth = cls.getMethod(transFieldToMethod(ls.get(in)));
                    Object val = meth.invoke(t);
                    System.out.println(val);
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
}
