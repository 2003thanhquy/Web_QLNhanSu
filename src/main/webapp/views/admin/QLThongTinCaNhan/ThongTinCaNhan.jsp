<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/7/2023
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file = "/component/all_css.jsp"%>
    <title>Quản lý nhân sự</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<div id="main-web" >
    <%@include file="/component/navbar/NoneMenu-nav.jsp"%>
    <%@include file="/component/header.jsp"%>
    <div id="content">
        <div id="main-content">
            <div class="thongtin-container container">
                <div class="thongtin-content">
                    <div class="formthongtin-container">
                        <form class="formthongtin" action="" method="post">
                            <div class = "avatar-container">

                            </div>
                            <div class="">
                                <div  class="thongtin-input--container">
                                    <label class="thongtin-input--label" for="thongtin-input-hoten" >Họ và tên</label>
                                    <input class="thongtin-input--element" name="thongtin-input-hoten" id="thongtin-input-hoten">
                                </div>
                                <div  class="thongtin-input--container">
                                    <label class="thongtin-input--label" for="thongtin-input-hoten" >Họ và tên</label>
                                    <input class="thongtin-input--element" name="thongtin-input-hoten" id="thongtin-input-hoten">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/component/all_javascript.jsp"%>

</body>
</html>
