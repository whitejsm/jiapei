package com.woniu.jiapei.mapper;

import com.woniu.jiapei.condition.AccountingCondition;
import com.woniu.jiapei.condition.MedicalCondition;
import com.woniu.jiapei.condition.ShareholderCondition;
import com.woniu.jiapei.model.Role;
import com.woniu.jiapei.model.UserInfo;
import com.woniu.jiapei.model.UserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
    List<UserInfo> findByRoleNameDistributor1(String name);

    List<UserInfo> findByRoleNameDistributor2(String name);

    List<UserInfo> findByRoleName(String name);

    List<UserInfo> findDistributor();

    int countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Integer userinfoId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Integer userinfoId);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo findByName(String username);


    List<UserInfo> getAccountingByCondition(AccountingCondition accountingCondition);

    Integer countRepairman();

    List<UserInfo> getRepairmanByCondition(AccountingCondition accountingCondition);

    List<UserInfo> getMedicalByCondition(MedicalCondition medicalCondition);

    Integer countMedical();

    List<UserInfo> getShareholderByCondition(ShareholderCondition shareholderCondition);

    Integer countShareholder();

    Integer countAccounting();
}
