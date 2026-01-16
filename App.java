package com.ejemplo;

public class App {
    public static void main(String[] args) {
        try {
            // Creamos cliente de correo apuntando al servidor SMTP de Gmail con SSL
            MailClient client = new MailClient("smtp.gmail.com", 465);

            // Configuración del remitente 
            client.setSender("alumno.ficticio@gmail.com");

            // Añadimos destinatarios
            client.addRecipient("profesor.ficticio@gmail.com");
            client.addRecipients(new String[]{"coordinador.ficticio@gmail.com", "otro.ficticio@gmail.com"});

            // Configuración de asunto y cuerpo
            client.setSubject("Prueba Cliente de Correos con JavaMail");
            client.setMailText("Este es un correo de prueba enviado desde la actividad de JavaMail.\n" +
                               "Es una prueba.");

            // Envío usando SSL 
            client.sendUsingSSLAuthentication("alumno.ficticio@gmail.com", "contraseñaFicticia123");

            System.out.println("Correo enviado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
