<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Zoo</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
<div id="page">

<#include 'common/header_begin.ftl'/>
    <div id="content">
        <div id="section1">

        <h2>Привет, ${model.user.name} ${model.user.surname}</h2>
            <h2>Указан почтовый ящик - ${model.user.email}</h2>
            <h2>Возраст - ${model.user.age}</h2>
            <h2>Время регистрации на сайте: ${model.user.registrationTime}</h2>
            <h2>Ваш профиль <#if model.user.state == "CONFIRMED"> подтвержден.<#else> не подтвержден.</#if></h2>



        </div>
        <div id="section2">

            <a href="/profile_info"><img src="images/avatar.png" alt=""/></a>

            <h2><a href="/profile_info_edit" >Изменить анкету</a></h2>
            <h2><a href="/profile_buy_list">Список купленных билетов</a></h2>

        </div>
    <#include 'common/header_animals.ftl'/>
    </div>

<#include 'common/header_end.ftl'/>
</div>
</body>
</html>