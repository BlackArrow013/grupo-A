/**
 * A class to model a simple email client. The client is run by a
 * particular user, and sends and retrieves mail via a particular server.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
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

    /**
     * Create a mail client run by user and attached to the given server.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
        enviados = 0;
        recibidos = 0; 
        caracteresMensajeMasLargo = 0;
    }

    /**
     * Return the next mail item (if any) for this user.
     */
    public MailItem getNextMailItem()
    {        
        MailItem item = server.getNextMailItem(user);
        if (item != null) {
            recibidos += 1;
            if (item.getMessage().length() > caracteresMensajeMasLargo) {
                caracteresMensajeMasLargo = item.getMessage().length();
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
            recibidos += 1;
            if (item.getMessage().length() > caracteresMensajeMasLargo) {
                caracteresMensajeMasLargo = item.getMessage().length();
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
        
        enviados += 1;
    }
    
    /**
     * Muestra por pantalla el número total de mensajes recibidos, numero total de mensajes enviados así como la dirección de correo de 
     * la persona que nos envío el email más largo hasta el momento y el número de caracteres del mismo.
     */
    public void infoDeMails()
    {
        System.out.println("Mails enviados: " + enviados);
        System.out.println("Mails recibidos: " + recibidos);
        System.out.println("Persona que me envía el mail más largo: " + user);
        System.out.println("Número de caracteres del mail más largo: " + caracteresMensajeMasLargo);
    }
}
