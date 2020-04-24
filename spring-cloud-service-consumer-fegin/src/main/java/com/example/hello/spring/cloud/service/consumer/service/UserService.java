package com.example.hello.spring.cloud.service.consumer.service;

import com.example.hello.spring.cloud.service.consumer.service.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hello-spring-cloud-service-provider", fallback = UserServiceHystrix.class)
public interface UserService {

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    String sayHi(@RequestParam("message") String message);
}
