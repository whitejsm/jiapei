package com.woniu.jiapei.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.jiapei.condition.*;
import com.woniu.jiapei.mapper.HospitalMapper;
import com.woniu.jiapei.mapper.ShareholderMapper;
import com.woniu.jiapei.mapper.RoleMapper;
import com.woniu.jiapei.mapper.UserInfoMapper;
import com.woniu.jiapei.mapper.UserInfoRoleMapper;
import com.woniu.jiapei.model.*;
import com.woniu.jiapei.model.Role;
import com.woniu.jiapei.model.UserInfo;
import com.woniu.jiapei.model.UserInfoRoleKey;
import com.woniu.jiapei.service.UserInfoService;
import com.woniu.jiapei.tools.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
    ShareholderMapper shareholderMapper;
    @Resource
    HospitalMapper hospitalMapper;
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
        userInfo.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
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
        userInfo.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
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
    public List<UserInfo> downloadAccount(AccountingCondition accountingCondition) {
        List<UserInfo> list=userInfoMapper.getAccountingByCondition(accountingCondition);
        return list;
    }

    @Override
    public List<UserInfo> downloadRepairman(AccountingCondition accountingCondition) {
        List<UserInfo> list=userInfoMapper.getRepairmanByCondition(accountingCondition);
        return list;
    }

    @Override
    public List<UserInfo> downloadShareholder(ShareholderCondition shareholderCondition) {
        List<UserInfo> list=userInfoMapper.getShareholderByCondition(shareholderCondition);
        return list;
    }

    @Override
    public List<UserInfo> downloadMedicalList(MedicalCondition medicalCondition) {
        List<UserInfo> list=userInfoMapper.getMedicalByCondition(medicalCondition);
        return list;
    }


    @Override
    public void resetPassword(UserInfo userInfo) {
        userInfo.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public int changePassword(String newPs, UserInfo userInfo) {
        int a=0;
        try{
            userInfo.setPassword(DigestUtils.md5DigestAsHex(newPs.getBytes()));
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
            a=1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }


    @Override
    public List<UserInfo> findAllMedical(PageBean pageBean, MedicalCondition medicalCondition) {
        PageHelper.startPage(pageBean.getPageNum(),pageBean.getPageSize());
        List<UserInfo> list=userInfoMapper.getMedicalByCondition(medicalCondition);
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(list);
        pageBean.setPages(pageInfo.getPages());
        pageBean.setTotal((int) pageInfo.getTotal());
        return list;
    }

    @Override
    public Integer countMedical() {
        return userInfoMapper.countMedical();
    }

    @Override
    public void addMedical(UserInfo userInfo, int level) {
        userInfo.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        userInfo.setCreateTime(new Date());
        userInfo.setIsdelete(true);
        userInfoMapper.insert(userInfo);
        System.out.println(userInfo.getUserinfoId());
        UserInfoRoleKey userInfoRoleKey=new UserInfoRoleKey();
        userInfoRoleKey.setUserinfoId(userInfo.getUserinfoId());
        if (level==1){
            userInfoRoleKey.setRoleId(5);
        }else if (level==0){
            userInfoRoleKey.setRoleId(6);
        }
        userInfoRoleMapper.insert(userInfoRoleKey);
    }

    @Override
    public void updateMedical(UserInfo userInfo, Boolean level) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if (level){
            userInfoRoleMapper.changeRoleB(userInfo.getUserinfoId());
            System.out.println("修改角色为医院对接人");
        }else if(!level){
            userInfoRoleMapper.changeRoleS(userInfo.getUserinfoId());
            System.out.println("修改角色为科室对接人");
        }
    }

    @Override
    public List<UserInfo> findAllShareholder(PageBean pageBean, ShareholderCondition shareholderCondition) {
        PageHelper.startPage(pageBean.getPageNum(),pageBean.getPageSize());
        List<UserInfo> list=userInfoMapper.getShareholderByCondition(shareholderCondition);
        PageInfo<UserInfo> pageInfo = new PageInfo<UserInfo>(list);
        pageBean.setPages(pageInfo.getPages());
        pageBean.setTotal((int) pageInfo.getTotal());
        for (UserInfo userInfo : list) {
            if (userInfo.getShareholder()==null){
                userInfo.setShareholder(new Shareholder());
            }
        }
        return list;
    }

    @Override
    public Integer countShareholder() {
        return userInfoMapper.countShareholder();
    }

    @Override
    public void addShareholder(UserInfo userInfo, int level, Shareholder shareholder) {
        userInfo.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        userInfo.setCreateTime(new Date());
        userInfo.setIsdelete(true);
        userInfoMapper.insert(userInfo);
        System.out.println(userInfo.getUserinfoId());
        UserInfoRoleKey userInfoRoleKey=new UserInfoRoleKey();
        userInfoRoleKey.setUserinfoId(userInfo.getUserinfoId());
        if (level==1){
            userInfoRoleKey.setRoleId(8);
            userInfoRoleMapper.insert(userInfoRoleKey);
            shareholder.setUserinfoId(userInfo.getUserinfoId());
            shareholderMapper.insert(shareholder);
        }else if(level==0){
            userInfoRoleKey.setRoleId(7);
            userInfoRoleMapper.insert(userInfoRoleKey);
        }
    }

    @Override
    public void updateShareholder(UserInfo userInfo, Boolean level, Shareholder shareholder) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if (level){
            userInfoRoleMapper.changeRoleGD(userInfo.getUserinfoId());
            System.out.println("修改角色为股东");
            Shareholder shareholder1=shareholderMapper.selectByPrimaryKey(userInfo.getUserinfoId());
            if (shareholder1!=null){
                shareholderMapper.updateByPrimaryKeySelective(shareholder);
            }else {
                shareholder.setUserinfoId(userInfo.getUserinfoId());
                shareholder.setShareholderTime(new Date());
                shareholderMapper.insert(shareholder);
            }
        }else if(!level){
            userInfoRoleMapper.changeRoleFXS(userInfo.getUserinfoId());
            System.out.println("修改角色为分销商");
            shareholderMapper.deleteByPrimaryKey(userInfo.getUserinfoId());
        }
    }

    /**
     * 查找分销商负责的医院
     * @param userinfoId
     * @return
     */
    @Override
    public List<Hospital> findAllInvestment(int userinfoId) {
        return hospitalMapper.findAllInvestment(userinfoId);
    }

    @Override
    public Integer countInvestment(int userinfoId) {
        HospitalExample example=new HospitalExample();
        HospitalExample.Criteria criteria=example.createCriteria();
        criteria.andDistributorIdEqualTo(userinfoId);
        return hospitalMapper.countByExample(example);
    }

    @Override
    public List<UserInfo> findByFaultSource(FaultCondition faultCondition) {
        return userInfoMapper.findByFaultSource(faultCondition);
    }

    @Override
    public UserInfo findById(Integer userinfoId) {
        return userInfoMapper.selectByPrimaryKey(userinfoId);
    }

    @Override
    public List<UserInfo> findRepairman(RepairCondition repairCondition) {
        return userInfoMapper.findRepairman(repairCondition);
    }
}
