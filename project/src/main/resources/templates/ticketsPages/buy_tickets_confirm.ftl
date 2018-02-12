<#ftl encoding='UTF-8'>
<#import '../spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Zoo</title>
    <link rel="stylesheet" href="/css/style.css" type="text/css" />
</head>
<body>
<div id="page">
<#include '../common/header_begin_clear.ftl'/>
    <div id="content">
        <div class="section2">
            <#if model.quantityAdult != 0> <p>Количество выбранных взрослых билетов: ${model.quantityAdult} -</p> <p> - ${model.adultBuySum} рублей. </p> </#if>
            <#if model.quantityKids != 0>  <p>Количество выбранных  детских билетов: ${model.quantityKids}  -</p> <p> - ${model.kidsBuySum} рублей. </p> </#if>
                <#if model.buySum !=0 ><p>Итого: ${model.buySum} рублей.</p></#if>

            <#if model.quantity == 0> <h1>Вы не выбрали билеты. <a href="/tickets"> Вернуться назад</a> </h1>
            <#else > <ul>

                      <p> <a href="/buy_tickets_pay"> * Подтвердить и перейти к оплате</a></p>
                      <p> <a href="/tickets"> <- Вернуться назад</a></p>

                    </ul>
            </#if>

        </div>
    <#include '../common/header_animals.ftl'/>
    </div>

<#include '../common/header_end.ftl'/>
</div>
</body>
</html>