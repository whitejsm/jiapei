package com.woniu.jiapei.mapper;

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
}
