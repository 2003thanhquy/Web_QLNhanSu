<%@ page import="com.qlns.model.Thongtinnhanvien" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<nav id="nav">
<%--    <% Thongtinnhanvien ttnv = (Thongtinnhanvien)session.getAttribute("user");%>--%>
    <div class="nav-human-infor">
        <div class="" style="text-align: center; z-index: 1;">
            <div class="avatar-container">
                <div class="avatar-nav">
<%--                    <img src="<%= request.getContextPath()%>/uploads/<%=ttnv.getHinhAnh()%>"/>--%>
                </div>
            </div>
<%--            <p class="nav-human-name"><%=ttnv.getHoTen()%></p>--%>
        </div>
    </div>
    <div class="brand-nav">
        <div class="nav-main-brand">
            <div class="brand-logo">
                <img src="<%= request.getContextPath()%>/assets/image/logo.png" alt="" class="brand-logo-image">
                <p class="brand-name">
                    Quản Lý Nhân Sự
                </p>
            </div>
            <p class="brand-describe">
                Công ty 111
            </p>
        </div>

    </div>

    <div class="menu-nav">
        <ul class="nav-list-items">
        </ul>
    </div>
</nav>

