<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Zoo</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" />
</head>
<body>
<div id="page">
    <div id="header">
        <a href="/" id="logo"><img src="images/logo.jpg" alt=""/></a>
        <ul>
            <li class="first">
                <h2><a href="/zoo">Live</a></h2>
                <span>Получайте радость от визита</span>
            </li>
            <li>
                <h2><a href="/zoo">Love</a></h2>
                <span>Жертвуйте на помощь животным</span>
            </li>
            <li>
                <h2><a href="/zoo">Learn</a></h2>
                <span>Узнавайте новое о животных</span>
            </li>
        </ul>

        <#if model.user?? >  <a href="/logout">Выйти из профиля</a>
        <#else > <a href="/tickets">Купить билеты / Войти</a>
        </#if>

        <ul id="navigation">
            <li id="link1" class="selected"><a href="/">  Home  </a></li>
              <#if model.user?? >  <li id="link2"><a href="/profile">Профиль</a></li></a>
              <#else > <li id="link2"> <a href="/login">Вход</a></li></a>
             </#if>
            <li id="link3"><a href="/registration">Регистрация</a></li>
            <li id="link4"><a href="/tickets"> Билеты </a></li>
            <li id="link5"><a href="/events"> События </a></li>
            <li id="link6"><a href="/gallery"> Галерея </a></li>
            <li id="link7"><a href="/contact"> Контакты </a></li>
        </ul>
        <img src="images/lion-family.jpg" alt="figure"/>
        <div>
            <h1>Для родителей:</h1>
            <p>Вход детям до 6 лет - абсолютно бесплатно! Подросткам - скидки.</a></p>
        </div>
    </div>

    <div id="content">
    <#include 'common/header_animals.ftl'/>
        <div class="section1">
            <h2>События</h2>
            <ul id="article">
                <li class="first">
                    <a href="/events"><span>Янв 17</span></a>
                    <p>Пока нет событий, достойных внимания.</p>
                </li>
                <li>
                    <a href="/zoo"><span>Янв 13</span></a>
                    <p>Работал над этим проектом Григорьев Василий.</p>
                </li>
                <li>
                    <a href="/zoo"><span>Янв 01</span></a>
                    <p>С новым годом!</a>.</p>
                </li>
            </ul>
        </div>
        <div class="section2">
            <h2>Наш блог</h2>
            <p> В нашем зоопарке большое разнообразие животных.</p>
            <a href="/tickets"><img src="images/dolphins.jpg" alt=""/></a>
            <ul>
                <li>
                    <p>У нас есть дельфины,</p>
                </li>
                <li>
                    <p>все любят дельфинов.</p>
                </li>
                <li>
                    <p>Открыты 3 вольера с хищниками,</p>
                </li>
                <li>
                    <p>а так же большое количество разнообразных травоядных.</p>
                </li>
                <li>
                    <p>И не забудте посетить наш террариум с членистоногими.</p>
                </li>
            </ul>
            <div id="section1">
                <ul>
                    <li>
                        <a href="/tickets"><img src="images/gorilla-2.jpg" alt=""/></a>
                        <h4><a href="/tickets">Горилла Джек</a></h4>
                        <p>Любимец публики Джек.</p>
                    </li>
                    <li>
                        <a href="/tickets"><img src="images/snake-2.jpg" alt=""/></a>
                        <h4><a href="/tickets">Хладнокровные змеи</a></h4>
                        <p>Нет, это не твоя бывшая, это обитатели нашего террариума.</p>
                    </li>
                </ul>
            </div>
            <div id="section2">
                <ul>
                    <li>
                        <a href="/tickets"><img src="images/butterfly-2.jpg" alt=""/></a>
                        <h4><a href="/tickets">Прекрасные бабочки</a></h4>
                        <p>Редкие, красивые бабочки - недолгие гости нашего зоопарка.</p>
                    </li>
                </ul>
            </div>
        </div>
        <div class="section3">
            <h2>Connect</h2>
            <a href="#" id="email">Email Us</a>
            <a href="http://facebook.com/" id="facebook">Facebook</a>
            <a href="http://twitter.com/" id="twitter">Twitter</a>
            <form action="">
                <h3>Подпишитесь на наши</h3>
                <h2>новости</h2>
                <input type="text" value="ваша почта..." onblur="this.value=!this.value?'your email here...':this.value;" onfocus="this.select()" onclick="this.value='';" />
            </form>
            <img src="images/penguin2.jpg" alt=""/>
        </div>
    </div>
<#include 'common/header_end.ftl'/>
</div>
</body>
</html>