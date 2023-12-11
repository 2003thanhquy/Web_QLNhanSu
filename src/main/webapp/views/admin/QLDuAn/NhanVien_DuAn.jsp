<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file = "/component/all_css.jsp"%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/NhanVien_DuAn.css">
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
            <div class = "nvda-container container">
                <div class="row">
                    <div class="col-sm-12 col-xl-8">
                        <div class="nvda-ttda--container">
                            <div class="nvda-ttda--maduan">
                                <h3 class="nvda-ttda--label">Mã dự án:</h3>
                                <h2 class="nvda-ttda--content">DA0001</h2>
                            </div>
                            <div class="nvda-ttda--tenduan">
                                <h3 class="nvda-ttda--label">Tên dự án:</h3>
                                <h2 class="nvda-ttda--content">Quần què</h2>
                            </div>
                        </div>


                        <div class="nvda-dsnv--container">
                            <h2>Danh sách nhân viên</h2>
                            <div class="nvda-dsnv--content">
                                <div class="table100 ver5 m-b-110">
                                    <div class="table100-head">
                                        <table>
                                            <thead>
                                            <tr class="row100 head">
                                                <th class="cell100 column1">Mã nhân viên</th>
                                                <th class="cell100 column2">Mã dự án</th>
                                                <th class="cell100 column3">Trạng thái</th>
                                            </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div class="table100-body js-pscroll">
                                        <table>
                                            <tbody>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">DA0001</td>
                                                <td class="cell100 column2">21110713</td>
                                                <td class="cell100 column3">Làm tốt</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">DA0001</td>
                                                <td class="cell100 column2">21110713</td>
                                                <td class="cell100 column3">Làm tốt</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">DA0001</td>
                                                <td class="cell100 column2">21110713</td>
                                                <td class="cell100 column3">Làm tốt</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">DA0001</td>
                                                <td class="cell100 column2">21110713</td>
                                                <td class="cell100 column3">Làm tốt</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">DA0001</td>
                                                <td class="cell100 column2">21110713</td>
                                                <td class="cell100 column3">Làm tốt</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">DA0001</td>
                                                <td class="cell100 column2">21110713</td>
                                                <td class="cell100 column3">Làm tốt</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">DA0001</td>
                                                <td class="cell100 column2">21110713</td>
                                                <td class="cell100 column3">Làm tốt</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">DA0001</td>
                                                <td class="cell100 column2">21110713</td>
                                                <td class="cell100 column3">Làm tốt</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">DA0001</td>
                                                <td class="cell100 column2">21110713</td>
                                                <td class="cell100 column3">Làm tốt</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">DA0001</td>
                                                <td class="cell100 column2">21110713</td>
                                                <td class="cell100 column3">Làm tốt</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-4">
                        <div class="nvda-ttnv--container">
                            <h2 style="text-align: center">Nhân viên</h2>
                            <form action="" method="post">
                                <div class="nvda-ttnv--input">
                                    <div class="nvda-ttnv-input--container">
                                        <label class="nvda-ttnv--label">Mã nhân viên</label>
                                        <input class="nvda-ttnv-input--element" type="text" id="nvda-ttnv--idnhanvien" name="nvda-ttnv--idnhanvien">
                                    </div>
                                    <div class="nvda-ttnv-input--container">
                                        <label class="nvda-ttnv--label">Tên nhân viên</label>
                                        <input class="nvda-ttnv-input--element" type="text" id="nvda-ttnv--tennhanvien" name="nvda-ttnv--tennhanvien">
                                    </div>
                                </div>
                                <div class= "nvda-ttnv--button">
                                    <div class="nvda-ttnv--controlbutton">
                                        <button class="nvda-ttnv--thembutton nvda-ttnv--button btn btn-outline-primary">Thêm vào dự án</button>
                                        <button class="nvda-ttnv--xoabutton nvda-ttnv--button btn btn-outline-danger">Xóa khỏi dự án</button>
                                    </div>
                                    <div class="nvd-ttnv--confirmbutton">
                                        <button class="nvda-ttnv--huybutton nvda-ttnv--button btn btn-outline-secondary">Hủy</button>
                                        <button type="submit" class="nvda-ttnv--xacnhanbutton nvda-ttnv--button btn btn-outline-success">Xác nhận</button>
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

<%@include file="/component/all_javascript.jsp"%>

</body>
</html>
