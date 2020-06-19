package com.woniu.jiapei.controller;

import com.woniu.jiapei.model.Role;
import com.woniu.jiapei.model.UserInfo;
import com.woniu.jiapei.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 周元皓丶
 */
@RestController
public class LoginController {
    @Resource
    UserInfoService userInfoServiceImpl;
    /*
    登录
     */
    @GetMapping("/login")
    public Map<String, Object> login(HttpSession session, String uname, String upass){
        upass= DigestUtils.md5DigestAsHex(upass.getBytes());
        Map<String, Object> map=new HashMap<>();
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(uname,upass);
        try{
//            subject.login(token);
            System.out.println("登录成功");
            UserInfo userinfo= userInfoServiceImpl.findByName(uname);
            Role role = userInfoServiceImpl.findRoleByUserId(userinfo.getUserinfoId());
            Integer userId=userinfo.getUserinfoId();
            String  userName=userinfo.getName();

            // 用户信息存入session
            session.setAttribute( "userId", userId);
            session.setAttribute( "userName", userName);
            session.setAttribute( "roleId", role.getRoleId());
            session.setAttribute( "roleName", role.getRolename());

            map.put("roleId", role.getRoleId());
            map.put("roleName", role.getRolename());
            map.put("status","success");
            map.put("userId",String.valueOf(userId));
            map.put("userName",userName);
        }catch(UnknownAccountException unknownAccountException){
            System.out.println("账户不存在或账户未启用");
            map.put("status","error");
            map.put("msg","账户不存在或账户未启用");
        }catch(IncorrectCredentialsException incorrectCredentialsException){
            System.out.println("口令和账户不匹配");
            map.put("status","error");
            map.put("msg","口令和账户不匹配");
        }catch (Exception e){
            map.put("status","error");
            System.out.println("登录失败");
            map.put("msg","登录失败");
            e.printStackTrace();
        }
        return map;
    }
    /*
    注销
     */
    @GetMapping("/logout")
    public void logout(){
        System.out.println("退出系统");
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
//        return "/tologin";
    }


    @PostMapping("changePassword")
    public Boolean changePassword(String newPs,HttpSession session){
        boolean flag=false;
        try{
            UserInfo userInfo=new UserInfo();
            userInfo.setUserinfoId((int)(session.getAttribute("userId")));
            int a=userInfoServiceImpl.changePassword(newPs,userInfo);
            if (a>0){
                flag=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
