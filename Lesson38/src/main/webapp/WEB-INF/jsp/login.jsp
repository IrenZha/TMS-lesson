<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title><spring:message code="label.titleLogin"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body class="bg-secondary-subtle">
<div class="container-fluid">
    <br>
    <div class="text-end px-5">
    <a class="btn-outline-secondary" href="login?lang=en">EN</a>
    <a class="btn-outline-secondary" href="login?lang=ru">RU</a>
    </div>
    <h2><spring:message code="label.titleLogin"/></h2>
    <form class="col-3 md-6 p-3 px-5" action="/login" method="post">
        <input class="form-control" type="text" name="login" placeholder="<spring:message code="label.login"/>"><br>
        <input class="form-control" type="password" name="password" placeholder="<spring:message code="label.password"/>"><br>
        <button class="btn btn-outline-secondary" type="submit"><spring:message code="label.titleLogin"/></button>
    </form>
</div>
</body>
</html>
