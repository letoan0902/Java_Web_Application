# Bài 1 — Chẩn đoán luồng chết trong Spring MVC

## Phần 1 — Phân tích logic

### 1) Lỗi trong `MyWebAppInitializer.java`: vì sao mapping `"/api/*"` làm `/welcome` bị 404?

Trong Spring MVC (không Spring Boot), `DispatcherServlet` chỉ **nhận (intercept)** các request nằm trong **servlet mapping** mà bạn đăng ký.

- Nếu cấu hình mapping là `"/api/*"` thì **DispatcherServlet chỉ lắng nghe** các URL có dạng:
  - `/api/...` (ví dụ: `/api/welcome`, `/api/users`, ...)
- Request `/welcome` **không khớp** với mapping `/api/*` ⇒ request **không đi vào DispatcherServlet**.
- Khi không có servlet nào khác xử lý `/welcome`, Tomcat sẽ trả về **404 Not Found**.

Nói ngắn gọn: `"/api/*"` giới hạn DispatcherServlet vào namespace `/api/`, nên `/welcome` không bao giờ tới được Spring MVC.

### 2) Lỗi trong `WebConfig.java`: `@ComponentScan(basePackages = "com.demo.service")` gây hậu quả gì?

`@ComponentScan` quyết định Spring sẽ **quét annotation** (`@Controller`, `@Service`, `@Component`, ...) ở những package nào.

- Spring MVC cần tìm **`@Controller`** để tạo `HandlerMapping` (map URL → controller method).
- Nếu bạn cấu hình quét **sai package** (chỉ quét `com.demo.service`) trong khi controller nằm ở package khác (ví dụ `com.demo.controller` hoặc `com.demo`) thì:
  - Spring **không tạo bean controller**
  - `HandlerMapping` không có mapping nào cho `/welcome`
  - Kết quả: vẫn 404 (hoặc có thể 404 dạng "No mapping for GET /welcome") dù DispatcherServlet đã bắt request.

### 3) Tổng hợp: chỉ sửa lỗi 1 (Servlet Mapping) mà không sửa lỗi 2 (ComponentScan) có chạy không?

Không chạy đúng.

- Sửa lỗi 1 (mapping `"/"`) giúp request `/welcome` **đi vào DispatcherServlet**.
- Nhưng nếu `@ComponentScan` sai, Spring vẫn **không tìm thấy controller** ⇒ **không map được URL** ⇒ vẫn 404.

Muốn hiển thị JSP thành công cần **đồng thời**:
1) DispatcherServlet bắt được URL (`"/"`)
2) Spring scan đúng package chứa `@Controller`
3) ViewResolver trỏ đúng prefix/suffix để resolve JSP.

## Phần 2 — Thực thi

- File đã sửa/viết lại:
  - `src/main/java/org/example/session02/bai1/MyWebAppInitializer.java` (mapping `"/"`)
  - `src/main/java/org/example/session02/bai1/WebConfig.java` (scan đúng package `org.example.session02.bai1`)

- Controller giữ tối giản:
  - `src/main/java/org/example/session02/bai1/WelcomeController.java`

- View:
  - `src/main/webapp/WEB-INF/views/welcome.jsp`

