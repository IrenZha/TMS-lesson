<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body class="bg-secondary-subtle">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6 p-3 px-5">
            <form class="row" action="/book" method="post">
                <div class="col">
                    <input class="form-control" type="text" name="title" placeholder="Title" required><br>
                    <input class="form-control" type="number" name="page" placeholder="Page"><br>
                    <input class="form-control" name="author" placeholder="Author" required><br>
                </div>
                <div class="col">
                    <button class="btn btn-outline-secondary" type="submit">Add</button>
                </div>
            </form>
        </div>
        <div class="col-md-6 p-3 px-5">
            <form class="row" action="/book" method="get">
                <div class="col"><input class="form-control" type="text" name="search" placeholder="Search"></div>
                <div class="col">
                    <button class="btn btn-outline-secondary" type="submit">Search</button>
                </div>
            </form>
        </div>
    </div>
    <div class="col p-3 px-5">
    <table class="table table-hover table-secondary">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Title</th>
            <th scope="col">Page</th>
            <th scope="col">Author</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${books}" varStatus="сounter">
        <tr>
            <th scope="row">${сounter.count}</th>
            <td><c:out value="${list.title}"/></td>
            <td><c:out value="${list.page}"/></td>
            <td><c:out value="${list.author}"/></td>
            </c:forEach>
        </tbody>
    </table>
    </div>
</div>
</body>
</html>
