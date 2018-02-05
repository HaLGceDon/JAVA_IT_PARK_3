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
        <div id="section2">

        <form class="form-style-4" title="Редактирование"
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
            <input type="submit" placeholder="Изменить">
        </form>
        </div>
    <#include 'common/header_animals.ftl'/>
    </div>

<#include 'common/header_end.ftl'/>
</div>
</body>
</html>