<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1>
<hr>
<h4>Панель администратора</h4>
<table border="1">
    <tr>
        <th>Email</th>
        <th>Номер телефона</th>
        <th>Активность</th>
        <th>Роли</th>
        <th>Бан</th>
        <th>Редактирование</th>
        <th>Подробная информация</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th><#if user.phoneNumber??>${user.phoneNumber}<#else>-</#if></th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><#list user.roles as role>${role}</#list></th>
            <th>
                <form action="/admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Бан">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id}">Редактировние</a></th>
            <th><a href="/user/${user.id}">Подробная информация</a></th>
        </tr>
    <#else>
        <h3>Пользователей нет</h3>
    </#list>
</table>

<h3>Создать новый товар</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Название модели :  <input type="text" name="title"/><br><br>
    Описание : <input type="text" name="description"/><br><br>
    Бренд : <input type="text" name="brand"/><br><br>
    Цена : <input type="number" name="price"/><br><br>
    Размер : <input type="number" name="size"/><br><br>
    Первая фотография : <input type="file" name="file1"/><br><br>
    2 фотография : <input type="file" name="file3"/><br><br>
    3 фотография : <input type="file"  name="file2"/><br><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Добавить товар"/>
</form>

<h3>Список товаров</h3>
<table border="1">
    <tr>
        <th>Название модели</th>
        <th>Описание</th>
        <th>Бренд</th>
        <th>Цена</th>
        <th>Размер</th>
        <th>Удалить</th>
    </tr>
    <#list products as product>
        <tr>
            <td>${product.title}</td>
            <td>${product.description}</td>
            <td>${product.brand}</td>
            <td>${product.price}</td>
            <td>${product.size}</td>
            <td>
                <form action="/product/delete/${product.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>
