<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="/frames/jQuery/jquery-2.2.4.min.js"></script>
    <link rel="stylesheet" href="/frames/LayUI-2.5.4/css/modules/layer/default/layer.css">
    <script src="/frames/LayUI-2.5.4/lay/modules/layer.js"></script>

    <!-- 通用样式 -->
    <style>
        input {
            width: 100px;
        }

        /* 主体/查询/列表 */
        .main, .queryTable, .list {
            margin: auto;
        }

        .queryTable {
            padding-top: 10px;
            padding-bottom: 10px;
        }

        /* 分页 */
        .page {
            text-align: center;
            margin-top: 25px;
            margin-bottom: 25px;
            vertical-align: middle;
            line-height: 17px;
        }

        .page a, .page span {
            vertical-align: middle;
            margin-left: 10px;
            color: #333;
        }

        .pageInput {
            vertical-align: middle;
            width: 26px;
            height: 15px;
            border: 1px solid #5a5a5a;
            margin-left: 5px;
        }

        .pageGo {
            height: 24px;
            width: 36px;
            background: #3078d8;
            color: #fff;
            text-align: center;
            line-height: 17px;
            display: inline-block;
            margin-left: 10px;
        }

        /* AJAX Append */
        .pageList {
            display: inline;
        }

        /* 新增/修改弹出框 */
        .formTable {
            margin: 10px auto auto;
        }
    </style>
</head>
<body>

<!--************************************************************分割线************************************************************-->
<!-- todo 全后端渲染 -->

<%--<div class="main">--%>
<%--    <form id="queryForm" action="" method="post">--%>
<%--        <table class="queryTable">--%>
<%--            <tr>--%>
<%--                <td>pwd</td>--%>
<%--                <td>--%>
<%--                    <input type="text" name="password" value="${pageBean.queryBean.password!=null?pageBean.queryBean.password:''}">--%>
<%--                </td>--%>
<%--                <td>name</td>--%>
<%--                <td>--%>
<%--                    <select name="name">--%>
<%--                        <option value="">请选择</option>--%>
<%--                        <option value="name123">name123</option>--%>
<%--                        <option value="name456">name456</option>--%>
<%--                        <option value="name248">name248</option>--%>
<%--                    </select>--%>
<%--                </td>--%>
<%--                <td>beginTime</td>--%>
<%--                <td>--%>
<%--                    <input class="Wdate" type="text" name="beginTime">--%>
<%--                </td>--%>
<%--                <td>endTime</td>--%>
<%--                <td>--%>
<%--                    <input class="Wdate" type="text" name="endTime">--%>
<%--                </td>--%>
<%--                <td><input type="button" value="提交" onclick="pageJump()"></td>--%>
<%--                <td><input type="reset" value="重置"></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form>--%>

<%--    <table class="list" border="1">--%>
<%--        <tr>--%>
<%--            <td>id</td>--%>
<%--            <td>name</td>--%>
<%--            <td>pwd</td>--%>
<%--            <td>操作</td>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${pageBean.list}" var="record">--%>
<%--            <tr>--%>
<%--                <td>${record.id}</td>--%>
<%--                <td>${record.name}</td>--%>
<%--                <td>${record.password}</td>--%>
<%--                <td>--%>
<%--                    <a href="">修改</a>--%>
<%--                    <a href="">删除</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>

<%--    <c:if test="${pageBean.pageSize > 0}">--%>
<%--        <div class="page">--%>
<%--            <span>共${pageBean.totalRecord}条记录 ${pageBean.currentPage}/${pageBean.totalPage}</span>--%>
<%--            <a href="javascript:void(0)" onclick="pageJump(1)">第一页</a>--%>
<%--            <c:forEach var="i" begin="${pageBean.beginPage}" end="${pageBean.endPage}">--%>
<%--                <a href="javascript:void(0)" onclick="pageJump(${i})">[${i}]</a>--%>
<%--            </c:forEach>--%>
<%--            <a href="javascript:void(0)" onclick="pageJump(${pageBean.currentPage+1})">下一页</a>--%>
<%--            <a href="javascript:void(0)" onclick="pageJump(${pageBean.totalPage})">最后一页</a>--%>
<%--            <!-- 跳转 -->--%>
<%--            <span>到第</span>--%>
<%--            <input type="text" class="pageInput">--%>
<%--            <span>页</span>--%>
<%--            <input type="button" value="GO" class="pageGo" onclick="pageJump()">--%>
<%--        </div>--%>
<%--    </c:if>--%>
<%--</div>--%>

