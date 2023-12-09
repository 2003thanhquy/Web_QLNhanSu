<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/7/2023
  Time: 2:34 PM
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
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/CapNhatNhanVien.css">
    <title>Quản lý nhân sự</title>
    <style>
        .header-item-context--phongban {
            color: #666666;
        }
        .header-item-context--phongban:hover {
            color: #666666;
        }
        .nav-item--capnhatnhanvien {
            background-color: #4dbce8;
        }
        .phongban-item {
            cursor: pointer;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<div id="main-web" >
    <%@include file="/component/navbar/QLPhongBan-nav.jsp"%>
    <%@include file="/component/header.jsp"%>
    <div id="content">
        <div id="main-content">
            <div class="capnhatnv-container container-fluid">
                <div class="row" >
                    <div class="col-12 container-fluid">
                        <div class="row">
                            <div class="col-6">
                                <div class="capnhatnv-dspb--container">
                                    <h1>Danh sách phòng ban</h1>
                                    <div class="capnhatnv-dspb--content">
                                        <div class="capnhatnv-dspb-table--wrapper">
                                            <div class="table-scroll">
                                                <table class="capnhatnv-dspb-table">
                                                    <thead>
                                                    <tr>
                                                        <th><span class="text">Mã phòng</span></th>
                                                        <th><span class="text">Tên phòng</span></th>
                                                        <th><span class="text">Chi nhánh</span></th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr> <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>
                                                    <tr>
                                                        <td>p0001</td>
                                                        <td>Marketing fffff</td>
                                                        <td>Hà Nội</td>
                                                    </tr>

                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="col-6">
    `                           <div class="capnhatnv-dsnvdc--container">

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 container-fluid">
                        <div class="row">
                            <div class="col-6">
                                <div class="capnhatnv-ttbp--container">

                                </div>
                            </div>
                            <div class="col-6">
                                <div class="capnhatnv-tnv--container">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<body>

</body>
</html>
