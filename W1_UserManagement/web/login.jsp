<%-- 
    Document   : login
    Created on : Aug 17, 2020, 8:17:09 PM
    Author     : nhoxq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="MainController" method="post">
            Username <input type="text" name="txtUsername" value=""> <br>
            <font color="red" style="font-style: italic">
            ${requestScope.INVALID.usernameError}
            </font> <br>
            Password <input type="password" name="txtPassword" value=""> <br>
            <font color="red" style="font-style: italic">
            ${requestScope.INVALID.passwordError}
            </font><br>
            <input type='submit' name="action" value="Login">
            <input type='reset' value="Reset">
        </form>
        <font color="red">
        ${requestScope.ERROR}
        </font>
    </body>
</html>
