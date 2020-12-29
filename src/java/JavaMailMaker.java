/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EEC
 */
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailMaker {

    private static String mMail = "hreserve286@gmail.com";
    private static String mpw = "HotelReserve123";

    public static void sendPassword(String reciver, String pw) throws MessagingException {
        System.out.println("sending....");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");//auth
        properties.put("mail.smtp.starttls.enable", "true");//encript
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mMail, mpw); //To change body of generated methods, choose Tools | Templates.
            }

        });
        Message message = prepareMessage(session, reciver, pw);
        Transport.send(message);
        System.out.println("sent");
    }

    private static Message prepareMessage(Session session, String reciver, String pw) {
        Message message = null;
        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mMail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(reciver));
            message.setSubject("Genrated password");
            String fromat = "<h1>Welcome in HotelReservation</h1> <br> <h2> Your password is </h2> <h3>" + pw + "</h3>";
            /*message.setText("Hello there,\n"
                    + "your password is :"+pw);*/
            message.setContent(fromat, "text/html");
        } catch (AddressException ex) {
            Logger.getLogger(JavaMailMaker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(JavaMailMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

}
