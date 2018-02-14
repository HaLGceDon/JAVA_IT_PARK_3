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
					<h1>Билеты</h1>
				<#if model.user?? > <#if model.user.login == "admin">
                    <a href="/tickets_redaction"><h1>** Редактировать билеты</h1></a>
                    <a href="/tickets_new_ticket"><h1>** Создать новый билет</h1></a>
				</#if>
				</#if>

                    <p>Выберите билеты на интерусующие вас шоу</p>
                    <ul>
						<#list model.tickets as ticket>
                            <li <#if ticket.id == 1>class="first"</#if>>
                                <h2><a href="/buy_tickets/${ticket.name}">${ticket.tittle}</a></h2>
                                <a href="/buy_tickets/${ticket.name}"><span>Взрослый билет - ${ticket.adultPrice} рублей</span></a>
                                <br>
                                <a href="/buy_tickets/${ticket.name}"><span>Детский билет - ${ticket.kidsPrice} рублей</span></a>
                                <div><a href="/buy_tickets/${ticket.name}"><img <#if ticket.image??>src="/files/${ticket.image.storageName}"<#else >src="../images/ticket.png"</#if> height="211" width="265" alt=""/></a></div>
                                <p> ${ticket.specification}</p>
                            </li>
						</#list>
                    </ul>

				</div>
			<#include '../common/header_animals.ftl'/>
            </div>

		<#include '../common/header_end.ftl'/>
		</div>
	</body>
</html>  