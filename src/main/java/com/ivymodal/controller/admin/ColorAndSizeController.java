package com.ivymodal.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ColorAndSizeController {
    @GetMapping("/admin-color-size")
    public String banner() {
        return "/admin/color_and_size/index.html";
    }
}
