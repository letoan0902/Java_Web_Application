<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <%-- Ghi chú nội bộ: dùng JSP comment để không lộ ra HTML client --%>
    <meta charset="UTF-8"/>
    <title>Báo cáo điểm</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 8px; }
        th { background: #f5f5f5; }
    </style>
</head>
<body>

<h1><c:out value="${reportTitle}"/></h1>

<c:choose>
    <c:when test="${empty studentList}">
        <p>Không có dữ liệu sinh viên.</p>
    </c:when>
    <c:otherwise>
        <table>
            <tr>
                <th>STT</th>
                <th>Họ tên</th>
                <th>Điểm</th>
                <th>Xếp loại</th>
            </tr>

            <c:forEach var="sv" items="${studentList}" varStatus="st">
                <tr>
                    <td>${st.count}</td>
                    <%-- fullName là dữ liệu hiển thị ra HTML: dùng c:out để escape chống XSS --%>
                    <td><c:out value="${sv.fullName}"/></td>
                    <td>${sv.score}</td>
                    <td>
                        <c:choose>
                            <c:when test="${sv.score ge 90}">Xuất sắc</c:when>
                            <c:when test="${sv.score ge 80}">Giỏi</c:when>
                            <c:when test="${sv.score ge 70}">Khá</c:when>
                            <c:when test="${sv.score ge 60}">Trung bình khá</c:when>
                            <c:when test="${sv.score ge 50}">Trung bình</c:when>
                            <c:otherwise>Yếu</c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

</body>
</html>


