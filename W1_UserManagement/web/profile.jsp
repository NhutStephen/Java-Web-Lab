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
                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/>
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
                                        <label>User Name</label>
                                    </div>
                                    <div class="col-md-8">
                                        <input data-test="name" type="text" class="input is-primary" name="name" value="Huynh Minh Nhut">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <label>Email</label>
                                    </div>
                                    <div class="col-md-8">
                                        <input data-test="email" type="text" class="input is-primary" name="name" value="nhuthm@dwarvesv.com">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <label>Phone</label>
                                    </div>
                                    <div class="col-md-8">
                                        <input data-test="number" type="text" class="input is-primary" name="name" value="0382575945">
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

