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
        .nav-item--phongban {
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
        </div>
    </div>
</div>

<%@include file="/component/all_javascript.jsp"%>

</body>
</html>
