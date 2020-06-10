package com.woniu.jiapei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.condition.OrderCondition;
import com.woniu.jiapei.mapper.BedMapper;
import com.woniu.jiapei.mapper.OrdersMapper;
import com.woniu.jiapei.model.Orders;
import com.woniu.jiapei.model.OrdersExample;
import com.woniu.jiapei.service.OrdersService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 周元皓丶
 * 订单业务实现类
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Resource
    OrdersMapper ordersMapper;

    @Resource
    BedMapper bedMapper;
    @Override
    public List<Orders> selectByCustomerId(int customerId) {
        OrdersExample example=new OrdersExample();
        example.setOrderByClause("'create_time' DESC");
        OrdersExample.Criteria criteriae=example.createCriteria();
        criteriae.andCustomerIdEqualTo(customerId);
        List<Orders> list=ordersMapper.selectByExample(example);
        for (Orders orders : list) {
            orders.setBed(bedMapper.findBedById(orders.getBedId()));
            String timec=null;
            SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                String old=dfs.format(orders.getCreateTime());
                String newt=dfs.format(orders.getEndTime());
                java.util.Date begin=dfs.parse(old);
                java.util.Date end = dfs.parse(newt);
                long l=end.getTime()-begin.getTime();
                long day=l/(24*60*60*1000);
                long hour=(l/(60*60*1000)-day*24);
                long min=((l/(60*1000))-day*24*60-hour*60);
                long s=(l/1000-day*24*60*60-hour*60*60-min*60);
                timec=""+day+"天"+hour+"小时"+min+"分"+s+"秒";
            }catch (Exception e){
                e.printStackTrace();
            }
            orders.setTimec(timec);
        }
        return list;
    }

    @Override
    public Integer countCustomerOrders(int customerId) {
        return ordersMapper.countById(customerId);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersMapper.selectByExample(null);
    }

    @Override
    public List<Orders> getOrdersByCondition(PageBean pageBean, OrderCondition orderCondition) {
        PageHelper.startPage(pageBean.getPageNum(), pageBean.getPageSize());
        List<Orders> ordersList = ordersMapper.getOrdersByCondition(orderCondition);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        pageBean.setTotal((int)pageInfo.getTotal());
        pageBean.setPages(pageInfo.getPages());

        return ordersList;
    }
}
