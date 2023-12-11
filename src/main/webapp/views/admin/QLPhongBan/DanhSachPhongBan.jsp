<%@ page import="com.qlns.model.TaiKhoan" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file = "/component/all_css.jsp"%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/XemPhongBan.css">
    <title>Quản lý nhân sự</title>
    <style>
        .header-item-context--phongban {
            color: #666666;
        }
        .header-item-context--phongban:hover {
            color: #666666;
        }
        .nav-item--xemphongban {
            background-color: #4dbce8;
        }
        .phongban-item {
            cursor: pointer;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<div id="main-web" >
    <%@include file="/component/navbar/QLPhongBan-nav.jsp"%>
    <%@include file="/component/header.jsp"%>
    <div id="content">
        <div id="main-content">
            <div class = "phongban-container container-md">
                <div class="row">
                    <div class = "col-xl-6 col-sm-12">
                        <div class="danhsachphongban-container">
                            <div class="button-chuyennoidung" style="display: flex">
                                <div tabindex="0" class="phongban-menu--container selected phongcoquanly-container " onclick="xempbqly()">
                                    <h3>Phòng có quản lý</h3>
                                </div>
                                <div tabindex="0" class="phongban-menu--container phongchuacoquanly-container" onclick="xempbkhongqly()">
                                    <h3>Phòng chưa có quản lý</h3>
                                </div>
                            </div>
                            <div class="danhsachphongban-main-content">

                                <div class="danhsachphongban-content container">

                                    <div class="button-quaylaiphongcha--container">
                                        <button class="button-qualaiphongcha btn btn-secondary" onclick="xempbcha()">
                                            <i class="fa-solid fa-arrow-rotate-left"></i>
                                            Quay lại
                                        </button>
                                    </div>
                                    <div class="row dataphongban">
                                        <c:forEach items="${listpb}" var="phongban">
                                            <div class="col-6 phongban-item--container">
                                                <div class="phongban-item" onclick="handleItemClick(event,'${phongban.tenPB}', '${phongban.maPB}', '${phongban.tenChiNhanh}', '${phongban.tenQuanLy}', '${phongban.ngayBD}','${phongban.maQuanLy}')">
                                                    <h1 class="tenphong">${phongban.tenPB}</h1>
                                                    <div class="chitietphong">
                                                        <div class="maphong-container chitiet-container">
                                                            <h3 class="maphong-label">Mã phòng:</h3>
                                                            <h3 class="maphong-text">${phongban.maPB}</h3>
                                                        </div>
                                                        <div class="chinhanh-container chitiet-container">
                                                            <h3 class="chinhanh-label">Chi nhánh:</h3>
                                                            <h3 class="chinhanh-text">${phongban.tenChiNhanh}</h3>
                                                        </div>
                                                        <div class="button-xemphongcon--container">
                                                            <button class="button-xemphongcon btn btn-outline-primary" onclick= "xempbcon('${phongban.maPB}','${phongban.tenPB}')">Xem phòng ban con</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class ="col-xl-6 col-sm-12">
                        <div class="thongtinphongban-container">
                            <div class="thongtinphongban-header">
                                <h1 class = "thongtinphongban-text">Thông tin chi tiết</h1>
                            </div>
                            <div class="thongtinphongban-content">
                                <form class="thongtinphongban-content-input--container">
                                    <div class="thongtinphongban-content-input--item">
                                        <label for="maphong" class="thongtinphongban-content-input--lable">Mã phòng</label>
                                        <input id="maphong" type="text" name="maphong" class="thongtinphongban-input">
                                    </div>
                                    <div class="thongtinphongban-content-input--item">
                                        <label for="tenphong" class="thongtinphongban-content-input--lable">Tên phòng</label>
                                        <input id="tenphong" type="text" name="tenphong" class="thongtinphongban-input">
                                    </div>
                                    <div class="thongtinphongban-content-input--item" >
                                        <label for="chinhanh" class="thongtinphongban-content-input--lable">Chi nhánh</label>
<%--                                        <input id="chinhanh" type="text" name="chinhanh" class="thongtinphongban-input">--%>
                                        <select id="chinhanh" type="text" name="chinhanh" class="thongtinphongban-input" >
                                            <c:forEach items="${listcntoanbo}" var="chinhanh">
                                                <option value="${chinhanh.maCN}">${chinhanh.maCN}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="thongtinphongban-content-input--item">
                                        <label for="truongphong" class="thongtinphongban-content-input--lable">Quản lý</label>
                                        <input id="truongphong" type="text" name="truongphong" class="thongtinphongban-input">
                                    </div>
                                    <div class="thongtinphongban-content-input--item">
                                        <label for="ngaythanhlap" class="thongtinphongban-content-input--lable">Thành lập</label>
                                        <input id="ngaythanhlap" type="text" name="ngaythanhlap" class="thongtinphongban-input">
                                    </div>
                                    <div class="thongtin-content--button">
                                        <div class = "button-control button-container">
                                            <div class="button-them btn btn-outline-primary btn-lg button-thongtinphongban" onclick="ThemPhongBan()">
                                                <p class="button-them--label">Thêm</p>
                                            </div>
                                            <div class="button-capnhat btn btn-outline-info btn-lg button-thongtinphongban" onclick="SuaPhongBan()">
                                                <p class="button-capnhat--label">Cập nhật</p>
                                            </div>
                                            <div class="button-xoa btn btn-outline-danger btn-lg button-thongtinphongban" onclick="XoaPhongBan">
                                                <p class="button-xoa--label">Xóa</p>
                                            </div>
                                        </div>
                                        <div class="button-confirm button-container">
                                            <div class="button-huy btn btn-outline-warning btn-lg button-thongtinphongban" onclick="Huy()">
                                                <p class="button-huy--label">Hủy</p>
                                            </div>
                                            <button class="button-xacnhan btn btn-outline-success btn-lg button-thongtinphongban" onclick="GuiDuLieu">
                                                <p class=" button-xacnhan--label">Xác nhận</p>
                                            </button>
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



<% TaiKhoan tkdangnhap = (TaiKhoan)session.getAttribute("account"); %>

<script>


    var buttonqlaiphongban = document.querySelector(".button-quaylaiphongcha--container");
    var buttonqly = document.querySelector(".phongcoquanly-container");
    var buttonkhongqly=document.querySelector(".phongchuacoquanly-container")


    buttonqlaiphongban.style.display = "none";
    buttonqly.style.display="none";

    var them = "thempbcha";
    var kieucapnhat = "";
    var mapbcha="";
    var tenpbcha="";


    var row = document.querySelector(".dataphongban");
    var pbhienthidautien = document.querySelector('.phongban-item');


    var maphong = document.getElementById('maphong');
    var tenpb = document.getElementById('tenphong');
    var tencn = document.getElementById('chinhanh');
    var tenql = document.getElementById('truongphong');
    var ngaybd = document.getElementById('ngaythanhlap');
    var maql;

    maphong.disabled = true;
    tenpb.disabled = true;
    tencn.disabled = true;
    tenql.disabled = true;
    ngaybd.disabled = true;
    var phongbandangclick;

    function handleItemClick(event,tenPB, maPB, tenCN,tenQL, ngayBD ,maQL) {
        maphong.value= maPB;
        tenpb.value= tenPB;
        tencn.value=tenCN;
        tenql.value=tenQL;
        ngaybd.value=ngayBD;
        maql=maQL;
        console.log(maQL);
        phongbandangclick = event.target;
    }
    function xempbcon(MaPB,TenPB) {
        mapbcha= MaPB;
        tenpbcha = TenPB;
        jQuery.ajax({
            type: "GET",
            url: "${request.getContextPath()}/QLNhanSu_war_exploded/phongban/xemphongbancon",
            data: {
                MaPB: MaPB
            },
            success: function(data) {
                row.innerHTML=data;
                document.querySelector('.phongban-item').onclick();


            },
            error: function(error) {
                console.log(error);
            }
        });
        them = "thempbcon";
        buttonqlaiphongban.style.display = "";
        buttonkhongqly.style.display="none";
        buttonqly.style.display="none";

    }
    function xempbcha() {
        mapbcha= "";
        tenpbcha = "";
        jQuery.ajax({
            type: "GET",
            url: "${request.getContextPath()}/QLNhanSu_war_exploded/phongban/xemphongbancha",
            data: {
            },
            success: function(data) {

                row.innerHTML=data;
                document.querySelector('.phongban-item').onclick();

            },
            error: function(error) {
                console.log(error);
            }
        });
        them = "thempbcha"
        buttonqlaiphongban.style.display = "none";
        buttonqly.style.display="none";
        buttonkhongqly.style.display="";

    }
    function xempbqly() {
        jQuery.ajax({
            type: "GET",
            url: "${request.getContextPath()}/QLNhanSu_war_exploded/phongban/xemphongbancha",
            data: {
            },
            success: function(data) {

                row.innerHTML=data;
                document.querySelector('.phongban-item').onclick();

            },
            error: function(error) {
                console.log(error);
            }
        });
        buttonqlaiphongban.style.display = "none";
        buttonqly.style.display="none";
        buttonkhongqly.style.display="";

    }
    function xempbkhongqly() {
        jQuery.ajax({
            type: "GET",
            url: "${request.getContextPath()}/QLNhanSu_war_exploded/phongban/xemphongbanchuacapnhatquanly",
            data: {
            },
            success: function(data) {
                row.innerHTML=data;
                document.querySelector('.phongban-item').onclick();

            },
            error: function(error) {
                console.log(error);
            }
        });
        buttonqlaiphongban.style.display = "none";
        buttonkhongqly.style.display="none";
        buttonqly.style.display="";

    }



    pbhienthidautien.click();
    function ThemPhongBan() {
        kieucapnhat = them;
        maphong.value = '';
        tenpb.value = '';
        tencn.value = '';
        tenql.value = '';
        ngaybd.value = '';
        tenpb.disabled = false;
        tencn.disabled = false;
        tenql.disabled = false;
        ngaybd.disabled = false;
        tenpb.focus();
    }
    function SuaPhongBan() {
        kieucapnhat = "sua";
        tenpb.disabled = false;
        tencn.disabled = false;
        tenql.disabled = false;
        ngaybd.disabled = false;
        tenql.value=   maql
        tenpb.focus();
    }
    function XoaPhongBan() {
        kieucapnhat = "xoa";
        if(them="thempbcha")
        {

        }
        else
        {

        }

    }
    function Huy() {
        phongbandangclick.click();
        maphong.disabled = true;
        tenpb.disabled = true;
        tencn.disabled = true;
        tenql.disabled = true;
        ngaybd.disabled = true;


    }
    function GuiDuLieu(){
        jQuery.ajax({
            type: "POST",
            url: "${request.getContextPath()}/QLNhanSu_war_exploded/phongban/capnhatphongban",
            data: {
                kieucapnhat : kieucapnhat,
                maphong : maphong,
                tenpb : tenpb,

                ngaybd :ngaybd,
                mapbcha : mapbcha,
                tenpbcha:tenpbcha,
            },
            success: function (data) {
                row.innerHTML=data;
                document.querySelector('.phongban-item').onclick();
                // alert("Dữ liệu đã được gửi thành công" + maPhongQL.toString() + " a "+ response);
            },
            error: function (error) {
                console.log(error);
            }
        });
    }


</script>


</body>
</html>