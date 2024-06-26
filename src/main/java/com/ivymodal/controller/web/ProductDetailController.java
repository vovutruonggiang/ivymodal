package com.ivymodal.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductDetailController {
    @GetMapping("product-detail")
    public String home() {
        return "/web/productDetail.html";
    }
}
