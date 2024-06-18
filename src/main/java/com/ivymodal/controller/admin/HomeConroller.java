package com.ivymodal.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeConroller {
    @RequestMapping("admin")
    public String home() {
        return "/admin/index.html";
    }
}
