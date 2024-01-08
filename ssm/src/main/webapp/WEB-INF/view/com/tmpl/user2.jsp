<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<table border="1">
    <tr>
        <td>user2.jsp</td>
    </tr>
    <c:forEach items="${userList2}" var="user">
        <tr>
            <td>id</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td>name</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td>pwd</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
</table>
