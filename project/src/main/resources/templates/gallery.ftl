<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Zoo</title>
        <link rel="stylesheet" href="/css/style.css" type="text/css" />
	</head>
	<body>
		<div id="page">
		<#include 'common/header_begin.ftl'/>

			<div id="content">
				<div id="gallery">
					<h1>Познакомтесь с нашими животными</h1>
					<ul>
						<li>
							<div><a href="#"><img src="images/gallery-lion.jpg" alt=""/></a></div>
							<a href="#">Лев</a>
						</li>
						<li>
							<div><a href="#"><img src="images/gallery-turtle.jpg" alt=""/></a></div>
							<a href="#">Черепаха</a>
						</li>
						<li>
							<div><a href="#"><img src="images/gallery-elephant.jpg" alt=""/></a></div>
							<a href="#">Слон</a>
						</li>
						<li>
							<div><a href="#"><img src="images/gallery-penguin.jpg" alt=""/></a></div>
							<a href="#">Пингвин</a>
						</li>
						<li>
							<div><a href="#"><img src="images/gallery-dolphin.jpg" alt=""/></a></div>
							<a href="#">Дельфин</a>
						</li>
						<li>
							<div><a href="#"><img src="images/gallery-buterfly.jpg" alt=""/></a></div>
							<a href="#">Бабочка</a>
						</li>
						<li>
							<div><a href="#"><img src="images/gallery-gorilla.jpg" alt=""/></a></div>
							<a href="#">Горилла</a>
						</li>
						<li>
							<div><a href="#"><img src="images/gallery-owl.jpg" alt=""/></a></div>
							<a href="#">Сова</a>
						</li>
						<li>
							<div><a href="#"><img src="images/gallery-blue-butterfly.jpg" alt=""/></a></div>
							<a href="#">Бабочка</a>
						</li>
					</ul>
				</div>
			</div>

		<#include 'common/header_end.ftl'/>
		</div>
	</body>
</html>  