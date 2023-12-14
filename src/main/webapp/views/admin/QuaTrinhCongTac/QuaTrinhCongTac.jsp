<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/component/all_css.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/QuaTrinhCongTac.css">
    <title>Quản lý nhân sự</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<div id="main-web">
    <%@include file="/component/navbar/NoneMenu-nav.jsp" %>
    <%@include file="/component/header.jsp" %>
    <div id="content">
        <div id="main-content">
            <div class="dsqtct-container container">
                <div class="row">
                    <div class="col-9">
                        <div class="dsqtct-main--container">
                            <div class="dsqtct-header">
                                <h2 class="dsqtct-heading">QUÁ TRÌNH CÔNG TÁC</h2>
                            </div>
                            <div class="dsqtct-content">
                                <div class="table100 ver5 m-b-110">
                                    <div class="table100-head">
                                        <table>
                                            <thead>
                                            <tr class="row100 head">
                                                <th class="cell100 column1">Mã chương trình</th>
                                                <th class="cell100 column2">Mã nhân viên</th>
                                                <th class="cell100 column3">Ngày bắt đầu</th>
                                                <th class="cell100 column4">Mã chức vụ</th>

                                            </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div class="table100-body js-pscroll">
                                        <table>
                                            <tbody>
                                            <tr class="row100 body">
                                                <td class="cell100 column1">Like a butterfly</td>
                                                <td class="cell100 column2">Boxing</td>
                                                <td class="cell100 column3">9:00 AM - 11:00 AM</td>
                                                <td class="cell100 column4">Aaron Chapman</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="dsqtct-noidung--container">
                            <div class="dsqtct-noidung--header">
                                <h2 class="dsqtct-noidung--heading">NỘI DUNG CHI TIẾT</h2>
                            </div>
                            <div class="dsqtct-noidung--content">
                                <textarea class="dsqtct-noidung--text">

                                </textarea>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="/component/all_javascript.jsp" %>
</body>
</html>