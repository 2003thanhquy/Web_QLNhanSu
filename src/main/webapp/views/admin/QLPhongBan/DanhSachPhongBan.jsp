<%@ page import="com.qlns.model.TaiKhoan" %>
<%@ page import="com.qlns.model.Thongtinnhanvien" %>
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
                                                <div class="phongban-item" onclick="handleItemClick(event,'${phongban.tenPB}', '${phongban.maPB}', '${phongban.tenChiNhanh}', '${phongban.tenQuanLy}', '${phongban.ngayBD}','${phongban.maQuanLy}','${phongban.maCN}')">
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
                                <h1 class = "thongtinphongban-text">THÔNG TIN CHI TIẾT</h1>
                            </div>
                            <div class="thongtinphongban-content">
                                <form class="thongtinphongban-content-input--container" >
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
                                        <input id="chinhanh"  type="text" name="chinhanh" class="thongtinphongban-input" >
                                    </div>
                                    <div class="thongtinphongban-content-input--item">
                                        <label for="truongphong" class="thongtinphongban-content-input--lable">Quản lý</label>
                                        <input id="truongphong" type="text" name="truongphong" class="thongtinphongban-input">
                                    </div>
                                    <div class="thongtinphongban-content-input--item">
                                        <label for="ngaythanhlap" class="thongtinphongban-content-input--lable">Thành lập</label>
                                        <input id="ngaythanhlap" type="text" name="ngaythanhlap" class="thongtinphongban-input">
                                    </div>
                                </form>
                                <div class="thongtin-content--button">
                                    <div class = "button-control button-container">
                                        <div class="button-them btn btn-primary btn-lg button-thongtinphongban" onclick="ThemPhongBan()">
                                            <p class="button-them--label">Tạo phòng ban</p>
                                        </div>
                                        <div class="button-capnhat btn btn-info btn-lg button-thongtinphongban" onclick="SuaPhongBan()">
                                            <p class="button-capnhat--label">Cập nhật thông tin</p>
                                        </div>
                                        <div class="button-xoa btn btn-danger btn-lg button-thongtinphongban" onclick="XoaPhongBan()">
                                            <p class="button-xoa--label">Xóa phòng ban</p>
                                        </div>
                                    </div>
                                    <div class="button-confirm button-container">
                                        <div class="button-huy btn btn-warning btn-lg button-thongtinphongban" onclick="Huy()">
                                            <p class="button-huy--label">Hủy</p>
                                        </div>
                                        <button class="button-xacnhan btn btn-success btn-lg button-thongtinphongban" onclick="XacNhan()">
                                            <p class=" button-xacnhan--label">Xác nhận</p>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/component/all_javascript.jsp"%>



<% TaiKhoan tkdangnhap = (TaiKhoan)session.getAttribute("account");
    Thongtinnhanvien ttnv = (Thongtinnhanvien)session.getAttribute("user");
%>

