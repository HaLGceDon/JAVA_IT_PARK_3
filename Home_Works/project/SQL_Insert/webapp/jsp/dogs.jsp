<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dogs</title>
    <link href="../css/table.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<h1></h1>

<div id="buttons">
    <ul>
        <li class="first"><a href="/jsp/index.jsp" title="">Home</a></li>
        <%--<li><a href="/cats" title="">Кошки</a></li>--%>
        <%--<li><a href="/users" title="">Члены нашего клуба</a></li>--%>
        <%--<li><a href="/jsp/about.jsp" title="">О нас</a></li>--%>
    </ul>
</div>

<table>
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Возраст</th>
        <th>Порода</th>
        <th>Цвет</th>
        <th>Вес</th>
        <th>Состояние здоровья</th>
        <th><h2>Забрать собаку</h2></th>
    </tr>
    <c:forEach items="${dogs}" var="dog">
        <tr>
            <td>${dog.id}</td>
            <td>${dog.name}</td>
            <td>${dog.age}</td>
            <td>${dog.breed}</td>
            <td>${dog.color}</td>
            <td>${dog.weight}</td>
            <td>${dog.health}</td>
            <td><form method="POST" action="/dogsDelete">
                <input type="hidden" name="id" value="${dog.id}"/>
                <input type="submit" value="Забрать собаку"/></form></td>
        </tr>
    </c:forEach>
</table>

<h1>Зарегестрировать нового пса</h1>
<form action="/dogs" method="post">
    <input type="text" name="name" placeholder="Кличка" required>
    <input type="text" name="age" placeholder="Возраст">
    <input type="text" name="breed" placeholder="Порода">
    <input type="text" name="color" placeholder="Цвет" required>
    <input type="text" name="weight" placeholder="Вес">
    <input type="text" name="health" placeholder="Состояние здоровья">

    <input type="submit">
</form>
</body>
</html>