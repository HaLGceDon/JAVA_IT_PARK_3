<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>News- Регистрация</title>
</head>
<body>

<table>
    <tr>
        <th>Id</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Логин</th>
        <th>Возраст</th>
        <th>E-Mail</th>
        <th>Время регистрации</th>
    </tr>
    <#list model.users as user>
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</a></td>
        <td>${user.surname}</td>
        <td>${user.login}</td>
        <td>${user.age}</td>
        <td>${user.email}</td>
        <td>${user.registrationTime}</td>
    </tr>
    </#list>
</table>
</body>
</html>