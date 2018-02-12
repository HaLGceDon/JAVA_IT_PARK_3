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

        <div id="section2">
            <p>Вы совершили покупку, информация о покупке направлена вам на почту: ${model.email} </p>
            <p>Вы так же можете посмотреть подробности в личном кабинете</p><a href="/profile"><b> Профиль </b></a></h2>
        </div>

    <#include '../common/header_animals.ftl'/>
    </div>

<#include '../common/header_end.ftl'/>
</div>
</body>
</html>