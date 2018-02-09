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
        <div id="tickets">
            <h1>Выберите количество взрослых и детских билетов</h1>
            <ul>
            <li class="first">

            <p>Примите к сведению, что детям</p>
            <p>до 6 лет разрешен проход без</p>
            <p>билета в присутствии взрослых</p>

            <form class="form-style-4" title="Покупка"
                  name="buyForm"
                  method="post"
                  action="/buy_tickets">
                <b>Взрослый билет - ${model.adultPrice} рублей:</b>
                <br>
                <input type="number" value="0" name="quantityAdult" required placeholder="Взрослые билеты"/>
                <br>
                <b>Детский билет - ${model.kidsPrice} рублей:</b>
                <br>
                <input type="number" value="0" name="quantityKids" required placeholder="Детские билеты"/>
                <br>
                <input type="submit" value="Подтвердить">
            </form>

                <p>После выбора количества, вам</p>
                <p>будет предложено подтвердить и</p>
                <p>оплатить выбранные билеты.</p>
                <p>Отправленный вам на почту</p>
                <p>электронный билет дейсвителен</p>
                <p>в течении 1 месяца.</p>
            </li>

            <li>
                <p>Вы выбрали:</p>
                <p>Безлимитный на весь день</p>
            <div><img src="images/ticket-lion.jpg" alt=""/></div>
                <p> Неограниченное посещение зоопарка в течении одного дня. Еда и напитки бесплатно, это же вымышленный зоопарк.</p>
                <br>
                <span>Детский билет - ${model.kidsPrice} рублей</span>
            </li>

                <li>
                    <p>Подарки:</p>
                    <p>Группам от 10 человек на входе в зоопарк будут вручены ценные подарки. По всем вопросам обращаться по телефону: 777 777</p>
                    <img src="images/penguin2.jpg" alt=""/>
                </li>
            </ul>
        </div>

    <#include 'common/header_animals.ftl'/>
    </div>

<#include 'common/header_end.ftl'/>
</div>
</body>
</html>