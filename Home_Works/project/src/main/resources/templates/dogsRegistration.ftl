<#ftl encoding='UTF-8'>

<html>
<head>
    <title>DogsRegistration</title>
    <link href="/css/table.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1></h1>

<div id="buttons">
    <ul>
        <li class="first"><a href="/" title="">Home</a></li>
        <li><a href="/cats" title="">Кошки</a></li>
        <li><a href="/dogs" title="">Собаки</a></li>
        <li><a href="/users" title="">Члены нашего клуба</a></li>
        <li><a href="/about" title="">О нас</a></li>
    </ul>
</div>
<div id="bg">

    <div id="main">
        <!-- header ends -->
        <!-- content begins -->
        <div id="content">
            <div id="content_top">
                <div id="content_bot">

                    <div id="left">


                    <h1>Зарегестрировать нового пса</h1>
<form class="form-style-4" action="/dogsRegistration" method="post"  name="dogsForm">
    <input type="text" name="name" placeholder="Кличка" required>
    <input type="text" name="age" placeholder="Возраст">
    <input type="text" name="breed" placeholder="Порода">
    <input type="text" name="color" placeholder="Цвет" required>
    <input type="text" name="weight" placeholder="Вес">
    <input type="text" name="health" placeholder="Состояние здоровья">

    <input type="submit">
</form>


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
        <li class="first"><a href="/dogs" title="">Назад</a></li>
</div>


</body>
</html>