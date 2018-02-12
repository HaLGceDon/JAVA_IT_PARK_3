<#ftl encoding='UTF-8'>
<#import '../spring.ftl' as spring>
<@spring.bind "model"/>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Zoo</title>
        <link rel="stylesheet" href="/css/style.css" type="text/css" />
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" src="/js/fileLoad.js"></script>
	</head>
	<body>
		<div id="page">
		<#include '../common/header_begin.ftl'/>

			<div id="content">
				<div id="gallery">
                    <#if model.user?? > <#if model.user.login == "admin">
                    <h2>Выберите изображение для загрузки в галерею.</h2>
                        <input id="fileInput" type="file" placeholder="Выбрать файл">
                        <button name="uploadButton"
                               onclick="uploadFile(document.getElementById('fileInput')['files'][0])">Загрузить</button>
                        </form>
                    <#else >
					</#if>
					</#if>
						<h1>Познакомтесь с нашими животными</h1>
					<ul>
						<#if model.images??>
						<#list model.images as image>

                            <li>
                                <div> <img src="/files/${image.storageName}" alt="image"/> </div>
                                <#if image.viewName??><b> ${image.viewName}</b></#if>
                            <#if model.user?? > <#if model.user.login == "admin">
                                <form name="galleryForm" method="post" action="/delete_image">
                                    <input type="hidden" name="storageName" value="${image.storageName}">
                                    <input type="submit" value="Delete">
                                </form>
                                <form name="galleryForm" method="post" action="/add_view_name">
                                    <input type="text" name="viewName" required placeholder="Имя"><input type="hidden" name="storageName" value="${image.storageName}">
                                    <input type="submit" value="Save">
                                </form>
                            </#if></#if>
                            </li>
						</#list>
							</#if>

					</ul>
				</div>
			</div>

		<#include '../common/header_end.ftl'/>
		</div>
	</body>
</html>  