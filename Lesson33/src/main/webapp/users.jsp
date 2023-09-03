<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
            <a class="navbar-brand" href="checkUser.jsp">Authorization</a>
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li>
                    <form method="get" action="/users">
                        <button class="nav-link active" aria-current="page" name="back">Back</button>
                    </form>
                </li>
                <li>
                    <form method="get" action="/users">
                        <button class="nav-link active" type="submit" name="users" aria-current="page">All Users
                        </button>
                    </form>
                </li>
                <li>
                    <form method="get" action="/users">
                        <button class="nav-link active" type="submit" name="tasks" aria-current="page">All Tasks
                        </button>
                    </form>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="text" placeholder="Search" name="search" aria-label="Search">
                <button class="btn btn-outline-light"  type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<br><br><br><br>
<div class="container">
    <strong><c:out value="${name}, ${typeUser}"/></strong>
<c:if test="${tasksList != null}">
    <table class="table table-hover table-secondary shadow mb-5">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Date of creation</th>
            <th scope="col">UserName</th>
            <th scope="col">Status</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <tbody>
        <c:forEach var="task" items="${tasksList}" varStatus="сounter">
        <tr class="table-secondary">
            <th scope="row">${сounter.count}</th>
            <td><c:out value="${task.title}"/></td>
            <td><c:out value="${task.description}"/></td>
            <td><c:out value="${task.date}"/></td>
            <td><c:out value="${task.userData.userName}"/></td>
            <c:if test="${task.status == 'DONE'}">
            <td class="text-success"><c:out value="${task.status}"/></td>
            </c:if>
            <c:if test="${task.status == 'IN_PROGRESS'}">
            <td class="text-info"><c:out value="${task.status}"/></td>
            </c:if>
            <c:if test="${task.status == 'NEW'}">
            <td class="text-danger"><c:out value="${task.status}"/></td>
            </c:if>
            <td>
                <div class="col-md gap-2 d-md-flex justify-content-md-end">
                    <form method="post" action="/users">
                        <input type="hidden" name="taskIdForDelete" value="${task.id}"/>
                        <input class="btn btn-outline-secondary" type="submit" value="Delete"/>
                    </form>
                </div>
            </td>
            </c:forEach>
        </tbody>
    </table>
</c:if>
<c:if test="${usersList != null}">
    <table class="table table-hover table-secondary shadow mb-5">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Type</th>
            <th scope="col">Birthday</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <tbody>
        <c:forEach var="user" items="${usersList}" varStatus="сounter">
        <tr class="table-secondary">
            <th scope="row">${сounter.count}</th>
            <td><c:out value="${user.userName}"/></td>
            <td><c:out value="${user.type}"/></td>
            <td><c:out value="${user.birthday}"/></td>
            <td>
                <div class="col-md gap-2 d-md-flex justify-content-md-end">
                    <c:if test="${typeUser == 'SUPPORT'}">
                    <form method="post" action="/users">
                        <input type="hidden" name="userIdForDelete" value="${user.id}"/>
                        <input class="btn btn-outline-secondary" type="submit" value="Delete"/>
                    </form>
                    </c:if>
                    <c:if test="${typeUser == 'ADMIN'}">
                        <input class="btn btn-secondary disabled" type="submit" aria-disabled="true" value="Delete"/>
                    </c:if>
                </div>
            </td>
            </c:forEach>
        </tbody>
    </table>
</c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>
