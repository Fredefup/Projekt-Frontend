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
	    <h3>Customer Details</h3>
	    <form>
		<div>
		    <div><select name="title" id="title" required style="margin-left: 130px;">
			    <option>Mr.</option>
			    <option>Mrs.</option>
			    <option>Ms.</option>
			</select></div>
		    <div><label for="cpr">Person nr.</label><input type="text" name="cpr" id="cpr" value="${customer.cpr}" required/></div>
		    <div><label for="fname">First Name</label><input type="text" name="fname" id="fname" value="${customer.firstName}" required/></div>
		    <div><label for="lname">Last Name</label><input type="text" name="lname" id="lname" value="${customer.lastName}" required/></div>
		    <div><label for="address">Address</label><input type="text" name="address" id="address" value="${customer.street}" required/></div>
		    <div><label for="postcode">PostCode</label><input type="text" name="postcode" id="postcode" value="${customer.postalCode}"/></div>
		    <div><label for="city">City</label><input type="text" name="city" id="city" value="${customer.postalDistrict}"/></div>
		    <div><label for="phone">Phone</label><input type="text" name="phone" id="phone" value="${customer.phone}"/></div>
		    <div><label for="email">Email</label><input type="email" name="email" id="email" value="${customer.email}"/></div>
		</div>
		<input type="hidden" name="command" value="save-customer">
		<br/>
		<input type="submit" value="Save" style="margin-left: 240px;">
	    </form>
	    <br/>
	</div>
    </body>
</html>
