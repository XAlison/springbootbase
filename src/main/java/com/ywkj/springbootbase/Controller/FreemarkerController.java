package com.ywkj.springbootbase.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @ClassName: FreemarkerController
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2018/8/13 16:32
 * @Version 1.0
 */
@Controller
@RequestMapping("freemarker")
public class FreemarkerController {

    @RequestMapping("hello")
    public String hello(Map<String,Object> map) {
        map.put("msg", "Hello Freemarker");
        return "hello";
    }
}