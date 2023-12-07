<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
                                <th><span class="text">Trạng thái</span></th>
                                <th><span class="text">Chi tiết</span></th>
                                <th><span class="text">Xóa</span></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>
                            <tr>
                                <td>21110713</td>
                                <td>Phạm Hữu Tuấn</td>
                                <td>Nhân viên</td>
                                <td>Marketing</td>
                                <td>Còn làm</td>
                                <td><i class="fa-solid fa-eye thongtinnhanvien-icon"></i></td>
                                <td><i class="fa-solid fa-trash xoanhanvien-icon"></i></td>
                            </tr>

                        </tbody>
                    </table>
                </div>
            </div>
            <button class="btn btn-primary btn-loadthemnhanvien">Hiện thêm >></button>
        </div>
    </div>
</div>
<%@include file="/component/all_javascript.jsp"%>
</body>
</html>