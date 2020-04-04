/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import enumerated.Host;
import modelo.Email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviaEmail {

    public static void envia(Email email) throws Exception {
        email.setHost(Host.GMAIL);
        switch (email.getHost()) {
            case GMAIL:
                enviarGmail(email);
            case OUTLOOK:
                enviarHotmail(email);
        }
    }

    private static void enviarGmail(Email email) throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email.getEmailRemetente(), email.getSenhaRemetente());
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getEmailRemetente()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getEmailDestinatario()));
            message.setSubject(email.getAssunto());
            message.setContent(email.getMenssagem(), "text/html; charset=utf-8");

            Transport.send(message);
        } catch (MessagingException e) {
            throw new Exception("Não foi possível enviar o email!");
        }
    }

    private static void enviarHotmail(Email email) {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email.getEmailRemetente(), email.getSenhaRemetente());
            }
        });

        session.setDebug(true);
        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getEmailRemetente()));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email.getEmailDestinatario())); //Destinatário(s)
            message.setSubject("Enviando email com JavaMail");//Assunto
            message.setText(email.getAssunto());

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
