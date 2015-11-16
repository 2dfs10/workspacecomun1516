/* URLs para envío, recepción y con archivos adjuntos  

http://www.chuidiang.com/java/herramientas/javamail/empezar-javamail.php

*/
/* Hay que habilitar cuenta gmail para aplicaciones menos seguros
 * 
 */

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarMail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// Propiedades de la conexión
			Properties props = new Properties();
			// Nombre del host de correo, es smtp.gmail.com
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			// TLS si está disponible
			props.setProperty("mail.smtp.starttls.enable", "true");
			// Puerto de gmail para envio de correos 587
			props.setProperty("mail.smtp.port", "587");
			// Nombre del usuario
			props.setProperty("mail.smtp.user", "ieslamarisma@gmail.com");
			// Si requiere o no usuario y password para conectarse.
			//props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.auth", "true");
			// Preparamos la sesion
			Session session = Session.getDefaultInstance(props);

			// Construimos el mensaje
			MimeMessage message = new MimeMessage(session);
			// Quien envia el correo
			message.setFrom(new InternetAddress("ieslamarisma@gmail.com"));
			// A quien va dirigido
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					"2dfs1011@gmail.com"));
			// Asunto
			message.setSubject("Asunto de envio mensaje");
			// mensaje a emviar
			message.setText("Esto es un ejemplo de envio de correo simple.");

			// Lo enviamos.
			Transport t = session.getTransport("smtp");
			// conexion
			 t.connect("ieslamarisma@gmail.com", "contraseña");
			t.sendMessage(message, message.getAllRecipients());

			// Cierre.
			t.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}













