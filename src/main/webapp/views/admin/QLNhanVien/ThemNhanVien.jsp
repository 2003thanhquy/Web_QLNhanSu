<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 12/7/2023
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file = "/component/all_css.jsp"%>
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
            <h1>Làm nội dung vào đây</h1>
        </div>
    </div>
</div>
</div>
<%@include file="/component/all_javascript.jsp"%>
</body>
</html>
