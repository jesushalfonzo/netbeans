<%-- 
    Document   : index
    Created on : 23/10/2014, 08:01:05 AM
    Author     : jalfonzo
--%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%
    try {
%>
<%--OBTENGO LA HORA ACTUAL Y ELIMINO LOS ":" PARA REALIZAR LA COMPARACION CON NUMEROS ENTEROS --%>
<c:set var="now" value="<%=new java.util.Date()%>" />
<fmt:setTimeZone value="America/Caracas"/>

<%

    java.text.DateFormat fechax = new java.text.SimpleDateFormat("HHmmss");
    String horaActual = fechax.format(new java.util.Date());
%>

<c:set var="horaActualizada" value="<%=horaActual%>" />

<c:set var="string2" value="${fn:split(horaActualizada, ':')}" />
<c:set var="horaActual" value="${fn:join(string2, '')}" />

<%
    String diaH = "";
    String dias[] = {"domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado"};
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    diaH = dias[cal.get(Calendar.DAY_OF_WEEK) - 1];
%>
<c:set var="nombreDia" value="<%=diaH%>" />

<%
    String getURL = request.getRequestURL().toString();
    String[] str2 = getURL.split("/");
    String rutaURL = str2[2];
    //PARA QUE NO SE LEA CACHEADO EL XML
    SecureRandom secureRand = SecureRandom.getInstance("SHA1PRNG");
    int numAleatorio = secureRand.nextInt(9000);
    String url = "http://static.telesurtv.net/xml/grilla/tvweb_eng.xml?ramdom=" + numAleatorio;
%>
<%--LEYENDO EL XML DE SEMANA ACTUAL  <%=url%>--%>
<c:import var="semanaActual" url="<%=url%>" charEncoding="UTF-8"/>
<x:parse xml="${semanaActual}" var="semana"/>

<x:forEach select="$semana/root/semana /*[local-name()=$nombreDia]/programas/programa" var="dia">
    <x:set var="programaId" select="string($dia/@id)"/>
    <c:set var="programaTitulo" scope="page"><x:out select="$dia/nombre" /></c:set>
    <jsp:useBean id="programaTitulo" type="java.lang.String" />
    <x:set var="horaPrograma" select="$dia/hora_ini"/>
    <x:set var="hora_fin" select="$dia/hora_fin"/>
    <x:set var="tp" select="$dia/tipo_xml"/>
    <c:set var="type">
        <x:out select="$tp"/>
    </c:set>
    <%
        String type = (String) pageContext.getAttribute("type");
        if (!type.equalsIgnoreCase("t")) {

    %>

    <%-- ASIGNO LA HORA DE INICO Y FIN DEL PROGRAMA A LAS VARIABLES CORRESPONDIENTES --%>
    <c:set var="horaInicial">
        <x:out select="$horaPrograma" />
    </c:set>

    <c:set var="horaFinal">
        <x:out select="$hora_fin" />
    </c:set>

    <%-- ELIMINO LOS ":" DE LA HORA DE INICIO Y FIN, PARA HACER MAS FACIL LA COMPARACION--%>

    <c:set var="dateParts" value="${fn:split(horaInicial, ' ')}" />
    <c:set var="soloHoraIni" value="${dateParts[1]}" />
    <c:set var="STR1" value="${fn:split(soloHoraIni, ':')}" />
    <c:set var="horaInicial" value="${fn:join(STR1, '')}" />

    <c:set var="datePartsFinal" value="${fn:split(horaFinal, ' ')}" />
    <c:set var="soloHoraFin" value="${datePartsFinal[1]}" />
    <c:set var="STR2" value="${fn:split(soloHoraFin, ':')}" />
    <c:set var="horaFinal" value="${fn:join(STR2, '')}" />
    <%-- SI LA HORA DE INICOO DEL PROGRAMA ES MAYOR A LA ACTUAL Y LA HORA DE FIN MENOR O IGUAL A LA ACTUAL, ENTONCES ESTA AL AIRE --%>
    <c:if test="${horaActual >= horaInicial &&  horaActual <= horaFinal}">
        <span> <%=programaTitulo%></span>
        <a href="#">Live</a>
    </c:if>


    <%    }
    %>
</x:forEach>


<%
} catch (Exception e) {
%><span>&nbsp;</span><%
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
