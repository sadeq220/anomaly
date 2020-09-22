<%--
  Created by IntelliJ IDEA.
  User: safdar
  Date: 9/17/2019
  Time: 7:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="bootstrap" value="/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="${bootstrap}">
<html>
<head>
    <title>user ${userAccount.username}</title>
</head>
<body>
you log in successfully<br>
${userAccount.username}<br>
${userAccount.password}<br>
${userAccount.year}:${userAccount.month}:${userAccount.day}<br>
<a  class="btn btn-dark" href="/panel">show all users</a>
</body>
</html>
