package com.ywkj.springbootbase.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName: ContextListener
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2018/8/14 10:19
 * @Version 1.0
 */
public class ContextListener implements ServletContextListener {

    public int count=0;//记录session的数量
    @Override
    public synchronized  void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("【HttpSessionListener监听器】count++  增加");
        count++;
        servletContextEvent.getServletContext().setAttribute("count", count);

    }

    @Override
    public synchronized void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("【HttpSessionListener监听器】count--  减少");
        count--;
        servletContextEvent.getServletContext().setAttribute("count", count);
    }
}
