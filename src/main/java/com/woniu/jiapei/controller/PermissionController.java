package com.woniu.jiapei.controller;

import com.woniu.jiapei.model.Permission;
import com.woniu.jiapei.model.UserInfo;
import com.woniu.jiapei.service.PermissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PermissionController {
    @Resource
    PermissionService permissionServiceImpl;

    @GetMapping("/getPermissions")
    public Map getUserPermissions(int userInfoId){
        System.out.println(userInfoId);
        List<Permission> permissionList=new ArrayList<>();
        permissionList=permissionServiceImpl.findPermissionsById(userInfoId);
        Map<Integer,Permission> permissionMap = new HashMap<Integer,Permission>();
        //先将所有的许可放入map
        for (Permission permission : permissionList) {
            //permission.setOpen(true);
            permissionMap.put(permission.getId(), permission);
        }
        //声明ztree
        List<Permission> ztree = new ArrayList<Permission>();
        Map<String,Object> map = new HashMap<String,Object>();
        //再循环将ztree所需要的json结构组装
        for(Permission permission : permissionList) {
            //判断该许可是否为根节点
            if(permission.getPid()==null) {
                ztree.add(permission);
            }else {
                //如果不是根节点
                //找出它的父节点
                Permission parent = permissionMap.get(permission.getPid());
                //并将当前节点添加到父节点的children中
                parent.getChildren().add(permission);
            }
        }
        System.out.println(ztree);
        map.put("permissionList", ztree);
        return map;
    }
}
