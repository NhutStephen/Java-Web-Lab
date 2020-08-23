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
                                Insert A New User
                            </span>

                            <div class="wrap-input100">
                                <input class="input100" type="text" name="txtUsername" value="${param.txtUsername}" placeholder="Username"/>
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                </span>
                                <font color="red" style="font-style: italic">
                                ${requestScope.INVALID.usernameError}
                                </font><br/>
                            </div>

                            <div class="wrap-input100">
                                <input class="input100" type="password" name="txtPassword" placeholder="Password"/>
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                </span>
                                <font color="red" style="font-style: italic">
                                ${requestScope.INVALID.passwordError}
                                </font><br/>
                            </div>

                            <div class="wrap-input100">
                                <input class="input100" type="password" name="txtConfirm" placeholder="Confirm Password"/>
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                </span>
                                <font color="red" style="font-style: italic">
                                ${requestScope.INVALID.confirmError}
                                </font><br/>
                            </div>

                            <div class="wrap-input100">
                                <input class="input100" type="text" name="txtEmail" value="${param.txtEmail}" placeholder="Email"/>
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                </span>
                                <font color="red" style="font-style: italic">
                                ${requestScope.INVALID.emailError}
                                </font><br/>
                            </div>

                            <div class="wrap-input100">
                                <input class="input100" type="text" name="txtPhone" value="${param.txtPhone}" placeholder="Phone Number"/>
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
                                        String role = request.getParameter("txtRoleID");
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
                                <input class="login100-form-btn" type="submit" value="Create" name="action"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
