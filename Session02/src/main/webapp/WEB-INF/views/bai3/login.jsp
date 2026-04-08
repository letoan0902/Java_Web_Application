<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Login</title>
</head>
<body>

<h2>Đăng nhập</h2>

<c:if test="${not empty errorMessage}">
    <p style="color:red"><c:out value="${errorMessage}"/></p>
</c:if>

<form method="post" action="<c:url value='/login'/>">
    <div>
        <label>Username:</label>
        <input name="username" type="text"/>
    </div>
    <div>
        <label>Password:</label>
        <input name="password" type="password"/>
    </div>
    <button type="submit">Login</button>
</form>

<p>Tài khoản mẫu: admin/admin123 hoặc staff/staff123</p>

</body>
</html>

