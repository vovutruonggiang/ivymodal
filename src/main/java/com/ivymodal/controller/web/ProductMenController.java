package com.ivymodal.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductMenController {
    @GetMapping("product-men")
    public String home() {
        return "/web/productMen.html";
    }
}
