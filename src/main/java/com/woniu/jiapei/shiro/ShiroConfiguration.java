package com.woniu.jiapei.shiro;

import com.woniu.jiapei.model.Permission;
import com.woniu.jiapei.service.PermissionService;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.reflect.generics.tree.Tree;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfiguration {
    @Resource
    PermissionService permissionServiceImpl;
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setLoginUrl("/index.jsp");
        //登录失败后去哪里
        factoryBean.setSuccessUrl("/admin/index.jsp");
        //认证成功后去哪里
        factoryBean.setUnauthorizedUrl("/unauthorized.jsp");
        //认证失败后去哪里
        factoryBean.setSecurityManager(securityManager);

        Map map = new LinkedHashMap();
        map.put("/*","anon");
        map.put("/login","anon");
        map.put("/index.jsp","anon");
        map.put("/static/**","anon");
        map.put("/css/**","anon");
        map.put("/jquery/**","anon");
        map.put("/ztree/**","anon");

        List<Permission> permissions=permissionServiceImpl.findAll();
        for (Permission p : permissions) {
            if(p.getUrl()!=null&&!p.getUrl().equals("")){
                String url=p.getUrl();
                url=url.substring(0,url.lastIndexOf("/")+1);
                System.out.println(url+"总权限");
                map.put(url+"**","perms["+url+":**]");
            }
        }

        map.put("/admin/**","authc");
        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }

    @Bean
    public SecurityManager securityManager(ShiroRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public ShiroRealm realm(){
        ShiroRealm realm = new ShiroRealm();
        return realm;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(securityManager);
        return aasa;
    }
}
