
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Completed</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body class="bg-secondary-subtle">
<div class="container">
    <h2>Completed</h2>
    <table class="table table-hover">
        <tbody>
        <c:forEach var="list" items="${userTodoList}" varStatus="сounter">
        <c:if test="${list.status.equals('Completed')}">
                <tr class="table-secondary">
                    <th scope="row">${сounter.count}</th>
                    <td class="col-5"><c:out value="${list.task}"/></td>
                    <td><c:out value="${list.status}"/></td>
                    </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
