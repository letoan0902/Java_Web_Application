package org.example;

import org.example.config.AppConfig;
import org.example.model.SystemConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo Spring Container bằng Java Config (không dùng XML)
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Lấy Bean SystemConfig từ Container
        SystemConfig config = context.getBean(SystemConfig.class);

        // In thông tin cấu hình ra màn hình
        System.out.println(config);
    }
}