<%--<script>--%>
<%--    /*--%>
<%--    * 条件查询+分页（从queryForm中获取查询条件，从page中获取currentPage当前页）--%>
<%--    * ①普通分页+GO跳转按钮（没输入currentPage但pageInput不为空）--%>
<%--    * ②第一次渲染页面（没输入currentPage）--%>
<%--    * ③条件查询（提交按钮/没输入currentPage）--%>
<%--    * */--%>
<%--    function pageJump(currentPage) {--%>
<%--        let pageInput = $(".pageInput").val()--%>
<%--        if (!currentPage && pageInput) {--%>
<%--            currentPage = pageInput /* GO跳转按钮 */--%>
<%--        }--%>
<%--        if (currentPage < 1 || currentPage > ${pageBean.totalPage}) {--%>
<%--            alert("请输入正确的页数")--%>
<%--        } else {--%>
<%--            /* 条件查询表单，serialize()序列化后为url挂参形式（name=1&pwd=2） */--%>
<%--            let queryForm = $("#queryForm").serialize()--%>

<%--            /* get */--%>
<%--            window.location.replace("${pageBean.pageURL}=currentPage?" + currentPage + "&" + queryForm)--%>

<%--            /* AJAX */--%>
<%--            let queryForm2 = $("#queryForm").serializeArray()--%>
<%--            console.log(queryForm2)--%>
<%--            $.ajax({--%>
<%--                type: "post",--%>
<%--                url: "${pageBean.pageURL}",--%>
<%--                data: {--%>
<%--                    currentPage: currentPage,--%>
<%--                    queryForm: queryForm2--%>
<%--                },--%>
<%--                dataType: "html",--%>
<%--                success: function (data, status) {--%>
<%--                    console.log(data)--%>
<%--                    console.log(status)--%>
<%--                }--%>
<%--            })--%>

<%--            /* jQuery发送表单 */--%>
<%--            let input = $('<input>').attr("type", "hidden").attr("name", "currentPage").val(currentPage)--%>
<%--            $("#queryForm").attr('action', '${pageBean.pageURL}').append(input).submit()--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>

<!--************************************************************分割线************************************************************-->

<!-- 拼接字符串 -->
<%--<table class="list" border="1">--%>
<%--<thead id="listHead">--%>
<%--<tr>--%>
<%--<td>id</td>--%>
<%--<td>name</td>--%>
<%--<td>pwd</td>--%>
<%--<td>操作</td>--%>
<%--</tr>--%>
<%--</thead>--%>
<%--<tbody id="listBody">--%>
<%--<tr>--%>
<%--<td>1</td>--%>
<%--<td>name1</td>--%>
<%--<td>pwd1</td>--%>
<%--<td>--%>
<%--<a href="">修改</a>--%>
<%--<a href="">删除</a>--%>
<%--</td>--%>
<%--</tr>--%>
<%--</tbody>--%>
<%--</table>--%>
<%--<div class="page">--%>
<%--<div class="pageList">--%>
<%--<span>共20条记录 1/2</span>--%>
<%--<a href="">第一页</a>--%>
<%--<a href="javascript:void(0)" onclick="pageJump(1)">[1]</a>--%>
<%--<a href="">[2]</a>--%>
<%--<a href="">下一页</a>--%>
<%--<a href="">最后一页</a>--%>
<%--</div>--%>
<%--<span>到第</span>--%>
<%--<input type="text" class="pageInput">--%>
<%--<span>页</span>--%>
<%--<input type="button" value="GO" class="pageGo" onclick="pageJump()">--%>
<%--</div>--%>

<!--
todo JS渲染数据
①全后端渲染：数据/分页由EL/JSTL拼接，分页跳转/查询由JS负责
②JS渲染：JS获取EL传值再渲染数据/分页
-->

<div class="main">
    <form id="queryForm" action="" method="post">
        <table class="queryTable">
            <tr>
                <td>pwd</td>
                <td>
                    <input id="queryPwd" type="text" name="password" value="">
                </td>
                <td>name</td>
                <td>
                    <select name="name">
                        <option value="">请选择</option>
                        <option value="name123">name123</option>
                        <option value="name456">name456</option>
                        <option value="name248">name248</option>
                    </select>
                </td>
                <td>beginTime</td>
                <td>
                    <input class="Wdate" type="text" name="beginTime">
                </td>
                <td>endTime</td>
                <td>
                    <input class="Wdate" type="text" name="endTime">
                </td>
                <td><input type="button" value="提交" onclick="pageJump()"></td>
                <td><input type="reset" value="重置"></td>
                <td><input type="button" value="新增" onclick="createOrUpdate()"></td>
            </tr>
        </table>
    </form>

    <table class="list" border="1">
        <thead id="listHead">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>pwd</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody id="listBody">
        </tbody>
    </table>

    <div class="page">
        <div class="pageList">
        </div>
        <!-- 跳转 -->
        <span>到第</span>
        <input type="text" class="pageInput">
        <span>页</span>
        <input type="button" value="GO" class="pageGo" onclick="pageJump()">
    </div>
</div>

<script>
    /* 从EL表达式中获取数据+渲染 */
    let pageBean = {}
    $(function () {
        let list = []
        <c:forEach items="${pageBean.list}" var="record">
        let j = {}
        j.id = ${record.id}
            j.name = "${record.name}"
        j.pwd = "${record.password}"
        list.push(j)
        </c:forEach>

        pageBean = {
            "list": list,
            "totalRecord": ${pageBean.totalRecord},
            "pageSize": ${pageBean.pageSize},
            "totalPage": ${pageBean.totalPage},
            "currentPage": ${pageBean.currentPage},
            "beginPage": ${pageBean.beginPage},
            "endPage": ${pageBean.endPage},
            "pageURL": "${pageBean.pageURL}",
            "queryBean": {
                name: "${pageBean.queryBean.name}",
                pwd: "${pageBean.queryBean.password}"
            }
        }

        /* 遍历数据 */
        if (list && list.length > 0) {
            let str = ''
            for (let i = 0; i < list.length; i++) {
                str += '<tr>' +
                    '<td>' + list[i].id + '</td>' +
                    '<td>' + list[i].name + '</td>' +
                    '<td>' + list[i].pwd + '</td>' +
                    '<td>' +
                    '<a href="javascript:void(0)" onclick="createOrUpdate(' + list[i].id + ')">修改</a>' +
                    '<a href="javascript:void(0)" onclick="remove(' + list[i].id + ')">删除</a>' +
                    '</td>' +
                    '</tr>'
            }
            $('#listBody').empty()
            $('#listBody').append(str)
        }

        /* 遍历分页 */
        let str = '<span>共' + pageBean.totalRecord + '条记录 ' + pageBean.currentPage + '/' + pageBean.totalPage + '</span>' +
            '<a href="javascript:void(0)" onclick="pageJump(1)">第一页</a>'
        for (let i = pageBean.beginPage; i < (pageBean.endPage + 1); i++) {
            str += '<a href="javascript:void(0)" onclick="pageJump(' + i + ')">' + i + '</a>'
        }
        str += '<a href="javascript:void(0)" onclick="pageJump(' + (pageBean.currentPage + 1) + ')">下一页</a>' +
            '<a href="javascript:void(0)" onclick="pageJump(' + pageBean.totalPage + ')">最后一页</a>'
        $('.pageList').empty()
        $('.pageList').append(str)

        /* 缓存用户输入 */
        $('#queryPwd').val(pageBean.queryBean.pwd)
    })

    /*
    * 条件查询+分页（从queryForm中获取查询条件，从page中获取currentPage当前页）
    * ①普通分页+GO跳转按钮（没输入currentPage但pageInput不为空）
    * ②第一次渲染页面（没输入currentPage）
    * ③条件查询（提交按钮/没输入currentPage）
    * */
    function pageJump(currentPage) {
        let pageInput = $(".pageInput").val()
        if (!currentPage && pageInput) {
            currentPage = pageInput /* GO跳转按钮 */
        }
        if (currentPage < 1 || currentPage > pageBean.totalPage) {
            alert("请输入正确的页数")
        } else {
            /* jQuery提交查询表单 */
            let input = $('<input>').attr("type", "hidden").attr("name", "currentPage").val(currentPage)
            $("#queryForm").attr("action", pageBean.pageURL).append(input).submit()
        }
    }

    /* 新增/修改弹出框 */
    function createOrUpdate(id) {
        if (id) { /* 修改 */
            $.ajax({
                type: "post",
                url: "/admin/selectByPrimaryKey",
                data: {
                    id: id
                },
                dataType: "json",
                traditional: true,
                success: function (data) {
                    let updateForm = '<form action="/admin/createOrUpdate" method="post">' +
                        '<table class="formTable">' +
                        '<input type="hidden" name="id" value="' + data.user.id + '">' +
                        '<tr>' +
                        '<td>用户名：<input type="text" name="name" value="' + data.user.name + '"></td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td>密码：<input type="text" name="password" value="' + data.user.password + '"></td>' +
                        '</tr>' +
                        '<tr>' +
                        '<td>' +
                        '<input type="submit" value="提交">' +
                        '<input type="reset" value="重置">' +
                        '</td>' +
                        '</tr>' +
                        '</table>' +
                        '</form>'
                    layer.open({
                        type: 1,
                        title: '修改',
                        content: updateForm,
                        area: ['300px', '150px'],
                        shade: 0.5,
                        shadeClose: true
                    })
                }
            })
        } else { /* 新增 */
            let addForm = '<form action="/admin/createOrUpdate" method="post">' +
                '<table class="formTable">' +
                '<input type="hidden" name="id" value="">' +
                '<tr>' +
                '<td>用户名：<input type="text" name="name" value=""></td>' +
                '</tr>' +
                '<tr>' +
                '<td>密码：<input type="text" name="password" value=""></td>' +
                '</tr>' +
                '<tr>' +
                '<td>' +
                '<input type="submit" value="提交">' +
                '<input type="reset" value="重置">' +
                '</td>' +
                '</tr>' +
                '</table>' +
                '</form>'
            layer.open({
                type: 1,
                title: '新增',
                content: addForm,
                area: ['300px', '150px'],
                shade: 0.5,
                shadeClose: true
            })
        }
    }

    /* 删除 */
    function remove(id) {
        $.ajax({
            type: "post",
            url: "/admin/delete",
            data: {
                id: id
            },
            dataType: "json",
            traditional: true,
            success: function (data) {
                if (data.status == 1000) {
                    layer.msg("删除成功", {time: 1000}, function () {
                        window.location.reload()
                    })
                }
            }
        })
    }
</script>

</body>
</html>
