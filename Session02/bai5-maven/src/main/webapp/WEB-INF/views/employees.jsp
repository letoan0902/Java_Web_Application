<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Danh sách nhân viên</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 8px; vertical-align: top; }
        th { background: #f5f5f5; }
        .badge { padding: 2px 6px; border-radius: 4px; display:inline-block; color:#fff; }
        .green { background: #2e7d32; }
        .orange { background: #ef6c00; }
        .blue { background: #1565c0; }
    </style>
</head>
<body>

<%@ include file="fragments/header.jsp" %>

<h2>Danh sách nhân viên</h2>

<fmt:setLocale value="vi_VN"/>

<table>
    <tr>
        <th>STT</th>
        <th>Mã NV</th>
        <th>Họ tên</th>
        <th>Phòng ban</th>
        <th>Lương (VNĐ)</th>
        <th>Ngày vào làm</th>
        <th>Trạng thái</th>
        <th></th>
    </tr>

    <c:forEach var="emp" items="${employees}" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td><c:out value="${emp.code}"/></td>
            <td><c:out value="${emp.fullName}"/></td>
            <td><c:out value="${emp.department}"/></td>
            <td><fmt:formatNumber value="${emp.salary}" type="number" groupingUsed="true"/></td>
            <td><fmt:formatDate value="${emp.joinDate}" pattern="dd/MM/yyyy"/></td>
            <td>
                <c:choose>
                    <c:when test="${emp.status.displayName eq 'Đang làm'}">
                        <span class="badge green">Đang làm</span>
                    </c:when>
                    <c:when test="${emp.status.displayName eq 'Nghỉ phép'}">
                        <span class="badge orange">Nghỉ phép</span>
                    </c:when>
                    <c:otherwise>
                        <span class="badge blue">Thử việc</span>
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:url var="detailUrl" value="/employees/${emp.code}"/>
                <a href="${detailUrl}">Xem chi tiết</a>
            </td>
        </tr>
    </c:forEach>
</table>

<p>
    Tổng lương phòng ban Kỹ thuật: <b><fmt:formatNumber value="${techTotalSalary}" type="number" groupingUsed="true"/></b>
</p>

<%@ include file="fragments/footer.jsp" %>

</body>
</html>


