package com.ivymodal.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/admin-product")
    public String Product() {
        return "admin/product/index.html";
    }
}
