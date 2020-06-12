/**
 * 报表
 * @auther ytmzz
 * @since 2020/06/12
 */
package com.woniu.jiapei.condition;

import com.woniu.jiapei.service.ReportService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ReportController {
    @Resource
    private ReportService reportServiceImpl;


}
