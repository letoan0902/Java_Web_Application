public class Employee {
    private final String code;
    private final String fullName;
    private final String department;
    private final long salary;
    private final java.util.Date joinDate;
    private final EmployeeStatus status;

    public Employee(String code, String fullName, String department, long salary, java.util.Date joinDate, EmployeeStatus status) {
        this.code = code;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDepartment() {
        return department;
    }

    public long getSalary() {
        return salary;
    }

    public java.util.Date getJoinDate() {
        return joinDate;
    }

    public EmployeeStatus getStatus() {
        return status;
    }
}


