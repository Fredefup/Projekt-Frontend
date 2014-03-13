<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/jspf/header.jspf" %>
        <title>Details for ${pageContext.request.remoteUser}</title>
    </head>
    <body>
        <h1>Customer Details!</h1>
        <p>${customer.firstName}</p>
        <p>${customer.lastName}</p>
        <p>${customer.email}</p>
        
    </body>
</html>
