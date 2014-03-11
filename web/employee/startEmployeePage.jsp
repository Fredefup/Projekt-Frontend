<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<LINK href="stylesheet/maincss.css" rel="stylesheet" type="text/css">
	<title>Employee Page</title>
    </head>
    <body>
	<div id="header">
	    <img src="images/logo.jpg" alt="logo">
	    <ul>
		<li>
		    <c:if test="${pageContext.request.isUserInRole('Employee') || 
				  pageContext.request.isUserInRole('SuperEmployee')}">
			  <a href="Controller?command=list-customers">| List Customers |</a>
		    </c:if>
		    <c:if test="${ pageContext.request.isUserInRole('SuperEmployee')}">
			<a href="Controller?command=create-customer">| Add Customer |</a>
		    </c:if>
			<a style="float: right; margin-right: 10px;" href="Controller?command=logout">| LogOut |</a>
		</li>
	    </ul>
	</div>
	<div id="main">
	</div>
    </body>
</html>
