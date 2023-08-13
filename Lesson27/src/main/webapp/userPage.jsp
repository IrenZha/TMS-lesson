<%@ page import="service.UserData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>To-do list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body class="bg-secondary-subtle">
<div class="container">
    <h2>To do:</h2>
    <form class="row" method="post" action="/todoList">
        <div class="col-md-4">
            <input type="text" class="form-control" name="text" required>
        </div>
        <div class="col-md-4">
            <button class="btn btn-secondary" type="submit">Save</button>
        </div>
    </form>
        <form method="get" action="/status">
            <button class="btn btn-secondary" type="submit">Completed cases</button>
        </form>
    <table class="table table-hover">
        <tbody>
        <c:forEach var="list" items="${userTodoList}" varStatus="сounter">
            <c:if test="${!list.status.equals('Completed')}">
                <form method="post" action="/status">
                    <tr class="table-secondary">
                        <th scope="row">${сounter.count}</th>
                        <td class="col-5"><c:out value="${list.task}"/></td>
                        <td>
                            <input type="hidden" name="text" value="${list.task}"/>
                            <input type="hidden" name="status" value="${list.status}"/>
                            <input class="btn btn-outline-secondary" type="submit" value="Change status"/>
                        </td>
                        <td><c:out value="${list.status}"/></td>
                </form>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>