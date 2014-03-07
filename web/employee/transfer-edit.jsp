<%-- 
    Document   : transfer-edit
    Created on : Mar 4, 2014, 12:06:02 PM
    Author     : Ahmed Sadiq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="stylesheet/maincss.css" rel="stylesheet" type="text/css">
        <title>Transaction</title>
    </head>
    <body>
	<div id="header">
	    <img src="images/logo.jpg" alt="logo">
	<ul>
	    <li>
	    <a href="Controller?command=employee-main">| Back to mainpage |</a>
	    </li>
	</ul>
	</div>
	<div id="main">
	<h3>Transfer</h3>
	<form action='Controller' method="post">
	<select name='sourceAccount'>
	<option>Source Account</option>
	<c:forEach var="account" items="${accounts}">
	    <option>${account.number}</option>
	</c:forEach>
	</select>
	Amount: <input type="text" name="amount" value="">
	Target Account: <input type="text" name="targetAccount" value="">
	<input type="submit" value="Make Transaction">
	<input type="hidden" name='command' value="detail-account-transaction">
	</form>
	</div>
    </body>
</html>
