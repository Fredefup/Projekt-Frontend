<%-- 
    Document   : accoub
    Created on : Feb 25, 2014, 9:57:54 AM
    Author     : Ahmed Sadiq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../WEB-INF/jspf/header.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="stylesheet/maincss.css" rel="stylesheet" type="text/css">
        <title>Account List</title>
    </head>
    <body>
	<div class="header">
	</div>
	<div id="main">
        <h3>Account List</h3>
	<input type="hidden" name="cpr" value="${customer.cpr}">
	<table>
	<tr>
	    <th>Account Number</th><th>Account Type</th>
	</tr>
    <c:forEach var="account" items="${accounts}">
	<tr>
	<td><a id="link" href="Controller?cpr=${customer.cpr}&accountNr=${account.number}&command=detail-account">${account.number}</a></td>
	<td>${account.type}</td></tr>
    </c:forEach>
	</table>
	</div>
    </body>
</html>
