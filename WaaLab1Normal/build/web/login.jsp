<%-- 
    Document   : login
    Created on : Jan 16, 2017, 4:25:26 PM
    Author     : rames
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginServlet" method="POST">
            <label>User Name: </label><input type="text" name="username"><br>
            <label>Password:  </label><input type="password" name="password"><br>
            <input type="submit" value="Login">
        </form>
        <div id="response">
            ${failure}
        </div>
    </body>
</html>
