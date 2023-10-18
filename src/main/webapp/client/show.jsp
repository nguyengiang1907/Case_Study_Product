<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenhuugiang19072004
  Date: 10/9/23
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show </title>
</head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
      integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
      crossorigin="anonymous" referrerpolicy="no-referrer"/>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>

    body {
        background-color: #dadce0;
    }
    .back{
        width: 80%;
        height: 40px;
        margin: 2rem auto;
    }

    .content_main {
        width: 80%;
        margin-top: 1rem;
        margin-left: 12rem;


    }
    .main{
        width: 100%;
        height: 71%;
        background-color: white;
        border-radius: 10px;
    }

    .picture {
        width: 45%;
        height: 42rem;
        float: left;
    }

    .content {
        float: left;
        width: 53%;
        height: 42rem;
    }

    img {
        width: 600px;
        margin: 2rem;
    }

    .button_main {
        width: 100%;
        height: 40px;
    }

    .button_cart {
        width: 49%;
        height: 30px;
        float: left;
    }

    .button_buy {
        width: 49%;
        height: 30px;
        float: left;
    }

    .cart {
        float: right;
        margin-right: 2rem;
        margin-top: 20px;
    }
    .name {
        margin-top: 30px;
        margin-bottom: 20px;
    }
    .price{
        color: #ea3838;
    }
    .detail{
        margin-top: 30px;
        margin-bottom: 100px;
    }


</style>
<body>
<div class="back">
    <form action="/products?action=null">
        <button type="submit" class="btn btn-success">Back</button>
    </form>
</div>

<div class="content_main">
    <div class="main">
        <c:forEach var="item" items="${product}">
        <div class="picture">
            <img src="${item.picture}"><br>
        </div>
        <div class="content">
            <div class="cart col-1 ">
                <form method="post" action="/products?action=basket">
                    <button title="Show cart" class="button-show-cart" style="border: none; background-color: white;"
                            type="submit"><i
                            class="fa-solid fa-cart-shopping icon-cart" style="font-size: 35px; margin-left: 2rem;"></i>
                    </button>
                </form>
            </div>
            <div class="content_product">


                <div class="name">
                    <h2>${item.name}</h2>
                </div>
                <div class="price">
                    <h2>₫${item.price}00</h2>
                </div>
                <div class="quantity">
                    <p>${item.quantity} lượt bán </p>
                </div>
                <div class="detail">
                    <h3>${item.detail}</h3>
                </div>
                <div class="button_main">
                    <div class="button_cart">
                        <form method="post" action="/products?action=add&id=${item.id}">
                            <button type="submit" class="btn btn-danger">Thêm Vào Giỏ Hàng</button>
                        </form>
                    </div>
                    <div class="button_buy">
                        <form method="post" action="/products?action=buy&id=${item.id}">
                            <button type="submit" class="btn btn-danger">Mua Ngay</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    </c:forEach>
</div>
</body>
</html>
