<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Zoo</title>
    <link rel="stylesheet" href="/css/style.css" type="text/css" />
</head>
<body>
<div id="page">
<#include 'common/header_begin_clear.ftl'/>
    <div id="content">
        <div>
            <table>
                <tr>
                    <th>Id</th>
                    <th>Имя</th>
                    <th>Фамилия</th>
                    <th>Логин</th>
                    <th>Возраст</th>
                    <th>E-Mail</th>
                    <th>Зарегистрирован</th>
                    <th>Статус</th>
                    <th>Удалить</th>
                </tr>
            <#list model.users as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</a></td>
                    <td>${user.surname}</td>
                    <td>${user.login}</td>
                    <td>${user.age}</td>
                    <td>${user.email}</td>
                    <td>${user.registrationTime.toLocalDate()}</td>
                    <td>${user.state}</td>
                    <td><form method="post" name="deleteUserForm" action="/delete_user">
                        <input type="hidden" name="login" value="${user.login}">
                        <input type="submit" value="Удалить" ></form></td>
                </tr>
            </#list>
            </table>

        </div>
    <#include 'common/header_animals.ftl'/>
    </div>

<#include 'common/header_end.ftl'/>
</div>
</body>
</html>