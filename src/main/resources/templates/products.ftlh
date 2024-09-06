<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Products</title>
</head>
<body>
<h1>STEPPIN | <a href="/login">Выйти</a></h1>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Выйти"/>
</form>
<form action="/products" method="get">
    Поиск по названию модели: <input type="text" name="title"><br>
    <input type="submit" value="поиск">
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб | <a href="/product/${product.id}">Подробнее...</a> |
        <form action="/addToCart" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="hidden" name="id" value="${product.id}">
            <input type="submit" value="Добавить в корзину">
        </form>
    </div>

    <div>
        <form action="user_cart.ftlh" method="get"></form>
    </div>
<#else>
    <h3>Товаров нет</h3>
</#list>
</body>
</html>
