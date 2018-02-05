<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>События</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" />
	</head>
	<body>
		<div id="page">

            <#include 'common/header_begin.ftl'/>

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