/**
 * order controller
 * @since 2020/06/09
 * @Author ytmzz
 */
package com.woniu.jiapei.controller;

import com.woniu.jiapei.JiapeiApplication;
import com.woniu.jiapei.condition.OrderCondition;
import com.woniu.jiapei.model.Orders;
import com.woniu.jiapei.service.OrdersService;
import com.woniu.jiapei.tools.DataFileUtil;
import com.woniu.jiapei.tools.PageBean;
import com.woniu.jiapei.tools.UploadFile;
import com.woniu.jiapei.tools.impl.OrderPrimaryKey;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Resource
    private OrdersService ordersServiceImpl;

    @GetMapping("/getAllOrders")
    public Map<String, Object> getAllOrders() {
        Map<String, Object> map = new HashMap<>();

        try {
            List<Orders> ordersList = ordersServiceImpl.getAllOrders();
            map.put("ordersList", ordersList);
            map.put("result", "ok");
        } catch(Exception e) {
            map.put("result", "error");
        }

        return map;
    }

    @GetMapping("/getOrdersByCondition")
    public Map<String, Object> getOrdersByCondition(PageBean pageBean, OrderCondition orderCondition) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(orderCondition);
        System.out.println(pageBean);
        try {
            List<Orders> ordersList = ordersServiceImpl.getOrdersByCondition(pageBean, orderCondition);
            map.put("ordersList", ordersList);
            map.put("pageBean", pageBean);
            map.put("result", "ok");
        } catch(Exception e) {
            e.printStackTrace();
            map.put("result", "error");
        }

        return map;
    }

    @GetMapping("/downloadOrdersFile")
    public void downloadOrdersFile(OrderCondition orderCondition,HttpServletResponse response) throws IOException {
        System.out.println(orderCondition);
        List<Orders> ordersList = ordersServiceImpl.getOrdersByCondition(orderCondition);
        System.out.println(ordersList);
        // 生成文件
        XSSFWorkbook workBook = DataFileUtil.createScoreFile(Orders.class, ordersList);
//        XSSFWorkbook workBook = DataFileUtil.createScoreFile(Examination.class, examinationMapper.findAll());

        String filename = "orders.xlsx";

        //设置文件下载头
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
//        response.setContentType("multipart/form-data");
        response.setContentType("application/vnd.ms-excel");
        //BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        // 不要使用ajax跳转到这个链接，否则会抛出管道中断错误
        OutputStream out = response.getOutputStream();
        workBook.write(out);
        out.flush();
        out.close();
    }

    @GetMapping("/down")
    public void down(HttpServletResponse response) throws IOException {
        // 生成文件
        XSSFWorkbook workBook = DataFileUtil.createTemplateXlsxFile(Orders.class);
//        XSSFWorkbook workBook = DataFileUtil.createScoreFile(Examination.class, examinationMapper.findAll());

        String filename = "orders.xlsx";

        //设置文件下载头
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
//        response.setContentType("multipart/form-data");
        response.setContentType("application/vnd.ms-excel");
        //BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        // 不要使用ajax跳转到这个链接，否则会抛出管道中断错误
        OutputStream out = response.getOutputStream();
        workBook.write(out);
        out.flush();
        out.close();
    }

    @RequestMapping("/uploadOrderFile")
    public boolean uploadOrderFile(MultipartFile file) {
        String realPath = JiapeiApplication.class.getClassLoader().getResource(".").getPath() + "upload/orders";
        System.out.println(realPath);
        // 文件保存路径
        String path = UploadFile.saveFile(file, realPath);

        boolean flag = false;
        try {
            List<Orders> list = DataFileUtil.getObjectList(Orders.class, path, new OrderPrimaryKey(), "ordersId");
            ordersServiceImpl.insertOrders(list);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
