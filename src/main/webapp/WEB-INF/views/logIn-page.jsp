<%--
  Created by IntelliJ IDEA.
  User: safdar
  Date: 9/17/2019
  Time: 6:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="bootstrap" value="/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="${bootstrap}">
<html>
<head>
    <title>Log in page</title>
</head>
<body>
<p class="text-danger text-lg-center">${userStatus}</p>
<form method="post" action="/logIn-page">
    inter your username<input type="text" name="username"><br>
    inter your password<input type="text" name="password"><br>
    <input type="submit" class="btn btn-primary" value="Log In">
</form>
</body>
</html>
