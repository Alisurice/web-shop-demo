package com.demo.base.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(value = "test swagger", tags = "test")
public class TestCon {
    @RequestMapping("/")
    public String test(Model model){
        System.out.println("test controller");
        model.addAttribute("test","中文韦利卡了解对方");
        return "test";
    }
}
