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
    // El emisor del mensaje más largo.
    private String emisor;
    //Se guarda el ultimo correo
    private MailItem ultimoCorreo;

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
        ultimoCorreo = null;
    }

    /**
     * Detecta si tienes mensajes nuevos o no, si hay los descarga y los
     * guarda y si detecta que son Spam porque contienen o la palabra regalo o
     * viagra te devuelve el valor null.
     */
    public MailItem getNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item.getMessage().contains("regalo") || item.getMessage().contains("viagra")) {
            item = null;
        }        
        else {
            //guarda el correo recibido
            ultimoCorreo = item;
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
     * Permite saber si tienes o no mensajes en el servidor y descargarlos y 
     * mostrartelos si los tienes, tambien permite detectar si el mensaje
     * es Spam o no y si lo es no te lo muestra y te informa de ello.
     */
    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item == null) {
            System.out.println("No new mail.");
        }
        else if(item.getMessage().contains("regalo") || item.getMessage().contains("viagra")){
            System.out.println("Has recibido Spam");
        }

        else {
            item.print();
            //guarda el correo recibido
            ultimoCorreo = item;
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
    }
    
        /**
     * Contador de correos. 
     * Muestra por pantalla los correos que tenemos en el servidor.
     */
    public void totalCorreos()
    {
        System.out.println("Cantidad correos en el servidor son " + server.howManyMailItems(user));
    }
    
    /**
     * imprime el ultimo correo recibido
     */
    public void ultimoCorreoRecibido()
    {
        if(ultimoCorreo == null){
            System.out.println("No hay correos guardados");
        }
        else{
            ultimoCorreo.print();            
        }
        
    }
    
        /**
    * Return the next mail item (if any) for this user.
    */
    public MailItem getNextItemAndSendReplay()
    {
        //creamos una nueva variable local de tipo MailItem
        //en ella almacenamos el siguiente mensaje de nuestro perfil,
        //con el metodo getgetNextMailItem(user) referenciando nuestro perfil con el parametro user
        //si no hay nuevos mensajes, me sacas un mensaje por pantalla avisando de ello
        MailItem item = server.getNextMailItem(user);        
        if(item == null) {
            System.out.println("No messages");          
        }        
        //si tenemos nuevo mensajes, 
        //creamos una nueva variable local llamada Respuesta, que almacenara un mensaje de respuesta, 
        //en ella almacenaremos los datos del remitente y la respuesta automatica
        //este nuevo mensaje de respuesta se va almacenar en el servidor
        else {          
            String destino = item.getFrom();
            String asunto = "RE: " + item.getSubject();
            String mensaje = "\nRespuesta automatica.\nGracias " + item.getFrom() 
            + ".\nMensaje de " + item.getFrom() + ": " + item.getMessage();
            MailItem Respuesta = new MailItem(false, user, destino, asunto, mensaje);
            server.post(Respuesta);
            //guarda el correo recibido
            ultimoCorreo = item;
            // Tras mandar un mensaje, el contador de enviados suma uno más al registro.
            enviados += 1;
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
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendMailItem(String to, String subject, String message)
    {
        MailItem item = new MailItem(false, user, to, subject, message);
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

    /**
     * manda mensaje encriptado
     */
    public void sendMailItemEncriptado(String to, String subject, String message)
    {                
        message = message.replace("a","$\\");
        message = message.replace("A","\\");
        message = message.replace("e","%\\");
        message = message.replace("E","\\%");
        message = message.replace("i","*\\");
        message = message.replace("I","\\*");
        message = message.replace("o","#\\");
        message = message.replace("O","\\#");
        message = message.replace("u","@\\");
        message = message.replace("U","\\@");
        message = "?=?" + message;

        MailItem item = new MailItem(true,user, to, subject, message); 
        server.post(item);
        
        // Tras mandar un mensaje encriptado, el contador de enviados suma uno más al registro.
        enviados += 1;
    }
}