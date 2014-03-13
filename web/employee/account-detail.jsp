<%-- 
    Document   : transfers-list
    Created on : Mar 4, 2014, 10:25:04 AM
    Author     : Ahmed Sadiq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../WEB-INF/jspf/header.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="stylesheet/maincss.css" rel="stylesheet" type="text/css">
        <title>Account Details</title>
    </head>
    <body>
	
	<div id="main">
	    <h3>Account Details</h3>
	    <input type="hidden" name="cpr" value="${customer.cpr}">
	    <table>
		<th>Account</th><th>Interest</th><th>Type</th>
		<tr>
		    <td>${account.number}</td>
		    <td>${account.interest}</td>
		    <td>${account.type}</td>
		</tr>
	    </table>
	    <table>
		<tr>
		    <th>Date</th><th>Amount</th><th>Destination</th>
		</tr>
		<c:forEach var="transfer" items="${account.transfers}">
		    <tr>
			<td>${transfer.date}</td>
			<td>${transfer.amount}</td>
			<td>${transfer.accountNumber}</td>
		    </tr>
		</c:forEach>
	    </table>
	</div>
    </body>
</html>
