package com.ivymodal.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class BannerController {
    @GetMapping("/admin-banner")
    public String banner() {
        return "/admin/banner/index.html";
    }
}
