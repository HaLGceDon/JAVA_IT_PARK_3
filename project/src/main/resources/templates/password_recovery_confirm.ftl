<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
<#if model.result == true> <meta http-equiv="refresh" content="0;URL=http://localhost/password_change" />     </#if>

</head>

<div>



            <h2>Ссылка не верна</h2>
            <a href="/login"><p>Назад</p></a>



</div>
</body>
</html>