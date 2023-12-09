<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/7/2023
  Time: 2:34 PM
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
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/CapNhatNhanVien.css">
    <title>Quản lý nhân sự</title>
    <style>
        .header-item-context--phongban {
            color: #666666;
        }
        .header-item-context--phongban:hover {
            color: #666666;
        }
        .nav-item--capnhatnhanvien {
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
            <div class="capnhatnv-container container-fluid">
                <div class="row" >
                    <div class="col-12 container-fluid">
                        <div class="row">
                            <div class="col-6">
                                <div class="capnhatnv-dspb--container">
                                    <h1 class="heading-content">Danh sách phòng ban</h1>
                                    <div class="capnhatnv-dspb--content">
                                        <div class="capnhatnv-dspb-table--wrapper">
                                            <div class="table-scroll">
                                                <table class="capnhatnv-dspb-table">
                                                    <thead>
                                                    <tr>
                                                        <th><span class="text">Mã phòng</span></th>
                                                        <th><span class="text">Tên phòng</span></th>
                                                        <th><span class="text">Chi nhánh</span></th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${listpb}" var="phongban">
                                                    <tr onclick="hienthongtinnhanvienphongban('${phongban.maPB}')">
                                                        <td>${phongban.maPB}</td>
                                                        <td>${phongban.tenPB} </td>
                                                        <td>${phongban.tenChiNhanh}</td>
                                                    </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="col-6">
                               <div class="capnhatnv-dsnvdc--container">
                                   <div class="capnhatnv-dnvdc--content">
                                        <h1 class="heading-content">Danh sách nhân viên đã có</h1>
                                       <div class="capnhatnv-dnvdc-table--wrapper">
                                           <div class="table-scroll">
                                               <table id="nhanvien-table" class="capnhatnv-dnvdc-table">
                                                   <thead>
                                                   <tr>
                                                       <th><span class="text">Mã Nhân viên</span></th>
                                                       <th><span class="text">Họ và tên</span></th>
                                                       <th><span class="text">Chức vụ</span></th>
                                                   </tr>
                                                   </thead>
                                                   <tbody id="nhanvien-tbody">
                                                   </tbody>
                                               </table>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 container-fluid" >
                        <div class="row">
                            <div class="col-10" >
                                <div class="capnhatnv-tnv--container capnhatnv-themnv--container">
                                    <h1 class="heading-content">Thêm nhân viên vào phòng ban</h1>
                                    <div class="form-themnv--container">
                                        <form action="" method="post" class="form-themnnv">
                                            <div class="capnhatnv-input-container">
                                                <label class="canhatnv-label" for="input-capnhatnv-mapb">Mã phòng ban</label>
<%--                                                <input class="capnhatnv-input" type="text" id="input-capnhatnv-mapb" name="input-capnhatnv-mapb">--%>
                                                <select class="capnhatnv-input" id="input-capnhatnv-mapb" name="input-capnhatnv-mapb">
                                                    <option value="option1">Option 1</option>
                                                    <option value="option2">Option 2</option>
                                                    <option value="option3">Option 3</option>
                                                    <option value="option4">Option 4</option>
                                                </select>
                                            </div>
                                            <div class="capnhatnv-input-container">
                                                <label class="canhatnv-label" for="input-capnhatnv-manv">Mã nhân viên</label>
                                                <input class="capnhatnv-input" type="text" id="input-capnhatnv-manv" name="input-capnhatnv-manv">
                                            </div>
                                            <div class="capnhatnv-input-container">
                                                <label class="canhatnv-label" for="input-capnhatnv-tennv">Tên nhân viên</label>
                                                <input class="capnhatnv-input" type="text" id="input-capnhatnv-tennv" name="input-capnhatnv-tennv">
                                            </div>
                                            <div class="button-confirm-container">
                                                <button class="capnhatnv-button btn btn-outline-warning">Hủy</button>
                                                <button type="submit" class="capnhatnv-button btn btn-outline-success">Xác nhân</button>
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
</div>
<%@include file="/component/all_javascript.jsp"%>
</body>
</html>
<script>
    // JavaScript

    var tbody = document.getElementById("nhanvien-tbody");

    function hienthongtinnhanvienphongban(MaPB) {

        tbody.innerHTML="";
        jQuery.ajax({
            type: "GET",
            url: "${request.getContextPath()}/QLNhanSu_war_exploded/danhsachnhanvientheophongban",
            data: {
                MaPB: MaPB
            },
            success: function(data) {

                tbody.innerHTML=data;
            },
            error: function(error) {
                console.log(error);
            }
        });
    }
</script>
