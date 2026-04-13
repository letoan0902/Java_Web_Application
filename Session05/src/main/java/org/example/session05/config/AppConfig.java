package org.example.session05.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Legacy entry point.
 *
 * Project hiện đã chuyển sang cấu hình Thymeleaf trong {@link WebConfig}.
 * Giữ class này để tránh lỗi nếu có chỗ khác vẫn import AppConfig.
 */
@Configuration
@Import(WebConfig.class)
public class AppConfig {}