<script>
    var isUserRoleAdmin = <%= tkdangnhap.getUserRole().equals("admin") %>;
    if (!isUserRoleAdmin) {
        document.querySelector(".thongtin-content--button").style.display = "none";
        document.querySelector(".phongchuacoquanly-container").style.display="none";
        document.querySelector(".button-chuyennoidung").style.display="none";

    }
    var roletotruong = <%= ttnv != null && ttnv.getIDChucVu()==3 %>;

    if (roletotruong) {
        document.querySelector(".button-xemphongcon--container").style.display="none";
    }



    var buttonqlaiphongban = document.querySelector(".button-quaylaiphongcha--container");
    var buttonqly = document.querySelector(".phongcoquanly-container");
    var buttonkhongqly=document.querySelector(".phongchuacoquanly-container")


    buttonqlaiphongban.style.display = "none";

    var kieucapnhat = "";
    var mapbcha="";
    var tenpbcha="";


    var row = document.querySelector(".dataphongban");
    var pbhienthidautien = document.querySelector('.phongban-item');


    var maphong = document.getElementById('maphong');
    var tenpb = document.getElementById('tenphong');
    var tencn =document.getElementById('chinhanh')
    var tenql = document.getElementById('truongphong');
    var ngaybd = document.getElementById('ngaythanhlap');
    var maql;
    var macn;
    var trangthai;

    maphong.disabled = true;
    tenpb.disabled = true;
    tencn.disabled = true;
    tenql.disabled = true;
    ngaybd.disabled = true;
    var sua="sua";

    function handleItemClick(event,tenPB, maPB, tenCN,tenQL, ngayBD ,maQL,maCN) {
        maphong.value= maPB;
        tenpb.value= tenPB;
        tencn.value=tenCN;
        tenql.value=tenQL;
        ngaybd.value=ngayBD;
        maql =maQL;
        macn = maCN;
        if (tenql.value === null) {
            tenql.value = "";
        }


        maphong.disabled = true;
        tenpb.disabled = true;
        tencn.disabled = true;
        tenql.disabled = true;
        ngaybd.disabled = true;
    }
    function xempbcon(MaPB,TenPB) {
        mapbcha= MaPB;
        tenpbcha = TenPB;
        jQuery.ajax({
            type: "GET",
            url: "${request.getContextPath()}/QLNhanSu_war_exploded/phongban/xemphongbancon",
            data: {
                maphong: MaPB
            },
            success: function(data) {
                row.innerHTML=data;


            },
            error: function(error) {
                console.log(error);
            }
        });
        buttonqlaiphongban.style.display = "";
        trangthai ="con";
        document.querySelector(".button-chuyennoidung").style.display="none";

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


            },
            error: function(error) {
                console.log(error);
            }
        });
        buttonqlaiphongban.style.display = "none";
        trangthai ="cha";
        document.querySelector(".button-chuyennoidung").style.display="";

    }
    function xempbqly() {
        sua = "sua";
        jQuery.ajax({
            type: "GET",
            url: "${request.getContextPath()}/QLNhanSu_war_exploded/phongban/xemphongbancha",
            data: {
            },
            success: function(data) {
                row.innerHTML=data;

            },
            error: function(error) {
                console.log(error);
            }
        });
        buttonqlaiphongban.style.display = "none";

    }
    function xempbkhongqly() {
        sua = "suapbchuaquanly";

        jQuery.ajax({
            type: "GET",
            url: "${request.getContextPath()}/QLNhanSu_war_exploded/phongban/xemphongbanchuacapnhatquanly",
            data: {
            },
            success: function(data) {
                row.innerHTML=data;

            },
            error: function(error) {
                console.log(error);
            }
        });
        buttonqlaiphongban.style.display = "none";

    }

    pbhienthidautien.click();
    function ThemPhongBan() {
        kieucapnhat = "them";

        maphong.value = '';
        tenpb.value = '';
        tencn.value = '';
        tenql.value = '';
        ngaybd.value = '';
        maphong.disabled=false;
        tenpb.disabled = false;
        tencn.disabled = false;
        ngaybd.disabled = false;
        tenql.disabled = false;

        maphong.focus();

        if (trangthai === "con") {
            tencn.value=macn;
            tencn.disabled=true;
        }

    }
    function SuaPhongBan() {

        kieucapnhat = sua;
        tenpb.disabled = false;
        ngaybd.disabled = false;
        tenql.disabled = false;
        tenql.value=   maql
        if (trangthai === "con") {
            tencn.value=macn;
            tencn.disabled=true;
        }
        tenpb.focus();

    }
    function XoaPhongBan() {
        kieucapnhat = "xoa";

    }
    function Huy() {
        phongbandangclick.click();


        maphong.disabled = true;
        tenpb.disabled = true;
        tencn.disabled = true;
        tenql.disabled = true;
        ngaybd.disabled = true;

    }


</script>
<script>
    function XacNhan(){
        jQuery.ajax({
            type: "GET",
            url: "${request.getContextPath()}/QLNhanSu_war_exploded/phongban/capnhatphongban",
            data: {
                kieucapnhat : kieucapnhat,
                maphong : maphong.value,
                tenpb : tenpb.value,
                mapbcha:mapbcha,
                tenpbcha:tenpbcha,
                macn: macn,
                maql: tenql.value,
                mgaybd :ngaybd.value,
            },
            success: function (data) {
                window.location.href ="${request.getContextPath()}/QLNhanSu_war_exploded/phongban/"
            },
            error: function (error) {
                console.log(error);
            }
        });
    }
</script>


</body>
</html>