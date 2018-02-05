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

            <table>
                <tr>
                    <th>ID</th>
                    <th>Имя</th>
                    <th>Общая цена</th>
                    <th>Количество взрослых</th>
                    <th>Количество детей</th>
                    <th>Дата покупки</th>
                    <th>Срок действия</th>
                </tr>
            <#list model.tickets as buyTicket>
                <tr>
                    <td>${buyTicket.id}</td>
                    <td>${buyTicket.ticketsName}</td>
                    <td>${buyTicket.price}</td>
                    <td>${buyTicket.quantityAdult}</td>
                    <td>${buyTicket.quantityKids}</td>
                    <td>${buyTicket.buyTime}</td>
                    <td>${buyTicket.buyEndTime}</td>
                </tr>
            </#list>
            </table>


        </div>
    <#include 'common/header_animals.ftl'/>
    </div>

<#include 'common/header_end.ftl'/>
</div>
</body>
</html>
