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

<!-- 直接引入外部模板 -->
<%--<c:import url="user1.jsp"/>--%>
<%--<c:import url="user2.jsp"/>--%>

<!-- 遍历顺序数组（一级） -->
<%--<c:forEach items="${sortArray}" var="sort">--%>
<%--<c:import url="${sort}"/>--%>
<%--</c:forEach>--%>

<!-- 遍历顺序Map（二级） -->
<c:forEach items="${sortMap}" var="sort">
    <c:import url="${sort.key}"/>
</c:forEach>

</body>
</html>
