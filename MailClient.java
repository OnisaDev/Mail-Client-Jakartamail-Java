package com.ejemplo;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MailClient {

    private String smtpHost;
    private int smtpPort;
    private String sender;
    private String subject;
    private String body;
    private List<String> recipients;

    // Constructor: define servidor SMTP y puerto
    public MailClient(String smtpHost, int smtpPort) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        this.recipients = new ArrayList<>();
    }

    // Métodos para añadir destinatarios
    public void addRecipient(String recipient) {
        recipients.add(recipient);
    }

    public void addRecipients(String[] recipientsArray) {
        for (String r : recipientsArray) {
            recipients.add(r);
        }
    }

    // Métodos para configurar remitente, asunto y cuerpo
    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMailText(String body) {
        this.body = body;
    }

    // Envío con SSL
    public void sendUsingSSLAuthentication(final String user, final String pass) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                return new jakarta.mail.PasswordAuthentication(user, pass);
            }
        });

        sendMessage(session);
    }

    // Envío con TLS
    public void sendUsingTLSAuthentication(final String user, final String pass) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                return new jakarta.mail.PasswordAuthentication(user, pass);
            }
        });

        sendMessage(session);
    }

    // Envío sin autenticación
    public void send() throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);

        Session session = Session.getInstance(props);
        sendMessage(session);
    }

    // Método interno para construir y enviar el mensaje
    private void sendMessage(Session session) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));

        for (String recipient : recipients) {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        }

        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);
    }
}
