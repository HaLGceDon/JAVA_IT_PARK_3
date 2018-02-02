<#ftl encoding='UTF-8'>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Билеты</title>
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
                    <li id="link1"><a href="/">  Home </a></li>
                    <li id="link2"><a href="/profile">Профиль</a></li>
                    <li id="link3"><a href="/registration">Регистрация</a></li>
                    <li id="link4" class="selected"><a href="/tickets"> Билеты </a></li>
                    <li id="link5"><a href="/events"> События </a></li>
                    <li id="link6""><a href="/gallery"> Галерея </a></li>
                    <li id="link7"><a href="/contact"> Контакты </a></li>
                </ul>
            </div>

			<div id="content">
				<div id="tickets">
					<h1>Билеты</h1>
						<p>Выберите билеты на интерусующие вас шоу</p>
					<ul>
						<li class="first">
							<div><a href="/buy_tickets"><img src="images/ticket-lion.jpg" alt=""/></a></div>
							<h2><a href="/buy_tickets">Безлимитный на весь день</a></h2>
							<p> Неограниченное посещение зоопарка в течении одного дня. Еда и напитки бесплатно, это же вымыщленный зоопарк.</p>
							<span>Взрослый - 600</span>
							<span>Детский - 300</span>
						</li>
						<li>
							<div><a href="/buy_tickets"><img src="images/ticket-dolphin.jpg" alt=""/></a></div>
							<h2><a href="/buy_tickets">Посещение дельфинария</a></h2>
							<p>Дельфины и другие морские животные с радостью обольют вас водой, и совсем недорого. Мороженое бесплатно.</p>
							<span>Взрослые - 800</span>
							<span>Детский - 400</span>
						</li>
						<li>
							<div><a href="/buy_tickets"><img src="images/ticket-gorilla.jpg" alt=""/></a></div>
							<h2><a href="/buy_tickets">Обучающее шоу с Гориллой</a></h2>
							<p>Оригинальное и позновательное шоу с гориллой по имени Джек для взрослых и детей. Горилла добрая, кусает только глупых, не смертельно.</p>
							<span>Взрослый - 400</span>
							<span>Детский - 200</span>
						</li>
					</ul>
				</div>
			<#include 'common/header_animals.ftl'/>
            </div>

		<#include 'common/header_end.ftl'/>
		</div>
	</body>
</html>  