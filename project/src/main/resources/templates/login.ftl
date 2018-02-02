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
    <div id="header">
        <a href="/" id="logo"><img src="images/logo-page.jpg" alt=""/></a>
        <ul id="links">
            <li class="first">
                <h2><a href="/zoo">Live</a></h2>
                <span>Получайте радость от визита</span>
            </li>
            <li>
                <h2><a href="/zoo">Love</a></h2>
                <span>Жертвуйте на помощь животным</span>
            </li>
            <li>
                <h2><a href="/zoo">Learn</a></h2>
                <span>Узнавайте новое о животных</span>
            </li>
        </ul>
        <a href="/tickets" id="button">Купить билеты / Войти</a>
        <ul id="navigation">
            <li id="link1"><a href="/">  Home </a></li>
            <li id="link2" class="selected"><a href="/login">Вход</a></li>
            <li id="link3"><a href="/registration">Регистрация</a></li>
            <li id="link4"><a href="/tickets"> Билеты </a></li>
            <li id="link5"><a href="/events"> События </a></li>
            <li id="link6""><a href="/gallery"> Галерея </a></li>
            <li id="link7"><a href="/contact"> Контакты </a></li>
        </ul>
    </div>
    <div id="content">
        <div class="section2">
    <#if model.error == true>
        <h1>Неверно введены имя пользователя или пароль</h1>
    </#if>
        <form class="form-style-4" title="Авторизация"
              name="registrationForm"
              method="post"
              action="/login">
            <br>
            <input type="text" name="login" placeholder="Логин"/>
            <br>
            <input type="password" name="password" placeholder="Пароль"/>
            <br>
            <input type="submit" value="Войти">
        </form>
        </div>
    <#include 'common/header_animals.ftl'/>
    </div>


<#include 'common/header_end.ftl'/>
</div>
</body>
</html>