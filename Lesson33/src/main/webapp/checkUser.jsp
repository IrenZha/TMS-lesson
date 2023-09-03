<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authorization</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body class="bg-secondary-subtle">
<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-secondary  text-body-white">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href=""><h3>Authorization</h3></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<br><br>
<div class="container">
    <br><br>
    <div class="row">
        <div class="col-md-6 p-3 px-5 shadow rounded">
            <form method="get" action="/checkUser">
                <h3>Log in</h3>
                <p class="text-end px-5">Show Tasks</p>
                <div class="row">
                    <div class="col-md-8"><input type="text" class="form-control" placeholder="Name" name="name"
                                                 value="${name}" required></div>
                    <br>
                    <div class="col-md-4 gap-2 d-md-flex justify-content-md-center">
                        <button type="submit" class="btn btn-outline-secondary shadow mb-5" name="allTasks">All
                        </button>
                        <button type="submit" class="btn btn-outline-secondary shadow mb-5" name="unfinishedTasks">
                            Unfinished
                        </button>
                    </div>
                </div>
            <div class="text-danger text-uppercase">
                <c:out value="${massage1}"/>
            </div>
<c:if test="${isVisible == true}">
            <table class="table table-hover">
    <thead>
    <tr>
    <th scope="col">#</th>
    <th scope="col">Title</th>
    <th scope="col">Status</th>
    <th scope="col">Date of creation</th>
    </tr>
    </thead>
                <tbody>
                <c:forEach var="list" items="${userTodoList}" varStatus="сounter">
                <tr class="table-secondary">
                    <th scope="row">${сounter.count}</th>
                    <td class="col-2"><c:out value="${list.title}"/></td>
                    <td><c:out value="${list.status}"/></td>
                    <td class="col"><c:out value="${list.date}"/></td>
                    </c:forEach>
                </tbody>
            </table>
    <div class="col-md gap-2 d-md-flex justify-content-md-end">
        <button type="submit" name="edit" class="btn btn-outline-secondary shadow mb-5">Edit</button>
    </div>
</c:if>
            </form>
        </div>

        <div class="col-md-6 p-3 px-5 shadow rounded">
            <form method="post" action="/newUser">
                <div class="row">
                    <h3>New User</h3>
                    <div class="col-md-8">
                        <input type="text" class="form-control" placeholder="Name" name="name" value="${name}" required>
                        <br>
                        <div>
                            <select class="form-select" aria-label="TypeUser" name="typeUser" required>
                                <option  selected value="USER">User</option>
                                <option value="ADMIN">Admin</option>
                                <option value="SUPPORT">Support</option>
                            </select>
                        </div>
                        <br>
                        <div class="shadow p-3 mb-5 rounded bg-white">
                            <h6>Gender</h6>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="gender" value="true" checked>
                                Male
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="gender" value="false">
                                Female
                            </div>
                        </div>
                        <label class="form-label">Birthday</label>
                        <input type="date" class="form-control" name="birthday" required>
                        <div class="text-danger  text-uppercase">
                            <c:out value="${massage}"/>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-secondary shadow mb-5" name="save" type="submit">Save</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>

