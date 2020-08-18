<%-- 
    Document   : error
    Created on : Aug 18, 2020, 1:14:25 PM
    Author     : nhoxq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Error</h1>
        <font color="red">
        ${requestScope.ERROR}
        </font>
    </body>
</html>
