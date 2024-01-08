<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!--
①web.xml中配置
②位于webapp根目录下
③会替代SpringMVC中的首页
-->
<table border="1">
    <tr>
        <td><a href="/servlet/ServletDemo1">ServletDemo1</a></td>
    </tr>
    <tr>
        <td>通过ServletContext通讯</td>
    </tr>
    <tr>
        <td><a href="/servlet/ServletContextDemo1">ServletContextDemo1</a></td>
    </tr>
    <tr>
        <td><a href="/servlet/ServletContextDemo2">ServletContextDemo2</a></td>
    </tr>
    <tr>
        <td>获取整个Web应用/单个Servlet的初始化参数</td>
    </tr>
    <tr>
        <td><a href="/servlet/ServletContextDemo3">ServletContextDemo3</a></td>
    </tr>
    <tr>
        <td>HttpServletResponse</td>
    </tr>
    <tr>
        <td><a href="/response/ResponseDemo1">ResponseDemo1</a></td>
    </tr>
    <tr>
        <td>HttpServletRequest</td>
    </tr>
    <tr>
        <td><a href="/request/RequestDemo1?param1=1&param2=2">RequestDemo1</a></td>
    </tr>
    <tr>
        <td>Cookie</td>
    </tr>
    <tr>
        <td><a href="/cookie/CookieDemo1">CookieDemo1</a></td>
    </tr>
    <tr>
        <td>Session</td>
    </tr>
    <tr>
        <td><a href="/session/SessionDemo1">SessionDemo1</a></td>
    </tr>
    <tr>
        <td>禁用Cookie（URL回写）</td>
    </tr>
    <tr>
        <td><a href="/session/SessionDemo2">SessionDemo2</a></td>
    </tr>
    <tr>
        <td>Filter</td>
    </tr>
    <tr>
        <td><a href="/filter/FilterServlet1">FilterDemo1</a></td>
    </tr>
    <tr>
        <td>JavaEE模拟SpringMVC</td>
    </tr>
</table>

</body>
</html>
