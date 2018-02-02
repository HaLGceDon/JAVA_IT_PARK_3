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
            <#if model.result == true>  <h2>Оплачено</h2> </#if>
            <#if model.result == false>  <h2>Ошибка. <a href="/buy_tickets_pay"><p> Назад </p></a></h2> </#if>
        </div>

    <#include 'common/header_animals.ftl'/>
    </div>

<#include 'common/header_end.ftl'/>
</div>
</body>
</html>