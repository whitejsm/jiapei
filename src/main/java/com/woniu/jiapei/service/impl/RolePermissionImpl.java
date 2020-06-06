package com.woniu.jiapei.service.impl;

import com.woniu.jiapei.mapper.RoleMapper;
import com.woniu.jiapei.model.Role;
import com.woniu.jiapei.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RolePermissionImpl implements RoleService {
    @Resource
    RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.selectByExample(null);
    }
}
