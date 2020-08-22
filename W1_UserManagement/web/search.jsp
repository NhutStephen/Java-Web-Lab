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
                                <input type="text" class="form-control" placeholder="Search&hellip;">
                            </div>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover table-bordered">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Username</i>
                            </th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Photo</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Thomas Hardy</td>
                            <td>89 Chiaroscuro Rd.</td>
                            <td>Portland</td>
                            <td>97219</td>
                            <td>
                                <a href="#" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                                <a href="#" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <!--<div class="clearfix">
                         <<div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                         <ul class="pagination">
                             <li class="page-item disabled"><a href="#"><i class="fa fa-angle-double-left"></i></a></li>
                             <li class="page-item"><a href="#" class="page-link">1</a></li>
                             <li class="page-item"><a href="#" class="page-link">2</a></li>
                             <li class="page-item active"><a href="#" class="page-link">3</a></li>
                             <li class="page-item"><a href="#" class="page-link">4</a></li>
                             <li class="page-item"><a href="#" class="page-link">5</a></li>
                             <li class="page-item"><a href="#" class="page-link"><i class="fa fa-angle-double-right"></i></a></li>
                         </ul>
                     </div>-->
            </div>
        </div>
    </div>
</body>

</html>