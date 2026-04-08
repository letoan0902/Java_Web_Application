# Bài 5 — Mini HR Portal (Spring MVC 6.x + Tomcat 10+)

## Ràng buộc đã đáp ứng

- Java Config thuần: dùng `AbstractAnnotationConfigDispatcherServletInitializer` (không `web.xml`, không `spring-servlet.xml`).
- Spring MVC: **6.1.x**
- Jakarta Servlet: **6.0** (Tomcat 10.1+)
- Build: **Maven WAR**
- JSTL URI: `jakarta.tags.*`
- JSP: không dùng scriptlet

## Chạy build

```powershell
cd "D:\Java Web\Session02\bai5-maven"
mvn -q clean package
```

WAR output:
- `target/bai5-hr-portal.war`

## URL

- `/login` (GET/POST)
- `/employees` (GET)
- `/employees/{code}` (GET)
- `/logout` (GET)

Tài khoản mẫu:
- `hr_manager` / `hr123`
- `hr_staff` / `staff456`

## Ghi chú triển khai

Deploy `target/bai5-hr-portal.war` lên Tomcat 10.1+.

