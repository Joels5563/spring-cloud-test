/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */
package cloud.simple.service;

import cloud.simple.model.UserInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouchao
 * @Description 用户服务
 * @date 2017/10/17 14:31
 */
@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    private static final String SERVICE_NAME = "cloud-service";

    @HystrixCommand(fallbackMethod = "fallbackSearchAll")
    @SuppressWarnings("unchecked")
    public List<UserInfo> readUserInfo() {
        return restTemplate.getForObject("http://" + SERVICE_NAME + "/user", List.class);
    }

    public List<UserInfo> fallbackSearchAll() {
        System.out.println("HystrixCommand fallbackMethod handle!");
        List<UserInfo> ls = new ArrayList<>();
        UserInfo user = new UserInfo();
        user.setUsername("TestHystrixCommand");
        ls.add(user);
        return ls;
    }
}
