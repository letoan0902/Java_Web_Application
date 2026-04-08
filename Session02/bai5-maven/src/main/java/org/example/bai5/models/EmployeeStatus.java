package org.example.bai5.models;

public enum EmployeeStatus {
    DANG_LAM("Đang làm"),
    NGHI_PHEP("Nghỉ phép"),
    THU_VIEC("Thử việc");

    private final String displayName;

    EmployeeStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

