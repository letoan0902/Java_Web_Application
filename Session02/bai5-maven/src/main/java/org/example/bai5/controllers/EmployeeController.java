package org.example.bai5.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.bai5.exceptions.EmployeeNotFoundException;
import org.example.bai5.models.Employee;
import org.example.bai5.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String listEmployees(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        List<Employee> employees = employeeService.findAll();
        long techTotal = employeeService.sumSalaryByDepartment("Kỹ thuật");

        model.addAttribute("employees", employees);
        model.addAttribute("techTotalSalary", techTotal);
        return "employees";
    }

    @GetMapping("/employees/{code}")
    public String employeeDetail(@PathVariable String code,
                                 HttpServletRequest request,
                                 Model model) {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        Employee emp = employeeService.findByCode(code)
                .orElseThrow(() -> new EmployeeNotFoundException(code));

        model.addAttribute("emp", emp);
        return "employee-detail";
    }
}

