
    <div id="header">
        <a href="index.html" id="logo"><img src="images/logo-page.jpg" alt=""/></a>
        <ul id="links">
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

        <#if model.user?? > <a href="/logout" id="button">Выйти из профиля</a>
        <#else > <a href="/tickets" id="button">Купить билеты / Войти</a>
        </#if>

        <ul id="navigation">
            <li id="link1"><a href="/">  Home  </a></li>

        <#if model.user?? >  <li id="link2" <#if model.select == "profile"> class="selected" </#if>><a href="/profile">Профиль</a></li></a>
        <#else > <li id="link2" <#if model.select == "login"> class="selected" </#if>><a href="/login">Вход</a></li></a>
        </#if>

            <li id="link3" <#if model.select == "registration"> class="selected" </#if>><a href="/registration">Регистрация</a></li>
            <li id="link4"<#if model.select == "tickets"> class="selected" </#if>><a href="/tickets">Билеты</a></li>
            <li id="link5"<#if model.select == "events"> class="selected" </#if>><a href="/events">События</a></li>
            <li id="link6"<#if model.select == "gallery"> class="selected" </#if>><a href="/gallery">Галерея</a></li>
            <li id="link7"><a href="/contact">Контакты</a></li>
        </ul>
    </div>

