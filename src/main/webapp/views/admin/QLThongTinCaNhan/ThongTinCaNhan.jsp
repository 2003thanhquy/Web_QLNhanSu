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
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/thongtincanhan.css">
    <title>Quản lý nhân sự</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<div id="main-web" >
    <%@include file="/component/navbar/NoneMenu-nav.jsp"%>
    <%@include file="/component/header.jsp"%>
    <div id="content">
        <div id="main-content">
            <div class="container-sm">
                <div class="thongtin-container">
                    <h1 class="h1">Thông tin cá nhân</h1>
                    <div class="thongtin-content">
                        <div class="formthongtin-container">
                            <form class="formthongtin" action="" method="post">
                                <div class="thongtin-input-element--container">
                                    <div class = "thongtin-avatar-container ">

                                        <div id="thongtin-imageContainer-avatar">

                                        </div>
                                        <label class="h2" for="thongtin-fileInput-avatar">Đổi ảnh đại diện:</label>
                                        <input class="btn btn-outline-info" type="file" id="thongtin-fileInput-avatar" name="thongtin-image--avatar" accept="image/*">
                                    </div>
                                    <div class="container">
                                        <div class="row">
                                            <div class="col-lg-6 col-12">
                                                <div>
                                                    <div  class="thongtin-input--container">
                                                        <label class="thongtin-input--label" for="thongtin-input-hoten" >Họ và tên</label>
                                                        <input class="thongtin-input--element" name="thongtin-input-hoten" id="thongtin-input-hoten">
                                                    </div>
                                                    <div  class="thongtin-input--container">
                                                        <label class="thongtin-input--label" for="thongtin-input-cccd" >CCCD/CMND</label>
                                                        <input class="thongtin-input--element" name="thongtin-input-cccd" id="thongtin-input-cccd">
                                                    </div>
                                                    <div  class="thongtin-input--container">
                                                        <label class="thongtin-input--label" for="thongtin-input-diachi" >Địa chỉ</label>
                                                        <input class="thongtin-input--element" name="thongtin-input-diachi" id="thongtin-input-diachi">
                                                    </div>
                                                    <div  class="thongtin-input--container">
                                                        <label class="thongtin-input--label" for="thongtin-input-sdt" >Số điện thoại</label>
                                                        <input class="thongtin-input--element" name="thongtin-input-sdt" id="thongtin-input-sdt">
                                                    </div>
                                                    <div  class="thongtin-input--container">
                                                        <label class="thongtin-input--label" for="thongtin-input-ngaysinh" >Ngày sinh</label>
                                                        <input class="thongtin-input--element" name="thongtin-input-ngaysinh" id="thongtin-input-ngaysinh">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-12">
                                                <div>
                                                    <div class="thongtin-input--container">
                                                        <label class="thongtin-input-text ">Giới tính</label>
                                                        <div class="thongtin-gioitinh-radiobutton">
                                                            <label class="thongtin-gioitinh-text">
                                                                <input  type="radio" name="gender" value="male"> Nam
                                                            </label>
                                                            <label class="thongtin-gioitinh-text" style="margin-left: 8px">
                                                                <input  type="radio" name="gender" value="female"> Nữ
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div  class="thongtin-input--container">
                                                        <label class="thongtin-input--label" for="thongtin-input-phongban" >Phòng ban</label>
                                                        <input class="thongtin-input--element" name="thongtin-input-phongban" id="thongtin-input-phongban">
                                                    </div>
                                                    <div  class="thongtin-input--container">
                                                        <label class="thongtin-input--label" for="thongtin-input-bacluong" >Bậc lương</label>
                                                        <input class="thongtin-input--element" name="thongtin-input-bacluong" id="thongtin-input-bacluong">
                                                    </div>
                                                    <div  class="thongtin-input--container">
                                                        <label class="thongtin-input--label" for="thongtin-input-chucvu" >Chức vụ</label>
                                                        <input class="thongtin-input--element" name="thongtin-input-chucvu" id="thongtin-input-chucvu">
                                                    </div>
                                                    <div  class="thongtin-input--container">
                                                        <label class="thongtin-input--label" for="thongtin-input-trinhdo" >Trình độ</label>
                                                        <input class="thongtin-input--element" name="thongtin-input-trinhdo" id="thongtin-input-trinhdo">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="thongtin-button--container">
                                    <button class="thongtin-button btn btn-outline-warning">Cập nhật</button>
                                    <button class="thongtin-button btn btn-outline-danger">Hủy</button>
                                    <button type="submit" class="thongtin-button btn btn-outline-success">Xác nhận</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/component/all_javascript.jsp"%>
<script>
    document.getElementById('thongtin-fileInput-avatar').addEventListener('change', function(event) {
        const selectedImage = event.target.files[0];
        if (selectedImage) {
            const reader = new FileReader();
            reader.onload = function(e) {
                const imageElement = document.createElement('img');
                imageElement.classList.add("thongtin-image-avatar");
                imageElement.src = e.target.result;
                const imageContainer = document.getElementById('thongtin-imageContainer-avatar');
                imageContainer.innerHTML = '';
                imageContainer.appendChild(imageElement);
            };
            reader.readAsDataURL(selectedImage);
        }
    });
</script>
</body>
</html>
