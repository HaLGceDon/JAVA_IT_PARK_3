
<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<body>

<h1></h1>



        <#if model.result == true>
            <h2>Вы успешно подтвердили почту</h2>
        <#else>
            <h2>Ссылка не верна</h2>
        </#if>


</body>
</html>