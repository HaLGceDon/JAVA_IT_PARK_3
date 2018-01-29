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
        <div class="tickets">

    <h2>Поздравляем, письмо для подтверждения регистрации отправлено на
        - ${model.email}</h2>

    </div>
    </div>

    <#include 'common/header_animals.ftl'/>
    <#include 'common/header_end.ftl'/>
    </div>
</body>
</html>