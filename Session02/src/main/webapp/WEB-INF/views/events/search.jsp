<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Tìm kiếm sự kiện</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 8px; vertical-align: top; }
        th { background: #f5f5f5; }
        .badge { padding: 2px 6px; border-radius: 4px; display: inline-block; }
        .free { background: #e8f5e9; color: #2e7d32; }
        .soldout { color: #c62828; font-weight: bold; }
        .low { color: #ef6c00; font-weight: bold; }
        .ok { color: #2e7d32; font-weight: bold; }
        .disabled { pointer-events: none; opacity: 0.5; text-decoration: none; }
    </style>
</head>
<body>

<h2>Kết quả tìm kiếm cho: <c:out value="${keyword}"/></h2>
<p>Tìm thấy <b>${totalFound}</b> sự kiện</p>

<c:if test="${empty events}">
    <p>Không tìm thấy sự kiện nào phù hợp.</p>
</c:if>

<c:if test="${not empty events}">
    <table>
        <tr>
            <th>STT</th>
            <th>Tên sự kiện</th>
            <th>Ngày tổ chức</th>
            <th>Giá vé</th>
            <th>Vé còn lại</th>
            <th>Thao tác</th>
        </tr>

        <c:forEach var="event" items="${events}" varStatus="st">
            <tr>
                <td>${st.count}</td>
                <td><c:out value="${event.name}"/></td>
                <td><c:out value="${event.eventDate}"/></td>
                <td>
                    <c:choose>
                        <c:when test="${event.price == 0}">
                            <span class="badge free">MIỄN PHÍ</span>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${event.price}" groupingUsed="true" maxFractionDigits="0"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span class="soldout">HẾT VÉ</span>
                        </c:when>
                        <c:when test="${event.remainingTickets lt 10}">
                            <span class="low">Sắp hết (còn ${event.remainingTickets} vé)</span>
                        </c:when>
                        <c:otherwise>
                            <span class="ok">${event.remainingTickets}</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:url var="bookUrl" value="/events/${event.id}/book"/>
                    <a href="${bookUrl}" class="${event.remainingTickets == 0 ? 'disabled' : ''}">Đặt vé</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<hr/>

<c:if test="${not empty events}">
    <p>
        Sự kiện đầu tiên (IN HOA):
        <b><c:out value="${fn:toUpperCase(events[0].name)}"/></b>
    </p>
</c:if>

<p>Keyword dài: <b>${fn:length(keyword)}</b> ký tự.</p>

</body>
</html>

