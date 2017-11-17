/**
 * A class to model a simple email client. The client is run by a
 * particular user, and sends and retrieves mail via a particular server.
 * 
 * @author David J. Barnes and Michael KÃƒÂ¶lling
 * @version 2011.07.31
 */
public class MailClient
{
    // The server used for sending and receiving.
    private MailServer server;
    // The user running this client.
    private String user;
    // El número de mails enviados.
    private int enviados;
    // El número de mails recibidos.
    private int recibidos;
    // El número de caracteres del mensaje más largo.
    private int caracteresMensajeMasLargo;
    // El emisor del mensaje más largo.
    private String emisor;

    /**
     * Create a mail client run by user and attached to the given server.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
        // el atributo enviados se inicializa a 0.
        enviados = 0;
        // el atributo recibidos se inicializa a 0.
        recibidos = 0; 
        // el atributo que cuenta los caracteres del mensaje más largo recibido se inicializa a 0.
        caracteresMensajeMasLargo = 0; 
        // el atributo encargado del emisor responsable del mensaje con más caracteres se inicializa con un nadie en caso de que no se haya recibido ningún mensaje.
        emisor = "nadie";
    }

    /**
     * Return the next mail item (if any) for this user.
     */
    public MailItem getNextMailItem()
    {        
        MailItem item = server.getNextMailItem(user);
        if (item != null) {
            // Suma al contador de mensajes recibidos uno cada vez que se imprime uno por pantalla.
            recibidos += 1;
            // Tras sumar un mensaje recibido se compara el número de caracteres del mensaje con el atributo caracteresMensajeMasLargo inicializado a 0.
            if (item.getMessage().length() > caracteresMensajeMasLargo) {
                // Sustituye los caracteres del mensaje por la inicialización del atributo, y lo guarda para compararlo con posteriores mensajes.
                caracteresMensajeMasLargo = item.getMessage().length();
                // Además devuelve como emisor a la persona que ha mandado el mensaje con más caracteres, sustituyendo el "nadie" con el que se inicializa el atributo.
                emisor = item.getFrom();
            }
        }
        return item;
    }

    /**
     * Print the next mail item (if any) for this user to the text 
     * terminal.
     */
    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);        
        if (item != null) {
            item.print();
            // Suma al contador de mensajes recibidos uno cada vez que se imprime uno por pantalla.
            recibidos += 1;
            // Tras sumar un mensaje recibido se compara el número de caracteres del mensaje con el atributo caracteresMensajeMasLargo inicializado a 0.
            if (item.getMessage().length() > caracteresMensajeMasLargo) {
                // Sustituye los caracteres del mensaje por la inicialización del atributo, y lo guarda para compararlo con posteriores mensajes.
                caracteresMensajeMasLargo = item.getMessage().length();
                // Además devuelve como emisor a la persona que ha mandado el mensaje con más caracteres, sustituyendo el "nadie" con el que se inicializa el atributo.
                emisor = item.getFrom();
            }                        
        }
        else {
            System.out.println("No new email");            
        }
    }

    /**
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendMailItem(String to, String subject, String message)
    {
        MailItem item = new MailItem(user, to, message, subject);
        server.post(item);
        // Tras mandar un mensaje, el contador de enviados suma uno más al registro.
        enviados += 1;
    }
    
    /**
     * Muestra por pantalla el número total de mensajes recibidos, numero total de mensajes enviados así como la dirección de correo de 
     * la persona que nos envío el email más largo hasta el momento y el número de caracteres del mismo.
     */
    public void infoDeMails()
    {              
        // Muestra la cantidad de mails enviados hasta el momento desde esta cuenta.
        System.out.println("Mails enviados: " + enviados);
        // Muestra la cantidad de mails recibidos hasta el momento a esta cuenta.
        System.out.println("Mails recibidos: " + recibidos);
        // Indica el nombre del emisor responsable del mensaje con más caracteres.
        System.out.println("Persona que me envía el mail más largo: " + emisor);
        // Indica el número de caracteres del mensaje más largo.
        System.out.println("Número de caracteres del mail recibido más largo: " + caracteresMensajeMasLargo);
    }
}
