package com.ywkj.springbootbase.Controller;

import com.ywkj.springbootbase.Entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MemberController
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2018/8/13 14:20
 * @Version 1.0
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    @RequestMapping("/helloWorld")
    public String helloWorld() {
        return "helloworld";
    }

    @RequestMapping("hello")
    public String hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "Hello Thymeleaf");
        return "hello";
    }

    @RequestMapping("getUsers")
    @ResponseBody
    public User getUsers() {
        User user = new User();
        user.setAddr("A");
        user.setAge("18");
        user.setName("zhangsna");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping("/getCountUser")
    @ResponseBody
    public String getCountUser(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {  //把sessionId记录在浏览器
            Cookie c = new Cookie("JSESSIONID", URLEncoder.encode(httpServletRequest.getSession().getId(), "utf-8"));
            c.setPath("/");
            //先设置cookie有效期为2天，不用担心，session不会保存2天
            c.setMaxAge(48 * 60 * 60);
            httpServletResponse.addCookie(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpSession session = httpServletRequest.getSession();
        Object count = session.getServletContext().getAttribute("count");
        return "count : " + count;
    }

}
