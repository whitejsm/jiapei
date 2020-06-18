package com.woniu.jiapei.controller;


import com.woniu.jiapei.condition.CustomerCondition;

import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.model.Orders;
import com.woniu.jiapei.service.CustomerService;
import com.woniu.jiapei.service.OrdersService;
import com.woniu.jiapei.tools.DataFileUtil;
import com.woniu.jiapei.tools.PageBean;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 周元皓丶
 * 普通用户管理控制器
 */
@RestController
public class CustomerController {
    @Resource
    CustomerService customerServiceImpl;

    @Resource
    OrdersService ordersServiceImpl;

    @GetMapping("/getAllCustomer")
    public Map<String,Object> getAllCustomer(PageBean pageBean, CustomerCondition customerCondition) throws ParseException {
        System.out.println(customerCondition);
        Map<String,Object> map=new HashMap<String,Object>();
        List<Customer> list=customerServiceImpl.findAll(pageBean,customerCondition);
        Integer countCustomer=customerServiceImpl.countCustomer();
        map.put("pageBean",pageBean);
        map.put("customerList",list);
        map.put("countCustomer",countCustomer);
        return map;
    }

    @GetMapping("/findCustomerOrder")
    public Map<String,Object> findCustomerOrder(int customerId) {
        Map<String,Object> map=new HashMap<String,Object>();
        List<Orders> list=ordersServiceImpl.selectByCustomerId(customerId);
        Integer countOrders=ordersServiceImpl.countCustomerOrders(customerId);
        map.put("ordersList",list);
        map.put("countOrders",countOrders);
        return map;
    }

    @PostMapping("/updateCustomer")
    public void updateCustomer(Customer customer){
        customerServiceImpl.updateOne(customer);
    }


    @GetMapping("/downloadCustomerAll")
    public void downloadOrdersFile(CustomerCondition customerCondition, HttpServletResponse response) throws IOException {
        List<Customer> customerList = customerServiceImpl.downByCondition(customerCondition);
        // 生成文件
        XSSFWorkbook workBook = DataFileUtil.createScoreFile(Customer.class, customerList);
//        XSSFWorkbook workBook = DataFileUtil.createScoreFile(Examination.class, examinationMapper.findAll());

        String filename = "customerAll.xlsx";

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


    @GetMapping("/downloadOrders")
    public void downloadOrders(Integer customerId, HttpServletResponse response) throws IOException {
        List<Orders> ordersList = ordersServiceImpl.downOrdersByCid(customerId);
        System.out.println(ordersList);
        // 生成文件
        XSSFWorkbook workBook = DataFileUtil.createScoreFile(Orders.class, ordersList);

        String filename = "personalOrdersReport.xlsx";

        //设置文件下载头
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        response.setContentType("application/vnd.ms-excel");
        // 不要使用ajax跳转到这个链接，否则会抛出管道中断错误
        OutputStream out = response.getOutputStream();
        workBook.write(out);
        out.flush();
        out.close();
    }
}
