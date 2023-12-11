<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
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
                                        <table>
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
                                        <table>
                                            <tbody>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">1</td>
                                                <td class="cell100 column2">Khen thưởng nhân viên xuất sắc</td>
                                                <td class="cell100 column3">24-11-2003</td>
                                                <td class="cell100 column4">2</td>
                                                <td style="text-align: center" class="cell100 column5">1</td>
                                                <td class="cell100 column6">21110713</td>
                                            </tr>
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
                                <form action="" method="post">
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
                                            <button class="ktkl-dsct--button btn btn-outline-primary">Thêm</button>
                                            <button class="ktkl-dsct--button btn btn-outline-warning">Cập nhật</button>
                                            <button class="ktkl-dsct--button btn btn-outline-danger">Xóa</button>
                                        </div>
                                        <div class="ktkl-dsct-button--confirm">
                                            <button class="ktkl-dsct--button btn btn-outline-secondary">Hủy</button>
                                            <button type="submit" class="ktkl-dsct--button btn btn-outline-success">Xác nhận</button>
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

</body>
</html>