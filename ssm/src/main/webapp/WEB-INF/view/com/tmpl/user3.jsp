<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!--************************************************************分割线************************************************************-->
<!-- todo 使用EL表达式拼接HTML -->

<%--<table id="user1" border="1">--%>
<%--<tr>--%>
<%--<td>user3_1</td>--%>
<%--</tr>--%>
<%--<c:forEach items="${userList1}" var="user">--%>
<%--<tr>--%>
<%--<td>id</td>--%>
<%--<td>${user.id}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>name</td>--%>
<%--<td>${user.name}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pwd</td>--%>
<%--<td>${user.password}</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--<table id="user2" border="1">--%>
<%--<tr>--%>
<%--<td>user3_2</td>--%>
<%--</tr>--%>
<%--<c:forEach items="${userList2}" var="user">--%>
<%--<tr>--%>
<%--<td>id</td>--%>
<%--<td>${user.id}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>name</td>--%>
<%--<td>${user.name}</td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>pwd</td>--%>
<%--<td>${user.password}</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>

<!--************************************************************半分割线******************************-->
<!-- todo 使用EL决定顺序，再用JS拼接HTML -->

<c:forEach items="${sortMap}" var="sortMap">
    <c:if test="${sortMap.key=='user3.jsp'}">
        <c:forEach items="${sortMap.value}" var="second">
            <table id="${second}" border="1">
            </table>
        </c:forEach>
    </c:if>
</c:forEach>

<script>
    /* 将EL表达式数据转换为JS数据 */
    let userList1 = []
    <c:forEach items="${userList1}" var="record">
    let j = {}
    j.id = ${record.id}
    j.name = "${record.name}"
    j.pwd = "${record.password}"
    userList1.push(j)
    </c:forEach>

    let userList2 = []
    <c:forEach items="${userList2}" var="record">
    let j = {}
    j.id = ${record.id}
    j.name = "${record.name}"
    j.pwd = "${record.password}"
    userList2.push(j)
    </c:forEach>

    appendStr('user1', 'user3_1', userList1)
    appendStr('user2', 'user3_2', userList2)

    /* 附加到table上 */
    function appendStr(selector, title, list) {
        if (list.length > 0) {
            let str = '<tr><td>' + title + '</td></tr>'
            for (let i = 0; i < list.length; i++) {
                str += '<tr>' +
                    '<td>id</td>' +
                    '<td>' + list[i].id + '</td>' +
                    '</tr>' +
                    '<tr>' +
                    '<td>name</td>' +
                    '<td>' + list[i].name + '</td>' +
                    '</tr>' +
                    '<tr>' +
                    '<td>pwd</td>' +
                    '<td>' + list[i].pwd + '</td>' +
                    '</tr>'
            }
            $('#' + selector).empty()
            $('#' + selector).append(str)
        }
    }
</script>
