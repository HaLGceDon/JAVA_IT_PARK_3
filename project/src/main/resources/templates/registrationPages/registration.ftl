<#ftl encoding='UTF-8'>
<#import '../spring.ftl' as spring>
<@spring.bind "model"/>
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Регистрация</title>
        <link rel="stylesheet" href="/css/style.css" type="text/css" />
        <title>Регистрация</title>
        <link rel="stylesheet" href="css/styleRegError.css"/>
        <script type="text/javascript" src="/js/registrationValidate.js"></script>
	</head>
	<body>
		<div id="page">

        <#include '../common/header_begin.ftl'/>

			<div id="content">
                <div>
                    <h2>Регистрация нового пользователя:</h2>


                <#if model.errorLogin == true> <h2>Данный логин занят! выберите другой:</h2> </#if>
                <#if model.errorEmail == true> <h2> Данный e-mail занят! выберите другой:</h2> </#if>

                    <br>
                    <b>Все поля обязательны для заполнения.</b>
                    <form title="Регистрация"
                          name="registrationForm"
                          method="post"
                          action="/registration">

                    <table>
                            <tr>
                                <td>  Логин для входа на сайт:</td>
                                <td>
                                    <input type="text" name="login" placeholder="Логин"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Ваш пароль:</td>
                                <td>
                                    <input type="password" name="password" placeholder="Пароль"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Повторите пароль:</td>
                                <td>
                                    <input name="password2" type="password" placeholder="Пароль">
                                </td>
                            </tr>
                            <tr>
                                <td>Email, для подтверждения:</td>
                                <td>
                                    <input type="email" name="email" placeholder="Почта"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Имя:</td>
                                <td>
                                    <input type="text" name="name" placeholder="Имя"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Фамилия:</td>
                                <td>
                                    <input type="text" name="surname" placeholder="Фамилия"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Возраст:</td>
                                <td>
                                    <input type="number" name="age" placeholder="Возраст"/>
                                </td>
                            </tr>
                        </table>

                        <input type="button" onclick="validate(this.form)" value="Зарегестрироваться"/>
                    </form>

                </div>
            <#include '../common/header_animals.ftl'/>
			</div>


			<#include '../common/header_end.ftl'/>
		</div>
	</body>
</html>  