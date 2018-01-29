<#ftl encoding='UTF-8'>
<html>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="/static/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="/css/style2.css"> <!-- Gem style -->
    <script src="js/modernizr.js"></script> <!-- Modernizr -->
    <link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
<div id="page">
    <#include 'common/header_begin.ftl'/>
    <#include 'common/reg.ftl'/>

    <div id="content">
        <div class="section2">

            <form class="form-style-4" title="Регистрация"
                  name="registrationForm"
                  method="post"
                  action="/registration">
                <input type="text" size="30"  name="name" placeholder="Имя"/>
                <br>
                <input type="text" name="surname" placeholder="Фамилия"/>
                <br>
                <input type="text" name="login" placeholder="Логин"/>
                <br>
                <input type="password" name="password" placeholder="Пароль"/>
                <br>
                <input type="text" name="email" placeholder="Почта"/>
                <br>
                <input type="text" name="age" placeholder="Возраст"/>
                <br>
                <input type="submit"/>
            </form>
        </div>
    </div>

<#include 'common/header_animals.ftl'/>
<#include 'common/header_end.ftl'/>
</div>
</body>
</html>