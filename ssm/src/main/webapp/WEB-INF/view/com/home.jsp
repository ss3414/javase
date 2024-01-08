<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Com Home</h2>
<h3><a href="/">返回欢迎页</a></h3>

<!--************************************************************分割线************************************************************-->

<table border="1">
    <tr>
        <td><a href="/com/user">User</a></td>
    </tr>
</table>

<table border="1">
    <tr>
        <td><a href="/page/page">分页（后端渲染）</a></td>
    </tr>
    <tr>
        <td><a href="/page/page2">分页（AJAX）</a></td>
    </tr>
    <tr>
        <td><a href="/page/page3">分页（MyBatis）</a></td>
    </tr>
</table>

<table border="1">
    <tr>
        <td><a href="/admin/list">后台管理+分页</a></td>
    </tr>
</table>

<table border="1">
    <tr>
        <td><a href="/tmpl/main">后端模板拆分（一级）</a></td>
    </tr>
    <tr>
        <td><a href="/tmpl/main2">后端模板拆分（二级）</a></td>
    </tr>
</table>

</body>
</html>
