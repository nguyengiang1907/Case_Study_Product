<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenhuugiang19072004
  Date: 10/9/23
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
    <link rel="stylesheet" href="../list.css">
</head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
      integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
      crossorigin="anonymous" referrerpolicy="no-referrer"/>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<style>
    .content {
        width: 100%;
        height: 100px;
    }

    .search_content {
        width: 40%;
        margin: 40px auto;
    }

    .product {
        width: 400px;
        height: 550px;
        margin: 30px auto;
        float: left;
        padding-left: 150px;
    }

    .hang {
        width: 350px;
        height: 500px;
        margin-right: 30px;
        border: 1px solid #dadce0;
        border-radius: 10px;
        float: left;
        transition: transform 0.3s ease;
    }

    .hang:hover {
        transform: scale(1.1);
    }

    h5 {
        text-align: center;
        color: black;
    }

    p {
        text-align: center;
        color: black;
    }

    h3 {
        text-align: center;
        color: #dc4e4e;
    }

    img {
        width: 300px;
        margin: 20px 20px;
    }
    .search{
        width: 40%;
        margin: 0 auto;
    }

    .button-show-cart:hover {
        color: #e0505b;
    }
    .footer-clean {
        width: 100%;
        height: 250px;
        float: left;
        padding:20px ;
        background-color: #e5e4e4;
        color:#4b4c4d;
    }

    .footer-clean h3 {
        margin-top:0;
        margin-bottom:12px;
        font-weight:bold;
        font-size:16px;
    }

    .footer-clean ul {
        padding:0;
        list-style:none;
        line-height:1.6;
        font-size:14px;
        margin-bottom:0;
    }

    .footer-clean ul a {
        color:inherit;
        text-decoration:none;
        opacity:0.8;
    }

    .footer-clean ul a:hover {
        opacity:1;
    }

    .footer-clean .item.social {
        text-align:right;
    }

    @media (max-width:767px) {
        .footer-clean .item {
            text-align:center;
            padding-bottom:20px;
        }
    }

    @media (max-width: 768px) {
        .footer-clean .item.social {
            text-align:center;
        }
    }

    .footer-clean .item.social > a {
        font-size:24px;
        width:40px;
        height:40px;
        line-height:40px;
        display:inline-block;
        text-align:center;
        border-radius:50%;
        border:1px solid #ccc;
        margin-left:10px;
        margin-top:22px;
        color:inherit;
        opacity:0.75;
    }

    .footer-clean .item.social > a:hover {
        opacity:0.9;
    }

    @media (max-width:991px) {
        .footer-clean .item.social > a {
            margin-top:40px;
        }
    }

    @media (max-width:767px) {
        .footer-clean .item.social > a {
            margin-top:10px;
        }
    }

    .footer-clean .copyright {
        margin-top:14px;
        margin-bottom:0;
        font-size:13px;
        opacity:0.6;
    }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<body>
<div class="main mt-3">
    <div class="header row">
        <div class="search_content col-11">
            <div class="search">
                <form class="d-flex" method="post" action="/products?action=search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"
                           name="search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
        <div class="cart col-1 justify-content-end">
            <form method="post" action="/products?action=basket">
                <button title="Show cart" class="button-show-cart" style="border: none; background-color: white;" type="submit"><i
                        class="fa-solid fa-cart-shopping icon-cart" style="font-size: 35px; margin-left: 2rem;"></i>
                </button>
            </form>
        </div>
    </div>
    <div class="content">

        <div>
            <c:forEach var="item" items="${lists}">
                <div class="product">
                    <a href="/products?action=show&id=${item.id}">
                        <div class="hang">
                            <form>
                                <input type="hidden" value="${item.picture}" name="picture">
                                <input type="hidden" value="${item.name}" name="name">
                                <input type="hidden" value="${item.price}" name="price">
                                <input type="hidden" value="${item.quantity}" name="quantity">
                                <input type="hidden" value="${item.id}" name="id">
                            </form>
                            <img src="${item.picture}"><br>
                            <h5>${item.name}</h5>
                            <h3>₫${item.price}00 </h3>
                            <p>sản phẩm có sẵn : ${item.quantity}  </p>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<div class="footer-clean">
    <footer>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-4 col-md-3 item">
                    <h3>Services</h3>
                    <ul>
                        <li><a href="#">Web design</a></li>
                        <li><a href="#">Development</a></li>
                        <li><a href="#">Hosting</a></li>
                    </ul>
                </div>
                <div class="col-sm-4 col-md-3 item">
                    <h3>About</h3>
                    <ul>
                        <li><a href="#">Company</a></li>
                        <li><a href="#">Team</a></li>
                        <li><a href="#">Legacy</a></li>
                    </ul>
                </div>
                <div class="col-sm-4 col-md-3 item">
                    <h3>Careers</h3>
                    <ul>
                        <li><a href="#">Job openings</a></li>
                        <li><a href="#">Employee success</a></li>
                        <li><a href="#">Benefits</a></li>
                    </ul>
                </div>
                <div class="col-lg-3 item social"><a href="#"><i class="icon ion-social-facebook"></i></a><a href="#https://www.facebook.com/nghuyen.son.104"><i class="icon ion-social-twitter"></i></a><a href="#"><i class="icon ion-social-snapchat"></i></a><a href="#"><i class="icon ion-social-instagram"></i></a>
                    <p class="copyright">Company Name © 2018</p>
                </div>
            </div>
        </div>
    </footer>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
