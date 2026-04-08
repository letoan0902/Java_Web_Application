# Bài 3 — Scope & Race Condition (Orders)

## 1) Vì sao thông báo lỗi đăng nhập phải lưu ở Request Scope?

Thông báo lỗi (vd `errorMessage`) chỉ cần tồn tại **trong đúng request** khi người dùng submit form sai.

- Nếu lưu ở **Request scope** (`Model model` / request attribute):
  - Trang `login.jsp` render xong là hết.
  - Reload trang sẽ **không còn lỗi** (đúng yêu cầu đề).

- Nếu lỡ lưu ở **Session scope**:
  - Thông báo lỗi sẽ “đeo bám” qua nhiều request tiếp theo.
  - Người dùng đăng nhập đúng rồi vẫn có thể thấy lỗi cũ (trải nghiệm sai).

## 2) Vì sao `totalViewCount` phải ở Application Scope?

`totalViewCount` là số lượt xem **toàn hệ thống**, nên phải dùng **Application scope** (`ServletContext`).

- Nếu lưu ở **Session scope**:
  - Mỗi nhân viên (mỗi session) sẽ có một biến đếm riêng.
  - Nhân viên A có thể thấy 3, nhân viên B chỉ thấy 1 → không phải “toàn hệ thống”.

## 3) Race Condition là gì? Vì sao đoạn code cũ dễ bị race?

**Race Condition** xảy ra khi nhiều thread cùng truy cập/sửa một dữ liệu dùng chung mà không đồng bộ, làm kết quả phụ thuộc vào thứ tự chạy của thread.

Đoạn code (không thread-safe):

```java
Integer count = (Integer) application.getAttribute("totalViewCount");
if (count == null) count = 0;
count++;
application.setAttribute("totalViewCount", count);
```

Khi 2 request đồng thời:
- cả 2 cùng đọc `count = 5`
- cả 2 cùng `count++` thành 6
- set lại 6 → bị **mất 1 lượt tăng** (lẽ ra phải thành 7)

### Cách phòng tránh

Trong bài làm, counter được lưu dưới dạng `AtomicInteger` trong Application scope và tăng bằng `incrementAndGet()`.

Việc khởi tạo `AtomicInteger` được bọc trong `synchronized (application)` để tránh 2 thread cùng tạo 2 counter khác nhau.

