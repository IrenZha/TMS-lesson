<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body class="bg-secondary-subtle">
<div class="container-fluid">
<form class="col-3 md-6 p-3 px-5" action="/login" method="post">
    <input class="form-control" type="text" name="login" placeholder="Login"><br>
    <input class="form-control" type="password" name="password" placeholder="Password"><br>
    <button class="btn btn-outline-secondary" type="submit">Login</button>
</form>
</div>
</body>
</html>
