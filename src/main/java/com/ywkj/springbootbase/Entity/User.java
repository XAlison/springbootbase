package com.ywkj.springbootbase.Entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2018/8/13 16:02
 * @Version 1.0
 */
public class User {
    private  String name;
    private  String age;
    private  String addr;
    @JSONField(format="yyyy-MM-dd")
    private Date birthday;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
