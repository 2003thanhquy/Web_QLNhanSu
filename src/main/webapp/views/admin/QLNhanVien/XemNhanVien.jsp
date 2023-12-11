<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/taglib.jsp"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file = "/component/all_css.jsp"%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/XemNhanVien.css">
    <title>Quản lý nhân sự</title>
    <style>
        .header-item-context--nhanvien {
            color: var(--color-header-selected);
        }
        .header-item-context--nhanvien:hover {
            color: var(--color-header-selected);
        }
        .nav-item--danhsachnhanvien {
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
            <div class="danhsachnhanvien-table-wrapper container-md">
                <div class="table-scroll">
                    <table class="danhsachnhanvien-table">
                        <thead>
                            <tr>
                                <th><span class="text">Mã nhân viên</span></th>
                                <th><span class="text">Họ và tên</span></th>
                                <th><span class="text">Chức vụ</span></th>
                                <th><span class="text">Phòng ban</span></th>
                                <th><span class="text">Chi tiết Nhân Viên</span></th>
                                <th><span class="text">Xóa</span></th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listnv}" var="nhanVien">
                            <tr>
                                <td>${nhanVien.maNV}</td>
                                <td>${nhanVien.hoTen}</td>
                                <td>${nhanVien.tenChucVu}</td>
                                <td>${nhanVien.tenPhongBan}</td>
                                <td><a href="thongtin?manv=<c:out value='${nhanVien.maNV}' />"><i class="fa-solid fa-eye thongtinnhanvien-icon" data-nhanvien="${nhanVien}"></i></a></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
</div>
<%@include file="/component/all_javascript.jsp"%>
</body>
</html>