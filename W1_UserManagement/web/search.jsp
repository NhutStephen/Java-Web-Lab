<%@page import="lab.DTOs.DTOuser"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="CSSContainer/search.css">
    </head>

    <body>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-8">
                                <h2>User Information</h2>
                            </div>
                            <div class="col-sm-4">
                                <div class="login100-form-btn">
                                    <form action="MainController" method="POST">
                                        <button type="submit" class="form-control" value="Create a new account" name="action">Insert new user</button>
                                    </form>
                                </div><br/>
                                <div class="search-box">
                                    <i class="material-icons">&#xE8B6;</i>
                                    <form action="MainController" method="POST">
                                        <input type="text" name="txtSearchUser" placeholder="Search Username"/>
                                        <input type="submit" name="action" value="Search User"/>
                                        <select name="txtRoleID">
                                            <%
                                                String role = request.getParameter("txtRole");
                                                String selectAll = "";
                                                String selectAdmin = "";
                                                String selectUser = "";
                                                if (role != null) {
                                                    if (role.equals("0")) {
                                                        selectAll = "selected";
                                                    } else if (role.equals("1")) {
                                                        selectAdmin = "selected";
                                                    } else {
                                                        selectUser = "selected";
                                                    }
                                                }
                                            %>
                                            <option value="0" <%= selectAll%>>All</option>
                                            <option value="1" <%= selectAdmin%>>Admin</option>
                                            <option value="2" <%= selectUser%>>User</option>
                                        </select><br>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div>                   

                        <%
                            List<DTOuser> listUser = (List<DTOuser>) request.getAttribute("LIST");
                            if (listUser != null) {
                                //if (listUser.size() > 0) {

                        %>
                        <table class="table table-striped table-hover table-bordered">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Photo</th>
                                    <th>Username</th>
                                    <th>Email</th>
                                    <th>Phone</th>
                                    <th>Role</th>
                                    <th>Status</th>
                                    <th>Promotion</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <%                            for (DTOuser user : listUser) {
                            %>
                            <tbody>
                                <tr>
                                    <td><%= user.getUserID()%></td>
                                    <td><image src="<%= user.getPhoto()%>" width="50px" height="50px"/></td>
                                    <td><%= user.getUsername()%></td>
                                    <td><%= user.getEmail()%></td>
                                    <td><%= user.getPhone()%></td>
                                    <td><%= user.getRole()%></td>
                                    <td><%= user.getStatus()%></td>
                                    <%--add promotion status--%>
                                    <td><%= user.getPromotionStatus()%></td>
                                    <td>
                                        <%
                                            String type = "submit";
                                            String type1 = "submit";
                                            if (user.getStatus().equals("inactive")) {
                                                type1 = "hidden";
                                                type = "hidden";
                                            } else if (user.getPromotionStatus().equals("Joining")) {
                                                type = "hidden";
                                            }
                                            
                                        %>
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="txtUsername" value="<%= user.getUsername()%>"/>
                                            <input type="hidden" name="txtSearchUser" value="${param.txtSearchUser}"/>
                                            <input type="<%= type1%>" name="action" value="Delete User">
                                        </form>
                                            
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="txtUsername" value="<%= user.getUsername()%>"/>
                                            <input type="hidden" name="txtSearchUser" value="${param.txtSearchUser}"/>
                                            <input type="<%= type1%>" name="action" value="Edit User"/>
                                        </form>
                                        
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="txtUsername" value="<%= user.getUsername()%>"/>
                                            <input type="hidden" name="txtSearchUser" value="${param.txtSearchUser}"/>
                                            <input type="<%= type%>" name="action" value="Assign to Promotion"/>
                                        </form>
                                    </td>
                                </tr>
                            </tbody>
                            <%
                                }
                            %>
                        </table>
                        <div class="container-login100-form-btn">
                            <input class="login100-form-btn" type='submit' value="Logout" name="action">
                        </div>
                        <div>
                            <a href="MainController?action=LoadPromotionList">Go to your promotion's list in here</a>
                        </div>
                    </div> 
                    <%
                        //}
                    } else {
                    %>
                    <label style="font-style: italic; color: red; font-weight: bold">No record Found!</label>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </body>

</html>