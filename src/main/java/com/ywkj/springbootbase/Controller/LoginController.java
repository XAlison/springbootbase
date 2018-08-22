package com.ywkj.springbootbase.Controller;

import com.ywkj.springbootbase.Config.WebConfig;
import com.ywkj.springbootbase.Entity.User;
import com.ywkj.springbootbase.HandlerInterceptor.LoginInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

/**
 * Created by huangds on 2017/10/24.
 */
@Controller
public class LoginController {


    @GetMapping("/")
    public String index(@SessionAttribute(WebConfig.SESSION_KEY)String account, Model model){

        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/loginVerify")
    public String loginVerify( User user, HttpSession session){
        //模拟登录
        if ("admin".equals(user.getUserName()) && "123456".equals(user.getPassWord())) {
            session.setAttribute(LoginInterceptor.SESSION_KEY, user);
            return "index";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(LoginInterceptor.SESSION_KEY);
        return "redirect:/login";
    }
}
