<%@page import="javax.mail.internet.ContentType"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Properties"%>

<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.Session"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.*"%>

<%@page contentType="text/html" pageEncoding="iso-8859-1"%>

<%!
    public class Fecha {

        //      MÉTODO PARA LA FECHA
        public String FechaMethod() {
            Calendar calendario = new GregorianCalendar();

            int date;
            String momentDate;

            if (Calendar.HOUR_OF_DAY < 12) {
                momentDate = "Morning";
            } else if (Calendar.HOUR_OF_DAY < 18 && Calendar.HOUR_OF_DAY > 12) {
                momentDate = "Afternoon";
            } else {
                momentDate = "Night";
            }

            Date dNow = new Date();
            SimpleDateFormat ft
                    = new SimpleDateFormat("dd/MM/yyyy");
            String currentDate = ft.format(dNow);

            String Subject2 = ("TeleSUR Newsletter" + " " + currentDate + " " + momentDate);
            String Subject = ("telesurwebimk:*t3l3SURcl4v32013/.* PRUEBA NEWSLETTER" + Subject2);
            return Subject;

        }
    }

    public class classEnvioMail {

        public String total = null;

        public String EnvioMail() {

            Fecha fecha = new Fecha();
            try {
                URL pagina = new URL("http://www.telesurtv.net/NewsletterENG.html");
                BufferedReader in = new BufferedReader(new InputStreamReader(pagina.openStream()));
                String entrada;

                while ((entrada = in.readLine()) != null) {
                    this.total = this.total + "\n" + entrada;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // ENVIO DEL CORREO EN EL TRY
            try {
                // Propiedades de la conexión
                Properties props = new Properties();
                props.setProperty("mail.smtp.auth", "true");
                props.setProperty("mail.smtp.host", "correo.telesurtv.net");
                props.setProperty("mail.smtp.port", "25");
                props.setProperty("mail.smtp.from", "contactenos@telesurtv.net");
                props.setProperty("mail.smtp.localhost", "correo.telesurtv.net");
// Get the Session object.
                Session session = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication("webtelesur@telesurtv.net", "/W3b-Tele$ur..");
                            }
                        });
                // Preparamos la sesion
   

                // Construimos el mensaje
                MimeMessage message = new MimeMessage(session);
                message.isMimeType("true");

                message.setFrom(new InternetAddress("Contactenos teleSUR <contactenos@telesurtv.net>"));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress("email-10025@z4.imolko.com"));
                message.setSubject(fecha.FechaMethod());
                message.setText("Prueba prueba solo texto, sin html");
                message.setSender(new InternetAddress("Contactenos teleSUR <contactenos@telesurtv.net>"));

                Transport t = session.getTransport("smtp");
                t.connect();
               // t.connect("correo.telesurtv.net", 25, "webtelesur@telesurtv.net", "/W3b-Tele$ur..CC");
                t.sendMessage(message, message.getAllRecipients());
                
                session.setDebug(true);
                // Cierre.
                t.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "TeleSUR Newsletter";
            
        }
        
    }

    classEnvioMail Obj = new classEnvioMail();
    String t = Obj.EnvioMail();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ENVIADO EL NEWSLETTER INGLÉS</h1>

    </body>
</html>
