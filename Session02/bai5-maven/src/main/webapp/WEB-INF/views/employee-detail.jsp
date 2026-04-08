<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Chi tiết nhân viên</title>
</head>
<body>

<%@ include file="fragments/header.jsp" %>

<h2>Chi tiết nhân viên</h2>

<fmt:setLocale value="vi_VN"/>

<ul>
    <li>Mã NV: <b><c:out value="${emp.code}"/></b></li>
    <li>Họ tên: <b><c:out value="${emp.fullName}"/></b></li>
    <li>Phòng ban: <b><c:out value="${emp.department}"/></b></li>
    <li>
        Lương:
        <b>
            <c:choose>
                <c:when test="${sessionScope.role == 'hr_manager'}">
                    <fmt:formatNumber value="${emp.salary}" type="number" groupingUsed="true"/>
                </c:when>
                <c:otherwise>
                    ***
                </c:otherwise>
            </c:choose>
        </b>
    </li>
    <li>Ngày vào làm: <b><fmt:formatDate value="${emp.joinDate}" pattern="dd/MM/yyyy"/></b></li>
    <li>Trạng thái: <b><c:out value="${emp.status.displayName}"/></b></li>
</ul>

<p>
    <a href="<c:url value='/employees' />">Quay lại</a>
</p>

<%@ include file="fragments/footer.jsp" %>

</body>
</html>

