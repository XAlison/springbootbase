package com.ywkj.springbootbase.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * @ClassName: CustomFilter
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2018/8/14 10:03
 * @Version 1.0
 */
public class CustomFilter   implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.print("自定义过滤器->filterConfig");
    }


    public void doFiltr(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.err.print("自定义过滤器->doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }


    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
