<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file = "/component/all_css.jsp"%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/DuAnThamGia.css">
    <style>
        .header-item-context--nhanvien {
            color: var(--color-header-selected);
        }
        .header-item-context--nhanvien:hover {
            color: var(--color-header-selected);
        }
        .nav-item--duanthamgia {
            background-color: var(--backcolor-menu-selected) ;
        }
    </style>
    <title>Quản lý nhân sự</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<div id="main-web" >
    <%@include file="/component/navbar/QLNhanVien-nav.jsp"%>
    <%@include file="/component/header.jsp"%>
    <div id="content">
        <div id="main-content">
            <div class="container-md">
                <div class="row">
                    <div class="col-6">
                        <div class="datg-nhanvien--container">
                            <h1 class="datg-nhanvien-heading">Nhân viên</h1>
                            <div class="datg-nhanvien--content">
                                <div class="datg-nhanvien-table--wrapper">
                                    <div class="table-scroll">
                                        <table class="datg-nhanvien-table">
                                            <thead>
                                            <tr>
                                                <th><span class="text">Mã nhân viên</span></th>
                                                <th><span class="text">Tên nhân viên</span></th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td></td>
                                                    <td>${phongban.tenPB} </td>
                                                    <td>${phongban.tenChiNhanh}</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="datg-duan--container">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/component/all_javascript.jsp"%>
</div>
</body>
</html>
