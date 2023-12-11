<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/7/2023
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.qlns.model.PhongBan"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file = "/component/all_css.jsp"%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/ThemNhanVien.css">
    <title>Quản lý nhân sự</title>
    <style>
        .header-item-context--nhanvien {
            color: var(--color-header-selected);
        }
        .header-item-context--nhanvien:hover {
            color: var(--color-header-selected);
        }
        .nav-item--themnhanvien {
            background-color: var(--backcolor-menu-selected) ;
        }
    </style>
</head>
<body>
<div id="main-web" >
    <%@include file="/component/navbar/QLNhanVien-nav.jsp" %>
    <%@include file="/component/header.jsp"%>
    <div id="content">
        <div id="main-content">
            <div class="themnhanvien-container container-md">
                <div class="themnhanvien-excel--container">
                    <div class="themnhanvien-excel--content">
                        <img class="themnhanvien-excel--image" src="<%=request.getContextPath()%>/assets/image/excel-logo.png">
                    </div>
                </div>
                <div class="themnhanvien-thucong--container">
                    <h1 class="themnhanvien-thucong--header">Thêm thủ công</h1>
                    <div class="themnhanvien-thucong--content">
                        <div class="themnhanvien-thucong-form--container container">

                            <form action="<%=request.getContextPath()%>/nhanvien/themnhanvien" method="post" class="form-tnv container" enctype="multipart/form-data">
                                <div class="row">
                                    <div class="col-10">
                                        <div class="input-element--container">
                                            <div class="input-container">
                                            </div>
                                            <div class="input-container">
                                                <label class="input-text" for="tnv-hovaten">Họ và tên</label>
                                                <input class="tnv-input" type="text" id="tnv-hovaten" name="tnv-hovaten">
                                            </div>
                                            <div class="input-container">
                                                <label class="input-text" for="tnv-cmnd">CMND/CCCD</label>
                                                <input class="tnv-input" type="text" id="tnv-cmnd" name="tnv-cmnd">
                                            </div>
                                            <div class="input-container">
                                                <label class="input-text" for="tnv-diachi">Địa chỉ</label>
                                                <input class="tnv-input" type="text" id="tnv-diachi" name="tnv-diachi">
                                            </div>
                                            <div class="input-container">
                                                <label class="input-text" for="tnv-sdt">Số điện thoại</label>
                                                <input class="tnv-input" type="text" id="tnv-sdt" name="tnv-sdt">
                                            </div>
                                            <div class="input-container">
                                                <label class="input-text" for="tnv-ngaysinh">Ngày sinh</label>
                                                <input class="tnv-input" type="date" id="tnv-ngaysinh" name="tnv-ngaysinh">
                                            </div>
                                            <div class="input-container">
                                                <label class="input-text ">Giới tính</label>
                                                <div class="gioitinh-radiobutton">
                                                    <label class="gioitinh-text">
                                                        <input  type="radio" name="gender" value="male"> Nam
                                                    </label>
                                                    <label class="gioitinh-text" style="margin-left: 8px">
                                                        <input  type="radio" name="gender" value="female"> Nữ
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="input-container">
                                                <label class="input-text" for="tnv-idtrinhdo">Mã trình độ</label>
                                                <select class="tnv-input"   id="tnv-idphongban" name="tnv-maphongban">
                                                    <c:forEach items="${lstPB}" var="pb">
                                                        <option value="${pb.maPB}">${pb.tenPB}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="input-container">
                                                <label class="input-text" for="tnv-idbacluong">Mã bậc lương</label>
                                                <select class="tnv-input"   id="tnv-idbacluong" name="tnv-idbacluong">
                                                    <c:forEach items="${lstLuong}" var="l">
                                                        <option value="${l.idBacLuong}">${l.idBacLuong}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="input-container">
                                                <label class="input-text" for="tnv-idchucvu">Mã chức vụ</label>
                                                <select class="tnv-input"   id="tnv-idchucvu" name="tnv-idchucvu">
                                                    <c:forEach items="${lstCV}" var="cv">
                                                        <option value="${cv.idChucVu}">${cv.tenChucVu}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="input-container">
                                                <label class="input-text" for="tnv-idtrinhdo">Mã trình độ</label>
                                                <select class="tnv-input"   id="tnv-idtrinhdo" name="tnv-idtrinhdo">
                                                    <c:forEach items="${lstTD}" var="td">
                                                        <option value="${td.idTrinhDo}">${td.tenTrinhDo}</option>
                                                    </c:forEach>
                                                </select>

                                            </div>
                                            <div class="input-container">
                                                <label class="h2" for="fileInput-avatar">Chọn ảnh đại diện:</label>
                                                <input class="btn btn-outline-info" type="file" id="fileInput-avatar" name="image" accept="image/*">
                                                <div id="imageContainer-avatar">

                                                </div>
                                            </div>


                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="button-container">
                                            <button  class="btn btn-outline-danger btnHuy">Hủy</button>
                                            <button type="submit" class="btn btn-outline-success btnXacNhan">Xác nhận</button>
                                        </div>
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
    document.getElementById('fileInput-avatar').addEventListener('change', function(event) {
        const selectedImage = event.target.files[0];
        if (selectedImage) {
            const reader = new FileReader();
            reader.onload = function(e) {
                const imageElement = document.createElement('img');
                imageElement.classList.add("image-avatar");
                imageElement.src = e.target.result;
                const imageContainer = document.getElementById('imageContainer-avatar');
                imageContainer.innerHTML = '';
                imageContainer.appendChild(imageElement);
            };
            reader.readAsDataURL(selectedImage);
        }
    });

</script>
<%--<script>--%>
<%--    $(document).ready(function() {--%>
<%--        $("#myForm").submit(function(event) {--%>
<%--            // Ngăn chặn sự kiện mặc định của form--%>
<%--            event.preventDefault();--%>

<%--            // Lấy dữ liệu từ form--%>
<%--            var formData = new FormData($("#myForm")[0]);--%>

<%--            // Gửi dữ liệu bằng Ajax--%>
<%--            $.ajax({--%>
<%--                url: "<%=request.getContextPath()%>/themnhanvien",--%>
<%--                type: "POST",--%>
<%--                data: formData,--%>
<%--                processData: false,--%>
<%--                contentType: false,--%>
<%--                success: function(response) {--%>
<%--                    // Xử lý kết quả thành công--%>
<%--                    alert("Thêm nhân viên thành công");--%>
<%--                },--%>
<%--                error: function(xhr, status, error) {--%>
<%--                    // Xử lý lỗi--%>
<%--                    alert("Thêm nhân viên không thành công");--%>
<%--                }--%>
<%--            });--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
</body>
</html>
