<%@page import="java.util.Hashtable"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="jdk.nashorn.api.scripting.URLReader"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="java.net.URL"%>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.ServletConfig.*" %>
<%@ page import="javax.servlet.ServletContext.*" %>
<%@ page import="javax.servlet.ServletException.*" %>

<%@page import="JsonParser.*" %>

<html>
    <head>
    </head>
    <body
        <%
            Hashtable<String, String> programas = new Hashtable<String, String>();

            JSONParser parser = new JSONParser();
            URL urljson = new URL("http://multimedia.telesurtv.net/api/programa/?ultimo=100&mostrar=nombre&mostrar=slug");
            JSONArray jsonArray = (JSONArray) parser.parse(new URLReader(urljson));

            for (Object o : jsonArray) {
                JSONObject prog = (JSONObject) o;

                String strNombrePrograma = (String) prog.get("nombre");
                String strSlug = (String) prog.get("slug");
                programas.put(strNombrePrograma, strSlug);
            }

            String programaGet = "Campaña Admirable";
            if (programas.containsKey(programaGet)) {
                System.out.println("El Slug de este programa es " + programas.get(programaGet));
            } else {
                System.out.println("No existe " + programaGet);
            }

        %>
</body>
</html>
