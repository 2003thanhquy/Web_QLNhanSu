<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file = "/component/all_css.jsp"%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/KhenThuong_KyLuat.css">
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
                    <div class="col-sm-12 col-xl-8">
                        <div class="ktkl--container">
                            <h2 style="text-align: center">Danh sách chương trình</h2>
                            <div class="ktkl--content">
                                <div class="table100 ver4 m-b-110">
                                    <div class="table100-head">
                                        <table id="tbl-ktkl">
                                            <thead>
                                            <tr class="row100 head">
                                                <th class="cell100 column1">Id</th>
                                                <th class="cell100 column2">Nội dung</th>
                                                <th class="cell100 column3">Ngày</th>
                                                <th class="cell100 column4">Số KT_KL</th>
                                                <th class="cell100 column5">Phân loại</th>
                                                <th class="cell100 column6">Mã nhân viên</th>
                                            </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div class="table100-body js-pscroll">
                                        <table >
                                            <tbody>
                                            <c:forEach items="${lstKtkl}" var="ktkl">
                                                <tr class="row100 body" onclick="handleItemClick('${ktkl.id}','${ktkl.noiDung}','${ktkl.getNgay()}','${ktkl.soKT_KL}','${ktkl.loai}','${ktkl.maNV}')">
                                                    <td class="cell100 column1">${ktkl.id}</td>
                                                    <td class="cell100 column3">${ktkl.noiDung}</td>
                                                    <td class="cell100 column3">${ktkl.getNgay()}</td>
                                                    <td class="cell100 column4">${ktkl.soKT_KL}</td>
                                                    <td class="cell100 column5">${ktkl.loai}</td>
                                                    <td class="cell100 column5">${ktkl.maNV}</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-4">
                        <div class="ktkl-dsct--container">
                            <h2 style="text-align: center">Thông tin chi tiết</h2>
                            <div class="ktkl-dsct--content">
                                <form action="" >
                                    <div class="ktkl-dsct-inputs">
                                        <div class="ktkl-dsct--input">
                                            <label class="ktkl-dsct--label" for="ktkl-dsct--id">ID</label>
                                            <input type="text" class="ktkl-dsct--input_element" id="ktkl-dsct--id" name="tk-tttk--id">
                                        </div>
                                        <div class="ktkl-dsct--input">
                                            <label class="ktkl-dsct--label" for="ktkl-dsct--noidung">Nội dung</label>
                                            <input type="text" class="ktkl-dsct--input_element" id="ktkl-dsct--noidung" name="ktkl-dsct--noidung">
                                        </div>
                                        <div class="ktkl-dsct--input">
                                            <label class="ktkl-dsct--label" for="ktkl-dsct--ngayapdung">Ngày áp dụng</label>
                                            <input type="text" class="ktkl-dsct--input_element" id="ktkl-dsct--ngayapdung" name="ktkl-dsct--ngayapdung">
                                        </div>
                                        <div class="ktkl-dsct--input">
                                            <label class="ktkl-dsct--label" for="ktkl-dsct--sokt_kl">Số KT_KL</label>
                                            <input type="text" class="ktkl-dsct--input_element" id="ktkl-dsct--sokt_kl" name="ktkl-dsct--sokt_kl">
                                        </div>
                                        <div class="ktkl-dsct--input">
                                            <label class="ktkl-dsct--label" for="ktkl-dsct--phanloai">Phân loại</label>
                                            <input type="text" class="ktkl-dsct--input_element" id="ktkl-dsct--phanloai" name="ktkl-dsct--phanloai">
                                        </div>
                                        <div class="ktkl-dsct--input">
                                            <label class="ktkl-dsct--label" for="ktkl-dsct--idnhanvien">Mã nhân viên</label>
                                            <input type="text" class="ktkl-dsct--input_element" id="ktkl-dsct--idnhanvien" name="ktkl-dsct--idnhanvien">
                                        </div>
                                    </div>
                                    <div class="ktkl-dsct-buttons">
                                        <div class="ktkl-dsct-button--control">
                                            <button type="button" class="ktkl-dsct--button btn btn-outline-primary" id="them" onclick="ThemChuongTrinh()">Thêm</button>
                                            <div class="ktkl-dsct--button btn btn-outline-warning" id="capnhat" onclick="CapNhat()">Cập nhật</div>
                                            <button type="button" class="ktkl-dsct--button btn btn-outline-danger" id="xoa" onclick="XoaChuongTrinh()">Xóa</button>
                                        </div>
                                        <div class="ktkl-dsct-button--confirm">
                                            <button type="button" class="ktkl-dsct--button btn btn-outline-secondary" id="huy">Hủy</button>
                                            <button type="submit" class="ktkl-dsct--button btn btn-outline-success" id="xacnhan" onclick="XacNhanChuongTrinh()">Xác nhận</button>
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
    var id = document.getElementById('ktkl-dsct--id')
    var noidung = document.getElementById('ktkl-dsct--noidung')
    var ngay = document.getElementById('ktkl-dsct--ngayapdung')
    var soktkl = document.getElementById('ktkl-dsct--sokt_kl')
    var loai = document.getElementById('ktkl-dsct--phanloai')
    var manv = document.getElementById('ktkl-dsct--idnhanvien')

    var them = document.getElementById('them')
    var capnhat = document.getElementById('capnhat')
    var xoa = document.getElementById('xoa')
    var huy = document.getElementById('huy')
    var xacnhan = document.getElementById('xacnhan')
    var kieuxacnhan = "";

    id.disabled = true;
    ngay.disabled = true;
    noidung.disabled = true;
    soktkl.disabled = true;
    loai.disabled = true;
    manv.disabled = true;
    huy.disabled =true;
    xacnhan.disabled = true;
    function getData() {
        let ID = id.value;
        let ngayApDung = ngay.value;
        let noiDung = noidung.value;
        let soKTKL = soktkl.value;
        let loaiCT = loai.value;
        let maNV = manv.value;
        return {
            Id: ID,
            ngayApDung: ngayApDung,
            noiDung: noiDung,
            soKTKL: soKTKL,
            loaiCT:loaiCT,
            maNV:maNV
        }
    }
    function XacNhanChuongTrinh(){

    }
    function getDanhSachChuongTrinh() {

    }
    function ThemChuongTrinh() {
        enableInputElement(false);
        clearTextInput();
        kieuxacnhan = "/them";
    }
    function CapNhat(){
        id.disabled = false;
        ngay.disabled = false;
        noidung.disabled = false;
        soktkl.disabled = false;
        loai.disabled = false;
        manv.disabled = false;
        huy.disabled =false;
        xacnhan.disabled = false;
        kieuxacnhan="/sua";
    }
    function XoaChuongTrinh(){
        kieuxacnhan="/xoa";
    }
    function  handleItemClick(Id,noiDung,Ngay,soKT_KL,Loai,Manv){
        id.value = Id ;
        noidung.value = noiDung;
        ngay.value = Ngay;
        soktkl.value = soKT_KL
        loai.value  = Loai
        manv.value = Manv

    }
    function enableInputElement(type) {
        id.disabled = type;
        ngay.disabled = type;
        noidung.disabled = type;
        soktkl.disabled = type;
        loai.disabled = type;
        manv.disabled = type;
        huy.disabled =type;
        xacnhan.disabled = type;
    }
    function clearTextInput(){
        id.value = null;
        ngay.value = null;
        noidung.value = null;
        soktkl.value = null;
        loai.value = null;
        manv.value = null;
        huy.value =null;
        xacnhan.value = null;
    }
</script>
</body>
</html>