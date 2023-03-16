<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<table>
    <tr>
        <td>用户名:</td>
        <td><%=request.getAttribute("user")%>
        </td>
    </tr>
    <tr>
        <td>姓名:</td>
        <td><%=request.getAttribute("name")%>
        </td>
    </tr>
    <tr>
        <td>性别:</td>
        <td><%=request.getAttribute("sex")%>
        </td>
    </tr>
    <tr>
        <td>密码:</td>
        <td><%=request.getAttribute("password")%>
        </td>
    </tr>
</table>
</body>
</html>