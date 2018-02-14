<#ftl encoding='UTF-8'>
<#import '../spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Билеты</title>
    <link rel="stylesheet" href="/css/style.css" type="text/css" />
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/fileTicketLoad.js"></script>
</head>
<body>
<div id="page">
<#include '../common/header_begin.ftl'/>

    <div id="content">
        <div id="tickets">
            <h1>Редактирование билетов:</h1>
            <#if model.deleteTicked??><b>Билет '${model.deleteTicked}' удален.</b></#if>

            <ul>
            <#list model.tickets as ticket>
                <li <#if ticket.id == 1>class="first"</#if>>
                    <form title="AddTicket" method="post"
                          name="ticketForm"
                          action="/delete_ticket">
                        <b>Name: ${ticket.name} </b><input type="hidden" name="name" value="${ticket.name}" required>
                        <input type="submit" value="Удалить">
                    </form>
                    <form title="AddTicket" method="post"
                          name="ticketForm"
                          action="/update_ticket">
                    <span>Имя:</span><input type="text" name="name" required value="${ticket.name}"><br>
                    <span>Оглавление:</span><input type="text" name="tittle" required size="40" value="${ticket.tittle}">
                        <img <#if ticket.image??>src="/files/${ticket.image.storageName}"<#else >src="../images/ticket.png"</#if> height="211" width="265" alt=""/>
                    <span>Цена билета:</span><br>
                    <span>Взрослый:</span><input type="number" required name="adultPrice" value="${ticket.adultPrice}">
                    <span>Детский:</span><input type="number" required name="kidsPrice" value="${ticket.kidsPrice}">
                    <span>Описание:</span><textarea name="specification" cols="34" rows="4">${ticket.specification}</textarea>
                    <br>
                    <input type="submit" value="Изменить">
                    </form>
                    <#if ticket.image??>
                        <b>Сменить изображение:</b><br>
                        <form method="post" action="/delete_ticket_image" name="deleteImage">
                            <input name="storageName" value="${ticket.image.storageName}" type="hidden">
                            <input type="submit" value="Удалить и выбрать новое">
                        </form>


                    <#else >
                        <b>Выбрать изображение:</b><br>

                        <input id="ticketId" type="hidden" name="ticketId" value="${ticket.name}">
                        <input id="fileInput" type="file" placeholder="Выбрать файл">
                        <button name="uploadButton"
                                onclick="uploadFile(document.getElementById('fileInput')['files'][0],
                                                    document.getElementById('ticketId').value)">Загрузить</button>

                    </#if>
                </li>
            </#list>
            </ul>


        </div>
    </div>

<#include '../common/header_end.ftl'/>
</div>
</body>
</html>