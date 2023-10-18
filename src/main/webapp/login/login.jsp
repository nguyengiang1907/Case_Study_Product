<%--
  Created by IntelliJ IDEA.
  User: nguyenhuugiang19072004
  Date: 10/12/23
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
    @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500&display=swap');

    * {
        box-sizing: border-box;
    }

    body {
        font-family: 'Montserrat', sans-serif;
        font-size: 17px;
        /*background-image: url("https://cdn.tgdd.vn//GameApp/1347093//25-800x450.jpg");*/
        background: antiquewhite;
    }

    #main {
        width: 450px;
        height: 450px;
        margin: 150px auto;
        border: 2px solid #dadce0;
        text-align: center;
        background: #eacdb0;
    }

    h3 {
        text-align: center;
        font-size: 24px;
        font-weight: 500;
        margin-top: 70px;
        margin-bottom: 30px;
    }

    .form-group {
        margin-bottom: 15px;
    }

    input {
        height: 50px;
        width: 300px;
        border: 1px solid #dadce0;
        padding: 10px;
        border-radius: 5px;
        font-size: inherit;
        color: #202124;
    }

    #button {
        margin-top: 20px;
        background: #79d10d;
        color: white;
    }
</style>
<body>
<form method="post" action="/users?action=login">
    <div id="main">
        <h3>Form Login</h3>
        <div class="form-group">
            <input type="text" name="userName" placeholder="Enter username: ">
        </div>
        <div class="form-group">
            <input type="password" name="passWord" placeholder="Enter password: ">
        </div>
        <input type="submit" value="Login" id="button">
    </div>
</form>


</body>
</html>
