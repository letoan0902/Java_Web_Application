package com.restaurant.bai3.controller;

import com.restaurant.bai3.service.AdminDishService;
import com.restaurant.common.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bai3")
public class AdminDishController {

    private final AdminDishService adminDishService;

    public AdminDishController(AdminDishService adminDishService) {
        this.adminDishService = adminDishService;
    }

    /**
     * Hiển thị danh sách món ăn (dành cho admin).
     */
    @GetMapping("/dishes")
    public String listDishes(Model model) {
        List<Dish> dishList = adminDishService.findAll();
        model.addAttribute("dishList", dishList);
        return "bai3/dish-list";
    }

    /**
     * Hiển thị form chỉnh sửa món ăn.
     * Nếu ID không tồn tại -> redirect về danh sách kèm thông báo lỗi.
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Dish> dishOpt = adminDishService.findById(id);
        if (dishOpt.isEmpty()) {
            // Dùng Flash Attribute để giữ thông báo lỗi qua redirect
            redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai3/dishes";
        }
        model.addAttribute("dish", dishOpt.get());
        return "bai3/edit-dish";
    }

    /**
     * Xử lý lưu thông tin chỉnh sửa món ăn.
     */
    @PostMapping("/edit/{id}")
    public String save(@PathVariable int id, @ModelAttribute Dish dish, RedirectAttributes redirectAttributes) {
        dish.setId(id);
        adminDishService.save(dish);
        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật món ăn thành công!");
        return "redirect:/bai3/dishes";
    }
}
