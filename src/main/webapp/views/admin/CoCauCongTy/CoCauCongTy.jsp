<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file = "/component/all_css.jsp"%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/KhenThuong_KyLuat.css">
    <title>Quản lý nhân sự</title>
    <style>
        .cocaucongty--container {

            text-align: center;
            margin-top: 50px;
        }
        .cocaucongty--content {
            padding-left: 40px;
            cursor: pointer;
        }
        .cocaucongty--chinhanh {
            padding-left: 40px;
        }
        .cocaucongty--phongcha {
            padding-left: 40px;
            display: none;
        }
        .cocaucongty--phongcon {
            padding-left: 40px;
            display: none;
        }
        .cocaucongty--nhanvien {
            padding-left: 40px;
            display: none;
        }
        .cocaucongty--chinhanh.appear {
            display: block;
        }
        .cocaucongty--phongcha.appear {
            display: block;
        }
        .cocaucongty--phongcon.appear {
            display: block;
        }
        .cocaucongty--nhanvien.appear {
            display: block;
        }
        .icon-arrow {
            transition: transform 0.5s ease-in-out;
            margin-right: 4px;
            transform: rotate(0deg);

        }
        .icon-1.a,
        .icon-2.a,
        .icon-3.a
        {
            transform: rotate(90deg);
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<div id="main-web" >
    <%@include file="/component/navbar/NoneMenu-nav.jsp"%>
    <%@include file="/component/header.jsp"%>
    <div id="content">
        <div id="main-content">
            <div class="cocaucongty--container">
                <div class="cocaucongty--heading"> <h1>Cơ cấu công ty</h1></div>
                <div class="cocaucongty--content">
                    <div class="cocaucongty--chinhanh">
                        <h2><i class="fa-solid fa-arrow-right icon-arrow icon-1"></i>Chi nhánh1</h2>
                        <div class="cocaucongty--phongcha">
                            <h3><i class="fa-solid fa-arrow-right icon-arrow icon-2"></i>Phòng ban cha</h3>
                            <div class="cocaucongty--phongcon">
                                <h4><i class="fa-solid fa-arrow-right icon-arrow icon-3"></i>Phòng con</h4>
                                <div class="cocaucongty--nhanvien">
                                    <h5>Nhân viên</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<%@include file="/component/all_javascript.jsp"%>
<script>
    var chinhanh = document.querySelector(".cocaucongty--chinhanh");
    var phongcha = document.querySelector(".cocaucongty--phongcha");
    var phongcon = document.querySelector(".cocaucongty--phongcon");
    var nhanvien = document.querySelector(".cocaucongty--nhanvien");
    var icon_1 = document.querySelector(".icon-1");
    var icon_2 = document.querySelector(".icon-2");
    var icon_3 = document.querySelector(".icon-3");
    chinhanh.addEventListener('click',e=>{
        e.stopPropagation();
        phongcha.classList.toggle("appear");
        icon_1.classList.toggle("a");
    });
    phongcha.addEventListener('click', e=>{
        e.stopPropagation();
        phongcon.classList.toggle("appear");
        icon_2.classList.toggle("a");
    })
    phongcon.addEventListener('click', e=>{
        e.stopPropagation();
        nhanvien.classList.toggle("appear");
        icon_3.classList.toggle("a");
    })
    nhanvien.addEventListener('click',e=>{
        e.stopPropagation();

    })
</script>
</body>
</html>