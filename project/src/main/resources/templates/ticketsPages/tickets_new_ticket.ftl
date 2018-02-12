<#ftl encoding='UTF-8'>
<#import '../spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Билеты</title>
    <link rel="stylesheet" href="/css/style.css" type="text/css" />
</head>
<body>
<div id="page">
<#include '../common/header_begin.ftl'/>

    <div id="content">
        <div id="tickets">
            <h1>Добавить новый билет:</h1>

        <#if model.newTicket??><br><b>Билет '${model.newTicket}' добавлен.</b></#if>

            <form title="AddTicket" method="post"
                  name="ticketForm"
                  action="/add_ticket">
                <p>Имя билета для хранения в бд</p>
                <input type="text" name="name" required placeholder="name">
                <p>Шапка билета, оглавление</p>
                <input type="text" name="tittle" required placeholder="Оглавление" size="58">
                <p>Описание билета</p>
                <textarea name="specification" cols="60" rows="6"> </textarea>
                <p>Цена взрослого билета</p>
                <input type="number" name="adultPrice" required placeholder="Цена взрослого">
                <p>Цена детского билета</p>
                <input type="number" name="kidsPrice" required placeholder="Цена детского">
                <br>
                <input type="submit" value="Сохранить">
            </form>

        </div>
    <#include '../common/header_animals.ftl'/>
    </div>

<#include '../common/header_end.ftl'/>
</div>
</body>
</html>