<#ftl encoding='UTF-8'>
<#import '../spring.ftl' as spring>
<@spring.bind "model"/>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>События</title>
        <link rel="stylesheet" href="/css/style.css" type="text/css" />
	</head>
	<body>
		<div id="page">

            <#include '../common/header_begin.ftl'/>

			<div id="content">
                <div>
                    <h2>События</h2>
                <#if model.newEventName??> <b>Новость:<p>'${model.newEventName}'</p> добавлена.</b></#if>
                <#if model.deleteEvent??> <b>Новость:<p>'${model.deleteEvent}'</p> удалена.</b></#if>

                <#if model.user?? > <#if model.user.login == "admin">
                <h2>Новая новость:</h2>
                    <form title="New event"
                          name="eventsForm"
                          method="post"
                          action="/new_event">
                        <b>Шапка новости</b>
                        <input type="text" name="name" placeholder="Шапка новости" required size="58">
                        <br>
                        <b>Текст новости</b>
                        <br>
                        <textarea name="text" cols="60" rows="8"  title="text"></textarea>
                        <br>
                        <b>Дата добавления</b>
                        <input type="date" name="date" placeholder="Дата добавления" required>
                        <br>
                        <b><input type="submit" value="Добавить новость"></b>
                    </form>
                </#if>
                </#if>
                    <br>
                    <ul id="article">
                        <#if model.events??>
                                <#list model.events as event>

                                            <br>
                                            <span>${event.date}</span>
                                            <br>
                                            <b>${event.name}</b>
                                            <br>
                                            <p>${event.text}</p>
                                            <br>

                                            <form title="Delete"
                                                      name="eventsForm"
                                                      method="post"
                                                      action="/delete_event">
                                                    <input type="hidden" name="id" value="${event.id}">
                                    <#if model.user?? >
                                        <#if model.user.login == "admin">
                                        <b><input type="submit" value="Удалить новость"></b>
                                        </#if>
                                    </#if>
                                           </form>

                                </#list>


                            <#else >

                                <li class="first">
                                    <span>На данный момент</span>
                                    <p>Здесь  нет новостей.</p>
                                </li>
                        </#if>

                    </ul>

                </div>

            <#include '../common/header_animals.ftl'/>

			</div>

		<#include '../common/header_end.ftl'/>
		</div>
	</body>
</html>