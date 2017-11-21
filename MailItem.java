/**
 * A class to model a simple mail item. The item has sender and recipient
 * addresses and a message string.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MailItem
{
    // The sender of the item.
    private String from;
    // The intended recipient.
    private String to;
    // The text of the message.
    private String message;
    // el asunto del message
    private String subject;
    // mensage encriptado
    private boolean encriptado;

    /**
     * Create a mail item from sender to the given recipient,
     * containing the given message.
     * @param from The sender of this item.
     * @param to The intended recipient of this item.
     * @param message The text of the message to be sent.
     */
    public MailItem(boolean encrip, String from, String to, String subject, String message )
    {
        this.encriptado = encrip;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    /**
     * @return The sender of this message.
     */
    public String getFrom()
    {
        return from;
    }

    /**
     * @return The intended recipient of this message.
     */
    public String getTo()
    {
        return to;
    }

    /**
     * @return The text of the message.
     */
    public String getMessage()
    {
        return message;
    }

        /**
     * @return The text of the message.
     */
    public String getSubject()
    {
        return subject;
    }
    
    /**
     * Print this mail message to the text terminal.
     */
    public void print()
    {  //print el mensage normal.
        if(encriptado = false){
            System.out.println("From: " + from);
            System.out.println("To: " + to);
            System.out.println("subject: " + subject);
            System.out.println("Message: " + message);
        }
        //print mensage encriptado.
        if(encriptado = true){
            System.out.println("From: " + from);
            System.out.println("To: " + to);
            System.out.println("subject: " + subject);
            message = message.replace("$\\","a");
            message = message.replace("\\$","A");
            message = message.replace("%\\","e");
            message = message.replace("\\%","E");
            message =message.replace("*\\","i");
            message = message.replace("\\*","I");
            message = message.replace("#\\","o");
            message = message.replace("\\#","O");
            message = message.replace("@\\","u");
            message = message.replace("\\@","U");
            System.out.println("Message: " + message);
        }
    }
}