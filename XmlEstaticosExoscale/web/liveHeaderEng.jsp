
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>

<c:set var="now" value="<%=new java.util.Date()%>" />

<fmt:setTimeZone value="America/Caracas"/>
<c:set var="timeZone" value="GMT-4"/>

<% 

java.text.DateFormat fechax = new java.text.SimpleDateFormat("HH:mm");
String horaActual = fechax.format(new java.util.Date());
%>

<c:set var="horaActualizada" value="<%=horaActual%>" />
<!--<c:out value="${horaActualizada}" />-->

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
    String getURL=request.getRequestURL().toString();
    String[] str2 = getURL.split("/");
    String rutaURL = str2[2];
    String url = "http://www.telesurtv.net/xml/english/programacion/tvweb_eng.xml";
 %>
 <%-- LEYENDO EL XML DE SEMANA ACTUAL --%>
<c:import var="semanaActual" url="<%=url%>" charEncoding="UTF-8"/>
<x:parse xml="${semanaActual}" var="semana"/>

<x:forEach select="$semana/root/semana /*[local-name()=$nombreDia]/programas/programa" var="dia">
<x:set var="programaId" select="string($dia/@id)"/>
<x:set var="programaTitulo" select="$dia/nombre"/>
<x:set var="horaPrograma" select="$dia/hora_ini"/>
<x:set var="hora_fin" select="$dia/hora_fin"/>
<x:set var="dura" select="$dia/duracion"/>

<%-- ASIGNO LA HORA DE INICO Y FIN DEL PROGRAMA A LAS VARIABLES CORRESPONDIENTES --%>
<c:set var="horaInicial">
	<x:out select="$horaPrograma" />
</c:set>
<c:set var="duracion">
	<x:out select="$dura" />
</c:set>
<%
	
	DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	Date fechaInicio = format.parse(((String) pageContext.getAttribute("horaInicial"))); 	
	cal.setTime(fechaInicio);	
	cal.add(Calendar.MINUTE,Integer.parseInt(pageContext.getAttribute("duracion").toString()));
	String fechaFin = format.format(cal.getTime());

%>
<c:set var="horaFinal" value="<%= fechaFin%>" />

<%-- ELIMINO LOS ":" DE LA HORA DE INICIO Y FIN, PARA HACER MAS FACIL LA COMPARACION --%>

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
	<c:set var="SaleLive" value="1" />
	<div class="transmision">Live: <x:out select="$programaTitulo" /></div>
	
	

</c:if>
</x:forEach>

	<div class="logo">
	<a href="/english/index.html" title="teleSUR">
	<img src="http://www.telesurtv.net/export/sites/telesur/arte/logo-telesur.png_433216343.png"  width="201" alt="teleSUR" title="teleSUR"/>
	</a> 
	<c:if test="${SaleLive==1}">
		<a href="#" class="btnLive" onclick="mostrar_ocultar();" >LIVE</a>
	</c:if>
	
</div>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>