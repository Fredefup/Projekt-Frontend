<%-- 
    Document   : test
    Created on : 09-04-2014, 11:20:44
    Author     : Frederik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script src="jq/jquery-1.9.1.js"></script>
        <!--    <script src="js/jquery.validate.js"></script>-->
        <script>
 $(document).ready(function() {
             
        $("#getinfofromphone").click(function(){
            getInfo();
        });
            
            function getInfo() {
                $.ajax({
                    url: "AutoFill",
                    cache: false,
                    dataType: "json"
                }).done(function(data) {
                    $("#data").html(data);
                });
            }
        
                
            });
                </script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <div id="data"></div>
        <input type="text" name="phone" id="phone" value="${customer.phone}"/>
                    <button id="getinfofromphone"> Search </button>
    </body>
</html>
