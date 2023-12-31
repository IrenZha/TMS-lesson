<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заявка</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body class="bg-secondary-subtle">
<div class="container">
<form method="post" action="/">
    <div class="col-md-4">
        <label class="form-label">Имя</label>
        <input type="text" class="form-control" name="firstName" value="${firstName}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Фамилия</label>
        <input type="text" class="form-control" name="secondName" value="${secondName}">
    </div>
    <div class="col-md-4">
        <label class="form-label">Город</label>
        <input type="text" class="form-control" name="city" value="${city}">
    </div>

    <div class="col-md-4">
        <label  class="form-label">Товар</label>
        <input type="text" class="form-control"  name="product" value="${product}">
    </div>
    <div>
       <br> <button class="btn btn-secondary" type="submit">Отправить заявку</button>
    </div>
</form>
</div>
</body>
</html>
