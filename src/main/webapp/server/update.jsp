<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenhuugiang19072004
  Date: 10/12/23
  Time: 12:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Edit Product</legend>
            <table>
                <input type="hidden" name="idUd" value="${product.id}">
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="nameUd" value="${product.name}"></td>
                </tr>
                <tr>
                    <td>Price :</td>
                    <td><input type="text" name="priceUd" value="${product.price}"></td>
                </tr>
                <tr>
                    <td>Link_Picture :</td>
                    <td><input type="text" name="pictureUd" value="${product.picture}"></td>
                </tr>
                <tr>
                    <td>Quantity :</td>
                    <td><input type="text" name="quantityUd" value="${product.quantity}"></td>
                </tr>
                <tr>
                    <td>Detail:</td>
                    <td><input type="text" name="detailUd" value="${product.detail}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update"></td>
                </tr>
            </table>
    </fieldset>
</form>
</body>
</html>
