<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Билеты</title>
        <link rel="stylesheet" href="/css/style.css" type="text/css" />
	</head>
	<body>
		<div id="page">
        <#include 'common/header_begin.ftl'/>

			<div id="content">
				<div id="tickets">
					<h1>Билеты</h1>
						<p>Выберите билеты на интерусующие вас шоу</p>
					<ul>
						<li class="first">
                            <h2><a href="/buy_tickets">Безлимитный на весь день</a></h2>
                            <a href="/buy_tickets"><span>Взрослый билет - ${model.adultPrice} рублей</span></a>
							<br>
                                <a href="/buy_tickets"><span>Детский билет - ${model.kidsPrice} рублей</span></a>
							<div><a href="/buy_tickets"><img src="images/ticket-lion.jpg" alt=""/></a></div>
							<p> Неограниченное посещение зоопарка в течении одного дня. Еда и напитки бесплатно, это же вымыщленный зоопарк.</p>
						</li>
						<li>
                            <h2><a href="/buy_tickets">Посещение дельфинария</a></h2>
                            <span>Взрослыq билет - продажи закрыты.</span>
                            <br>
                            <span>Детский билет - продажи закрыты.</span>
							<div><a href="/buy_tickets"><img src="images/ticket-dolphin.jpg" alt=""/></a></div>
							<p>Дельфины и другие морские животные с радостью обольют вас водой, и совсем недорого. Мороженое бесплатно.</p>
						</li>
						<li>
                            <h2><a href="/buy_tickets">Обучающее шоу с Гориллой</a></h2>
                            <span>Взрослый билет - продажи закрыты.</span>
                            <br>
                            <span>Детский билет - продажи закрыты.</span>
							<div><a href="/buy_tickets"><img src="images/ticket-gorilla.jpg" alt=""/></a></div>
							<p>Оригинальное и позновательное шоу с гориллой по имени Джек для взрослых и детей. Горилла добрая, кусает только глупых, не смертельно.</p>
						</li>
					</ul>
				</div>
			<#include 'common/header_animals.ftl'/>
            </div>

		<#include 'common/header_end.ftl'/>
		</div>
	</body>
</html>  