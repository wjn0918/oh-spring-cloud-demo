package com.example.hello.spring.cloud.service.consumer.service.hystrix;

import com.example.hello.spring.cloud.service.consumer.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserService {
    @Override
    public String sayHi(String message) {
        return "sorry the service is hystrix";
    }
}
