<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenhuugiang19072004
  Date: 10/11/23
  Time: 8:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy</title>
</head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
      integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
      crossorigin="anonymous" referrerpolicy="no-referrer"/>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
    .back{
        margin: 15px auto;
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
<body>
<div class="back">
    <a href="/products?action=null">
        <button type="submit" class="btn btn-success">Back</button>
    </a>
</div>
    <div class="table_basket">
        <table class="table table-bordered">
            <tr>
                <th>Picture</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Thành tiền</th>
                <th>Status</th>
                <th>Action</th>
            </tr>

            <c:forEach var="buy" items="${buyProduct}">
                <tr>
                    <td><img src="${buy.picture}" width="100px">
                    <td> ${buy.name}</td>
                    <td>₫${buy.price}00</td>
                    <td>${buy.quantity}</td>
                    <td>₫${buy.price}00</td>
                    <td>Đang vận chuyển </td>
                    <td>
                        <form method="post" action="/products?action=dropBuy&id=${buy.id}">
                            <button type="submit" class="btn btn-warning">Hủy Đơn Hàng</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
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
