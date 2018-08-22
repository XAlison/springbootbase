package com.ywkj.springbootbase.Controller;

import com.ywkj.springbootbase.Entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2018/8/14 18:06
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    @ResponseBody
    public String login(HttpSession session,User user) {
        //模拟登录
        if ("admin".equals( user.getUserName()) && "123456".equals(user.getPassWord())) {
            session.setAttribute("user", user);
            return "登录成功！";
        }
        return "登录失败，请核对用户名密码后重试！";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login";
    }
}