package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*@ResponseBody
@Controller*/
@Slf4j
@RestController
public class HelloController {

    @Autowired
    Car car;

    @Autowired
    Person person;
    @RequestMapping("/car")
    public Car testcar(){
        return car;
    }
    @RequestMapping("/hello")
    public String handle01(){
        log.info("请求进来了");
        return "Hello,Spring Boot 2!";
    }
    @RequestMapping("/person")
    public Person person(){
        System.out.println(person.getUserName());
        return person;
    }
}
