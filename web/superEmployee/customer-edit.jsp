<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <LINK href="stylesheet/maincss.css" rel="stylesheet" type="text/css">
        <%@include file="../WEB-INF/jspf/header.jspf" %>
        <title>Add Customer</title>
        <style>
            label {display: inline; width: 8em; text-align: left; float: left;}
        </style>
        
        <style type="text/css">
      #myform label.error {
        color:red; width:auto; font-size: small;
        float : right; display: block;
      }
      #myform input.error {
        border:1px solid red;
      }
    </style>
        <script src="jq/jquery-1.9.1.js"></script>
        <!--    <script src="js/jquery.validate.js"></script>-->
        <script src="jq/jqueryValidation.js"></script>
        <script>
            $(document).ready(function() {
                // validate the comment form when it is submitted
                $("#myform").validate({
                    rules: {
                        cpr: {required: true, minlength: 11, maxlength: 11},
                        firstname: {required: true, minlength: 2},
                        lastname: {required: true, minlength: 2},
                        mail: {required: true, remote:"EmailValidation", email: true},
                        address: {required: true, minlength: 5},
                        postcode: {required: true, minlength: 4, maxlength: 4,number: true},
                        city: {required: true, minlength: 4},
                        phone: {required: true, minlength: 8, maxlength: 8, number: true}
                    },
                    messages: {
                        cpr: {
                            required: "please enter your cpr",
                            minlength: "not a valid cpr number",
                            maxlength: "not a valid cpr number"
                        },
                        firstname: {
                            required: "Please enter you first name",
                            minlength: jQuery.format("At least {0} characters required!")
                        },
                        lastname: {
                            required: "Please enter your lastname",
                            minlength: jQuery.format("At least {0} characters required!")
                        },
                        mail: {
                            required: "Please enter a email address",
                            remote: "Email is already registred",
                            email: "not a valid email address"
                        },
                        address: {
                            required: "Please enter a address",
                            minlength: "not a valid address"
                        },
                        postcode: {
                            required: "Please enter zipcode",
                            minlength: "not a valid zipcode",
                            maxlength: "not a valid zipcode",
                            number: "not a valid zipcode"
                            
                        },
                        city: {
                            required: "Please enter city",
                            minlength: "city does not exist"
                        },
                        phone: {
                            required: "please enter phone number",
                            minlength: "not a valid phone number",
                            maxlength: "not a valid phone number",
                            number: "not a valid phone number"
                            
                            
                        }
                    }
//                    ,
//                    errorLabelContainer: "#errors", wrapper: "div"
                });
            });
        </script>
    </head>
    <body>

        <div id="main">
            <h3>Customer Details</h3>
            <form id="myform" method="get" action="">   
                
                 <p>

                <label>Person nr.</label>
                <input type="text" name="cpr" id="cpr" value="${customer.cpr}">
               </p>

                <p>
                    <label for="firstname">First name</label>
                    <input id="firstname" name="firstname" type="text" value="${customer.firstName}"  />
                </p>
                <p>
                    <label for="lastname">Last name</label>
                    <input id="lastname" name="lastname" type="text" value="${customer.lastName}" />
                </p>

                <p>
                    <label for="mail">E-Mail</label>
                    <input id="mail" type="text" name="mail" value="${customer.email}" />
                </p>
                <p>
                    <label for="address">Address</label>
                    <input type="text" name="address" id="address" value="${customer.street}"/>
                </p>
                <p>     
                    <label for="postcode">PostCode</label>
                    <input type="text" name="postcode" id="postcode" value="${customer.postalCode}"/>
                </p>
                <p>
                    <label for="city">City</label>
                    <input type="text" name="city" id="city" value="${customer.postalDistrict}"/>
                </p>
                <p>   
                    <label for="phone">Phone</label>
                    <input type="text" name="phone" id="phone" value="${customer.phone}"/>
                </p>
                <p> 
                    <label for="pw">Password</label>
                    <input id="pw" type="password" name="pw" />
                </p>
                <p>
                    <label for="pwRepeat">Repeat the password</label>
                    <input id="pwRepeat" type="password" name="pwRepeat"/>
                </p>


                <p>
                    <input type="hidden" name="command" value="save-customer">
		<br/>
		<input type="submit" value="Save" style="margin-left: 240px;">
                </p>
            </form>
            <div id="errors" class="fs2" style="border : red solid thin;"></div>
            <br/>
        </div>
    </body>
</html>
