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
        <div>

            <h2>Введите новый пароль:</h2>
            <form title="password" name="passwordForm"
                  method="post"
                  action="/password_change">
                <input type="password" name="password" required placeholder="password">
                <input type="submit" value="Изменить пароль">
            </form>

        </div>
    <#include 'common/header_animals.ftl'/>
    </div>

<#include 'common/header_end.ftl'/>
</div>
</body>
</html>