<%@ page import="com.qlns.model.NhanVien" %>
<%@ page import="com.qlns.model.Thongtinnhanvien" %><%--
  Created by IntelliJ IDEA.
  User: macos
  Date: 05/12/2023
  Time: 08:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />
    <%@ include file = "/component/all_css.jsp"%>
</head>
<body>
<div id="main-web" >
    <%@include file="/component/navbar/NoneMenu-nav.jsp"%>
    <%@include file="/component/header.jsp"%>
    <div id="content">
        <div id="main-content">

            <div class="thongtincanhan">
                <div class="rectangle-parent">
                    <div class="instance-child"></div>
                    <div class="xc-nhn">Thêm</div>
                </div>
                <button class="thongtincanhan-child"></button>
                <div class="thongtincanhan-inner">
                    <div class="group-wrapper">
                        <div class="group-container">
                            <div class="rectangle-group">
                                <div class="group-child"></div>
                                <div class="hy">Xóa</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="rectangle-container">
                    <div class="instance-child"></div>
                    <div class="xc-nhn1">Xác nhận</div>
                </div>
                <div class="group-div">
                    <div class="group-container">
                        <div class="rectangle-group">
                            <div class="group-child"></div>
                            <div class="hy1">Xóa</div>
                        </div>
                    </div>
                </div>
                <button class="thongtincanhan-item"></button>
                <div class="thng-tin-c">Thông tin cá nhân</div>
                <%   Thongtinnhanvien nvhienthi =  (Thongtinnhanvien) session.getAttribute("user");   %>


                <div class="h-v-tn">Họ và tên:</div>
                <div class="rectangle-div">
                    <%= nvhienthi.getHoTen() %>
                </div>
                <div class="thongtincanhan-child1 " >
                    <%= nvhienthi.getNamSinh()%>
                </div>
                <div class="thongtincanhan-child2">  <%= nvhienthi.getGioiTinh()%></div>
                <div class="thongtincanhan-child3">  <%= nvhienthi.getCccd()%></div>
                <div class="thongtincanhan-child4">  <%= nvhienthi.getDiaChi()%></div>
                <div class="thongtincanhan-child5">  <%= nvhienthi.getTenChiNhanh()%></div>
                <div class="thongtincanhan-child6">  <%= nvhienthi.getTenChucVu()%></div>
                <div class="thongtincanhan-child7">  <%= nvhienthi.getSoDienThoai()%></div>
                <div class="thongtincanhan-child8">  <%= nvhienthi.getBacLuong()%></div>
                <div class="thongtincanhan-child9">  <%= nvhienthi.getTenTrinhDo()%></div>
                <div class="thongtincanhan-child10">  <%= nvhienthi.getTenPhongBan()%></div>
                <div class="ngy-sinh">Ngày sinh:</div>
                <div class="gii-tnh">Giới tính:</div>
                <div class="cmnd">CMND:</div>
                <div class="a-ch">Địa chỉ</div>
                <div class="chc-v">Chức vụ:</div>
                <div class="phng-ban">Phòng ban:</div>
                <div class="s-in-thoi">Số điện thoại:</div>
                <div class="bc-lng">Bậc lương</div>
                <div class="trnh">Trình độ:</div>
                <div class="chi-nhnh">Chi Nhánh</div>
                <div class="rectangle-parent2">
                    <div class="instance-inner"></div>
                    <div class="xc-nhn2">Xác nhận</div>
                </div>
                <div class="thongtincanhan-inner1">
                    <div class="rectangle-group">
                        <div class="rectangle-group">
                            <div class="group-inner"></div>
                            <div class="hy2">Hủy</div>
                        </div>
                    </div>
                </div>
                <div class="rectangle-parent4">
                    <div class="instance-child1"></div>
                    <div class="chi-tit">Cập nhật</div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<%@include file="/component/all_javascript.jsp"%>

<script type="text/javascript">

    var elementsMenuNav = document.querySelectorAll('.menu-nav');
    elementsMenuNav.forEach(function(elementMenuNav) {
        elementMenuNav.style.display = 'none';
    });
    var capnhatdiv = document.querySelectorAll('.instance-child1,.chi-tit');
    var capnhat = document.querySelectorAll('.rectangle-div, .thongtincanhan-child, .thongtincanhan-child1, .thongtincanhan-child2, .thongtincanhan-child3, .thongtincanhan-child4, .thongtincanhan-child5, .thongtincanhan-child6, .thongtincanhan-child7, .thongtincanhan-child8, .thongtincanhan-child9, .thongtincanhan-child10');

    capnhatdiv.forEach(function(element) {
        element.addEventListener('click', function() {
            capnhat.forEach(function(innerElement) {
                innerElement.contentEditable = true;
            });
        });
    });
</script>

</body>
</html>

