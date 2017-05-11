/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import modelo.Email;

/**
 *
 * @author Marcelo
 */
public class EnviaEmail {
    
    private Session session;
    private MimeMessage message;

    public void enviarGmail(Email email) throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email.getEmailRemetente(), email.getSenhaRemetente());//email e senha usuário 
            }
        });

        //monta email  
        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getEmailRemetente()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getEmailDestinatario()));
            message.setSubject(email.getAssunto());
            message.setContent(email.getMenssagem(), "text/html; charset=utf-8");
             
            Transport.send(message);            
        } catch (MessagingException e) {
            throw new Exception("Não foi possível enviar o email!");
        }
    }

    public boolean enviarHotmail() {
        boolean retorno = false;
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Hotmail
         */
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
       
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("ruben.junior.2@hotmail.com", "*******");
                    }
                });
        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);
        try {

            message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ruben.junior.2@hotmail.com")); //Remetente

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("siedler@gmail.com")); //Destinatário(s)
            message.setSubject("Enviando email com JavaMail");//Assunto
            message.setText("Enviei este email utilizando JavaMail com minha conta Hotmail!");
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);
            System.out.println("Feito!!!");
            retorno = true;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return retorno;
    }
}
