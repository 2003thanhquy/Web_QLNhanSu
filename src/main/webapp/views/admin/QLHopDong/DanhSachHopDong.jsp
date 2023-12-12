<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
                                    <div class="table100-body js-pscroll">
                                        <table id="tbl-hopdong">
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
                                            <input type="text" class="hd-tthd-input--element" name="hd-tthd-idhopdong" id="hd-tthd-idhopdong" disabled>
                                        </div>
                                        <div class="hd-tthd-input--content">
                                            <label class="hd-tthd-input--label" for="hd-tthd-ngaybatdau">Ngày bắt đầu</label>
                                            <input type="text" class="hd-tthd-input--element" name="hd-tthd-ngaybatdau" id="hd-tthd-ngaybatdau" disabled>
                                        </div>
                                        <div class="hd-tthd-input--content">
                                            <label class="hd-tthd-input--label" for="hd-tthd-ngayketthuc">Ngày hết hạn</label>
                                            <input type="text" class="hd-tthd-input--element" name="hd-tthd-ngayketthuc" id="hd-tthd-ngayketthuc" disabled>
                                        </div>
                                        <div class="hd-tthd-input--content">
                                            <label class="hd-tthd-input--label" for="hd-tthd-idnhanvien">Mã nhân viên</label>
                                            <input type="text" class="hd-tthd-input--element" name="hd-tthd-idnhanvien" id="hd-tthd-idnhanvien" disabled>
                                        </div>
                                        <div class="hd-tthd-input--content">
                                            <label  class="hd-tthd-input--label" for="hd-tthd-noidung">Nội dung</label>
                                            <textarea  type="text" name="hd-tthd-noidung" class="hd-tthd-noidung--element"  id="hd-tthd-noidung" disabled></textarea>
                                        </div>
                                    </div>
                                    <div class="hd-tthd--buttons">
                                        <div class="hd-tthd--controlbuttons">
                                            <button class="hd-tthd--button hd-tthd--thembutton btn btn-outline-primary" type="button" onclick="handleThemClicked()">Thêm</button>
                                            <button class="hd-tthd--button hd-tthd--suabutton btn btn-outline-warning" type="button" onclick="handleCapNhatClicked()">Cập nhật</button>
                                            <button class="hd-tthd--button hd-tthd--xoabutton btn btn-outline-danger" type="button" onclick="handleXoaClicked()">Xóa</button>
                                        </div>
                                        <div class="hd-tthd--confirmbuttons">
                                            <button class="hd-tthd--button hd-tthd--huybutton btn btn-outline-secondary" type="button" onclick="handleHuyClicked">Hủy</button>
                                            <button type="button" class="hd-tthd--button hd-tthd--xacnhanbutton btn btn-outline-success" onclick="XacNhan()">Xác nhận</button>
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
    var kieucapnhat = "";

    jQuery(document).ready(function() {
        getDanhSachHopDong();
    });

    function getDanhSachHopDong() {
        jQuery.ajax({
            url: "${pageContext.request.getContextPath()}/nhanvien/hopdong/danhsach",
            method: "GET",
            dateType: "json",
            success: function (data) {
                var tblHopDong = jQuery("#tbl-hopdong");
                tblHopDong.empty();
                tblHopDong.append("<tbody>");
                jQuery(data).each(function (index, element) {
                    tblHopDong.append(`<tr class="row100 body"><td class="cell100 column1">\${element.maHopDong}</td><td class="cell100 column2">\${element.ngayBD}</td><td class="cell100 column3">\${element.ngayKT}</td><td class="cell100 column4">\${element.maNV}</td></tr>`);
                });
                tblHopDong.append("</tbody>");
            },
            error: function (data) {
                console.error("Can't get contracts list");
            },
        })
            .done(function () {
                //fill clicked data to form
                jQuery(".row100").on("click", function () {
                    var clickedRow = jQuery(this);

                    jQuery("#hd-tthd-idhopdong").val(clickedRow.find(".column1").text());
                    jQuery("#hd-tthd-ngaybatdau").val(clickedRow.find(".column2").text());
                    jQuery("#hd-tthd-ngayketthuc").val(clickedRow.find(".column3").text());
                    jQuery("#hd-tthd-idnhanvien").val(clickedRow.find(".column4").text());
                });
            });
    }

    function getData() {
        let maHopDong = jQuery("#hd-tthd-idhopdong").val();
        let maNV = jQuery("#hd-tthd-idnhanvien").val();
        let ngayBD = jQuery("#hd-tthd-ngaybatdau").val();
        let ngayKT = jQuery("#hd-tthd-ngayketthuc").val();
        let noiDung = jQuery("#hd-tthd-noidung").val();

        return {
            maHopDong: maHopDong,
            maNV: maNV,
            ngayBD: ngayBD,
            ngayKT: ngayKT,
            noiDung: noiDung,
        }
    }

    function handleThemClicked() {
        kieucapnhat = "/them";
        removeDisabledInput();
        $("#hd-tthd-idhopdong").focus();
    }

    function handleCapNhatClicked() {
        kieucapnhat = "/sua";
        removeDisabledInput();
        $("#hd-tthd-idhopdong").focus();
    }

    function handleXoaClicked() {

    }
    function handleHuyClicked() {

    }

    //Handle button "XacNhan" clicked
    function XacNhan() {
        var dataObj = getData();
        let url = window.location.href + kieucapnhat;
        jQuery.ajax({
            url: url,
            method: "GET",
            data: dataObj,
            success: getDanhSachHopDong,
            error: function () {
                console.error("Adding failed!")
            }
        })
    }

    function removeDisabledInput() {
        $('.hd-tthd--form input').removeAttr('disabled');
        $('.hd-tthd--form textarea').removeAttr('disabled');
    }
</script>

</body>
</html>
