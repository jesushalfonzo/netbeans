<%@page import="org.apache.commons.httpclient.HttpStatus"%>
<%@page import="org.apache.commons.httpclient.methods.GetMethod"%>
<%@page import="org.apache.commons.httpclient.HttpClient"%>
<%
String url = "https://dmds-telesur.planisys.net/api-get.php?pedido=enviarMails&serverKey=g2pqbQCjvJnXAsQcRDFK731m3P03SR6m&formato=json&enIso=1&campanaId=dfc55882-1fe7-1532-6061-573e38b10503&email=1&suscriptos[0][email]=jjalfonzo@telesurtv.net";
HttpClient hclient = new HttpClient();
GetMethod method = new GetMethod(url);
int responseCode = hclient.executeMethod(method);
String responseBody = "";    
switch (responseCode) {
    case HttpStatus.SC_OK:
       responseBody = method.getResponseBodyAsString();
       break;
     default:
        break;
    }
method.releaseConnection();
%>
 
<%=responseBody%>
