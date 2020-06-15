package com.woniu.jiapei.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 * @author 周元皓丶
 */
@RestController
public class LoginController {
    public void dev(){
        System.out.println("123");
    }
    /*
    登录
     */
    @GetMapping("/login")
    public String login(String uname, String upass, ModelMap map){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(uname,upass);
        try{
            subject.login(token);
            System.out.println("登录成功");
            return "redirect:/admin/index.jsp";
        }catch(UnknownAccountException unknownAccountException){
            System.out.println("账户不存在");
            map.put("error","账户不存在");
            return "/index";
        }catch(IncorrectCredentialsException incorrectCredentialsException){
            System.out.println("口令和账户不匹配");
            map.put("error","口令和账户不匹配");
            return "/index";
        }catch (Exception e){
            map.put("error","登录失败");
            System.out.println("登录失败");
            return "/index";
        }
    }
    /*
    注销
     */
    @RequestMapping("/admin/logout")
    public String logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "/tologin";
    }
}
