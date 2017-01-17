<%-- 
    Document   : welcome
    Created on : Jan 16, 2017, 5:04:53 PM
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
        <h1>
            Welcome <%=request.getSession().getAttribute("name")%>
                    
        </h1>
    </body>
</html>
