
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
        <div class="tickets">


        <#if model.result == true>
            <h2>Вы успешно подтвердили почту</h2>
        <#else>
            <h2>Ссылка не верна</h2>
        </#if>


        </div>
    </div>

<#include 'common/header_animals.ftl'/>
<#include 'common/header_end.ftl'/>
</div>
</body>
</html>