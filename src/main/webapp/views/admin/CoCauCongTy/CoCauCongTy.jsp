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
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
<div id="main-web" >
    <%@include file="/component/navbar/NoneMenu-nav.jsp"%>
    <%@include file="/component/header.jsp"%>
    <div id="content">
        <div id="main-content">
            <div class="cocaucongty--container">
                <div class="cocaucongty--heading">
                    <div>
                        <ul>
                            <li class="tree-node ">
                                <span class="tree-level-1">cong ty 111</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

        </div>
    </div>

<%@include file="/component/all_javascript.jsp"%>
<script>
    jQuery('.tree-level-1').one('click',function(event) {
        console.log('hello tre-level1')
        var li = jQuery(event.currentTarget).parent() ;
        li.children('ul').remove();
        jQuery.ajax({
            url: '<%=request.getContextPath()%>/cocaucongty/chinhanh',
            success: function(data) {
                console.log(data)
                li.append('<ul></ul>');
                var ul = li.find("ul");
                jQuery.each(data, function (index, item) {
                    var html = `<li class="tree-node" style="display: none;"><span class="tree-level-2" macn="\${item.macn}">\${item.tencn}</span></li>`;
                    ul.append(html);
                });

               ul.find(".tree-node").toggle("slow");
                li.find(">span").on('click', function () {
                    ul.find("> li").toggle("slow");
                })
            }

        }).done(function () {
            level2();
        });

    })
    function level2() {
        jQuery('.tree-level-2').one('click', function (event) {
            console.log('hello tre-level2')
            var li = jQuery(event.currentTarget).parent() ;
            li.children('ul').remove();
            var macn = jQuery(this).attr('macn')
            jQuery.ajax({
                url: '<%=request.getContextPath()%>/cocaucongty/pbcha',
                data: {
                    macn:macn
                },
                success: function (data) {
                    console.log(data)
                    li.append('<ul></ul>');
                    var ul = li.find("ul");
                    jQuery.each(data, function (index, item) {
                        var html = `<li class="tree-node" style="display: none;"><span class="tree-level-3" mapbcha="\${item.mapbcha}">\${item.tenpbcha}</span></li>`;
                        ul.append(html);
                    });
                    ul.find(".tree-node").toggle("slow");
                    li.find(">span").on('click', function () {
                        ul.find("> li").toggle("slow");
                    })
                }

            }).done(function () {
                level3();
            });
        });
    }
    function level3() {
        jQuery('.tree-level-3').one('click',function (event) {
            console.log('hello tre-level3')
            var li = jQuery(event.currentTarget).parent() ;
            li.find('ul').remove();
            var mapbcha = jQuery(this).attr('mapbcha')
            jQuery.ajax({
                url: '<%=request.getContextPath()%>/cocaucongty/pbcon',
                data: {
                    mapbcha:mapbcha
                },
                success: function (data) {
                    console.log(data)
                    li.append('<ul></ul>');
                    var ul = li.find("ul");
                    jQuery.each(data, function (index, item) {
                        var html = `<li class="tree-node" style="display: none;"><span class="tree-level-4" mapbcha="\${item.mapbcon}">\${item.tenpbcon}</span></li>`;
                        ul.append(html);
                    });
                    ul.find(".tree-node").toggle("slow");
                    li.find(">span").on('click', function () {
                        ul.find("> li").toggle("slow");
                    })
                }

            }).done(function () {
                //level3();
            });
        });
    }














</script>
</body>
</html>