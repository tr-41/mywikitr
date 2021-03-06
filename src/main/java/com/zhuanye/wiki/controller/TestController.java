package com.zhuanye.wiki.controller;

import com.zhuanye.wiki.domain.Test;
import com.zhuanye.wiki.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController

public class TestController {

    @Resource
    private TestService testService;
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!Alice";
    }

    @GetMapping("/list")
    public List<Test> list(){
        return testService.list();
    }
}
