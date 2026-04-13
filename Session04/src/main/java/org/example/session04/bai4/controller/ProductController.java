package org.example.session04.bai4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bai4")
public class ProductController {

    @GetMapping("/products")
    public String listProducts(
            @RequestParam("category") String category,
            @RequestParam("limit") int limit,
            ModelMap modelMap
    ) {
        modelMap
                .addAttribute("category", category)
                .addAttribute("limit", limit)
                .addAttribute("message", "Tim kiem thanh cong");

        return "productList";
    }
}

