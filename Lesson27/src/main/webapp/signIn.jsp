<%@ page import="service.UserData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body class="bg-secondary-subtle">
<div class="container">
    <h2>Sign in</h2>
    <form method="post" action="/signIn">
        <div class="col-md-4">
            <label class="form-label">Login</label>
            <input type="text" class="form-control" name="login" required>
        </div>
        <div class="col-md-4">
            <label class="form-label">Password</label>
            <input type="password" class="form-control" name="password" required>
        </div>
        <div class="col-12">
           <br> <button class="btn btn-secondary" type="submit">Sign in</button>
        </div>
    </form>
     <a class="btn btn-secondary" href="registration.jsp" type="submit">Registration</a>
</div>
</body>
</html>

