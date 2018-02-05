<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Регистрация</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" />
	</head>
	<body>
		<div id="page">

        <#include 'common/header_begin.ftl'/>

			<div id="content">
                <div class="section2">

                    <form class="form-style-4" title="Регистрация"
                          name="registrationForm"
                          method="post"
                          action="/registration">
                        <input type="text" name="name" placeholder="Имя"/>
                        <br>
                        <input type="text" name="surname" placeholder="Фамилия"/>
                        <br>
                        <input type="text" name="login" placeholder="Логин"/>
                        <br>
                        <input type="password" name="password" placeholder="Пароль"/>
                        <br>
                        <input type="email" name="email" placeholder="Почта"/>
                        <br>
                        <input type="number" name="age" placeholder="Возраст"/>
                        <br>
                        <input type="submit" value="Зарегестрироваться"/>
                    </form>
                </div>
            <#include 'common/header_animals.ftl'/>
			</div>


			<#include 'common/header_end.ftl'/>
		</div>
	</body>
</html>  