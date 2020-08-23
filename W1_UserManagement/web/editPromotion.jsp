<%-- 
    Document   : editPromotion
    Created on : Aug 23, 2020, 6:38:23 PM
    Author     : nhoxq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Promotion</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <label>UserName: </label>
            <input type="text" name="txtUsername" value="${sessionScope.PROMOTION.username}" readonly="readonly" /><br>
            <label>Rank </label>
            <input type="text" name="txtRank" value="${sessionScope.PROMOTION.rank}"/><br>
            <input type="submit" value="Edit" name="action" />
        </form>
    </body>
</html>
