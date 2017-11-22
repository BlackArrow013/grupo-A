public class Test {
    
    public static void testfuncionalidad1() {     
        // Pruebas sobre la funcionalidad1 MailClient...
        MailServer servidor = new MailServer();
        MailClient mailClie1 = new MailClient(servidor, "Jorge");
        MailClient mailClie2 = new MailClient(servidor, "Julio");
        MailClient mailClie3 = new MailClient(servidor, "Maikel");
        System.out.println("## Maikel y Jorge env�an cada uno un mail a Julio ##");
        mailClie3.sendMailItem("Julio", "Servidor", "Hola :) Solo quiero probar el m�todo de totalCorreos()");
        mailClie1.sendMailItem("Julio", "Servidor", "Yo tambi�n quiero, por eso te mando uno m�s");
        System.out.println("## Se indicar� el n�mero de correos que tiene Julio alojados en el servidor sin descargar, que son dos ##");
        mailClie2.totalCorreos();
        System.out.println("## Julio descarga los dos correos acumulados en el servidor, y los muestra por la terminal ##");
        System.out.println("## Primer mensaje ##");
        mailClie2.printNextMailItem();
        System.out.println("## Segundo mensaje ##");
        mailClie2.printNextMailItem();  
        System.out.println("## Se indicar� el n�mero de correos que tiene Julio alojados en el servidor sin descargar, que ahora son cero ##");
        mailClie2.totalCorreos();
    } 
    
        public static void testfuncionalidad2() {     
        // Pruebas sobre la funcionalidad2 MailClient...
        MailServer servidor = new MailServer();
        MailClient mailClie1 = new MailClient(servidor, "Jorge");
        MailClient mailClie2 = new MailClient(servidor, "Julio");
        MailClient mailClie3 = new MailClient(servidor, "Maikel");
        System.out.println("## Jorge env�a un mail a Julio, y Julio un mensaje de saludo a Jorge ##");
        mailClie1.sendMailItem("Julio", "Servidor", "Yo tambi�n quiero, por eso te mando uno m�s");
        mailClie2.sendMailItem("Jorge", "Servidor", "Hola");
        mailClie1.getNextMailItem();
        mailClie2.getNextMailItem();
        System.out.println("## Se mostrar� el �ltimo mensaje de Jorge recibido ##");
        mailClie1.ultimoCorreoRecibido();
        System.out.println("## Se mostrar� el �ltimo mensaje de Julio recibido ##");
        mailClie2.ultimoCorreoRecibido();
        System.out.println("## Se mostrar� el �ltimo mensaje de Maikel recibido. Como a Maikel nadie le manda mails (porque no tiene amigos), no le mostrar� ninguno ##");
        mailClie3.ultimoCorreoRecibido();
        System.out.println("## Se le manda otro mensaje a Julio sustituyendo al �ltimo ##");
        mailClie1.sendMailItem("Julio", "Servidor", "Este sustituye al �ltimo mail de Julio"); 
        mailClie2.getNextMailItem();
        mailClie2.ultimoCorreoRecibido(); 
    } 
    
    public static void testfuncionalidad3() {   
        // Pruebas sobre la funcionalidad3 MailClient...
        MailServer servidor = new MailServer();
        MailClient mailClie1 = new MailClient(servidor, "Jorge");
        MailClient mailClie2 = new MailClient(servidor, "Julio");
        MailClient mailClie3 = new MailClient(servidor, "Maikel");
        System.out.println("## Julio manda un mail a Jorge ##");
        mailClie2.sendMailItem("Jorge", "Saludos", "Bien, �y t�?");
        System.out.println("## Jorge descarga el mail pero no lo visualiza y env�a una respuesta autom�tica de 68 caracteres que pone 'RE: Respuesta autom�tica. Gracias. Mensaje de Jorge' + el mensaje recibido ##");
        mailClie1.getNextItemAndSendReplay();
        System.out.println("## Jorge ha enviado un mail (el autom�tico) y ha recibido el de Julio de 12 caracteres ##");
        mailClie1.infoDeMails();
        System.out.println("## Julio imprime por pantalla el mensaje recibido de la respuesta autom�tica de Jorge ##");
        mailClie2.printNextMailItem();
        System.out.println("## Julio ha enviado un mail y ha recibido otro, el de Jorge, de 68 caracteres ##");
        mailClie2.infoDeMails();
    } 
    
    public static void testfuncionalidad4() {    
        // Pruebas sobre la funcionalidad4 MailClient...
        MailServer servidor = new MailServer();
        MailClient mailClie1 = new MailClient(servidor, "Jorge");
        MailClient mailClie2 = new MailClient(servidor, "Julio");
        MailClient mailClie3 = new MailClient(servidor, "Maikel");
        System.out.println("## Jorge env�a un mail a Julio con la palabra viagra, y se a�adir� al spam directamente, pues es una palabra prohibida ##");
        mailClie1.sendMailItem("Julio", "Spam", "Hola, �quieres viagra?");
        System.out.println("## Jorge ha enviado un mail (el spam) ##");
        mailClie1.infoDeMails();
        System.out.println("## Julio imprime por pantalla el mensaje recibido, pero como es spam as� lo indicar� la terminal ##");
        mailClie2.printNextMailItem();
        System.out.println("## Julio ha recibido un mail de Jorge pero como es spam no cuenta ##");
        mailClie2.infoDeMails();
        System.out.println("## Maikel env�a un mail a Jorge con la palabra regalo, y se a�adir� al spam directamente, pues es una palabra prohibida ##");
        mailClie3.sendMailItem("Jorge", "Spam", "No, no quiere ning�n regalo.");
        System.out.println("## Maikel ha enviado un mail y no ha recibido ninguno ##");
        mailClie3.infoDeMails();
        System.out.println("## Jorge descargar� el mensaje sin mostrarlo en pantalla. El mensaje enviado por Maikel es spam, por lo que no se descarga nada del servidor ##");
        mailClie1.getNextMailItem();
        System.out.println("## Jorge ha enviado un mail (el spam) y ha recibido uno de Maikel, pero al ser spam no cuenta ##");
        mailClie1.infoDeMails();
    }
    
    public static void testfuncionalidad5() {
        // Pruebas sobre la funcionalidad5 MailClient...
        MailServer servidor = new MailServer();
        MailClient mailClie1 = new MailClient(servidor, "Jorge");
        MailClient mailClie2 = new MailClient(servidor, "Julio");
        MailClient mailClie3 = new MailClient(servidor, "Maikel");
        System.out.println("## Jorge le manda a Julio el mensaje de 18 caracteres 'Hola, �c�mo est�s?' ##");
        mailClie1.sendMailItem("Julio", "Saludos", "Hola, �C�mo est�s?");
        System.out.println("## Julio no ha enviado mails, y no los ha recibido porque no los ha descargado del servidor ##");
        mailClie2.infoDeMails();
        System.out.println("## Julio descargar� el mensaje sin mostrarlo en pantalla ##");
        mailClie2.getNextMailItem(); 
        System.out.println("## Julio no ha enviado mails, pero ha recibido el de Jorge de 18 caracteres ##");
        mailClie2.infoDeMails();
        System.out.println("## Jorge ha enviado un mail y no ha recibido ninguno ##");
        mailClie1.infoDeMails();
        System.out.println("## Julio responde a Jorge con un mensaje de 12 caracteres 'Bien, �y t�?' ##");
        mailClie2.sendMailItem("Jorge", "Saludos", "Bien, �y t�?");
        System.out.println("## Julio ha enviado un mail, y ha recibido el de Jorge de 18 caracteres ##");
        mailClie2.infoDeMails();
        System.out.println("## Jorge descargar� el mensaje de Julio sin mostrarlo en pantalla ##");
        mailClie1.getNextMailItem(); 
        System.out.println("## Jorge ha enviado un mail y ha recibido uno de Julio de 12 caracteres ##");
        mailClie1.infoDeMails();
        System.out.println("## Jorge responde a Julio con un mail de 46 caracteres ##");
        mailClie1.sendMailItem("Julio", "Saludos", "Bien, t�o, aqu� andamos, tirando como podemos.");
        System.out.println("## Jorge ha enviado dos mails y ha recibido uno de Julio de 12 caracteres ##");
        mailClie1.infoDeMails();
        System.out.println("## Julio descargar� el mensaje de Jorge mostr�ndolo en pantalla ##");
        mailClie2.printNextMailItem(); 
        System.out.println("## Julio ha enviado un mail, y ha recibido dos de Jorge, uno de 46 caracteres ##");
        mailClie2.infoDeMails();
        System.out.println("## Maikel env�a un mail a Jorge con un mensaje de 39 caracteres ##");
        mailClie3.sendMailItem("Jorge", "Saludos", "Te voy a quitar el record de caracteres");
        System.out.println("## Jorge descargar� el mensaje de Maikel mostr�ndolo en pantalla ##");
        mailClie1.printNextMailItem(); 
        System.out.println("## Jorge ha enviado dos mails y ha recibido dos mails, uno de Maikel de 39 caracteres ##");
        mailClie1.infoDeMails();
        System.out.println("## Maikel ha enviado un mail y no ha recibido ninguno (porque no tiene amigos) ##");
        mailClie3.infoDeMails();
    }   

    public static void testfuncionalidad6() {  
        // Pruebas sobre la funcionalidad6 MailClient...
        MailServer servidor = new MailServer();        
        MailClient mailClie1 = new MailClient(servidor, "Jorge");
        MailClient mailClie2 = new MailClient(servidor, "Maikel");
        System.out.println("## Jorge le manda un mensaje de 94 caracteres a Maikel, pero est� encriptado para evitar que Julio lo lea ##");
        mailClie1.sendMailItemEncriptado("Maikel", "Encriptado", "Maikel, quiero contarte un secreto, pero Julio lo va a interceptar, as� que te lo encripto.");
        System.out.println("## Maikel imprime el �ltimo mail de Jorge encriptado. Si comienza con ?=? significa que el mensaje enviado estaba encriptado ##");
        mailClie2.printNextMailItem();
        System.out.println("## Maikel no ha enviado ning�n mail, y ha recibido un mensaje de Jorge de 94 caracteres (encriptado) ##");
        mailClie2.infoDeMails();
    }
}  
