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
<#include 'common/header_begin.ftl'/>
    <div id="content">

        <div class="section2">
            <h2>Оплатить ${model.price} рублей</h2>
            <form class="form-style-4" title="Оплата"
                  name="payForm"
                  method="post"
                  action="/buy_tickets_pay">
                <input type="hidden" value="${model.price}" name="price"/>
                <p>
                    <b>Номер карты</b><input type="text"  name="cardNumber" maxlength="20"/>
                <br>
                    <b>Месяц</b><input type="text"  name="cardMonth" size="10" maxlength="2"/>

                    <b>Год</b><input type="text"  name="cardYear" size="9" maxlength="2"/>
                <br>
                    <b>Имя Фамилия</b><input type="text"  name="cardHolder" size="19"/>
                <br>
                    <p>CVC код<input type="text"  name="cardCvc" size="8" maxlength="3"/>
                </p>
                <br>
                <input type="submit" value="* Оплатить">
            </form>
            <a href="/buy_tickets"> Назад </a>

        </div>

    <#include 'common/header_animals.ftl'/>
    </div>

<#include 'common/header_end.ftl'/>
</div>
</body>
</html>