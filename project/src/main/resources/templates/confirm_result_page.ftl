
<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
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