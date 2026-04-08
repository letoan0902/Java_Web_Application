# Bài 2 — Khá 2: Giải phẫu trang JSP lộn xộn

Tài liệu này gồm 2 phần theo yêu cầu đề: **(1) phân tích lỗi** trong JSP cũ và **(2) JSP refactor** theo chuẩn Thin View (EL + JSTL), không scriptlet.

## Phần 1 — Bảng phân tích (ít nhất 5 vấn đề)

| # | Vị trí (thành phần) | Loại vấn đề | Mô tả chi tiết hậu quả |
|---|----------------------|-------------|-------------------------|
| 1 | `<%! private int requestCounter = 0; %>` | **Race Condition / Shared State** | Biến instance trong JSP servlet bị **dùng chung cho mọi request**. Nhiều user truy cập đồng thời sẽ làm `requestCounter++` không thread-safe → số lượt xem sai/nhảy lung tung. |
| 2 | Khối scriptlet: `<% requestCounter++; List<Student> list = ... %>` | **Logic trong View (Scriptlet)** | View gánh xử lý Java (lấy request attribute, tăng counter). Vi phạm “Thin View”, khó bảo trì, khó test, dễ lỗi khi đổi model. |
| 3 | Vòng lặp + if-else trong JSP: `for (...) { ... if(...) rank=... }` | **Business logic trong View** | Tính xếp loại ngay trong JSP làm code rối, lặp lại, khó tái sử dụng. Nên chuyển logic sang Controller/Service hoặc tối thiểu dùng JSTL `<c:choose>`. |
| 4 | In dữ liệu trực tiếp: `<%= sv.getFullName() %>` | **XSS (thiếu escape output)** | Nếu tên SV chứa HTML/JS (vd: `<script>...</script>`), trình duyệt sẽ thực thi. Cần dùng `<c:out value="${sv.fullName}"/>` để escape. |
| 5 | `<td><%= sv.getScore()%>;</td>` | **Sai cú pháp / output bẩn** | Thừa dấu `;` làm HTML hiển thị sai (vd: `92;`) và là code smell; dễ gây nhầm lẫn/bug khi format. |
| 6 | HTML comment: `<!-- Tiêu đề trang báo cáo -->` | **Lộ comment nội bộ** | HTML comment vẫn gửi xuống client (view-source thấy). Ghi chú nội bộ nên dùng JSP comment `<%-- --%>` để không render ra client. |

## Phần 2 — `report.jsp` chuẩn (refactor)

- Không dùng Scriptlet
- Dùng EL + JSTL (`c:forEach`, `c:choose`…)
- Dùng `<c:out>` với dữ liệu user nhập
- Xoá declaration biến đếm

File JSP refactor đã được đặt tại: `src/main/webapp/WEB-INF/views/report.jsp`


