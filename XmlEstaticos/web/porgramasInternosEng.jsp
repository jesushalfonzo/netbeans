<%@page import="java.security.SecureRandom"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.TimeZone"%>
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
    //PARA QUE NO SE LEA CACHEADO EL XML
    SecureRandom secureRand = SecureRandom.getInstance("SHA1PRNG");
    int numAleatorio = secureRand.nextInt(9000);
    String url = "http://static.telesurtv.net/xml/grilla/tvweb_eng.xml?ramdom=" + numAleatorio;
%>

<c:import var="programacion" url="<%=url%>" charEncoding="UTF-8"/>
<x:parse xml="${programacion}" var="output"/>


<%
    String dias[] = {"domingo", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado"};
    String timeZones[] = {"America/Caracas", "America/Bogota", "Cuba", "America/Mexico_City", "America/Buenos_Aires", "Europe/Madrid", "America/New_York"};
    int defaultTimeZone = 0;
    String today = "";
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    today = dias[cal.get(Calendar.DAY_OF_WEEK) - 1];

    /**
     * Busco en el request si se paso la zona horaria y seteo las zonas horarias
     */
    DateFormat inFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    inFormat.setTimeZone(TimeZone.getTimeZone("America/Caracas"));

    DateFormat outFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    if (request.getParameter("tz") != null) {
        try {
            defaultTimeZone = Integer.parseInt(request.getParameter("tz"));
            outFormat.setTimeZone(TimeZone.getTimeZone(timeZones[defaultTimeZone]));
        } catch (Exception e) {
        }
    } else {
        outFormat.setTimeZone(TimeZone.getTimeZone(timeZones[defaultTimeZone]));
    }

    boolean thereIsNowUp = false;
    boolean thereIsComingUp = false;
    boolean showUp = false;
    boolean separator = false;
    int cont = 0;
    long n = 0;
    Date nowDate = new Date();

    List<Map<String, String>> programas = new ArrayList<Map<String, String>>();
    
%>


<c:set var="d" value="<%=today%>" />
<x:set var="diaXML"  select="$output/root/semana/*[name()=$d]" />
<x:forEach var="programaDiaXML" select="$diaXML/programas/programa">
    <x:set var="fi" select="$programaDiaXML/hora_ini"/>
    <x:set var="ff" select="$programaDiaXML/hora_fin"/>
    <x:set var="nom" select="$programaDiaXML/nombre"/>
    <c:set var="fchIni">
        <x:out select="$fi"/>
    </c:set>
    <c:set var="fchFin">
        <x:out select="$ff"/>
    </c:set>
    <c:set var="nombre">	        				
        <x:out select="$nom"/>
    </c:set>                

    <%
        try {
            Map<String, String> programa = new HashMap<String, String>();

            /**
             * Se crea la
             * fecha actual
             * usando el
             * formato de la
             * timeZone
             * default y
             * luego lo
             * convierto a la
             * zona horaria seleccionada
             */
            DateFormat nowFormat = new SimpleDateFormat("HH:mm");
            nowFormat.setTimeZone(TimeZone.getTimeZone(timeZones[defaultTimeZone]));
            inFormat.format(nowDate);
            String now = nowFormat.format(nowDate);

            /**
             * Se crea la
             * fecha de
             * inicio con el
             * formato de la
             * timeZona
             * America/Caracas
             */
            Date fechaInicio = inFormat.parse(((String) pageContext.getAttribute("fchIni")));
            /**
             * Se pasa la
             * fecha de
             * inicio a la
             * timeZone
             * seleccionada
             * por el usuario
             * y se extrae de
             * la fecha solo
             * la hora y
             * minuto sin los
             * :
             */
            String fchI = outFormat.format(fechaInicio);
            fchI = fchI.substring(11);
            String fchIShow = fchI.substring(0, 5);
            fchI = fchI.replaceAll(":", "");
            fchI = fchI.substring(0, 4);
            /**
             * Se crea la
             * fecha de fin
             * con el formato
             * de la timeZona
             * America/Caracas
             */
            Date fechaFin = inFormat.parse(((String) pageContext.getAttribute("fchFin")));

            /**
             * Se pasa la
             * fecha de fin a
             * la timeZone
             * seleccionada
             * por el usuario
             * y se extrae de
             * la fecha solo
             * la hora y
             * minuto sin los
             * :
             */
            String fchF = outFormat.format(fechaFin);
            fchF = fchF.substring(11);
            String fchFShow = fchF.substring(0, 5);
            fchF = fchF.replaceAll(":", "");
            fchF = fchF.substring(0, 4);
            now = now.replaceAll(":", "");

            /**
             * Se pasa las
             * horas a Long
             * para manejar
             * las
             * condiciones
             */
            long ini = Long.parseLong(fchI);
            long fin = Long.parseLong(fchF);
            n = Long.parseLong(now);

            if (!thereIsNowUp && (n >= ini && n <= fin) && cont < 5) {
                thereIsNowUp = true;
                showUp = true;
                cont++;
    %>        
    <div class="blueback">Now on <img style="width:78px;" src="/arte/grilla/logo-footer.png" width="78" height="17" alt=""></div>
        <%
        } else if (!thereIsComingUp && n <= ini && cont < 5) {
            thereIsComingUp = true;
            showUp = true;
            cont++;
        %>  
    <div class="blueback">Coming up</div>
    <%
        } else if (n < ini && thereIsComingUp && thereIsNowUp && cont < 5) {
            showUp = true;
            cont++;
            separator = true;
        } else {
            showUp = false;
        }
    %> 
    <% if (showUp) {%>       
    <div class="titleblue">
        <a href="#" class="her">
             <c:set var="programaTitulo" scope="page"><x:out select="$programaDiaXML/nombre"/></c:set>
        <jsp:useBean id="programaTitulo" type="java.lang.String" />
        <%=programaTitulo%>
            						          		
        </a>
    </div>
    <div class="autshow"> <a href="#" class="her"></a></div>
    <div class="bluedate"><%= fchIShow + " - "%><%= fchFShow + ""%></div>
    <% if (separator) { %> <div class="separador2"></div><% } %>
    <% }
            programa.put("fchIShow", fchIShow);
            programa.put("fchFShow", fchFShow);
            programa.put("nombre", (String) pageContext.getAttribute("nombre"));
            programas.add(programa);
        } catch (Exception e) {
        }
    %>  


</x:forEach> 
<%
    try {

        Calendar cale = Calendar.getInstance();
        cale.setTime(nowDate);
        //Si ningun programa cumple la condicion muestro 5 dependiendo del bloque horario
        if (cont == 0) {
            if (programas != null && programas.size() > 0) {
                int np = programas.size();
                int s = 0;
                thereIsComingUp = false;
                for (int i = 0, j = 0; i < programas.size(); i++) {
                    String hora = cale.get(Calendar.HOUR_OF_DAY) + "" + cale.get(Calendar.MINUTE);
                    int horaActual = Integer.parseInt(hora);

                    if (horaActual < 1200) {
                        s = i;
                        j++;
                    } else {
                        s = np - 5;
                        j++;
                        np++;
                    }

                    int horaInicio = Integer.parseInt(programas.get(s).get("fchIShow").replaceAll(":", ""));
                    int horaFin = Integer.parseInt(programas.get(s).get("fchFShow").replaceAll(":", ""));
                    if (horaInicio < horaActual && horaFin >= horaActual && !thereIsComingUp) {
                        thereIsComingUp = true;
%><div class="blueback">Coming up</div><%
                                            }
%>
<div class="titleblue">
    <a href="#" class="her">					          		
        <%= StringEscapeUtils.escapeHtml4(programas.get(s).get("nombre"))%>
    </a>
</div>
<div class="autshow"> <a href="#" class="her"></a></div>
<div class="bluedate">
    <%= programas.get(s).get("fchIShow") + " - "%>
    <%= programas.get(s).get("fchFShow") + ""%>
</div>
<div class="separador2"></div>

<%

                    if (j == 5) {
                        break;
                    }
                }
            }
        }
    } catch (Exception e) {
    }

    /**
     * Esto
     * es
     * para
     * ocultar
     * el
     * streaming
     * ingles,
     * quitar
     * el
     * false
     * para activar
     */
    if (!thereIsNowUp && false) {
%><script type="text/javascript">
    $("#grilla-superior-streming").remove();
    $("#grilla-superior").addClass("invisible");
</script> <%
                                                  }

%>