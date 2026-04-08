package org.example.session02.bai3.controllers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.session02.bai3.models.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class OrderController {

    private static final String TOTAL_VIEW_COUNTER_KEY = "totalViewCount";

    @GetMapping("/orders")
    public String orders(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        // Fake orders (hardcode)
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("OD001", "Bàn phím cơ", 850_000L, dateOf(2026, Calendar.MARCH, 10)));
        orders.add(new Order("OD002", "Chuột không dây", 320_000L, dateOf(2026, Calendar.MARCH, 18)));
        orders.add(new Order("OD003", "Tai nghe", 1_250_000L, dateOf(2026, Calendar.APRIL, 2)));
        orders.add(new Order("OD004", "Màn hình 24 inch", 3_600_000L, dateOf(2026, Calendar.APRIL, 6)));

        model.addAttribute("orders", orders); // request scope

        // Application scope counter (thread-safe)
        ServletContext application = request.getServletContext();
        AtomicInteger counter;
        synchronized (application) {
            counter = (AtomicInteger) application.getAttribute(TOTAL_VIEW_COUNTER_KEY);
            if (counter == null) {
                counter = new AtomicInteger(0);
                application.setAttribute(TOTAL_VIEW_COUNTER_KEY, counter);
            }
        }
        int current = counter.incrementAndGet();
        model.addAttribute("totalViewCount", current);

        return "bai3/orders";
    }

    private static Date dateOf(int year, int month, int dayOfMonth) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}

