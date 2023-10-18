<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenhuugiang19072004
  Date: 10/11/23
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
      integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
      crossorigin="anonymous" referrerpolicy="no-referrer"/>
<style>
    .table_basket {
        width: 80%;
        height: 100%;
        margin-left: 10%;
        margin-righ: 10%;
    }

    td {
        vertical-align: middle;
        text-align: center;
    }

    th {
        text-align: center;
    }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/css.css">
<body>

<div class="table_basket">
    <a href="/admin?action=create">
        <input type="submit" value="Add">
    </a>
    <table class="table table-bordered">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Picture</th>
            <th>Quantity</th>
            <th>Detail</th>
            <th>Action Update</th>
            <th>Action Delete</th>
        </tr>
        <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.id}</td>
            <td> ${list.name}</td>
            <td> ${list.price}00</td>
            <td><img src="${list.picture}" width="100px">
            <td>${list.quantity}</td>
            <td>${list.detail}</td>
            <td>
                <a href="/admin?action=update&id=${list.id}">
                    Edit
                </a>
            </td>
            <td>
                <a href="/admin?action=delete&id=${list.id}">
                    Delete
                </a>
            </td>
        </tr>
        </c:forEach>
</div>
</body>
</html>
