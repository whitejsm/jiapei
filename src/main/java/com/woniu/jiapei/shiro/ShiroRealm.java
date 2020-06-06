package com.woniu.jiapei.shiro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.jiapei.model.Permission;
import com.woniu.jiapei.model.Role;
import com.woniu.jiapei.model.UserInfo;
import com.woniu.jiapei.service.UserInfoService;
import lombok.SneakyThrows;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.reflect.generics.tree.Tree;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ShiroRealm extends AuthorizingRealm {

    @Resource
    UserInfoService userInfoServiceImpl;

    //授权------赋予权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        UserInfo userinfo=userInfoServiceImpl.findByName(username);

        System.out.println("给"+username+"授权");

        //根据用户名查询数据库得到用户应有的角色，并且进行设置
        List<Role> roles = userinfo.getRoles();
        List<String> permission = new ArrayList<>();
        List<Permission> permissions=userinfo.getPermissions();
        for (Permission p : permissions) {
            if (p.getUrl()!=null&&!p.getUrl().equals("")){
                String url=p.getUrl();
                url=url.substring(0,url.lastIndexOf("/")+1)+":**";
                System.out.println(url+"个人权限");
                permission.add(url);
            }
        }

        SimpleAuthorizationInfo sai = new SimpleAuthorizationInfo();
        for (Role role : roles) {
            sai.addRole(role.getRoleName());
        }
        sai.addStringPermissions(permission);
        return sai;
    }

    //认证------登录
    @SneakyThrows
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        System.out.println(username);

        UserInfo userinfo=userInfoServiceImpl.findByName(username);

        if (userinfo==null){
            throw new UnknownAccountException();
        }else{
            HttpServletRequest request= ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
            List permissions=userinfo.getPermissions();

            ObjectMapper mapper = new ObjectMapper();
            String jsonRoleTree=mapper.writeValueAsString(permissions);
            request.getSession().setAttribute("permissions",jsonRoleTree);
        }

        SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(userinfo.getUsername(),userinfo.getPassword(),getName());
        return sai;
    }

}
