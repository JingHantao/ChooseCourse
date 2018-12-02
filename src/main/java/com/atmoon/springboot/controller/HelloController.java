package com.atmoon.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world quick!";
    }
    @RequestMapping("/welcome")
    public String hello1(){
        return "you are welcome quick!";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        return "hello2";
    }
    @GetMapping("index")
    public String home(){
        return "index";
    }
}
