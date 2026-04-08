package org.example.bai5.services;

import org.example.bai5.models.Employee;
import org.example.bai5.models.EmployeeStatus;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InMemoryEmployeeService implements EmployeeService {

    private final List<Employee> employees;

    public InMemoryEmployeeService() {
        employees = new ArrayList<>();
        employees.add(new Employee("NV001", "Nguyễn Thị Lan", "Kế toán", 15_000_000L, dateOf(2020, Calendar.MARCH, 1), EmployeeStatus.DANG_LAM));
        employees.add(new Employee("NV002", "Trần Văn Hùng", "Kỹ thuật", 25_000_000L, dateOf(2019, Calendar.JULY, 15), EmployeeStatus.DANG_LAM));
        employees.add(new Employee("NV003", "Lê Minh Đức", "Kinh doanh", 18_500_000L, dateOf(2021, Calendar.NOVEMBER, 20), EmployeeStatus.NGHI_PHEP));
        employees.add(new Employee("NV004", "Phạm Thu Hương", "Kỹ thuật", 22_000_000L, dateOf(2022, Calendar.JANUARY, 5), EmployeeStatus.DANG_LAM));
        employees.add(new Employee("NV005", "Hoàng Văn Nam", "Kế toán", 12_000_000L, dateOf(2023, Calendar.JUNE, 10), EmployeeStatus.THU_VIEC));
    }

    private static java.util.Date dateOf(int year, int month, int dayOfMonth) {
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

    @Override
    public List<Employee> findAll() {
        return List.copyOf(employees);
    }

    @Override
    public Optional<Employee> findByCode(String code) {
        return employees.stream().filter(e -> e.getCode().equalsIgnoreCase(code)).findFirst();
    }

    @Override
    public long sumSalaryByDepartment(String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .mapToLong(Employee::getSalary)
                .sum();
    }
}


