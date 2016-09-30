/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ScriptJsonClima;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Jvillegas
 */
public class SendMail {
   
  String to = "serviciosweb@telesurtv.net";
    String from = "webtelesur@telesurtv.net";

    public void SendAlertToMail(String mensaje) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "correo.telesurtv.net");
        props.put("mail.smtp.socketFactory.port", "25");
       // props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.transport.protocol.", "smtp");

        Session session;
        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("webtelesur@telesurtv.net", "/W3b-Tele$ur..");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("alertas@telesurtv.net"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("serviciosweb@telesurtv.net"));
            message.setSubject("Servicio del Clima");
            message.setContent(mensaje, "text/html;charset=utf-8");
           // message.setText(mensaje);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
    