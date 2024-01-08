<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- todo request对象所有属性 -->
<%--<table border="1">--%>
<%--<tr>--%>
<%--<td>pageContext.request.attributeNames</td>--%>
<%--<td>${pageContext.request.attributeNames}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.authType</td>--%>
<%--<td>${pageContext.request.authType}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.characterEncoding</td>--%>
<%--<td>${pageContext.request.characterEncoding}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.contentLength</td>--%>
<%--<td>${pageContext.request.contentLength}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.contentType</td>--%>
<%--<td>${pageContext.request.contentType}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.contextPath</td>--%>
<%--<td>${pageContext.request.contextPath}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.cookies</td>--%>
<%--<td>${pageContext.request.cookies}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.headerNames</td>--%>
<%--<td>${pageContext.request.headerNames}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.inputStream</td>--%>
<%--<td>${pageContext.request.inputStream}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.localAddr</td>--%>
<%--<td>${pageContext.request.localAddr}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.locale</td>--%>
<%--<td>${pageContext.request.locale}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.locales</td>--%>
<%--<td>${pageContext.request.locales}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.localName</td>--%>
<%--<td>${pageContext.request.localName}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.localPort</td>--%>
<%--<td>${pageContext.request.localPort}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.method</td>--%>
<%--<td>${pageContext.request.method}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.parameterMap</td>--%>
<%--<td>${pageContext.request.parameterMap}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.parameterNames</td>--%>
<%--<td>${pageContext.request.parameterNames}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.pathInfo</td>--%>
<%--<td>${pageContext.request.pathInfo}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.pathTranslated</td>--%>
<%--<td>${pageContext.request.pathTranslated}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.protocol</td>--%>
<%--<td>${pageContext.request.protocol}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.queryString</td>--%>
<%--<td>${pageContext.request.queryString}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.reader</td>--%>
<%--<td>报错</td>--%>
<%--&lt;%&ndash;<td>${pageContext.request.reader}</td>&ndash;%&gt;--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.remoteAddr</td>--%>
<%--<td>${pageContext.request.remoteAddr}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.remoteHost</td>--%>
<%--<td>${pageContext.request.remoteHost}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.remotePort</td>--%>
<%--<td>${pageContext.request.remotePort}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.remoteUser</td>--%>
<%--<td>${pageContext.request.remoteUser}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.requestedSessionId</td>--%>
<%--<td>${pageContext.request.requestedSessionId}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.requestedSessionIdFromCookie</td>--%>
<%--<td>${pageContext.request.requestedSessionIdFromCookie}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.requestedSessionIdFromURL</td>--%>
<%--<td>${pageContext.request.requestedSessionIdFromURL}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.requestedSessionIdFromUrl</td>--%>
<%--<td>${pageContext.request.requestedSessionIdFromUrl}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.requestedSessionIdValid</td>--%>
<%--<td>${pageContext.request.requestedSessionIdValid}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.requestURI</td>--%>
<%--<td>${pageContext.request.requestURI}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.requestURL</td>--%>
<%--<td>${pageContext.request.requestURL}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.scheme</td>--%>
<%--<td>${pageContext.request.scheme}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.secure</td>--%>
<%--<td>${pageContext.request.secure}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.serverName</td>--%>
<%--<td>${pageContext.request.serverName}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.serverPort</td>--%>
<%--<td>${pageContext.request.serverPort}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.servletPath</td>--%>
<%--<td>${pageContext.request.servletPath}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.session</td>--%>
<%--<td>${pageContext.request.session}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pageContext.request.userPrincipal</td>--%>
<%--<td>${pageContext.request.userPrincipal}</td>--%>
<%--</tr>--%>
<%--</table>--%>

<!--************************************************************分割线************************************************************-->
<!-- todo 循环/遍历 -->

<%--<!-- 循环 -->--%>
<%--<table border="1">--%>
<%--<c:forEach var="i" begin="1" end="5">--%>
<%--<tr>--%>
<%--<td>${i}</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>

<!-- 遍历Map -->
<%--<table border="1">--%>
<%--    <c:forEach items="${userMap}" var="userMap" varStatus="status">--%>
<%--        <c:forEach items="${userMap.value}" var="user">--%>
<%--            <tr>--%>
<%--                <td>${user.id}</td>--%>
<%--                <td>${status.index}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </c:forEach>--%>
<%--</table>--%>

<!--************************************************************半分割线******************************-->
<!-- todo 常见JSTL标签/函数 -->

<%--<table border="1">--%>
<%--    <c:forEach items="${userList}" var="user">--%>
<%--        <tr>--%>
<%--            <td>Date型时间（未格式化）</td>--%>
<%--            <td>${user.dateDate}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Date型时间（格式化）</td>--%>
<%--            <td><fmt:formatDate type="both" value="${user.dateDate}"/></td>--%>
<%--            <td><fmt:formatDate type="date" value="${user.dateDate}"/></td>--%>
<%--            <td><fmt:formatDate type="time" value="${user.dateDate}"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Date型时间（格式化+截取）</td>--%>
<%--            <td><fmt:formatDate pattern="yyyy" value="${user.dateDate}"/></td>--%>
<%--            <td><fmt:formatDate pattern="M" value="${user.dateDate}"/></td>--%>
<%--            <td><fmt:formatDate pattern="d" value="${user.dateDate}"/></td>--%>
<%--            <td><fmt:formatDate pattern="D" value="${user.dateDate}"/></td>--%>
<%--            <!-- D：一年的第多少天 -->--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>String型时间（未截取）</td>--%>
<%--            <td>${user.stringDate}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>String型时间（截取为年月日）</td>--%>
<%--            <td>${fn:substring(user.stringDate,0,4)}</td>--%>
<%--            <td>${fn:substring(user.stringDate,6,7)}</td>--%>
<%--            <td>${fn:substring(user.stringDate,9,10)}</td>--%>
<%--            <td>${fn:substring(user.stringDate,11,20)}</td>--%>
<%--            <td>${fn:length(user.stringDate)>10?fn:substring(user.stringDate,0,10).concat("..."):user.stringDate}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>

<!--************************************************************分割线************************************************************-->
<!-- todo Tomcat虚拟路径 -->

<!--
图片
①在Tomcat server.xml Host中添加（<Context path="pictures" docBase="C:\Users\Administrator\IdeaProjects(2)\javaee\ssm\src\main\webapp\images" debug="0" reloadable="false"/>）
②访问/pictures/test.jpg即相当于访问C:\Users\Administrator\IdeaProjects(2)\javaee\ssm\src\main\webapp\images\test.jpg
③不写地址（127.0.0.1:80）默认为项目地址
-->
<img src="http://127.0.0.1:80/pictures/test.jpg">

<!--
视频
①在Tomcat server.xml Host中添加（<Context path="videos" docBase="C:\Users\Administrator\WebstormProjects\front\medias\videos" debug="0" reloadable="false"/>）
-->
<%--<iframe src="http://127.0.0.1:80/videos/test.mp4" allowfullscreen="allowfullscreen"/>--%>

</body>
</html>
