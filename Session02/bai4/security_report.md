# Bài 4 — Security report (XSS + JSTL)

## 1) XSS là gì? Vì sao `<c:out value="${keyword}"/>` an toàn hơn `${keyword}`?

**XSS (Cross-Site Scripting)** là lỗ hổng cho phép kẻ tấn công chèn JavaScript/HTML độc hại vào trang web, khiến trình duyệt người dùng thực thi đoạn script đó.

Trong JSP:
- Nếu in trực tiếp `${keyword}` trong body HTML, tuỳ cấu hình container/JSP/EL, dữ liệu có thể **không được escape** đầy đủ (đặc biệt khi dev trộn scriptlet/`out.print`).
- `<c:out>` của JSTL sẽ **escape XML/HTML characters** theo mặc định (`<` → `&lt;`, `>` → `&gt;`, `"` → `&quot;`, `&` → `&amp;`).

Ví dụ input: `<script>alert(1)</script>`

- Nếu output không escape, HTML sẽ chứa:
  ```html
  <script>alert(1)</script>
  ```
  → trình duyệt chạy script.

- Nếu dùng `<c:out>`:
  ```html
  &lt;script&gt;alert(1)&lt;/script&gt;
  ```
  → chỉ hiển thị text thuần, không chạy script.

## 2) Khác nhau giữa `<c:if>` và `<c:choose>`

- `<c:if>`: chỉ là **một điều kiện đơn** (if).
- `<c:choose>/<c:when>/<c:otherwise>`: giống **if / else-if / else**, phù hợp khi có nhiều nhánh mutually-exclusive.

Trong bài này:
- Phần **Giá vé** có 2 nhánh (free vs paid) → dùng `<c:choose>` rõ ràng.
- Phần **Vé còn lại** có 3 nhánh (0 / <10 / còn nhiều) → nên dùng `<c:choose>` để tránh nhiều `<c:if>` rời rạc.

## 3) `<c:url>` giải quyết vấn đề gì?

`<c:url>` giúp tạo URL đúng với **context path** khi deploy.

Ví dụ nếu app deploy ở `/ticketing`:
- Hardcode `href="/events/1/book"` sẽ trỏ về **root server** `/events/1/book` (sai app).
- `<c:url value="/events/1/book"/>` sẽ sinh ra `/ticketing/events/1/book` (đúng context).

Vì vậy trong `search.jsp` mình dùng:
- `<c:url var="bookUrl" value="/events/${event.id}/book"/>`

## Checklist yêu cầu đề

- Không scriptlet: ✅
- Dữ liệu user nhập (`keyword`) in qua `<c:out>`: ✅
- Dữ liệu DB “bẩn” (`event.name`) cũng in qua `<c:out>`: ✅
- JSTL Jakarta URI: `jakarta.tags.*`: ✅

