import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;



public class RecibirEmailSimple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// Se obtiene la Session
        Properties prop = new Properties();
        prop.setProperty("mail.pop3.starttls.enable", "false");
        prop.setProperty(
            "mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.setProperty("mail.pop3.socketFactory.fallback", "false");
        prop.setProperty("mail.pop3.port", "995");
        prop.setProperty("mail.pop3.socketFactory.port", "995");
        Session sesion = Session.getInstance(prop);
        // sesion.setDebug(true);

        try
        {
          // Se obtiene el Store y el Folder, para poder leer el
          // correo.
            Store store = sesion.getStore("pop3");
            store.connect(
                "pop.gmail.com", "2dfs1011@gmail.com", "password");
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            // Se obtienen los mensajes.
            Message[] mensajes = folder.getMessages();

            // Se escribe from y subject de cada mensaje
            for (int i = 0; i < mensajes.length; i++)
            {
                System.out.println(
                    "From:" + mensajes[i].getFrom()[0].toString());
                System.out.println("Subject:" + mensajes[i].getSubject());
                
                // Se visualiza, si se sabe como, el contenido de cada mensaje
                //
                  
               
                   if (mensajes[i].isMimeType("text/*"))
                      // mensaje de texto simple
                   {
                	   System.out.println("texto"+mensajes[i].getContent());
                   }
                   
                              	   
                	   if (mensajes[i].isMimeType("multipart/*"))
                      // mensaje compuesto
                	   {
                	   }
          
                
               // analizaParteDeMensaje(mensajes[i]);
            }

            folder.close(false);
            store.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
		
		
	}


