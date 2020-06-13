package com.woniu.jiapei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.condition.AccountingCondition;
import com.woniu.jiapei.mapper.RoleMapper;
import com.woniu.jiapei.mapper.UserInfoMapper;
import com.woniu.jiapei.mapper.UserInfoRoleMapper;
import com.woniu.jiapei.model.Customer;
import com.woniu.jiapei.model.Role;
import com.woniu.jiapei.model.UserInfo;
import com.woniu.jiapei.model.UserInfoRoleKey;
import com.woniu.jiapei.service.UserInfoService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    UserInfoMapper userInfoMapper;
    @Resource
    UserInfoRoleMapper userInfoRoleMapper;
    @Resource
    private RoleMapper roleMapper;

    /*
    根据登录用户名，查询用户是否存在，实现登录
     */
    @Override
    public UserInfo findByName(String username) {
        return userInfoMapper.findByName(username);
    }

    /**
     * 获取所有会计信息
     * @param pageBean
     * @param accountingCondition
     * @return
     */
    @Override
    public List<UserInfo> findAllAccounting(PageBean pageBean, AccountingCondition accountingCondition) {
        PageHelper.startPage(pageBean.getPageNum(),pageBean.getPageSize());
        List<UserInfo> list=userInfoMapper.getAccountingByCondition(accountingCondition);

        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(list);
        pageBean.setPages(pageInfo.getPages());
        pageBean.setTotal((int) pageInfo.getTotal());
        return list;
    }

    /**
     * 获取会计总人数
     * @return
     */
    @Override
    public Integer countAccounting() {
        return userInfoMapper.countAccounting();
    }

    /**
     * 添加一个会计
     * @param userInfo
     */
    @Override
    public void addAccounting(UserInfo userInfo) {
        userInfo.setPassword("123456");
        userInfo.setCreateTime(new Date());
        userInfo.setIsdelete(true);
        userInfoMapper.insert(userInfo);
        System.out.println(userInfo.getUserinfoId());
        UserInfoRoleKey userInfoRoleKey=new UserInfoRoleKey();
        userInfoRoleKey.setUserinfoId(userInfo.getUserinfoId());
        userInfoRoleKey.setRoleId(3);
        userInfoRoleMapper.insert(userInfoRoleKey);
    }

    /**
     * 修改会计信息
     * @param userInfo
     */
    @Override
    public void updateAccounting(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
    /**
     * 获取所有维修人员信息
     * @param pageBean
     * @param accountingCondition
     * @return
     */
    @Override
    public List<UserInfo> findAllRepairman(PageBean pageBean, AccountingCondition accountingCondition) {
        PageHelper.startPage(pageBean.getPageNum(),pageBean.getPageSize());
        List<UserInfo> list=userInfoMapper.getRepairmanByCondition(accountingCondition);

        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(list);
        pageBean.setPages(pageInfo.getPages());
        pageBean.setTotal((int) pageInfo.getTotal());
        return list;
    }
    /**
     * 获取维修人员总人数
     * @return
     */
    @Override
    public Integer countRepairman() {
        return userInfoMapper.countRepairman();
    }

    @Override
    public void addRepairman(UserInfo userInfo) {
        userInfo.setPassword("123456");
        userInfo.setCreateTime(new Date());
        userInfo.setIsdelete(true);
        userInfoMapper.insert(userInfo);
        System.out.println(userInfo.getUserinfoId());
        UserInfoRoleKey userInfoRoleKey=new UserInfoRoleKey();
        userInfoRoleKey.setUserinfoId(userInfo.getUserinfoId());
        userInfoRoleKey.setRoleId(4);
        userInfoRoleMapper.insert(userInfoRoleKey);
    }

    @Override
    public void updateRepairman(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public Role findRoleByUserId(Integer userinfoId) {
        return roleMapper.findRoleByUserId(userinfoId);
    }

    @Override
    public List<UserInfo> getDistributor(Integer userId) {
        return userInfoMapper.getDistributor(userId);
    }
}
