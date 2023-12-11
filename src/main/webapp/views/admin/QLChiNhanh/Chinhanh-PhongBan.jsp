<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file = "/component/all_css.jsp"%>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/ChiNhanh-PhongBan.css">
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
            <div class="container-md cnpb-container">
                <div class="row">
                    <div class="col-sm-12 col-xl-6">
                        <div class="cnpb-cn--container">
                            <h1  style="text-align: center">Danh sách chi nhánh</h1>
                            <div class="cnpb-cn--content">
                                <div class="table100 ver1 m-b-110">
                                    <div class="table100-head">
                                        <table>
                                            <thead>
                                            <tr class="row100 head">
                                                <th class="cell100 column1">Mã chi nhánh</th>
                                                <th class="cell100 column2">Tên chi nhánh</th>
                                                <th class="cell100 column3">Địa chỉ</th>
                                            </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div class="table100-body js-pscroll">
                                        <table>
                                            <tbody>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr><tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr><tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr><tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr><tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr><tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="cnpb-pb--container">
                            <h1>Danh sách phòng ban</h1>
                            <div class="cnpb-pb--content">
                                <div class="table100 ver1 m-b-110">
                                    <div class="table100-head">
                                        <table>
                                            <thead>
                                            <tr class="row100 head">
                                                <th class="cell100 column1">Mã phòng ban</th>
                                                <th class="cell100 column2">Tên phòng ban</th>
                                                <th class="cell100 column3">Chi nhánh</th>
                                                <th class="cell100 column4">Xóa</th>
                                            </tr>
                                            </thead>
                                        </table>
                                    </div>
                                    <div class="table100-body js-pscroll">
                                        <table>
                                            <tbody>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4"><i class="fa-solid fa-trash" style="color: #dc3546"></i></td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4"><i class="fa-solid fa-trash" style="color: #dc3546"></i></td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4"><i class="fa-solid fa-trash" style="color: #dc3546"></i></td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4"><i class="fa-solid fa-trash" style="color: #dc3546"></i></td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4"><i class="fa-solid fa-trash" style="color: #dc3546"></i></td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4"><i class="fa-solid fa-trash" style="color: #dc3546"></i></td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4"><i class="fa-solid fa-trash" style="color: #dc3546"></i></td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4"><i class="fa-solid fa-trash" style="color: #dc3546"></i></td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4"><i class="fa-solid fa-trash" style="color: #dc3546"></i></td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4"><i class="fa-solid fa-trash" style="color: #dc3546"></i></td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4"><i class="fa-solid fa-trash" style="color: #dc3546"></i></td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4"><i class="fa-solid fa-trash" style="color: #dc3546"></i></td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4"><i class="fa-solid fa-trash" style="color: #dc3546"></i></td>
                                            </tr>
                                            <tr class="row100 body ">
                                                <td class="cell100 column1">CN0001</td>
                                                <td class="cell100 column2">Chi nhánh 1</td>
                                                <td class="cell100 column3">Hà Nội</td>
                                                <td class="cell100 column4"><i class="fa-solid fa-trash" style="color: #dc3546"></i></td>
                                            </tr>
                                            </tbody>
                                        </table>
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
