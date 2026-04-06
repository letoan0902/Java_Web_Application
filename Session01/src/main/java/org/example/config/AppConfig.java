package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    // Lớp cấu hình: Spring sẽ quét toàn bộ package org.example
    // để tìm các class có @Component và đăng ký chúng làm Bean.
}
