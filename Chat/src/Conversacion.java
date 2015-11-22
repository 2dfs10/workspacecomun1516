

public class Conversacion
{
  private static final int NMENSAJES = 12;
  private static String[] conversación = new String[NMENSAJES];
  
  static
  {
    // Iniciar la matriz sólo la primera vez
    for (int i = 0; i < NMENSAJES; ++i)
      conversación[i] = "";
  }
  
  public synchronized static void añadirMensaje(String mensaje)
  {
    // Conservar en una pila los NMENSAJES últimos
    int i;
    // Añadir el último mensaje
    for (i = 0; i < NMENSAJES - 1; ++i)
      conversación[i] = conversación[i+1];
    conversación[i] = mensaje; // último mensaje recibido
  }
  
  public synchronized static String[] obtenerConversacion()
  {
    return conversación;
  }
}
