<%-- 
    Document   : addAccount
    Created on : Mar 10, 2014, 12:15:01 PM
    Author     : Ahmed Sadiq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="stylesheet/maincss.css" rel="stylesheet" type="text/css">
	<title>Add Customer</title>
	<style>
	    label {display: inline; width: 8em; text-align: left; float: left;}
	</style>
    </head>
<body>
	<div id="header">
	    <img src="images/logo.jpg" alt="logo">
	</div>
	<div id="main">
	    <h3>Add Account</h3>
	    <form>
		<div>
		    ${customer.cpr}
		    <input type="hidden" name="cpr" value="${customer.cpr}">
		    <div><label for="interest">Interest</label><input type="text" name="interest" id="interest" required/>%</div>
		</div>
		<input type="hidden" name="command" value="save-account">
		<br/>
		<input type="submit" value="Add" style="margin-left: 240px;">
	    </form>
	    <br/>
	</div>
    </body>
</html>
