package com.ivymodal.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductByCategory {
    @GetMapping("product-by-category")
    public String home() {
        return "/web/productByCategory.html";
    }
}
