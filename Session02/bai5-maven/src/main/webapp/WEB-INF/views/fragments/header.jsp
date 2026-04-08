<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div style="padding: 10px; border-bottom: 1px solid #ddd; margin-bottom: 16px;">
    <div>
        <a href="<c:url value='/employees'/>">Nhân viên</a>

        <c:if test="${sessionScope.role == 'hr_manager'}">
            | <span>Chế độ quản lý</span>
        </c:if>

        <span style="float:right;">
            <c:if test="${not empty sessionScope.loggedUser}">
                User: <b><c:out value='${sessionScope.loggedUser}'/></b>
                | Role: <b><c:out value='${sessionScope.role}'/></b>
                | <a href="<c:url value='/logout'/>">Đăng xuất</a>
            </c:if>
        </span>
    </div>
</div>

