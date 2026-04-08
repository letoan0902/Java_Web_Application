package org.example.bai5.controllers;

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
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpServletRequest request,
                        Model model) {

        boolean manager = "hr_manager".equals(username) && "hr123".equals(password);
        boolean staff = "hr_staff".equals(username) && "staff456".equals(password);

        if (!manager && !staff) {
            model.addAttribute("errorMessage", "Sai username hoặc password");
            return "login"; // forward
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("loggedUser", username);
        session.setAttribute("role", manager ? "hr_manager" : "hr_staff");

        return "redirect:/employees";
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

