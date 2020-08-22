<%-- 
    Document   : search
    Created on : Aug 19, 2020, 8:59:08 AM
    Author     : nhoxq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
        <h1>Admin</h1>
        <form action="MainController" method="POST">
            <input type="submit" value="Create a new account" name="action" />
        </form>
        <font color="red" style="font-style: italic">
            ${requestScope.NOTI}
            </font>
    </body>
</html>
