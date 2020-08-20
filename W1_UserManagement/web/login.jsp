<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management</title>
        <link rel="stylesheet" type="text/css" href="CSSContainer/login.css">
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <form class="login100-form" action="MainController" method="post">
                        <span class="login100-form-title">
                            User Login
                        </span>

                        <div class="wrap-input100">
                            <input class="input100" type="text" name="txtUsername" placeholder="User name">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-envelope" aria-hidden="true"></i>
                            </span>
                            <font color="red" style="font-style: italic">
                            ${requestScope.INVALID.usernameError}
                            </font>
                        </div>

                        <div class="wrap-input100">
                            <input class="input100" type="password" name="txtPassword" placeholder="Password">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-lock" aria-hidden="true"></i>
                            </span>
                            <font color="red" style="font-style: italic">
                            ${requestScope.INVALID.passwordError}
                            </font>
                        </div>

                        <div class="container-login100-form-btn">
                            <input class="login100-form-btn" type='submit' value="Login" name="action">
                        </div>
                        <div class="container-login100-form-btn">
                            <input class="login100-form-btn" type='reset' value="Reset">
                        </div>
                    </form>
                    <font color="red">
                    ${requestScope.ERROR}
                    </font>
                </div>
            </div>
        </div>
    </body>
</html>
