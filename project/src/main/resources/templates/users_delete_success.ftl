<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Zoo</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <meta http-equiv="refresh" content="5;URL=http://localhost/users" />

</head>
<body>
<div id="page">
<#include 'common/header_begin_clear.ftl'/>
    <div id="content">
        <div>

            <#if model.result> Удаление пользователя успешно
            <#else > Удаление неудалось
            </#if>

        </div>
    <#include 'common/header_animals.ftl'/>
    </div>

<#include 'common/header_end.ftl'/>
</div>
</body>
</html>