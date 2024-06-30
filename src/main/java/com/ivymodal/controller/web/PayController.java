package com.ivymodal.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PayController {
    @GetMapping("pay")
    public String Pay(){
        return "/web/pay.html";
    }
}
