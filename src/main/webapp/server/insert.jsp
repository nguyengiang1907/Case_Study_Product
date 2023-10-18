<%--
  Created by IntelliJ IDEA.
  User: nguyenhuugiang19072004
  Date: 10/11/23
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<style>
    body{
        background-color: white;
    }
    .main_insert{
        width: 450px;
        height: 450px;
        border: 1px solid black;
        text-align: center;
        margin: 150px auto;
        background-color:#cccccc;
    }
</style>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<form method="post">
<div class="main_insert">
    <legend>Create Product</legend>
    <input type="hidden" name="id">
    <br>
    <label>Name Product :</label>
    <input type="text" name="name">
    <br>
    <br>
    <label>Price Product :</label>
    <input type="text" name="price">
    <br>
    <br>
    <label>Link_Picture :</label>
    <input type="text" name="picture">
    <br>
    <br>
    <label>Quantity Product :</label>
    <input type="text" name="quantity">
    <br>
    <br>
    <label>Detail Product :</label>
    <input type="text" name="detail">
    <br>
    <br>
    <input type="submit" value="Add">
</div>



</form>
</html>
