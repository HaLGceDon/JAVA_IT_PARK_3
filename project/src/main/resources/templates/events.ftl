<#ftl encoding='UTF-8'>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>События</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" />
	</head>
	<body>
		<div id="page">
            <div id="header">
                <a href="/" id="logo"><img src="images/logo-page.jpg" alt=""/></a>
                <ul id="links">
                    <li class="first">
                        <h2><a href="/zoo">Live</a></h2>
                        <span>Получайте радость от визита</span>
                    </li>
                    <li>
                        <h2><a href="/zoo">Love</a></h2>
                        <span>Жертвуйте на помощь животным</span>
                    </li>
                    <li>
                        <h2><a href="/zoo">Learn</a></h2>
                        <span>Узнавайте новое о животных</span>
                    </li>
                </ul>
                <a href="/tickets" id="button">Купить билеты / Войти</a>
                <ul id="navigation">
                    <li id="link1"><a href="/">Home</a></li>
                    <li id="link2"><a href="/profile">Профиль</a></li>
                    <li id="link3"><a href="/registration">Регистрация</a></li>
                    <li id="link4"><a href="/tickets">Билеты</a></li>
                    <li id="link5" class="selected"><a href="/events">События</a></li>
                    <li id="link6"><a href="/gallery">Галерея</a></li>
                    <li id="link7"><a href="/contact">Контакты</a></li>
                </ul>
            </div>
			<div id="content">
                <div class="section1">
                    <h2>События</h2>
                    <ul id="article">
                        <li class="first">
                            <a href="#"><span>29 янв</span></a>
                            <p>Здесь пока нет событий.</p>
                        </li>
                    </ul>
                </div>
            <#include 'common/header_animals.ftl'/>
			</div>

		<#include 'common/header_end.ftl'/>
		</div>
	</body>
</html>  