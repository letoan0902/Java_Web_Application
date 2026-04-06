package org.example.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {

    @Value("Cyber Center - Chi nhánh Hà Nội")
    private String branchName;

    @Value("08:00")
    private String openingHour;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(String openingHour) {
        this.openingHour = openingHour;
    }

    @Override
    public String toString() {
        return "=== Thông tin cấu hình hệ thống ===" +
                "\nTên chi nhánh : " + branchName +
                "\nGiờ mở cửa   : " + openingHour;
    }
}
