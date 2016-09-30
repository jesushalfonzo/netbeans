<%-- 
    Document   : index
    Created on : 19/06/2015, 08:34:23 AM
    Author     : jvillegas
--%>

<%@page import="ScriptJsonClima.ProcessXML"%>
<%@page import="ScriptJsonClima.JsonParserGeneral"%>
<%@page import="ScriptJsonClima.ProcessXML.*" %>
<%@page import="ScriptJsonClima.SendMail" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    JsonParserGeneral parcerGeneral = new JsonParserGeneral();
    SendMail sendMail = new SendMail();   
    String mensaje;
  
    try {
        parcerGeneral.main();
        mensaje= ("Archivos del servicio del clima, han sido generados exitosamente!!");
    } catch (Exception ex) {
        mensaje = "Ah ocurrido el siguiente error: " + ex.getMessage();
         sendMail.SendAlertToMail(mensaje);

    }
    out.println(mensaje);
%>
    

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicio Clima teleSUR</title>
    </head>
    <body>
        <h1>Script de Clima a Sido Generado Correctamente.....</h1>
        <h1>Se han cargado los estados metereologicos de las ciudades configuradas</h1>
    </body>
</html>