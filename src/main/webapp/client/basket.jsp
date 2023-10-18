<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenhuugiang19072004
  Date: 10/9/23
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basket Product</title>
</head>
<style>
    .table_basket {
        width: 80%;
        height: 100%;
        margin-left: 10%;
        margin-righ: 10%;
    }
    td{
        vertical-align: middle;
        text-align: center;
    }
    .back{
        width: 80%;
        height: 40px;
        margin: 2rem auto;
    }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>
<form>
    <div class="back">
        <a href="/products?action=null">
            <button type="submit" class="btn btn-success">Back</button>
        </a>
    </div>

    <div class="table_basket">
        <table class="table table-bordered">
            <tr>
                <th>Select</th>
                <th>Picture</th>
                <th>Name</th>
                <th>Id</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Action</th>
            </tr>
            <c:forEach var="basket" items="${listBasket}">
                <tr>
                    <td><input type="checkbox" value="${basket.idProduct}" name="id"></td>
                    <td><img src="${basket.pictureProduct}" width="100px">
                    <td> ${basket.nameProduct}</td>
                    <td> ${basket.idProduct}</td>
                    <td>${basket.priceProduct}</td>
                    <td>${basket.quantityProduct}</td>
                    <td>
                        <a href="/products?action=delete&idDelete=${basket.idBasket}">
                            <button type="button" class="btn btn-warning">Delete</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>


        </table>
        <a href="/products?action=buy">
            <input type="submit" >
        </a>
        <a href="/products?action=showBuy">
            <p>Thanh toan</p>
        </a>

    </div>
</form>
</body>
</html>
