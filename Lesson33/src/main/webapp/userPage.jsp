<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tasks</title>
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

            <c:if test="${typeUser != 'USER'}">
                <form method="get" action="/users">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li>
                            <button class="nav-link active" type="submit" name="users" aria-current="page">All Users
                            </button>
                        </li>
                        <li>
                            <button class="nav-link active" type="submit" name="tasks" aria-current="page">All Tasks
                            </button>
                        </li>
                    </ul>
                </form>
            </c:if>

        </div>
    </div>
</nav>
<br><br><br><br>
<div class="container">
    <strong><c:out value="${name}, ${typeUser}"/></strong>
    <br>
    <form class="row" method="post" action="/todoList">
        <div class="col-md-2">
            <input type="text" class="form-control" placeholder="title" name="title" value="${title}" required>
        </div>
        <div class="col-md-4">
            <input type="text" class="form-control" placeholder="description" name="description" value="${description}"
                   required>
        </div>
        <div class="col-md-1 gap-2 d-md-flex justify-content-md-center">
            <button class="btn btn-secondary" type="submit">Save</button>
        </div>
        <div class="text-danger text-uppercase">
            <c:out value="${massage}"/>
        </div>
    </form>
    <table class="table table-hover table-secondary shadow mb-5">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Date of creation</th>
            <th scope="col"></th>
            <th scope="col">Status</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="task" items="${userTodoList}" varStatus="сounter">

        <tr class="table-secondary">
            <th scope="row">${сounter.count}</th>
            <td class="col"><c:out value="${task.title}"/></td>
            <td class="col"><c:out value="${task.description}"/></td>
            <td class="col"><c:out value="${task.date}"/></td>
            <td>
                <form method="get" action="/todoList">
                    <input type="hidden" name="taskId" value="${task.id}"/>
                    <input class="btn btn-outline-secondary" type="submit" value="Change status"/>
                </form>
            </td>
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
                    <c:if test="${typeUser != 'USER'}">
                        <form method="post" action="/todoList">
                            <input type="hidden" name="taskIdForDelete" value="${task.id}"/>
                            <input class="btn btn-outline-secondary" type="submit" value="Delete"/>
                        </form>
                    </c:if>
                    <c:if test="${typeUser == 'USER'}">
                        <input class="btn btn-secondary disabled" type="submit" aria-disabled="true" value="Delete"/>
                    </c:if>
                </div>
            </td>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>