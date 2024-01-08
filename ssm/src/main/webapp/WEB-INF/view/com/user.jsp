<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
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
</table>

</body>
</html>
