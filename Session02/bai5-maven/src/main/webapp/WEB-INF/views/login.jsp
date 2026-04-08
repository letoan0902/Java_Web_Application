<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Login</title>
</head>
<body>

<%@ include file="fragments/header.jsp" %>

<h2>Đăng nhập</h2>

<c:if test="${not empty errorMessage}">
    <p style="color:red"><c:out value="${errorMessage}"/></p>
</c:if>

<form method="post" action="<c:url value='/login'/>">
    <div>
        <label>Username:</label>
        <input type="text" name="username"/>
    </div>
    <div>
        <label>Password:</label>
        <input type="password" name="password"/>
    </div>
    <button type="submit">Login</button>
</form>

<p>Tài khoản mẫu: hr_manager/hr123 hoặc hr_staff/staff456</p>

<%@ include file="fragments/footer.jsp" %>

</body>
</html>

