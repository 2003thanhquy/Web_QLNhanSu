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
                                                    <c:forEach items="${lstDA}" var="da">
                                                        <tr class="row100 body" onclick="handleItemClick('${da.maDuAn}','${da.tenDuAn}','${da.trangThai}')">
                                                            <td class="cell100 column1">${da.maDuAn}</td>
                                                            <td class="cell100 column3">${da.tenDuAn}</td>
                                                            <td class="cell100 column3">${da.trangThai}</td>
                                                            <td style="text-align: center" class="cell100 column3">
                                                                <a href="<%=request.getContextPath()%>/nhanvien/duan/chitiet?maduan=${da.maDuAn}">
                                                                <i style="color: #0d6efd;" class="fa-solid fa-users-viewfinder"></i>
                                                            </a></td>
                                                        </tr>
                                                    </c:forEach>
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
                                            <button class="dsda-button dsda-them-button btn btn-outline-primary" id="them" function="Them()">Thêm</button>
                                            <div class="dsda-button dsda-sua-button btn btn-outline-warning" id="capnhat" function="CapNhat()">Cập nhật</div>
                                            <button class="dsda-button dsda-xoa-button btn btn-outline-danger" id="xoa" function="Xoa()">Xóa</button>
                                        </div>
                                        <div class="dsda-confirm-button--container">
                                            <button class="dsda-button dsda-huy-button btn btn-outline-secondary" id="huy" function="Huy()">Hủy</button>
                                            <button class="dsda-button dsda-xacnhan-button btn btn-outline-success" id="xacnhan" function="XacNhan()">Xác nhận</button>
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
    var maduan = document.getElementById("dsda-input--idduan")
    var tenduan = document.getElementById("dsda-input--tenduan")
    var ttlamviec = document.getElementById("dsda-input--ttlamviec")

    var them = document.getElementById('them')
    var capnhat = document.getElementById('capnhat')
    var xoa = document.getElementById('xoa')
    var huy = document.getElementById('huy')
    var xacnhan = document.getElementById('xacnhan')

    maduan.disabled = true;
    tenduan.disabled = true;
    ttlamviec.disabled = true;
    huy.disabled =true;
    xacnhan.disabled = true;

    function handleItemClick(ma,ten,tt){
        maduan.value = ma;
        tenduan.value = ten;
        ttlamviec.value = tt;
    }
    function CapNhat(){
        maduan.disabled = false;
        tenduan.disabled = false;
        ttlamviec.disabled = false;
        huy.disabled =false;
        xacnhan.disabled = false;
    }
    
</script>
</body>
</html>