/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */

package cloud.simple.web;

import cloud.simple.model.User;
import cloud.simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * @author zhouchao
 * @Description 用户控制器
 * @date 2017/10/17 14:31
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private DiscoveryClient client;

    /**
     * 创建负载均衡的Restful调用
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/users")
    public ResponseEntity<List<User>> readUserInfo() {
        ServiceInstance instance = client.getLocalServiceInstance();
        System.out.println("/users, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        List<User> users = userService.readUserInfo();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
