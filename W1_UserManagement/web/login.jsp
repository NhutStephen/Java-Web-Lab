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
            Username <input type="text" name="username" value=""> <br>
            <font color="red" style="font-style: italic">
            ${requestScope.INVALID.usernameError}
            </font>
            Password <input type="password" name="password" value=""> <br>
            <input type='submit' name="action" value="Login">
            <input type='reset' value="Reset">
        </form>
    </body>
</html>