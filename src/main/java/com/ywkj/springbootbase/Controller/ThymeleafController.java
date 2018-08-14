package com.ywkj.springbootbase.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @ClassName: ThymeleafController
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2018/8/13 16:14
 * @Version 1.0
 */
@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @RequestMapping("hello")
    public String hello(Map<String,Object> map) {
        map.put("msg", "Hello Thymeleaf");
        return "hello";
    }
}