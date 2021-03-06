<#ftl encoding='UTF-8'>
<#import '../spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Zoo</title>
    <link rel="stylesheet" href="/css/style.css" type="text/css" />
</head>
<body>
<div id="page">
<#include '../common/header_begin.ftl'/>
    <div id="content">
        <div id="section2">
<p>Купленные билеты можно распечатать либо предьявить на экране вашего электронного устройства.</p>
<#if model.buyTickets?? >
    <h2>Купленные билеты:</h2>
    <#list model.buyTickets as buyTicket>
        <br>
        <p>Имя - ${buyTicket.ticketsName}, Общая цена: ${buyTicket.price}. Код - ${buyTicket.ticketsCode}</p>
        <p>Количество взрослых билетов - ${buyTicket.quantityAdult}, Количество детских билетов - ${buyTicket.quantityKids}</p>
        <p>Дата покупки:${buyTicket.buyTime.toLocalDate()}, Срок действия до:${buyTicket.buyEndTime.toLocalDate()}.</p>
        <br>
    </#list>
<#else >
    <h2>Еще нет купленных билетов.</h2>
</#if>



        </div>
    <#include '../common/header_animals.ftl'/>
    </div>

<#include '../common/header_end.ftl'/>
</div>
</body>
</html>
