<%@page import="java.util.List"%>
<%@page import="lab.DTOs.DTOpromotion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="CSSContainer/promotion1.css">
        <link href="CSSContainer/promotion1.css" rel="stylesheet" media="all">
    </head>
    <body>
        <section id="tabs" class="project-tab">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <nav>
                            <div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
                                <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Project Tab 1</a>
                                <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Project Tab 2</a>
                                <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">Project Tab 3</a>
                            </div>
                        </nav>
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                                <%
                                    List<DTOpromotion> list = (List<DTOpromotion>) request.getAttribute("LIST_PROMO");
                                    if (list != null) {

                                %>
                                <table class="table" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Username</th>
                                            <th>Rank</th>
                                            <th>Date assign</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <%                                        for (DTOpromotion dto : list) {
                                    %>
                                    <tbody>
                                        <tr>
                                            <td><%= dto.getUserID()%></td>
                                            <td><%= dto.getUsername()%></td>
                                            <td><%= dto.getRank()%></td>
                                            <td><%= dto.getDateAssign()%></td>
                                            <td>
                                                <form action="MainController" method="POST">
                                                    <input type="hidden" name="txtUserID" value="<%= dto.getUserID()%>"/>
                                                    <input type="submit" name="action" value="Remove">
                                                </form>

                                                <form action="MainController" method="POST">
                                                    <input type="hidden" name="txtUserID" value="<%= dto.getUserID()%>"/>
                                                    <input type="submit" name="action" value="Edit Promotion"/>
                                                </form>
                                            </td>
                                        </tr>
                                    </tbody>
                                    <%
                                        }
                                    %>    
                                </table>
                            </div>
                            <%
                            } else {
                            %>
                            <label style="font-style: italic; color: red; font-weight: bold">No record Found!</label>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>


