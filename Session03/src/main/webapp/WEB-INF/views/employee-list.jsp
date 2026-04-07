<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách nhân viên</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #f5f5f5; }
    </style>
</head>
<body>
<h2>Danh sách nhân viên - Phòng Đào tạo</h2>

<c:if test="${empty employees}">
    <p>Không có nhân viên.</p>
</c:if>

<c:if test="${not empty employees}">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Họ và tên</th>
            <th>Phòng ban</th>
            <th>Lương</th>
            <th>Đánh giá</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="e">
            <tr>
                <td>${e.id}</td>
                <td>${e.fullName}</td>
                <td>${e.department}</td>
                <td>${e.salary}</td>
                <td>
                    <c:choose>
                        <c:when test="${e.salary >= 10000}">Mức lương cao</c:when>
                        <c:otherwise>Mức lương cơ bản</c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html>

