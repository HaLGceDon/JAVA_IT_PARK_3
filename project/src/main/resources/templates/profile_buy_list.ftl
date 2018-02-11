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
<p>Купленные билеты можно распечатать либо предьявить на экране вашего электронного устройства.</p>
<#if model.noTickets == true >  <h2>Еще нет купленных билетов.</h2>
<#else > <h2>Купленные билеты:</h2>
</#if>
            <#list model.tickets as buyTicket>
                <br>
                <p>Имя - ${buyTicket.ticketsName}, Общая цена: ${buyTicket.price}. Код - ${buyTicket.ticketsCode}</p>
                <p>Количество взрослых билетов - ${buyTicket.quantityAdult}, Количество детских билетов - ${buyTicket.quantityKids}</p>
                <p>Дата покупки:${buyTicket.buyTime.toLocalDate()}, Срок действия до:${buyTicket.buyEndTime.toLocalDate()}.</p>
                <br>
            </#list>


        </div>
    <#include 'common/header_animals.ftl'/>
    </div>

<#include 'common/header_end.ftl'/>
</div>
</body>
</html>
