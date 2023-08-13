<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2>Registration</h2>
    <form method="post" action="/registration">
        <div class="col-md-4">
            <label class="form-label">First name</label>
            <input type="text" class="form-control" name="firstName" required>
        </div>
        <div class="col-md-4">
            <label class="form-label">Last name</label>
            <input type="text" class="form-control" name="lastName" required>
        </div>
        <div class="col-md-4">
            <label class="form-label">Login</label>
            <input type="text" class="form-control" name="login" value="${login}" required>
            <div class="text-danger">
            <c:out value="${massage}"/>
            </div>
        </div>
        <div class="col-md-4">
            <label class="form-label">Password</label>
            <input type="password" class="form-control" name="password" required>
        </div>

        <div class="col-12">
           <br> <button class="btn btn-secondary" type="submit">Save</button>
        </div>
    </form>

</div>
</body>
</html>
