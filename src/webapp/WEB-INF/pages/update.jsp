<%--
  Created by IntelliJ IDEA.
  User: romkonst
  Date: 08.06.2020
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update of user</title>
</head>
<body>
<form action="/update" method="post" style="margin: 30px;">
    <table border="1" cellspacing="0" cellpadding="2">
        <tr>
            <td>ID</td>
            <td>name</td>
            <td>age</td>
            <td>password</td>
            <td>role</td>
        </tr>
        <br>
        <tr>
            <td>
                <input type="text" name="id" value="${id}" hidden> ${id}
            </td>
            <td>
                <input type="text" name="name" value="${name}">
            </td>

            <td>
                <input type="number" name="age" value="${age}">
            </td>

            <td>
                <input type="text" name="pass" value="${password}">
            </td>
            <td>
                <select name="role" autofocus>
                    <option value="user" ${role == 'user' ? 'selected' : ''}>user</option>
                    <option value="admin" ${role == 'admin' ? 'selected' : ''}>admin</option>
                </select>
                <%--<input type="text" name="role" value="${user.role}">--%>
            </td>
            <td>
            <button type="submit">UPDATE</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
