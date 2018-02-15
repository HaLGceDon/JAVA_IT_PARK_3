<#ftl encoding='UTF-8'>
<#import '../spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Zoo</title>
    <link rel="stylesheet" href="/css/style.css" type="text/css" />
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/fileProfileLoad.js"></script>
</head>
<body>
<div id="page">
<#include '../common/header_begin.ftl'/>
    <div id="content">

        <div id="section1">
        <h2>Редактирование данных профиля</h2>
        <form title="Редактирование"
              name="namesForm"
              method="post"
              action="/profile_info_edit">
            <br>
            <p>Имя</p><input type="text"  name="name" value="${model.user.name}"/>
            <br>
            <br>
            <p>Фамилия</p><input type="text"  name="surname" value="${model.user.surname}"/>
            <br>
            <br>
            <p>Возраст</p><input type="number"  name="age" value="${model.user.age}"/>
            <br>
            <input type="submit" value="Сохранить изменения">
        </form>
            <br>
            <p>Чтобы изменить пароль нажмите<br> нижнюю кнопку и следуйте инструкциям:</p>
            <form title="password"
                  name="registrationForm"
                  method="post" action="/password_recovery">
                <input type="hidden" name="email" value="${model.user.email}">
                <input type="submit" value="Изменить пароль">
            </form>
        </div>


        <div id="section2">
            <br>
            <#if model.image??> <img src="/files/${model.image}" height="212" width="211" alt=""/><br>
            <b>Сменить аватарку:</b><br>
                <form method="post" action="/delete_avatar" name="deleteAvatarFo">
                    <input name="storageName" value="${model.image}" type="hidden">
                    <input type="submit" value="Удалить и выбрать новый">
                </form>

            </form>
            <#else > <img src="../images/avatar.png" height="212" width="211" alt=""/> <br>
                <b>Выбрать аватарку:</b><br>
           <input id="fileInput" type="file" placeholder="Выбрать файл">    <br>
                <button name="uploadButton"
                        onclick="uploadFile(document.getElementById('fileInput')['files'][0])">Загрузить</button>
            </#if>
            <br>

        </div>


    <#include '../common/header_animals.ftl'/>
    </div>

<#include '../common/header_end.ftl'/>
</div>
</body>
</html>