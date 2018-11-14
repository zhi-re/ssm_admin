<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">

    <!-- Tell the browser to be responsive to screen width -->
    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                产品管理
                <small>全部产品</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/pages/product-list.jsp">产品管理</a></li>

                <li class="active">全部产品</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content"> <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建"
                                            onclick='location.href="${pageContext.request.contextPath}/pages/product-add.jsp"'>
                                        <i class="fa fa-file-o"></i> 新建
                                    </button>
                                    <button type="button" class="btn btn-default" title="删除"
                                            onclick='confirm("你确认要删除吗？")'>
                                        <i class="fa fa-trash-o"></i> 删除
                                    </button>
                                    <button type="button" class="btn btn-default" title="开启"
                                            onclick='confirm("你确认要开启吗？")'>
                                        <i class="fa fa-check"></i> 开启
                                    </button>
                                    <button type="button" class="btn btn-default" title="屏蔽"
                                            onclick='confirm("你确认要屏蔽吗？")'>
                                        <i class="fa fa-ban"></i> 屏蔽
                                    </button>
                                    <button type="button" class="btn btn-default" title="刷新"
                                            onclick="window.location.reload();">
                                        <i class="fa fa-refresh"></i> 刷新
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm"
                                       placeholder="搜索"> <span
                                    class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </div>
                        <!--工具栏/-->

                        <!--数据列表-->
                        <table id="dataList"
                               class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="" style="padding-right: 0px;"><input
                                        id="selall" type="checkbox" class="icheckbox_square-blue">
                                </th>
                                <th class="sorting_asc">产品编号</th>
                                <th class="sorting">路线名称</th>
                                <th class="sorting">出发城市</th>
                                <th class="sorting">出发日期</th>
                                <th class="sorting">产品价格</th>
                                <th class="sorting">状态</th>
                                <th class="sorting">描述</th>
                                <th class="text-center">操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            <tr>
                                <c:forEach items="${page.list}" var="product">
                                <td><input name="ids" type="checkbox"></td>
                                <td>${product.productNum}</td>
                                <td>${product.productName}</td>
                                <td>${product.cityName}</td>
                                <td>${product.departureTimeStr}</td>
                                <td>${product.productPrice}</td>
                                <td>${product.productStatusStr}</td>
                                <td>${product.productDesc}</td>
                                <td class="text-center">
                                    <button type="button" class="btn bg-olive btn-xs"
                                            onclick='location.href="${pageContext.request.contextPath}/product/findProductById?id=${product.id}"'>
                                        修改
                                    </button>
                                    <button type="button" class="btn bg-olive btn-xs"
                                            onclick='javascript:deleteProduct(${product.id})'>删除
                                    </button>
                                </td>
                            </tr>
                            </c:forEach>

                            </tbody>

                        </table>
                        <!--数据列表/-->

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建"
                                            onclick='location.href="all-order-manage-edit.html"'>
                                        <i class="fa fa-file-o"></i> 新建
                                    </button>
                                    <button type="button" class="btn btn-default" title="删除"
                                            onclick='confirm("你确认要删除吗？")'>
                                        <i class="fa fa-trash-o"></i> 删除
                                    </button>
                                    <button type="button" class="btn btn-default" title="开启"
                                            onclick='confirm("你确认要开启吗？")'>
                                        <i class="fa fa-check"></i> 开启
                                    </button>
                                    <button type="button" class="btn btn-default" title="屏蔽"
                                            onclick='confirm("你确认要屏蔽吗？")'>
                                        <i class="fa fa-ban"></i> 屏蔽
                                    </button>
                                    <button type="button" class="btn btn-default" title="刷新"
                                            onclick="window.location.reload();">
                                        <i class="fa fa-refresh"></i> 刷新
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm"
                                       placeholder="搜索"> <span
                                    class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </div>
                        <!--工具栏/-->


                    </div>
                    <!-- 数据表格 /-->

                </div>
                <!-- /.box-body -->

                <!-- .box-footer-->
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            总共${page.pages} 页，共${page.total} 条数据。
                            每页 <select class="form-control" onchange="submitPageSize(this)" , id="pageSelect">
                            <option value="5"
                                    <c:if test="${page.pageSize==5}">selected</c:if> >5
                            </option>
                            <option value="10"
                            <%--
                            <c:if test="${page.pageSize==10}">selected</c:if>
                            --%>
                            ${page.pageSize==10?"selected":""} >10
                            </option>
                        </select> 条
                        </div>
                        <script type="text/javascript">

                            function submitPageSize(who) {
                                // document.getElementById("pageSelect").value;
                                // $("#pagepageSelect").val();
                                location.href = "${pageContext.request.contextPath}/product/findByPageHelper?pageSize=" + who.value;
                            }

                        </script>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <li><a href="javascript:submitPageNum(1)" aria-label="Previous">首页</a></li>
                            <li><a href="javascript:submitPageNum(${page.prePage})">上一页</a></li>

                            <c:choose>
                                <c:when test="${page.pages <= 5}">
                                    <c:set var="begin" value="1" />
                                    <c:set var="end" value="${page.pages}" />
                                </c:when>
                                <%--页数超过了5页--%>
                                <c:otherwise>
                                    <c:set var="begin" value="${page.pageNum-2}" />
                                    <c:set var="end" value="${page.pageNum + 2}" />
                                    <%--如果begin减1后为0,设置起始页为1,最大页为5--%>
                                    <c:if test="${begin -1 <= 0}">
                                        <c:set var="begin" value="1" />
                                        <c:set var="end" value="5" />
                                    </c:if>
                                    <%--如果end超过最大页,设置起始页=最大页-4--%>
                                    <c:if test="${end > page.pages}">
                                        <c:set var="begin" value="${page.pages - 4}" />
                                        <c:set var="end" value="${page.pages}" />
                                    </c:if>
                                </c:otherwise>
                            </c:choose>

                           <%-- <c:forEach begin="1" end="${page.pages}" var="i">
                                <li><a href="javascript:submitPageNum(${i})">${i}</a></li>
                            </c:forEach>
                            --%>

                            <c:forEach  begin="${begin}" end="${end}" var="i">
                                <li ><a <c:if test="${page.pageNum==i }">style="color: blue"</c:if>
                                        href="${pageContext.request.contextPath }/product/findByPageHelper?pageNum=${i}&pageSize=${pageInfo.pageSize}">${i }</a></li>
                            </c:forEach>
                            <li><a href="javascript:submitPageNum(${page.nextPage})">下一页</a></li>
                            <li><a href="javascript:submitPageNum(${page.pages})" aria-label="Next">尾页</a></li>
                        </ul>
                    </div>
                    <script type="text/javascript">
                        function submitPageNum(pageNum) {
                            location.href = "${pageContext.request.contextPath}/product/findByPageHelper?pageNum=" + pageNum;
                        }
                    </script>

                </div>
                <!-- /.box-footer-->

            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.8
        </div>
        <strong>Copyright &copy; 2014-2018 <a
                href="http://www.chenqi.fun">后台管理系统</a>.
        </strong> All rights reserved. </footer>
    <!-- 底部导航 /-->

</div>

<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

<script>

    // 删除方法
    function deleteProduct(id) {
        var b = confirm("确定删除？");
        if (b) {
            location.href = "${pageContext.request.contextPath}/product/deleteById?id=" + id;
        }
    }


    $(document).ready(function () {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document).ready(function () {

        // 激活导航位置
        setSidebarActive("order-manage");

        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
        // 全选操作
        $("#selall").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
</script>
</body>

</html>