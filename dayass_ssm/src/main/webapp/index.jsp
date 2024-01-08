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

<!--
欢迎页替代了首页，jsp:forward不能写/，会无限循环跳转欢迎页
-->
<jsp:forward page="/home"/>

</body>
</html>
