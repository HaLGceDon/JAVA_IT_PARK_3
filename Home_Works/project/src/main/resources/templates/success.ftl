<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>News- Регистрация</title>
    <link href="../css/styles.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>

<div id="logo"><h1><a href="#">ftdMoonLight</a></h1></div>
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


                    <h1>Поздравляем, ваш Id - ${model.id}</h1>
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
        <li class="first"><a href="/"  title="">Home</a></li>
    </ul>
</div>
</body>
</html>