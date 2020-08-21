<%-- 
    Document   : insert
    Created on : Aug 20, 2020, 11:35:47 AM
    Author     : nhoxq
--%>

<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List"%>
<%@page import="lab.DTOs.DTOrole" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert a new user</title>
    </head>
    <body>
        <h1>Insert a new user</h1>
        <form action="MainController" method="POST" enctype="multipart/form-data">
            <label>Username*</label>    <input style="margin-left: 1%" type="text" name="txtUsername" value="${param.txtUsername}"/>
            <font color="red" style="font-style: italic">
            ${requestScope.INVALID.usernameError}
            </font><br/>
            
            <label>Password*</label>    <input style="margin-left: 1%" type="password" name="txtPassword"/>
            <font color="red" style="font-style: italic">
            ${requestScope.INVALID.passwordError}
            </font><br/>
            
            <label>Confirm*</label>     <input style="margin-left: 1%" type="password" name="txtConfirm"/>
            <font color="red" style="font-style: italic">
            ${requestScope.INVALID.confirmError}
            </font><br/>
            
            <label>Email*</label>    <input style="margin-left: 1%" type="text" name="txtUsername" value="${param.txtUsername}"/>
            <font color="red" style="font-style: italic">
            ${requestScope.INVALID.emailError}
            </font><br/>
            
            <label>Phone*</label>    <input style="margin-left: 1%" type="text" name="txtUsername" value="${param.txtUsername}"/>
            <font color="red" style="font-style: italic">
            ${requestScope.INVALID.phoneError}
            </font><br/>
            
            <label>Role*</label>
            <select name="txtRole">
                <%
                    String role = request.getParameter("txtRole");
                    String selectAdmin = "";
                %>
            </select>
            
            <label>Add avatar: </label>
            <input id="file" style="margin-left: 1%" type="file" name="uploadFile" onchange="return fileValidation()"/><br/>
            <input type="submit" value="Create"/>
        </form>
    </body>
</html>
