<%@page isELIgnored="false" %>
<%@taglib prefix="st" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
<c:url var="bootstrap" value="/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="${bootstrap}">
<c:set var="s" value="sadeq"/>
<title>home</title>

<header style="text-align: center">
    <h1 class="text-white bg-dark">this page is created by ${s}:(</h1>
</header>

<body class="bg-light">
<div style="text-align: center">
    <a class="btn btn-secondary" href="/registery" >register</a>
    <a class="btn btn-dark" href="/logIn-page">Log In</a>
</div>
<%--<img src="<st:url value="/resources/images/lambda-expression.jpg"/>"/>--%>

</body>
</html>
