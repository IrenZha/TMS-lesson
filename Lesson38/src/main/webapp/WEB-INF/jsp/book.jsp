<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><spring:message code="label.titleBook" /></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body class="bg-secondary-subtle">
<div class="container-fluid">
    <br>
    <div class="text-end px-5">
        <a href="book?lang=en">EN</a>
        <a href="book?lang=ru">RU</a>
    </div>
    <h2><spring:message code="label.titleBook" /></h2>
    <div class="row">
        <div class="col-md-6 p-3 px-5">
            <form class="row" action="/book" method="post">
                <div class="col">
                    <input class="form-control" type="text" name="title" placeholder="<spring:message code="label.title" />">${title_error} <br>
                    <input class="form-control" type="number" name="pages" placeholder="<spring:message code="label.pages" />">${pages_error} <br>
                    <input class="form-control" name="author" placeholder="<spring:message code="label.author" />">${author_error} <br>
                </div>
                <div class="col">
                    <button class="btn btn-outline-secondary" type="submit"><spring:message code="label.add" /></button>
                </div>
            </form>
        </div>
        <div class="col-md-6 p-3 px-5">
            <form class="row" action="/book" method="get">
                <div class="col"><input class="form-control" type="text" name="search" placeholder="<spring:message code="label.search" />"></div>
                <div class="col">
                    <button class="btn btn-outline-secondary" type="submit"><spring:message code="label.search" /></button>
                </div>
            </form>
        </div>
    </div>
    <div class="col p-3 px-5">
    <table class="table table-hover table-secondary">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col"><spring:message code="label.title" /></th>
            <th scope="col"><spring:message code="label.pages" /></th>
            <th scope="col"><spring:message code="label.author" /></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${books}" varStatus="сounter">
        <tr>
            <th scope="row">${сounter.count}</th>
            <td><c:out value="${list.title}"/></td>
            <td><c:out value="${list.pages}"/></td>
            <td><c:out value="${list.author}"/></td>
            </c:forEach>
        </tbody>
    </table>
    </div>
</div>
</body>
</html>
