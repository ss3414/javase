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

<h2>MVC Home</h2>
<h3><a href="/">返回欢迎页</a></h3>

<!--************************************************************分割线************************************************************-->

<!-- todo View -->
<table border="1">
    <tr>
        <td>
            <a href="/mvc/jsp">JSP</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/mvc/freemarker">FreeMarker</a>
        </td>
    </tr>
</table>
<!-- todo MVC -->
<table border="1">
    <tr>
        <td>
            <a href="/mvc/mvc/i18n">国际化</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/mvc/redirect">页面重定向</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="javascript:void(0)" onclick="test()">AJAX重定向</a>
        </td>
    </tr>
</table>
<!-- todo WebSocket -->
<table border="1">
    <tr>
        <td>
            <a href="/mvc/websocket">WebSocket</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/mvc/log">日志</a>
        </td>
    </tr>
</table>

<script>
    function test() {
        $.ajax({
            type: "post",
            url: "/mvc/redirect",
            dataType: "json",
            /* AJAX完成后的回调 */
            complete: function (xhr) {
                /* ModelAndView重定向无法兼容AJAX */
                console.log(xhr.status)
            },
            success: function (data) {
            }
        })
    }
</script>
</body>
</html>
