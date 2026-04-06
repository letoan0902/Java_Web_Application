# Bài 4: So sánh các phương pháp Dependency Injection

## Bảng so sánh

| Tiêu chí | Constructor Injection | Field Injection |
|---|---|---|
| Cú pháp | Tiêm qua constructor | Đặt `@Autowired` trên field |
| Hỗ trợ `final` | Có | Không |
| Đảm bảo not null | Có, fail ngay khi khởi tạo | Không, có thể null |
| Viết Unit Test | Dễ, truyền mock qua constructor | Khó, phải dùng Reflection |
| Đọc hiểu code | Nhìn constructor biết ngay cần gì | Phải đọc từng field |
| Số dòng code | Nhiều hơn một chút | Ít hơn |
| Spring khuyên dùng | Có | Không |

## Xử lý bẫy dữ liệu: SMS bị đứt mạng

Việc mạng SMS bị đứt là lỗi runtime, xử lý bằng try-catch trong method, không liên quan đến cách inject:

```java
public void notifyDeduction(String username, double amount) {
    String message = "Tài khoản " + username + " đã bị trừ " + amount + "đ";
    emailSender.send(username, message);
    try {
        smsSender.send(username, message);
    } catch (Exception e) {
        System.err.println("SMS gửi thất bại: " + e.getMessage());
    }
}
```

## Kết luận

Chọn **Constructor Injection** vì:
- Đảm bảo dependency luôn có giá trị khi tạo object
- Hỗ trợ `final`, an toàn hơn
- Dễ viết Unit Test
- Được Spring khuyên dùng chính thức
