<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пользователи</title>
    <link href="/css/table.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>${hello}</h1>

<div id="buttons">
    <ul>
        <li class="first"><a href="/jsp/index.jsp" title="">Home</a></li>
        <%--<li><a href="/dogs" title="">Собаки</a></li>--%>
        <%--<li><a href="/cats" title="">Кошки</a></li>--%>
        <%--<li><a href="/jsp/about.jsp" title="">О нас</a></li>--%>
    </ul>
</div>
<table>
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Логин</th>
        <th>Возраст</th>
        <th>E-Mail</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td><a href="/usersUpdate?id=${user.id}">${user.name}</a></td>
            <td>${user.surname}</td>
            <td>${user.login}</td>
            <td>${user.age}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>

</table>
<form action="/users" method="post">
    <input type="text" name="name" placeholder="Имя" required>
    <input type="text" name="surname" placeholder="Фамилия">
    <input type="text" name="login" placeholder="Логин">
    <input type="text" name="age" placeholder="Возраст" required>
    <input type="text" name="email" placeholder="E-Mail">
    <input type="text" name="password" placeholder="Пароль">

    <input type="submit">
</form>


</body>
</html>