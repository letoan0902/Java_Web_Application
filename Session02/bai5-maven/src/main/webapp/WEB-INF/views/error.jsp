<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Lỗi</title>
</head>
<body>

<%@ include file="fragments/header.jsp" %>

<h2>Đã xảy ra lỗi</h2>
<p style="color:red"><c:out value="${errorMessage}"/></p>

<p>
    <a href="<c:url value='/employees'/>">Về danh sách nhân viên</a>
</p>

<%@ include file="fragments/footer.jsp" %>

</body>
</html>

