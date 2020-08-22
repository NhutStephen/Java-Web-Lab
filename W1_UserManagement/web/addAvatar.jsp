<%-- 
    Document   : addAvatar
    Created on : Aug 22, 2020, 8:59:03 AM
    Author     : nhoxq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Avatar</title>
    </head>
    <body>
        <form action="addPhotoController" method="POST" enctype="multipart/form-data">
            <label>Add avatar: </label>
            <input id="file" style="margin-left: 1%" type="file" name="uploadFile" onchange="return fileValidation()"/><br/>
            <input type="submit" value="Upload Image"/>
        </form>
        <a href="search.jsp"><h3>Skip</h3></a>
        <div id="imagePreview"></div>
        <script>
        function fileValidation() {
            var fileInput = document.getElementById('file');
            var filePath = fileInput.value;//lấy giá trị input theo id
            var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;//các tập tin cho phép
            //Kiểm tra định dạng
            if (!allowedExtensions.exec(filePath)) {
                alert('Vui lòng upload các file có định dạng: .jpeg/.jpg/.png/.gif only.');
                fileInput.value = '';
                return false;
            } else {
                //Image preview
                if (fileInput.files && fileInput.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        document.getElementById('imagePreview').innerHTML = '<img style="width:200px;height:200px;" src="' + e.target.result + '"/>';
                    };
                    reader.readAsDataURL(fileInput.files[0]);
                }
            }
        }
        </script>
    </body>
</html>
