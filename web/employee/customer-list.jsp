<%-- 
    Document   : customer-list
    Created on : Feb 26, 2014, 10:23:21 AM
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
        <title>Customers List</title>
    </head>
    <body>
	
	<div id="main">
        <h3>Customers List</h3>
	<table border="0px">
	    <tr>
		<th>Person Number</th>
		<th>Name</th>
		<th>Address</th>
		<th>Phone Number</th>
		<th>Email</th>
		<c:if test="${ pageContext.request.isUserInRole('SuperEmployee')}">
		<th></th>
		</c:if>
	    </tr>
	    <c:forEach var="customer" items="${customers}">
		<tr><td><a id="link" href="Controller?cpr=${customer.cpr}&command=list-accounts">${customer.cpr} </a></td>
		    <td> ${customer.name}</td> 
		    <td>${customer.address}</td>
		    <td> ${customer.phone} </td>
		    <td> ${customer.email} </td>
		    <c:if test="${ pageContext.request.isUserInRole('SuperEmployee')==true}">
		    <td><a id="link" href="Controller?cpr=${customer.cpr}&command=edit-customer">Edit</td>
		    </c:if>
		</tr> 
	    </c:forEach>
	</table>
	</div>
    </body>
</html>
