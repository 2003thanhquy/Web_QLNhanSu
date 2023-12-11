<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file = "/component/all_css.jsp"%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/HopDong.css">
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
            <div class="hd-container container-lg">
                <div class="row">
                    <div class="col-sm-12 col-xl-8">
                        <div class="hd-dshd--container">
                            <h2 style="text-align: center">Danh sách hợp đồng</h2>
                            <div class="hd-dshd--content">
                                <div class="table100 ver5 m-b-110">
                                    <div class="table100-head">
                                        <table>
                                            <thead>
                                            <tr class="row100 head">
                                                <th class="cell100 column1">Mã hợp đồng</th>
                                                <th class="cell100 column2">Ngày bắt đầu</th>
                                                <th class="cell100 column3">Ngày hết hạn</th>
                                                <th class="cell100 column4">Mã nhân viên</th>
                                            </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div class="table100-body js-pscroll">
                                        <table>
                                            <tbody>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">HD0001</td>
                                                <td class="cell100 column2">24-11-2003</td>
                                                <td class="cell100 column3">24-11-2003</td>
                                                <td class="cell100 column4">21110713</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">HD0001</td>
                                                <td class="cell100 column2">24-11-2003</td>
                                                <td class="cell100 column3">24-11-2003</td>
                                                <td class="cell100 column4">21110713</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">HD0001</td>
                                                <td class="cell100 column2">24-11-2003</td>
                                                <td class="cell100 column3">24-11-2003</td>
                                                <td class="cell100 column4">21110713</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">HD0001</td>
                                                <td class="cell100 column2">24-11-2003</td>
                                                <td class="cell100 column3">24-11-2003</td>
                                                <td class="cell100 column4">21110713</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">HD0001</td>
                                                <td class="cell100 column2">24-11-2003</td>
                                                <td class="cell100 column3">24-11-2003</td>
                                                <td class="cell100 column4">21110713</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">HD0001</td>
                                                <td class="cell100 column2">24-11-2003</td>
                                                <td class="cell100 column3">24-11-2003</td>
                                                <td class="cell100 column4">21110713</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">HD0001</td>
                                                <td class="cell100 column2">24-11-2003</td>
                                                <td class="cell100 column3">24-11-2003</td>
                                                <td class="cell100 column4">21110713</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">HD0001</td>
                                                <td class="cell100 column2">24-11-2003</td>
                                                <td class="cell100 column3">24-11-2003</td>
                                                <td class="cell100 column4">21110713</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">HD0001</td>
                                                <td class="cell100 column2">24-11-2003</td>
                                                <td class="cell100 column3">24-11-2003</td>
                                                <td class="cell100 column4">21110713</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">HD0001</td>
                                                <td class="cell100 column2">24-11-2003</td>
                                                <td class="cell100 column3">24-11-2003</td>
                                                <td class="cell100 column4">21110713</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">HD0001</td>
                                                <td class="cell100 column2">24-11-2003</td>
                                                <td class="cell100 column3">24-11-2003</td>
                                                <td class="cell100 column4">21110713</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">HD0001</td>
                                                <td class="cell100 column2">24-11-2003</td>
                                                <td class="cell100 column3">24-11-2003</td>
                                                <td class="cell100 column4">21110713</td>
                                            </tr>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">HD0001</td>
                                                <td class="cell100 column2">24-11-2003</td>
                                                <td class="cell100 column3">24-11-2003</td>
                                                <td class="cell100 column4">21110713</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-4">
                        <div class="hd-tthd--container">
                            <h2 style="text-align: center">Thông tin chi tiết</h2>
                            <div class=" hd-tthd--content">
                                <form class="hd-tthd--form" action="" method="post">
                                    <div class="hd-tthd-input--container">
                                        <div class="hd-tthd-input--content">
                                            <label class="hd-tthd-input--label" for="hd-tthd-idhopdong">Mã hợp đồng</label>
                                            <input type="text" class="hd-tthd-input--element" name="hd-tthd-idhopdong" id="hd-tthd-idhopdong">
                                        </div>
                                        <div class="hd-tthd-input--content">
                                            <label class="hd-tthd-input--label" for="hd-tthd-ngaybatdau">Ngày bắt đầu</label>
                                            <input type="text" class="hd-tthd-input--element" name="hd-tthd-ngaybatdau" id="hd-tthd-ngaybatdau">
                                        </div>
                                        <div class="hd-tthd-input--content">
                                            <label class="hd-tthd-input--label" for="hd-tthd-ngayketthuc">Ngày hết hạn</label>
                                            <input type="text" class="hd-tthd-input--element" name="hd-tthd-ngayketthuc" id="hd-tthd-ngayketthuc">
                                        </div>
                                        <div class="hd-tthd-input--content">
                                            <label class="hd-tthd-input--label" for="hd-tthd-idnhanvien">Mã nhân viên</label>
                                            <input type="text" class="hd-tthd-input--element" name="hd-tthd-idnhanvien" id="hd-tthd-idnhanvien">
                                        </div>
                                        <div class="hd-tthd-input--content">
                                            <label  class="hd-tthd-input--label" for="hd-tthd-noidung">Nội dung</label>
                                            <textarea  type="text" name="hd-tthd-noidung" class="hd-tthd-noidung--element"  id="hd-tthd-noidung"> </textarea>
                                        </div>
                                    </div>
                                    <div class="hd-tthd--buttons">
                                        <div class="hd-tthd--controlbuttons">
                                            <button class="hd-tthd--button hd-tthd--thembutton btn btn-outline-primary">Thêm</button>
                                            <button class="hd-tthd--button hd-tthd--suabutton btn btn-outline-warning">Cập nhật</button>
                                            <button class="hd-tthd--button hd-tthd--xoabutton btn btn-outline-danger">Xóa</button>
                                        </div>
                                        <div class="hd-tthd--confirmbuttons">
                                            <button class="hd-tthd--button hd-tthd--huybutton btn btn-outline-secondary">Hủy</button>
                                            <button type="submit" class="hd-tthd--button hd-tthd--xacnhanbutton btn btn-outline-success">Xác nhận</button>
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

</body>
</html>
