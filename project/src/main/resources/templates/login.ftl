<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Авторизация</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
<div id="page">

<#include 'common/header_begin.ftl'/>
    <div id="content">
        <div class="section2">
    <#if model.error == true>
        <h1>Неверно введены имя пользователя или пароль</h1>
    </#if>
        <form title="Авторизация"
              name="authorization"
              method="post"
              action="/login">
            <b>Логин:</b>
            <br>
            <input type="text" name="login" required placeholder="Логин"/>
            <br>
            <b>Пароль:</b>
            <br>
            <input type="password" name="password" required placeholder="Пароль"/>
            <p> <input type="checkbox" checked name="remember-me" > Запомнить</p>
            <a href="/password_recovery"><p>Забыли пароль?</p></a>
            <input type="submit" value="Войти">
        </form>
        </div>
    <#include 'common/header_animals.ftl'/>
    </div>


<#include 'common/header_end.ftl'/>
</div>
</body>
</html>