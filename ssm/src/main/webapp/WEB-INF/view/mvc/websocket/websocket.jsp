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
        <td><a href="javascript:void(0)" onclick="test('ws://127.0.0.1/websocket')">ws://127.0.0.1/websocket</a></td>
    </tr>
</table>

<script>
    function test(url) {
        let websocket = new WebSocket(url)
        websocket.onopen = function () {
            console.log("websocket onopen")
        }
    }
</script>

</body>
</html>
