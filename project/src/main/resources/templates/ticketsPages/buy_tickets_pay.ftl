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
            <#if model.error == true ><h2>При оплате произошла ошибка,<br> попробуйте еще раз!</h2></#if>
            <h2>Оплатить ${model.price} рублей</h2>
            <form title="Оплата"
                  name="payForm"
                  method="post"
                  action="/buy_tickets_pay">
                <br>
                <p>
                    <b>Номер карты</b><input type="text"  name="cardNumber" value="0000000000000000" required maxlength="19" />
                <br>
                    <b>Месяц</b><input type="text"  name="cardMonth" required value="00" size="10" maxlength="2" />

                    <b>Год</b><input type="text"  name="cardYear" required value="00" size="9" maxlength="2" />
                <br>
                    <b>CVC код </b><input type="text"  name="cardCvc" required  value="000" size="8" maxlength="3" />
                <br>
                    <b>Имя Фамилия</b><input type="text"  name="cardHolder" value="null" required size="19" />
                <br>
                    <br>
                <input type="submit" value="* Оплатить">
                </p>
            </form>
            <p> <a href="/tickets"> Назад </a> </p>

        </div>

    <#include '../common/header_animals.ftl'/>
    </div>

<#include '../common/header_end.ftl'/>
</div>
</body>
</html>