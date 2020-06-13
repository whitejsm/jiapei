package com.woniu.jiapei.mapper;

import com.woniu.jiapei.model.UserInfoRoleExample;
import com.woniu.jiapei.model.UserInfoRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoRoleMapper {
    int countByExample(UserInfoRoleExample example);

    int deleteByExample(UserInfoRoleExample example);

    int deleteByPrimaryKey(UserInfoRoleKey key);

    int insert(UserInfoRoleKey record);

    int insertSelective(UserInfoRoleKey record);

    List<UserInfoRoleKey> selectByExample(UserInfoRoleExample example);

    int updateByExampleSelective(@Param("record") UserInfoRoleKey record, @Param("example") UserInfoRoleExample example);

    int updateByExample(@Param("record") UserInfoRoleKey record, @Param("example") UserInfoRoleExample example);

    void changeRoleB(Integer userinfoId);

    void changeRoleS(Integer userinfoId);

    void changeRoleGD(Integer userinfoId);

    void changeRoleFXS(Integer userinfoId);
}