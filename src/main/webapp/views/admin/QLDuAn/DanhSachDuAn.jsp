<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file = "/component/all_css.jsp"%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/DuAn.css">
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
            <div class="dsda-container container-fluid">
                <div class="row">
                    <div class="col-sm-12 col-xl-8 container-fluid">
                        <div class="row">
                            <div class="col-12">
                                <div class="dsda-da--container" style="height: 50%">
                                    <h2  style="text-align: center;" class="dsda-da--heading ">Danh sách dự án</h2>
                                    <div class="dsda-da--content">
                                        <div class="dsda-da-table table100 ver1 m-b-110">
                                            <div class="table100-head ">
                                                <table>
                                                    <thead>
                                                    <tr class="row100 head ">
                                                        <th class="cell100 column1">Mã dự án</th>
                                                        <th class="cell100 column2">Tên dự án</th>
                                                        <th class="cell100 column3">Trang thái</th>
                                                        <th class="cell100 column4">Danh sách nhân viên</th>
                                                    </tr>
                                                    </thead>
                                                </table>
                                            </div>
                                            <div class="table100-body js-pscroll">
                                                <table>
                                                    <tbody>
                                                    <tr class="row100 body dscn-table-tr">
                                                        <td class="cell100 column1">DA0001</td>
                                                        <td class="cell100 column2">BBBBBB</td>
                                                        <td class="cell100 column3">HOÀN THÀNH</td>
                                                        <td style="text-align: center" class="cell100 column3"><i style="color: #0d6efd;" class="fa-solid fa-users-viewfinder"></i></td>
                                                    </tr>
                                                    <tr class="row100 body dscn-table-tr">
                                                        <td class="cell100 column1">DA0001</td>
                                                        <td class="cell100 column2">BBBBBB</td>
                                                        <td class="cell100 column3">HOÀN THÀNH</td>
                                                        <td style="text-align: center" class="cell100 column3"><i style="color: #0d6efd;" class="fa-solid fa-users-viewfinder"></i></td>
                                                    </tr>
                                                    <tr class="row100 body dscn-table-tr">
                                                        <td class="cell100 column1">DA0001</td>
                                                        <td class="cell100 column2">BBBBBB</td>
                                                        <td class="cell100 column3">HOÀN THÀNH</td>
                                                        <td style="text-align: center" class="cell100 column3"><i style="color: #0d6efd;" class="fa-solid fa-users-viewfinder"></i></td>
                                                    </tr>
                                                    <tr class="row100 body dscn-table-tr">
                                                        <td class="cell100 column1">DA0001</td>
                                                        <td class="cell100 column2">BBBBBB</td>
                                                        <td class="cell100 column3">HOÀN THÀNH</td>
                                                        <td style="text-align: center" class="cell100 column3"><i style="color: #0d6efd;" class="fa-solid fa-users-viewfinder"></i></td>
                                                    </tr>
                                                    <tr class="row100 body dscn-table-tr">
                                                        <td class="cell100 column1">DA0001</td>
                                                        <td class="cell100 column2">BBBBBB</td>
                                                        <td class="cell100 column3">HOÀN THÀNH</td>
                                                        <td style="text-align: center" class="cell100 column3"><i style="color: #0d6efd;" class="fa-solid fa-users-viewfinder"></i></td>
                                                    </tr>
                                                    <tr class="row100 body dscn-table-tr">
                                                        <td class="cell100 column1">DA0001</td>
                                                        <td class="cell100 column2">BBBBBB</td>
                                                        <td class="cell100 column3">HOÀN THÀNH</td>
                                                        <td style="text-align: center" class="cell100 column3"><i style="color: #0d6efd;" class="fa-solid fa-users-viewfinder"></i></td>
                                                    </tr>
                                                    <tr class="row100 body dscn-table-tr">
                                                        <td class="cell100 column1">DA0001</td>
                                                        <td class="cell100 column2">BBBBBB</td>
                                                        <td class="cell100 column3">HOÀN THÀNH</td>
                                                        <td style="text-align: center" class="cell100 column3"><i style="color: #0d6efd;" class="fa-solid fa-users-viewfinder"></i></td>
                                                    </tr>
                                                    <tr class="row100 body dscn-table-tr">
                                                        <td class="cell100 column1">DA0001</td>
                                                        <td class="cell100 column2">BBBBBB</td>
                                                        <td class="cell100 column3">HOÀN THÀNH</td>
                                                        <td style="text-align: center" class="cell100 column3"><i style="color: #0d6efd;" class="fa-solid fa-users-viewfinder"></i></td>
                                                    </tr>
                                                    <tr class="row100 body dscn-table-tr">
                                                        <td class="cell100 column1">DA0001</td>
                                                        <td class="cell100 column2">BBBBBB</td>
                                                        <td class="cell100 column3">HOÀN THÀNH</td>
                                                        <td style="text-align: center" class="cell100 column3"><i style="color: #0d6efd;" class="fa-solid fa-users-viewfinder"></i></td>
                                                    </tr>
                                                    <tr class="row100 body dscn-table-tr">
                                                        <td class="cell100 column1">DA0001</td>
                                                        <td class="cell100 column2">BBBBBB</td>
                                                        <td class="cell100 column3">HOÀN THÀNH</td>
                                                        <td style="text-align: center" class="cell100 column3"><i style="color: #0d6efd;" class="fa-solid fa-users-viewfinder"></i></td>
                                                    </tr> <tr class="row100 body dscn-table-tr">
                                                        <td class="cell100 column1">DA0001</td>
                                                        <td class="cell100 column2">BBBBBB</td>
                                                        <td class="cell100 column3">HOÀN THÀNH</td>
                                                        <td style="text-align: center" class="cell100 column3"><i style="color: #0d6efd;" class="fa-solid fa-users-viewfinder"></i></td>
                                                    </tr> <tr class="row100 body dscn-table-tr">
                                                        <td class="cell100 column1">DA0001</td>
                                                        <td class="cell100 column2">BBBBBB</td>
                                                        <td class="cell100 column3">HOÀN THÀNH</td>
                                                        <td style="text-align: center" class="cell100 column3"><i style="color: #0d6efd;" class="fa-solid fa-users-viewfinder"></i></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-4 container-fluid">
                        <div class="dsda-ttct--container">
                            <h2 style="text-align: center">Thông tin dự án</h2>
                            <div class="dsda-ttct--content">
                                <form action="" method="post">
                                    <div class="dsda-ttct-inputs--container">
                                        <div class="dsda-input--container">
                                            <label class="dsda-input--label" for="dsda-input--idduan" >Mã dự án</label>
                                            <input class="dsda-input--element " id="dsda-input--idduan" name="dsda-input--idduan">
                                        </div>
                                        <div class="dsda-input--container">
                                            <label class="dsda-input--label" for="dsda-input--tenduan" >Tên dự án</label>
                                            <input class="dsda-input--element " id="dsda-input--tenduan" name="dsda-input--tenduan">
                                        </div>
                                        <div class="dsda-input--container">
                                            <label class="dsda-input--label" for="dsda-input--ttlamviec" >Trạng thái </label>
                                            <input class="dsda-input--element " id="dsda-input--ttlamviec" name="dsda-input--ttlamviec">
                                        </div>
                                    </div>
                                    <div class="dsda-button--container">
                                        <div class="dsda-thaotac-button--container">
                                            <button class="dsda-button dsda-them-button btn btn-outline-primary">Thêm</button>
                                            <button class="dsda-button dsda-sua-button btn btn-outline-warning">Cập nhật</button>
                                            <button class="dsda-button dsda-xoa-button btn btn-outline-danger">Xóa</button>
                                        </div>
                                        <div class="dsda-confirm-button--container">
                                            <button class="dsda-button dsda-huy-button btn btn-outline-secondary">Hủy</button>
                                            <button class="dsda-button dsda-xacnhan-button btn btn-outline-success">Xác nhận</button>
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