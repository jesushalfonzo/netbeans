<%-- 
    Document   : newjsp
    Created on : 05/02/2015, 11:07:42 AM
    Author     : jalfonzo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <script >

            Object.prototype.removeItem = function (key) {
                if (!this.hasOwnProperty(key))
                    return
                if (isNaN(parseInt(key)) || !(this instanceof Array))
                    delete this[key]
                else
                    this.splice(key, 1)
            };
            var key = "reportero";
            var elements = [{"news": 88}, {"reportero": 56}, {"otras": 15}];
            
            alert(elements.indexOf(key));
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
