<%--
  Created by IntelliJ IDEA.
  User: quyth
  Date: 11/28/2023
  Time: 5:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/login.css">
<%--    <style>--%>
<%--        <%@include file="../assets/css/login.css"%>--%>
<%--    </style>--%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Poppins:wght@300;400;500;700&family=Sora:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<style>

</style>
<body>

<div class="container mycontainer">
    <div class="row p-5">
        <div class="col-md-6">
            <figure class="myimg text-center">
                <img style="width: 120px;height: 120px;" src="<%=request.getContextPath()%>/assets/image/userlogin.png" alt="userlogin">
            </figure>

        </div>
        <div class="col-md-6">
            <h3 class="fw-normal pb-3 text-center text-dark" style="letter-spacing: 1px;font-size: 32px;">Đăng Nhập</h3>
            <%if(request.getAttribute("alter")!=null){%>
            <div class="alert alert-danger center" role="alert">
                <p>${alter}</p>
            </div>
            <%}%>
            <form class="mx-auto mt-5"  action="<%=request.getContextPath()%>/login" method="post">
                <div class="myin form-outline ">
                    <input type="text" name="username" id="username" value="admin" placeholder="account" class="myinp form-control form-control-lg" />
                </div>
                <div class="myin form-outline">
                    <input type="password" name="pwd" id="pwd" value="admin" placeholder="password" class="myinp form-control form-control-lg" />
                </div>
                <div class="mylogin pt-1 text-center ">
                    <button class="mybtn btn btn-success btn-lg btn-block text-light"  type="submit">Đăng nhập</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
