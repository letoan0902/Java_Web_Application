package org.example.session02.bai3.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLogin() {
        return "bai3/login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpServletRequest request,
                          Model model) {

        boolean okAdmin = "admin".equals(username) && "admin123".equals(password);
        boolean okStaff = "staff".equals(username) && "staff123".equals(password);

        if (!okAdmin && !okStaff) {
            // Request scope: chỉ hiển thị 1 lần
            model.addAttribute("errorMessage", "Sai username hoặc password");
            return "bai3/login";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("loggedUser", username);
        session.setAttribute("role", okAdmin ? "admin" : "staff");

        return "redirect:/orders";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/login";
    }
}

