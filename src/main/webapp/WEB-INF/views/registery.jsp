<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: safdar
  Date: 8/26/2019
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<%
    boolean b=false;
    Map<String,String> month = new LinkedHashMap<>();
    month.put("september","spt");
	month.put("may","may");
	month.put("april", "apr");
	month.put("october","oct");
	request.setAttribute("months",month);
    request.setAttribute("showPass",b);
%>
<style>
    .error {
        color: #ff0000;
    }

    .errorblock {
        color: #000;
        background-color: #ffEEEE;
        border: 3px solid #ff0000;
        padding: 8px;
        margin: 16px;
    }
</style>
<%@taglib prefix="spf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="st" uri="http://www.springframework.org/tags" %>
<st:url value="/registery" var="thisPage"/>

<html>
<head>
    <title>registery</title>
</head>
<header class="text-white bg-dark text-lg-center">
    <h1>enroll</h1>
</header>
<body style="text-align: center" class="bg-secondary">
<spf:form action="${thisPage}" method="post" modelAttribute="info">
    <lable>username       </lable><spf:input path="username"  placeholder="inter your username"/><br>
    <label>password       </label><spf:password path="password"  showPassword="${showPass}" placeholder="inter your password"/><br>
    <label>Retype Password</label><spf:password path="ensurepass" showPassword="${showPass}"/><br>

    <label>Birthday:year</label><select name="birthday">
    <option  value="NONE">--SELECT--</option>
    <option value="1990">1990</option>
    <option value="1991">1991</option>
    <option value="1992">1992</option>
    <option value="1996">1996</option>
</select>

    <label>month</label><select name="birthday">
    <option value="NONE">--SELECT--</option>
    <option value="09">SEPTEMBER</option>
    <%--<spf:options items="${months}"/>--%>
</select>


    <label>day</label><select name="birthday">
    <option value="NONE">--SELECT--</option>
    <option value="11">11</option>
</select>

<br>
    <spf:errors path="*" cssClass="errorblock" element="div"/><br>
<button type="submit" class="btn btn-dark">submit</button>
</spf:form>

</body>
</html>
