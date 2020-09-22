<%--
  Created by IntelliJ IDEA.
  User: safdar
  Date: 8/26/2019
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  isELIgnored="false" %>
<%@taglib prefix="st" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<st:url value="/resources/css/bootstrap.min.css"/>">

<html>
<head>
    <title>panel</title>
</head>
<body>

<table class="table table-striped">
    <caption class="text-lg-center">list of users</caption>
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Username</th>
        <th scope="col">Password</th>
        <th scope="col">BirthDay</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="cur" items="${listInfo}" varStatus="index">

    <tr>
        <th scope="row">${index.count}</th>
        <td>${cur.username}</td>
        <td>${cur.password}</td>
        <td>${cur.year}:${cur.month}:${cur.day}</td>
    </tr>

    </c:forEach>
    </tbody>

</table>
<a class="btn btn-dark" href="<st:url value="/"/>">back</a>
</body>
</html>
