<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <td>
            国际化：<spring:message code="internationalization"/>
        </td>
    </tr>
    <tr>
        <td>
            <a href="?lang=zh_CN">中文</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="?lang=en_US">English</a>
        </td>
    </tr>
</table>

</body>
</html>
