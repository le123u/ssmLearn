package com.consoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/anno")
public class AnnoController {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username,
                                   @RequestParam(value = "pass") String password){
    // 作用：把请求中指定的名称参数传给控制器中的形参赋值
        // 属性 1.请求参数中的名称
        //2.required 请求参数中是否必须提供此参数，默认是true
        //    public String testRequestParam(@RequestParam( "name") String username){
        System.out.println("testRequestParam");
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
//        用于获取请求体的内容（注意：get方法不可以）
//        2. 属性
//        1. required：是否必须有请求体，默认值是true
        System.out.println("RequestBody");
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVarible/{sid}")
    public String testPathVarible(@PathVariable(name = "sid") String password){
        System.out.println("testPathVarible");
        System.out.println(password);
        return "success";
    }
}
