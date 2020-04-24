package com.example.hello.spring.cloud.service.consumer.controller;

import com.example.hello.spring.cloud.service.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    String sayHi(String message) {
        return userService.sayHi(message);
    }

}
