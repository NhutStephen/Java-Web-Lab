<%-- 
    Document   : updateUser
    Created on : Aug 23, 2020, 9:36:33 AM
    Author     : nhoxq
--%>

<%@page import="lab.DTOs.DTOuser"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List"%>
<%@page import="lab.DTOs.DTOrole" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSSContainer/login.css">
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="container emp-profile">
                        <form class="login100-form" action="MainController" method="POST">
                            <span class="login100-form-title">
                                Update User
                            </span>

                            <%
                                DTOuser user = (DTOuser) request.getAttribute("USER");
                            %>
                            
                            <div class="wrap-input100">
                                <input class="input100" type="text" name="txtUsername" value="<%= user.getUsername()%>" placeholder="Username" readonly/>
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                </span>
                                <font color="red" style="font-style: italic">
                                ${requestScope.INVALID.usernameError}
                                </font><br/>
                            </div>

                            <div class="wrap-input100">
                                <input class="input100" type="text" name="txtEmail" value="<%= user.getEmail()%>" placeholder="Email"/>
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                </span>
                                <font color="red" style="font-style: italic">
                                ${requestScope.INVALID.emailError}
                                </font><br/>
                            </div>

                            <div class="wrap-input100">
                                <input class="input100" type="text" name="txtPhone" value="<%= user.getPhone()%>" placeholder="Phone Number"/>
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                </span>
                                <font color="red" style="font-style: italic">
                                ${requestScope.INVALID.phoneError}
                                </font><br/>
                            </div>


                            <div class="wrap-input100">
                                <select name="txtRoleID" class="input100">
                                    <%
                                        String role = user.getRoleID();
                                        String selectAdmin = "";
                                        String selectUser = "";
                                        if (role != null) {
                                            if (role.equals("1")) {
                                                selectAdmin = "selected";
                                            } else {
                                                selectUser = "selected";
                                            }
                                        }
                                    %>
                                    <option value="1" <%= selectAdmin%>>Admin</option>
                                    <option value="2" <%= selectUser%>>User</option>
                                </select><br>
                            </div>
                            <div class="container-login100-form-btn">
                                <input class="login100-form-btn" type="submit" value="Update User" name="action"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
