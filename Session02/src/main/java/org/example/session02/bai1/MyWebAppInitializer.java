package org.example.session02.bai1;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.example.session02.bai1.WebConfig;

/**
 * Bài 1 (demo lỗi cấu hình Spring MVC).
 *
 * Bản đã sửa đúng: DispatcherServlet bắt toàn bộ URL ("/") để mapping được /welcome.
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // FIX: không dùng "/api/*" vì sẽ chỉ bắt request bắt đầu bằng /api/
        return new String[]{"/"};
    }
}
