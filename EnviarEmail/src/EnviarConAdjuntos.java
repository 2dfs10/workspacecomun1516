import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EnviarConAdjuntos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
        {
          // se obtiene el objeto Session. La configuración es para
          // una cuenta de gmail.
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "ieslamarisma@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            // session.setDebug(true);

            // Se compone la parte del texto
            BodyPart texto = new MimeBodyPart();
            
            texto.setText("Ejemplo adjuntando dos imagenes");

            // Se compone el adjunto con la imagen
            MimeBodyPart adjunto1 = new MimeBodyPart();
            MimeBodyPart adjunto2 = new MimeBodyPart();
         
            adjunto1.setDataHandler(
                new DataHandler(new FileDataSource("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg")));
            adjunto1.setFileName("Desierto.jpg");
            
            /*
            adjunto2.setDataHandler(
                    new DataHandler(new FileDataSource("C:/Users/Usuario/Pictures/moto.jpg")));
                adjunto2.setFileName("moto.jpg");
*/
            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto1);
  //          multiParte.addBodyPart(adjunto2);
            // Se compone el correo, dando to, from, subject y el
            // contenido.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ieslamarisma@gmail.com"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress("2dfs1011@gmail.com"));
            message.setSubject("Imagenes enviadas");
            message.setContent(multiParte);

            // Se envia el correo.
            Transport t = session.getTransport("smtp");
            t.connect("ieslamarisma@gmail.com", "contraseña");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
