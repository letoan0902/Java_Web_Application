package org.example.session03.controller;

import org.example.session03.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Nguyễn Văn A", "Đào tạo", 9500));
        employees.add(new Employee(2, "Trần Thị B", "Đào tạo", 10000));
        employees.add(new Employee(3, "Lê Văn C", "Đào tạo", 15000));

        model.addAttribute("employees", employees);
        return "employee-list";
    }
}

