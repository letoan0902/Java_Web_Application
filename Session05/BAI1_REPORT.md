# Bài 1 – Phá án lỗi kết xuất giao diện (ViewResolver)

## Ít nhất 2 điểm sai trong cấu hình giả
Code sai:
```java
resolver.setPrefix("/WEB-INF/views");
resolver.setSuffix(".jsp");
```

### Sai 1: Trỏ sai thư mục template
- Theo chuẩn cấu hình Thymeleaf trong Spring MVC thuần, template HTML nên đặt ở thư mục **`/WEB-INF/templates/`**.
- `/WEB-INF/views/` thường là convention cho **JSP** trong cấu hình `InternalResourceViewResolver`.

### Sai 2: Dùng sai hậu tố (suffix)
- Thymeleaf (trong bài) dùng template **`.html`**, không phải `.jsp`.
- Nếu suffix là `.jsp`, Spring sẽ cố tìm file JSP (không phải Thymeleaf template) nên có thể dẫn tới lỗi 404/500 hoặc render sai.

### (Gợi ý thêm) Sai 3: Thiếu các bean còn lại của Thymeleaf
Chỉ cấu hình `SpringResourceTemplateResolver` là chưa đủ. Chuỗi cần có:
- `SpringResourceTemplateResolver`
- `SpringTemplateEngine`
- `ThymeleafViewResolver`

## Cấu hình đúng (đã code trong `com.restaurant.bai1.WebConfig`)
- Prefix: `/WEB-INF/templates/`
- Suffix: `.html`
- UTF-8
- (Có) đăng ký `LayoutDialect` trong `SpringTemplateEngine`

> Lưu ý: project đang khởi tạo Spring MVC bằng `AppInit -> AppConfig`. File `WebConfig` là để nộp bài theo yêu cầu package `com.restaurant.bai1`.

