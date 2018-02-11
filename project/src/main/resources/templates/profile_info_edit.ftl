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
<#include 'common/header_begin.ftl'/>
    <div id="content">
        <div id="section2">
        <h2>Редактирование данных профиля</h2>
        <form title="Редактирование"
              name="namesForm"
              method="post"
              action="/profile_info_edit">
            <br>
            <p>Имя</p>
                <input type="text"  name="name" value="${model.user.name}"/>
            <br>

            <br>
            <p>Фамилия</p>
                <input type="text"  name="surname" value="${model.user.surname}"/>
            <br>
            <br>
            <p>Возраст</p>
                <input type="number"  name="age" value="${model.user.age}"/>
            <br>
            <input type="submit" value="Сохранить изменеия">
        </form>
            <br>
            <p>Чтобы изменить пароль нажмите нижнюю кнопку и следуйте инструкциям:</p>
            <form title="password"
                  name="registrationForm"
                  method="post" action="/password_recovery">
                <input type="hidden" name="email" value="${model.user.email}">
                <input type="submit" value="Изменить пароль">
            </form>
        </div>
    <#include 'common/header_animals.ftl'/>
    </div>

<#include 'common/header_end.ftl'/>
</div>
</body>
</html>