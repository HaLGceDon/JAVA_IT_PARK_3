<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>password</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
<div id="page">
<#include 'common/header_begin.ftl'/>
    <div id="content">
        <div>
            <#if model.error == true><h2>Пользователя с такой почтой нет.<br> Попробуйте еще раз:</h2>
            <#else > <h2>Введите адрес электронной почты, <br> на который будет отправлено письмо для смены пароля:</h2></#if>
            <br>
            <form title="password"
                  name="passwordRecovery"
                  method="post" action="/password_recovery">
                <input type="email" name="email" placeholder="email" required>
                <input type="submit" value="Отправить">
            </form>
        </div>
    <#include 'common/header_animals.ftl'/>
    </div>

<#include 'common/header_end.ftl'/>
</div>
</body>
</html>