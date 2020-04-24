package com.example.hello.spring.cloud.service.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

//    获取application.yml中配置
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHi(String message){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String name = request.getHeader("username");
        return String.format("you are message is : %s , port is : %s，name is ：%s" , message, port, name);
    }


}
