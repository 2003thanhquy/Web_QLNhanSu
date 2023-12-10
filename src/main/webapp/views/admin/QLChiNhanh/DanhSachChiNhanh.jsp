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
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/DanhSachChiNhanh.css">
    <title>Quản lý nhân sự</title>
    <style>
        .header-item-context--chinhanh {
            color: var(--color-header-selected);
        }
        .header-item-context--chinhanh:hover {
            color: var(--color-header-selected);
        }
        .nav-item--xemchinhanh {
            background-color: var(--backcolor-menu-selected) ;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<div id="main-web" >
    <%@include file="/component/navbar/QLChiNhanh-nav.jsp"%>
    <%@include file="/component/header.jsp"%>
    <div id="content">
        <div id="main-content">
            <div class=" container-md dscn-container">
                <div class="row">
                    <div class="col-sm-12 col-xl-6">
                        <div class="dscn-cn--container">
                            <h1 class="dscn-cn--heading" style="text-align: center">Danh sách chi nhánh</h1>
                            <div class="dscn-cn--content">
                                <div class="dscn-cn-table table100 ver2 m-b-110">
                                    <div class="table100-head ">
                                        <table>
                                            <thead>
                                            <tr class="row100 head ">
                                                <th class="cell100 column1">Mã chi nhánh</th>
                                                <th class="cell100 column2">Tên chi nhánh</th>
                                                <th class="cell100 column3">Địa chỉ</th>
                                                <th class="cell100 column4">Ngày thành lập</th>
                                                <th class="cell100 column5">Mã giám đốc</th>
                                            </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div class="table100-body js-pscroll">
                                        <table>
                                            <tbody>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            <tr class="row100 body dscn-table-tr">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4">24-11-2003</td>
                                                <td class="cell100 column5">NV0001</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="dscn-ttcn--container">
                            <h1 class="dscn--ttcn--heading" style="text-align: center">Thao tác</h1>
                            <div class="dscn-ttcn--content">
                               <form action="" method="post" class="dscn-ttcn--form">
                                   <div class="dscn-ttnv--main-input">
                                       <div class="dscn--ttcn--input-container">
                                           <label class="dscn-ttcn-label-input" for="dscn--ttcn-idchinhanh">Mã chi nhánh</label>
                                           <input class="dscn-ttcn-input-element" type="text" id="dscn--ttcn-idchinhanh" name="dscn--ttcn-idchinhanh">
                                       </div>
                                       <div class="dscn--ttcn--input-container">
                                           <label class="dscn-ttcn-label-input" for="dscn--ttcn-tenchinhanh">Tên chi nhánh</label>
                                           <input class="dscn-ttcn-input-element" type="text" id="dscn--ttcn-tenchinhanh" name="dscn--ttcn-tenchinhanh">
                                       </div>
                                       <div class="dscn--ttcn--input-container">
                                           <label class="dscn-ttcn-label-input" for="dscn--ttcn-diachi">Địa chỉ</label>
                                           <input class="dscn-ttcn-input-element" type="text" id="dscn--ttcn-diachi" name="dscn--ttcn-diachi">
                                       </div>
                                       <div class="dscn--ttcn--input-container">
                                           <label class="dscn-ttcn-label-input" for="dscn--ttcn-ngaythanhlap">Ngày thành lập</label>
                                           <input class="dscn-ttcn-input-element" type="text" id="dscn--ttcn-ngaythanhlap" name="dscn--ttcn-ngaythanhlap">
                                       </div>
                                       <div class="dscn--ttcn--input-container">
                                           <label class="dscn-ttcn-label-input" for="dscn--ttcn-idgiamdoc">Mã giám đốc</label>
                                           <input class="dscn-ttcn-input-element" type="text" id="dscn--ttcn-idgiamdoc" name="dscn--ttcn-idgiamdoc">
                                       </div>
                                   </div>
                                   <div class="button-container">
                                        <div class="dscn-ttcn--thaotac-button">
                                            <button class="btn btn-outline-primary dscn-ttcn-thembutton dscn-ttcn--button">Thêm</button>
                                            <button class="btn btn-outline-warning dscn-ttcn-capnhatbutton dscn-ttcn--button">Cập nhật</button>
                                            <button class="btn btn-outline-danger dscn-ttcn-xoatbutton dscn-ttcn--button">Xóa</button>
                                        </div>
                                       <div class="dscn-ttcn--confirm-button">
                                           <button class="btn btn-outline-secondary dscn-ttcn-huytbutton dscn-ttcn--button">Hủy</button>
                                           <button class="btn btn-outline-success dscn-ttcn-xacnhantbutton dscn-ttcn--button">Xác nhận</button>
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
