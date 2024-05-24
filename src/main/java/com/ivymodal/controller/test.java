package com.ivymodal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {
    @RequestMapping("/home")
    public String home() {
        return "index";
    }
}
