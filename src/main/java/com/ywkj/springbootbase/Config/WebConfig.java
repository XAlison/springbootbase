package com.ywkj.springbootbase.Config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.ywkj.springbootbase.HandlerInterceptor.LoginInterceptor;
import com.ywkj.springbootbase.Listener.ContextListener;
import com.ywkj.springbootbase.Servlet.ServletTest;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @ClassName: WebConfig
 * @Description: 配置Fastjson
 * @Author: Administrator
 * @Date: 2018/8/13 16:00
 * @Version 1.0
 */
@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter implements WebMvcConfigurer {
    public final static String SESSION_KEY="username";
    /**
     * 注册fastjs说on
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
       FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);

        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        return new HttpMessageConverters(converter);
    }

    /**
     * 注册servlet
     * @return
     */
   /* @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new ServletTest(),"/myServlet");
    }
*/
    /**
     * 注册监听器
     * @return
     */
    /*@Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean slrBean = new ServletListenerRegistrationBean();
        slrBean.setListener(new ContextListener());
        return slrBean;
    }*/

    @Bean
    public LoginInterceptor getSecurityInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
    /**
     * 注册拦截器
     * @return
     */
    public void addInterceptors(InterceptorRegistry registry) {
        //添加自定义拦截器和拦截路径，此处对所有请求进行拦截，除了登录界面和登录接口,还有静态资源不拦截
        registry.addInterceptor(getSecurityInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/verifyLogin","/user/login","/static/**","/plugin/**","static/plugin/**","/error");

        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/login**");

        addInterceptor.addPathPatterns("/**");
    }

    /**
     * @Description: 自定义资源映射addResourceHandlers
     * @Author: Administrator
     * @param: 
     * @Date: 2018/8/14 10:16
     * @Version 1.0
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/files/");
    }

}
