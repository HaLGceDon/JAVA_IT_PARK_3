<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Dogs</title>
    <link href="/css/table.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1></h1>

<div id="bg">

    <div id="main">
        <!-- header ends -->
        <!-- content begins -->
        <div id="content">
            <div id="content_top">
                <div id="content_bot">

                    <div id="left">
                        <div id="buttons">
                            <ul>
                                <li class="first"><a href="/" title="">Home</a></li>
                                <li><a href="/cats" title="">Кошки</a></li>
                                <li><a href="/dogs" title="">Собаки</a></li>
                                <li><a href="/users" title="">Члены нашего клуба</a></li>
                                <li><a href="/about" title="">О нас</a></li>
                            </ul>
                        </div>
                        <div class="text">
                            <h1>Список собак</h1>
                        </div>

                        <table>
                            <tr>
                                <th>Id</th>
                                <th>Имя</th>
                                <th>Возраст</th>
                                <th>Порода</th>
                                <th>Цвет</th>
                                <th>Вес</th>
                                <th>Состояние здоровья</th>
                                <th><h2>Забрать собаку</h2></th>
                            </tr>
                        <#list model.dogs as dog>
                            <tr>
                                <td>${dog.id}</td>
                                <td>${dog.name}</td>
                                <td>${dog.age}</td>
                                <td>${dog.breed}</td>
                                <td>${dog.color}</td>
                                <td>${dog.weight}</td>
                                <td>${dog.health}</td>
                                <td><form method="POST" action="/dogsDelete">
                                    <input type="hidden" name="id" value="${dog.id}"/>
                                    <input type="submit" value="Забрать собаку"/></form></td>
                            </tr>
                        </#list>
                        </table>

                        <div id="buttons">
                            <ul>
                                <li><a href="/dogsRegistration" title="">Зарегестрировать нового пса</a></li>
                            </ul>
                        </div>

                        <div style="clear: both"></div>

                    </div>

                    <!-- content ends -->
                </div>
            </div>
        </div>


    </div>
</div>

<div id="buttons">
    <ul>
        <li class="first"><a href="/" title="">Назад</a></li>
</div>
</body>
</html>