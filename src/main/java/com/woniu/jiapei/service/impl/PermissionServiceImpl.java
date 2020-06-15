package com.woniu.jiapei.service.impl;

import com.woniu.jiapei.mapper.PermissionMapper;
import com.woniu.jiapei.model.Permission;
import com.woniu.jiapei.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 周元皓丶
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    PermissionMapper permissionMapper;

    /*
    拿到所有权限
     */
    @Override
    public List findAll() {
        return permissionMapper.selectByExample(null);
    }

    @Override
    public List findPermissionsById(int userInfoId) {
        return  permissionMapper.findByUid(userInfoId);
    }
}
