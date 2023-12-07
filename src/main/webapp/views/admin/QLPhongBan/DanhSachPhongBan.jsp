<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file = "/component/all_css.jsp"%>
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
                            <div class="danhsachphongban-content container">
                                <div class="row">
                                    <!-- Tạo phòng ban-->
                                    <div class="col-6 phongban-item--container">
                                        <div class="phongban-item">
                                            <h1 class="tenphong">Nhân sự</h1>
                                            <div class="chitietphong">
                                                <div class="maphong-container chitiet-container">
                                                    <h3 class="maphong-label">Mã phòng:</h3>
                                                    <h3 class="maphong-text">0000001</h3>
                                                </div>
                                                <div class="chinhanh-container chitiet-container">
                                                    <h3 class="chinhanh-label">Chi nhánh:</h3>
                                                    <h3 class="chinhanh-text">Hà Nội</h3>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Tạo phòng ban-->
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
                                    <div class="thongtinphongban-content-input--item">
                                        <label for="chinhanh" class="thongtinphongban-content-input--lable">Chi nhánh</label>
                                        <input id="chinhanh" type="text" name="chinhanh" class="thongtinphongban-input">
                                    </div>
                                    <div class="thongtinphongban-content-input--item">
                                        <label for="truongphong" class="thongtinphongban-content-input--lable">Trưởng phòng</label>
                                        <input id="truongphong" type="text" name="truongphong" class="thongtinphongban-input">
                                    </div>
                                    <div class="thongtinphongban-content-input--item">
                                        <label for="ngaythanhlap" class="thongtinphongban-content-input--lable">Ngày thành lập</label>
                                        <input id="ngaythanhlap" type="text" name="ngaythanhlap" class="thongtinphongban-input">
                                    </div>
                                    <div class="thongtin-content--button">
                                        <div class = "button-control button-container">
                                            <div class="button-them btn btn-outline-primary btn-lg button-thongtinphongban">
                                                <p class="button-them--label">Thêm</p>
                                            </div>
                                            <div class="button-capnhat btn btn-outline-info btn-lg button-thongtinphongban">
                                                <p class="button-capnhat--label">Cập nhật</p>
                                            </div>
                                            <div class="button-xoa btn btn-outline-danger btn-lg button-thongtinphongban">
                                                <p class="button-xoa--label">Xóa</p>
                                            </div>
                                        </div>
                                        <div class="button-confirm button-container">
                                            <div class="button-huy btn btn-outline-warning btn-lg button-thongtinphongban">
                                                <p class="button-huy--label">Hủy</p>
                                            </div>
                                            <button type="submit" class="button-xacnhan btn btn-outline-success btn-lg button-thongtinphongban">
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
</div>
<%@include file="/component/all_javascript.jsp"%>
<script src=""></script>
</body>
</html>