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
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/DanhSachChiNhanh.css">
    <title>Quản lý nhân sự</title>
    <style>
        .header-item-context--chinhanh {
            color: var(--color-header-selected);
        }
        .header-item-context--chinhanh:hover {
            color: var(--color-header-selected);
        }
        .nav-item--xemchinhanh {
            background-color: var(--backcolor-menu-selected) ;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<div id="main-web" >
    <%@include file="/component/navbar/QLChiNhanh-nav.jsp"%>
    <%@include file="/component/header.jsp"%>
    <div id="content">
        <div id="main-content">
            <div class=" container-md dscn-container">
                <div class="row">
                    <div class="col">
                        <div class="dscn-cn--container">
                            <h1 class="dscn-cn--heading">Danh sách chi nhánh</h1>
                            <div class="dscn-cn--content">
                                <div class="dscn-cn-table--wrapper">
                                    <div class="table-scroll">
                                        <table class="dscn-cn-table">
                                            <thead>
                                            <tr>
                                                <th><span class="text">Mã chi nhánh</span></th>
                                                <th><span class="text">Tên chi nhánh</span></th>
                                                <th><span class="text">Địa chỉ</span></th>
                                                <th><span class="text">Ngày thành lập</span></th>
                                                <th><span class="text">Mã giám đốc</span></th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>CN0001</td>
                                                    <td>Chi nhánh 1</td>
                                                    <td>Hà Nội</td>
                                                    <td>24-11-2003</td>
                                                    <td>NV0001</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/component/all_javascript.jsp"%>

</body>
</html>
