<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Zoo</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
<div id="page">
<#include 'common/header_begin_clear.ftl'/>
    <div id="content">
        <div class="section2">
            <#if model.quantityAdult != 0> <p>Количество выбранных взрослых билетов: ${model.quantityAdult} -</p> <p> - ${model.adultBuySum} рублей. </p> </#if>
            <#if model.quantityKids != 0>  <p>Количество выбранных  детских билетов: ${model.quantityKids}  -</p> <p> - ${model.kidsBuySum} рублей.. </p> </#if>
                <#if model.buySum !=0 ><p>Итого: ${model.buySum} рублей.</p></#if>

            <#if model.quantity == 0> <h1>Вы не выбрали билеты. <a href="/buy_tickets"> Вернуться назад</a> </h1>
            <#else > <ul>
                <form class="form-style-4" title="Покупка"
                      name="buyForm"
                      method="post"
                      action="/buy_tickets_confirm">
                    <input type="hidden" value="${model.quantityAdult}" name="quantityAdult"/>
                    <input type="hidden" value="${model.quantityKids}" name="quantityKids"/>
                    <input type="submit" value="* Подтвердить и оплатить">
                </form>


                      <p> <a href="/buy_tickets"> <- Вернуться назад</a></p>

                    </ul>
            </#if>

        </div>
    <#include 'common/header_animals.ftl'/>
    </div>

<#include 'common/header_end.ftl'/>
</div>
</body>
</html>