<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSSContainer/profile.css" rel="stylesheet" media="all">
    </head>
    <body>
        <div class="container emp-profile">
            <form method="post">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img src="${requestScope.WELCOME.photo}" height="150px" width="150px"/>
                            <div class="file btn btn-lg btn-primary">   
                                Change Photo
                                <input type="file" name="file"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <div class="row">
                                    <div class="col-md-6">
                                        <label style="font-weight: bold">User Name</label>
                                    </div>
                                    <div class="col-md-8">
                                        <label>${requestScope.WELCOME.username}</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <label style="font-weight: bold">Email</label>
                                    </div>
                                    <div class="col-md-8">
                                        <label>${requestScope.WELCOME.email}</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <label>Phone</label>
                                    </div>
                                    <div class="col-md-8">
                                        <label>${requestScope.WELCOME.phone}</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <label hidden>Test</label>
                                    </div>
                                    <div class="col-md-8">
                                        <div class="profile-edit-btn">
                                            <input type="submit" class="profile-edit-btn" name="btnEdit" value="Save Profile"/></div>
                                        <div class="profile-edit-btn">
                                            <input type="submit" class="profile-edit-btn" value="Back to HomePage"/></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>           
        </div>
    </body>
</html>

