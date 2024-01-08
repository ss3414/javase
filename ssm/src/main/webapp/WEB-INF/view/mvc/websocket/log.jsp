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

<script>
    $(function () {
        let websocket = new WebSocket("ws://127.0.0.1/log")
        websocket.onmessage = function (event) {
            console.log(event.data)
        }
    })
</script>

</body>
</html>
