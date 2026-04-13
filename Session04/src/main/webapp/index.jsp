<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<h2>Session04 - Bai tap</h2>
<ul>
    <li><a href="bai1/orders">Bai 1 - GET /bai1/orders</a></li>
    <li><a href="bai1/orders/5">Bai 1 - GET /bai1/orders/{id}</a></li>
    <li><a href="bai2/menu">Bai 2 - GET /bai2/menu (default category)</a></li>
    <li><a href="bai2/menu?category=man">Bai 2 - GET /bai2/menu?category=...</a></li>
    <li><a href="bai3/orders/5">Bai 3 - GET /bai3/orders/5</a></li>
    <li><a href="bai4/products?category=chay&amp;limit=10">Bai 4 - JSP /bai4/products?category=...&amp;limit=...</a></li>
    <li><a href="bai5/orders/5">Bai 5 - GET /bai5/orders/5</a></li>
</ul>
</body>
</html>