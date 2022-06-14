package TPE;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    public static void send(String to, String p, String d, String t) {

        String user = "turnofacilxd@gmail.com";
        String pass = "opndrdrigaapyqhq";
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();

        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
  
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }

        });
        //session.setDebug(true);

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(" ¡Confirmado! Turno con " + d);
            message.setContent("<p> turno </p>", "text/html");
            System.out.println("Sending message...");

            Transport.send(message);
            
            System.out.println("Sent message successfully....");
            
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}