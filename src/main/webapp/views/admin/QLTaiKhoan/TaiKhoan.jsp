<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.qlns.model.TaiKhoan" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file = "/component/all_css.jsp"%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/TaiKhoan.css">
    <title>Quản lý nhân sự</title>
    <style>
    </style>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<div id="main-web" >
    <%@include file="/component/navbar/NoneMenu-nav.jsp"%>
    <%@include file="/component/header.jsp"%>
    <div id="content">
        <div id="main-content">
            <div class="tk-container container-lg">
                <div class="row">

                    <div class="container-left col-sm-12 col-xl-8">
                        <div class="tk-dstk--container">
                            <h2 style="text-align: center">Danh sách tài khoản</h2>
                            <div class="tk-dstk--content">
                                <div class="table100 ver4 m-b-110">
                                    <div class="table100-head">
                                        <table>
                                            <thead>
                                            <tr class="row100 head">
                                                <th class="cell100 column1">UserId</th>
                                                <th class="cell100 column2">Username</th>
                                                <th class="cell100 column3">Password</th>
                                                <th class="cell100 column4">Userrole</th>
                                                <th class="cell100 column5">Mã nhân viên</th>
                                            </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div class="table100-body js-pscroll">
                                        <table>
                                            <tbody>
                                            <c:forEach items="${listtk}" var ="tk">
                                                <tr class="row100 body">
                                                    <td class="cell100 column1">ddd</td>
                                                    <td class="cell100 column2">admin</td>
                                                    <td class="cell100 column3">1234</td>
                                                    <td class="cell100 column4">admin</td>
                                                    <td class="cell100 column5">21110713</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container-right col-sm-12 col-xl-4">
                        <div class="tk-tttk--container">
                            <h2 style="text-align: center">Thông tin tài khoản</h2>
                            <div class="tk-tttk--content">
                                <form action="" method="post">
                                    <div class="tk-tttk-inputs">
                                        <div class="tk-tttl--input">
                                            <label class="tk-tttk--label" for="tk-tttk--userid">UserID</label>
                                            <input type="text" class="tk-tttk--input_element" id="tk-tttk--userid" name="tk-tttk--userid">
                                        </div>
                                        <div class="tk-tttl--input">
                                            <label class="tk-tttk--label" for="tk-tttk--username">Username</label>
                                            <input type="text" class="tk-tttk--input_element" id="tk-tttk--username" name="tk-tttk--username">
                                        </div>
                                        <div class="tk-tttl--input">
                                            <label class="tk-tttk--label" for="tk-tttk--password">Password</label>
                                            <input type="text" class="tk-tttk--input_element" id="tk-tttk--password" name="tk-tttk--password">
                                        </div>
                                        <div class="tk-tttl--input">
                                            <label class="tk-tttk--label" for="tk-tttk--userrole">Userrole</label>
                                            <input type="text" class="tk-tttk--input_element" id="tk-tttk--userrole" name="tk-tttk--userrole">
                                        </div>
                                        <div class="tk-tttl--input">
                                            <label class="tk-tttk--label" for="tk-tttk--idnhanvien">Mã nhân viên</label>
                                            <input type="text" class="tk-tttk--input_element" id="tk-tttk--idnhanvien" name="tk-tttk--idnhanvien">
                                        </div>
                                    </div>
                                    <div class="tk-tttk-buttons">
                                        <div class="tk-tttk-button--control">
                                            <button class="tk-tttk--button btn btn-outline-primary">Thêm</button>
                                            <button class="tk-tttk--button btn btn-outline-warning">Cập nhật</button>
                                            <button class="tk-tttk--button btn btn-outline-danger">Xóa</button>
                                        </div>
                                        <div class="tk-tttk-button--confirm">
                                            <button class="tk-tttk--button btn btn-outline-secondary">Hủy</button>
                                            <button type="submit" class="tk-tttk--button btn btn-outline-success">Xác nhận</button>
                                        </div>
                                    </div>
                                </form>
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
    var left_container = document.querySelector(".container-left");
    var right_container = document.querySelector(".container-right");
    <%TaiKhoan tkdangnhap = (TaiKhoan)session.getAttribute("account");  %>
    if(!<%=tkdangnhap.getUserRole().equals("admin")%>){
        left_container.style.display = "none";
    }
</script>
</body>
</html>