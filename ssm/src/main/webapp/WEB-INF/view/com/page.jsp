<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="/frames/jQuery/jquery-2.2.4.min.js"></script>
</head>
<body>

<!-- 公用样式 -->
<style>
    ul {
        list-style: none; /* 去除ul li前的黑点 */
    }

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
</style>

<!--************************************************************分割线************************************************************-->
<!-- todo 手动分页（后端渲染） -->

<script>
    /* 分页跳转 */
    function pageJump(currentPage) {
        if (!currentPage) {
            currentPage = $(".pageInput").val() /* 输入页数跳转 */
        }
        if (currentPage < 1 || currentPage > ${pageBean.totalPage}) {
            alert("请输入正确的页数")
        } else {
            window.location.replace("${pageBean.pageURL}=" + currentPage)
        }
    }
</script>

<ul>
    <c:forEach items="${pageBean.list}" var="record">
        <li>${record.name}</li>
    </c:forEach>
</ul>

<!-- 分页 -->
<c:if test="${pageBean.pageSize > 0}">
    <div class="page">
        <span>共${pageBean.totalRecord}条记录 ${pageBean.currentPage}/${pageBean.totalPage}</span>
        <a href="javascript:void(0)" onclick="pageJump(1)">第一页</a>
        <c:forEach var="i" begin="${pageBean.beginPage}" end="${pageBean.endPage}">
            <a href="javascript:void(0)" onclick="pageJump(${i})">[${i}]</a>
        </c:forEach>
        <a href="javascript:void(0)" onclick="pageJump(${pageBean.currentPage+1})">下一页</a>
        <a href="javascript:void(0)" onclick="pageJump(${pageBean.totalPage})">最后一页</a>
        <!-- 跳转 -->
        <span>到第</span>
        <input type="text" class="pageInput">
        <span>页</span>
        <input type="button" value="GO" class="pageGo" onclick="pageJump()">
    </div>
</c:if>

<!--************************************************************分割线************************************************************-->

<!-- AJAX拼接字符串（调试用） -->
<%--<ul class="data">--%>
<%--<li>1</li>--%>
<%--<li>2</li>--%>
<%--</ul>--%>

<%--<div class="page">--%>
<%--<div class="pageList">--%>
<%--<span>共20条记录 1/2</span>--%>
<%--<a href="">第一页</a>--%>
<%--<a href="javascript:void(0)" onclick="page2AJAX(1)">[1]</a>--%>
<%--<a href="">[2]</a>--%>
<%--<a href="">下一页</a>--%>
<%--<a href="">最后一页</a>--%>
<%--</div>--%>
<%--<!-- 跳转 -->--%>
<%--<span>到第</span>--%>
<%--<input type="text" class="pageInput">--%>
<%--<span>页</span>--%>
<%--<input type="button" value="GO" class="pageGo" onclick="pageJump()">--%>
<%--</div>--%>

<!--
todo 手动分页（全AJAX/MyBatis）
全AJAX/MyBatis前端完全相同，只有AJAX接口不同
-->

<%--<script>--%>
<%--    let totalPage = 0 /* 总页数（首屏/AJAX时更新） */--%>

<%--    /* 页面刷新完，首屏数据 */--%>
<%--    $(function () {--%>
<%--        page2AJAX()--%>
<%--    })--%>

<%--    /* AJAX获取分页数据 */--%>
<%--    function page2AJAX(currentPage) {--%>

<%--        /*--%>
<%--        * ①当前页不为空时，需要输入正确的页数--%>
<%--        * ②当前页为空，首屏刷新--%>
<%--        * */--%>
<%--        if (!currentPage) {--%>
<%--        } else if (currentPage < 1 || currentPage > totalPage) {--%>
<%--            alert("请输入正确的页数")--%>
<%--            return--%>
<%--        }--%>

<%--        $.ajax({--%>
<%--            type: "post",--%>
<%--            url: "/page/page2AJAX",--%>
<%--            data: {--%>
<%--                currentPage: currentPage,--%>
<%--            },--%>
<%--            dataType: "json",--%>
<%--            traditional: true,--%>
<%--            success: function (data) {--%>
<%--                console.log("pageBean:" + data.pageBean)--%>
<%--                console.log("list:" + JSON.stringify(data.pageBean.list))--%>
<%--                console.log("list[0]:" + JSON.stringify(data.pageBean.list[0]))--%>
<%--                console.log("list[0].id:" + data.pageBean.list[0].id)--%>

<%--                totalPage = data.pageBean.totalPage /* 更新总页数 */--%>
<%--                let pageList = data.pageBean.list /* 渲染数据 */--%>
<%--                let totalRecord = data.pageBean.totalRecord /* 总记录数 */--%>
<%--                let currentPage = data.pageBean.currentPage /* 当前页 */--%>
<%--                let beginPage = data.pageBean.beginPage /* 头页 */--%>
<%--                let endPage = data.pageBean.endPage /* 尾页 */--%>

<%--                if (pageList.length > 0) {--%>
<%--                    /* 附加数据和分页 */--%>
<%--                    let str = ''--%>
<%--                    for (let i = 0; i < pageList.length; i++) {--%>
<%--                        str += '<li>' + pageList[i].name + '</li>'--%>
<%--                    }--%>
<%--                    $('.data').empty()--%>
<%--                    $('.data').append(str)--%>

<%--                    str = '<span>共' + totalRecord + '条记录 ' + currentPage + '/' + totalPage + '</span>' +--%>
<%--                        '<a href="javascript:void(0)" onclick="page2AJAX(1)">第一页</a>'--%>
<%--                    for (let i = beginPage; i < (endPage + 1); i++) {--%>
<%--                        str += '<a href="javascript:void(0)" onclick="page2AJAX(' + i + ')">' + i + '</a>'--%>
<%--                    }--%>
<%--                    str += '<a href="javascript:void(0)" onclick="page2AJAX(' + (currentPage + 1) + ')">下一页</a>' +--%>
<%--                        '<a href="javascript:void(0)" onclick="page2AJAX(' + totalPage + ')">最后一页</a>'--%>
<%--                    $('.pageList').empty()--%>
<%--                    $('.pageList').append(str)--%>
<%--                }--%>
<%--            },--%>
<%--            error: function () {--%>
<%--            }--%>
<%--        })--%>
<%--    }--%>

<%--    function pageJump() {--%>
<%--        let currentPage = $(".pageInput").val()--%>
<%--        /* !currentPage判断是否为undefined/null */--%>
<%--        if (!currentPage || currentPage < 1 || currentPage > totalPage) {--%>
<%--            alert("请输入正确的页数")--%>
<%--        } else {--%>
<%--            page2AJAX(currentPage)--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>

<%--<ul class="data">--%>
<%--</ul>--%>

<%--<div class="page">--%>
<%--    <div class="pageList">--%>
<%--    </div>--%>
<%--    <!-- 跳转 -->--%>
<%--    <span>到第</span>--%>
<%--    <input type="text" class="pageInput">--%>
<%--    <span>页</span>--%>
<%--    <input type="button" value="GO" class="pageGo" onclick="pageJump()">--%>
<%--</div>--%>

</body>
</html>
