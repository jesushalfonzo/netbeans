<%-- 
    Document   : newjsp1
    Created on : 04/03/2015, 11:39:22 AM
    Author     : jalfonzo
--%>

<%
    Cookie[] cookies = request.getCookies();
    Boolean mostrarIntersticial=false;
    for (Cookie cookie : cookies) {
        if ("IntersticialSURHomedev".equals(cookie.getName())) {
           mostrarIntersticial= true;
        }
    }
    
    if(mostrarIntersticial){ out.print("cc");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
