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

<!--OBTENGO LA HORA ACTUAL Y ELIMINO LOS ":" PARA REALIZAR LA COMPARACION CON NUMEROS ENTEROS -->
<c:set var="now" value="<%=new java.util.Date()%>" />
<fmt:setTimeZone value="America/Caracas"/>
<c:set var="timeZone" value="GMT-4"/>
<%

    java.text.DateFormat fechax = new java.text.SimpleDateFormat("HHmmss");
    String horaActual = fechax.format(new java.util.Date());
%>

<c:set var="horaActualizada" value="<%=horaActual%>" />
<c:set var="string2" value="${fn:split(horaActualizada, ':')}" />
<c:set var="horaActual" value="${fn:join(string2, '')}" />

<%
    String diaH = "";
    String diaMan = "";
    String dias[] = {"domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado"};
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    diaH = dias[cal.get(Calendar.DAY_OF_WEEK) - 1];
    if (diaH == "sabado") {
        diaH = "domingo";
    } else {
        diaMan = dias[cal.get(Calendar.DAY_OF_WEEK)];
    }
%>
<c:set var="nombreDia" value="<%=diaH%>" />
<c:set var="diaNext" value="<%=diaMan%>" />

<%
    //PARA QUE NO SE LEA CACHEADO EL XML
    SecureRandom secureRand = SecureRandom.getInstance("SHA1PRNG");
    int numAleatorio = secureRand.nextInt(9000);
    String url = "http://static.telesurtv.net/xml/grilla/tvweb_eng.xml?ramdom=" + numAleatorio;
%>


<!-- PARA SACAR EL NUMERO DE PROGRAMAS DIARIOS -->
<ul>
    <c:import var="semanaActual" url="<%=url%>" charEncoding="UTF-8"/>
    <x:parse xml="${semanaActual}" var="semana"/>
    <x:forEach select="$semana/root/semana /*[local-name()=$nombreDia]" var="diaEntero">
        <x:set var="totalProgramas" select="string($diaEntero/@cuantos)"/>
    </x:forEach>
    <!--FIN -->
    <!--LEYENDO EL XML DE SEMANA ACTUAL -->
    <c:set var="contadorProgramas" value="0" />
    <x:forEach select="$semana/root/semana /*[local-name()=$nombreDia]/programas/programa" var="dia">
        <c:set var="contadorProgramas" value="${contadorProgramas+1}" />
        <c:set var="faltantesProg" value="${faltantesProg -1}" />
        <x:set var="programaId" select="string($dia/@id)"/>
        <c:set var="programaTitulo" scope="page"><x:out select="$dia/nombre" /></c:set>
        <jsp:useBean id="programaTitulo" type="java.lang.String" />
        <x:set var="horaPrograma" select="$dia/hora_ini"/>
        <x:set var="hora_fin" select="$dia/hora_fin"/>
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
        <c:set var="horaIniPrint" value="${fn:substring(soloHoraIni, 0, 5)}" />
        <c:set var="STR1" value="${fn:split(soloHoraIni, ':')}" />
        <c:set var="horaInicial" value="${fn:join(STR1, '')}" />
        <c:set var="enVivoNow" value="0" />
        <c:set var="datePartsFinal" value="${fn:split(horaFinal, ' ')}" />
        <c:set var="soloHoraFin" value="${datePartsFinal[1]}" />
        <c:set var="horaFinPrint" value="${fn:substring(soloHoraFin, 0, 5)}" />
        <c:set var="STR2" value="${fn:split(soloHoraFin, ':')}" />
        <c:set var="horaFinal" value="${fn:join(STR2, '')}" />
        <c:if test = "${horaFinal == 000000}">
            <c:set var="horaFinal" value="240000" />
        </c:if>


        <%-- SI LA HORA DE INICOO DEL PROGRAMA ES MAYOR A LA ACTUAL Y LA HORA DE FIN MENOR O IGUAL A LA ACTUAL, ENTONCES ESTA AL AIRE --%>
        <c:if test="${horaActual >= horaInicial &&  horaActual <= horaFinal}">
            <c:set var="controFaltantes" value="${controFaltantes + 1}" />
            <c:set var="enVivoNow" value="1" />
            <c:set var="faltantesProg" value="3" />
            <li><strong>live  ·</strong> <%=programaTitulo%></li>
                <c:set var="restantesProgramas" value="${totalProgramas - contadorProgramas}" />
            </c:if>



        <c:if test="${horaActual < horaInicial &&  faltantesProg < 0 && control!=1}">
            <c:set var="controFaltantes" value="${controFaltantes + 1}" />
            <c:set var="enVivoNow" value="1" />
            <c:set var="faltantesProg" value="3" />
            <li><strong>coming soon .</strong> <%=programaTitulo%></li>
                <c:set var="restantesProgramas" value="${totalProgramas - contadorProgramas}" />
            </c:if>


        <c:if test="${enVivoNow!=1}">
            <c:set var="restantesProgramas" value="3" />
        </c:if>

        <c:if test="${restantesProgramas >= 2 && enVivoNow==0 && faltantesProg == 2}">
            <c:set var="control" value="1"/>
            <li><strong>next .</strong> <%=programaTitulo%></li>
            </c:if>
            <c:if test="${restantesProgramas >=1 && enVivoNow==0 && faltantesProg == 1}">

            <li><strong>later .</strong> <%=programaTitulo%></li>
            </c:if>


    </x:forEach> 
    <!-- SI LLEGADA LA HORA, NO EXISTEN MAS PROGRAMAS PARA EL DIA, TOCA SALTAR AL OTRO DIA Y SAcARLO DE SU XML -->
    <c:if test="${faltantesProg != 0}" >
        <c:set var="contadorProgramas" value="0" />
        <x:forEach select="$semana/root/semana /*[local-name()=$diaNext]/programas/programa" var="dia">
            <c:set var="faltantesProg" value="${faltantesProg -1}" />
            <x:set var="programaId" select="string($dia/@id)"/>
            <c:set var="programaTitulomanana" scope="page"><x:out select="$dia/nombre" /></c:set>
            <jsp:useBean id="programaTitulomanana" type="java.lang.String" />
            <x:set var="horaPrograma" select="$dia/hora_ini"/>
            <x:set var="hora_fin" select="$dia/hora_fin"/>
            <c:if test="${faltantesProg == 2}">								
                <li><strong>later .</strong> <%=StringEscapeUtils.escapeHtml4(programaTitulomanana)%></li>
                </c:if>
                <c:if test="${faltantesProg == 1}">
                <li><strong>later .</strong> <%=StringEscapeUtils.escapeHtml4(programaTitulomanana)%></li>
                </c:if>
            </x:forEach>
        </c:if>
</ul>
<%@page contentType="text/html" pageEncoding="UTF-8"%>                                                   