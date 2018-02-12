
<#ftl encoding='UTF-8'>
<#import '../spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
<#if model.result == true> <meta http-equiv="refresh" content="0;URL=http://localhost/confirm_result_page_successfully" />     </#if>
</head>
<body>

<h1></h1>



        <#if model.result == true>
            <h2>Вы успешно подтвердили почту</h2>
        <a href="/login"><p>Назад</p></a>
        <#else>
            <h2>Ссылка не верна</h2>
        <a href="/registration"><p>Назад</p></a>
        </#if>


</body>
</html>