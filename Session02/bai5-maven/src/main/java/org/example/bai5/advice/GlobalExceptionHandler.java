package org.example.bai5.advice;

import org.example.bai5.exceptions.EmployeeNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFound(EmployeeNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", "Nhân viên [" + ex.getCode() + "] không tồn tại trong hệ thống");
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleAny(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Có lỗi xảy ra. Vui lòng thử lại sau.");
        return "error";
    }
}

