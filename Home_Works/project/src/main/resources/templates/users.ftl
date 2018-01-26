<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Пользователи</title>
    <link href="/css/table.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="buttons">
    <ul>
        <li class="first"><a href="/" title="">Home</a></li>
        <li><a href="/cats" title="">Кошки</a></li>
        <li><a href="/dogs" title="">Собаки</a></li>
        <li><a href="/users" title="">Члены нашего клуба</a></li>
        <li><a href="/about" title="">О нас</a></li>
    </ul>
</div>

<div id="bg">

    <div id="main">
        <!-- header ends -->
        <!-- content begins -->
        <div id="content">
            <div id="content_top">
                <div id="content_bot">

                    <div id="left">

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

                        <div style="clear: both"></div>

                    </div>

                    <!-- content ends -->
                </div>
            </div>
        </div>


    </div>
</div>


<div id="buttons">
    <ul>
        <li class="first"><a href="/" title="">Назад</a></li>
</div>

</body>
</html>