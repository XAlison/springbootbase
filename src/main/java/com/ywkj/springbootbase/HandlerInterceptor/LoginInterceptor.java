package com.ywkj.springbootbase.HandlerInterceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: LoginInterceptor
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2018/8/14 18:02
 * @Version 1.0
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    public final static String SESSION_KEY="username";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        HttpSession session = request.getSession();
        //用户已登录
        if (session.getAttribute(SESSION_KEY) != null) {
            return true;
        } else {
            //用户未登录，直接跳转登录页面
            response.sendRedirect("/login");
            return false;
        }

    }
}
