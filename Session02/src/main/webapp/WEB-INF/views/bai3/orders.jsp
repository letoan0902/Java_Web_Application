<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Orders</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 8px; }
        th { background: #f5f5f5; }
    </style>
</head>
<body>

<p>
    Xin chào, <b><c:out value="${sessionScope.loggedUser}"/></b>!
    Vai trò: <b><c:out value="${sessionScope.role}"/></b>
    | <a href="<c:url value='/logout' />">Đăng xuất</a>
</p>

<h2>Danh sách đơn hàng</h2>

<table>
    <tr>
        <th>#</th>
        <th>Mã đơn</th>
        <th>Sản phẩm</th>
        <th>Tổng tiền</th>
        <th>Ngày đặt</th>
    </tr>

    <c:forEach var="o" items="${orders}" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td><c:out value="${o.code}"/></td>
            <td><c:out value="${o.productName}"/></td>
            <td>
                <fmt:setLocale value="vi_VN"/>
                <fmt:formatNumber value="${o.totalAmount}" type="currency"/>
            </td>
            <td>
                <fmt:formatDate value="${o.orderDate}" pattern="dd/MM/yyyy"/>
            </td>
        </tr>
    </c:forEach>
</table>

<p>
    Tổng lượt xem đơn hàng toàn hệ thống: <b>${totalViewCount}</b>
</p>

</body>
</html>

