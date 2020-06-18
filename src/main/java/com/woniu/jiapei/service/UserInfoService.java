package com.woniu.jiapei.service;

import com.woniu.jiapei.condition.AccountingCondition;
import com.woniu.jiapei.condition.FaultCondition;
import com.woniu.jiapei.condition.MedicalCondition;
import com.woniu.jiapei.condition.ShareholderCondition;
import com.woniu.jiapei.model.Hospital;
import com.woniu.jiapei.model.Shareholder;
import com.woniu.jiapei.model.Role;
import com.woniu.jiapei.model.UserInfo;
import com.woniu.jiapei.tools.PageBean;

import java.util.List;

public interface UserInfoService {
    public UserInfo findByName(String username);

    List<UserInfo> findAllAccounting(PageBean pageBean, AccountingCondition accountingCondition);

    Integer countAccounting();

    void addAccounting(UserInfo userInfo);

    void updateAccounting(UserInfo userInfo);

    List<UserInfo> findAllRepairman(PageBean pageBean, AccountingCondition accountingCondition);

    Integer countRepairman();

    void addRepairman(UserInfo userInfo);

    void updateRepairman(UserInfo userInfo);

    List<UserInfo> findAllMedical(PageBean pageBean, MedicalCondition medicalCondition);

    Integer countMedical();

    void addMedical(UserInfo userInfo, int level);

    void updateMedical(UserInfo userInfo, Boolean level);

    List<UserInfo> findAllShareholder(PageBean pageBean, ShareholderCondition shareholderCondition);

    Integer countShareholder();

    void addShareholder(UserInfo userInfo, int level, Shareholder shareholder);

    void updateShareholder(UserInfo userInfo, Boolean level, Shareholder shareholder);

    List<Hospital> findAllInvestment(int userinfoId);

    Integer countInvestment(int userinfoId);

    Role findRoleByUserId(Integer userinfoId);

    List<UserInfo> findByFaultSource(FaultCondition faultCondition);

    UserInfo findById(Integer userinfoId);

    List<UserInfo> getDistributor(Integer userId);

    List<UserInfo> downloadAccount(AccountingCondition accountingCondition);

    List<UserInfo> downloadRepairman(AccountingCondition accountingCondition);

    List<UserInfo> downloadShareholder(ShareholderCondition shareholderCondition);

    List<UserInfo> downloadMedicalList(MedicalCondition medicalCondition);

    void resetPassword(UserInfo userInfo);

    int changePassword(String newPs, UserInfo userInfo);
}
