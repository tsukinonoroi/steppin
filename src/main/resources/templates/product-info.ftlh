<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product</title>
</head>
<body>
HELLO, STEPPIN!
<h4>Подробная информация о товаре</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60" width="160"> <br><br>
</#list>

<b>Название товара: </b> ${product.title}<br>
<b>Описание: </b> ${product.description}<br>
<b>Бренд: </b> ${product.brand}<br>
<b>Цена товара: </b> ${product.price}<br>
<b>Размер товара: </b> ${product.size}<br>
<hr>
</body>
</html>