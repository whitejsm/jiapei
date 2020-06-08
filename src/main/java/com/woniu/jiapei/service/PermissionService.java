package com.woniu.jiapei.service;

import java.util.List;

public interface PermissionService {
    public List findAll();

    List findPermissionsById(int userInfoId);
}
