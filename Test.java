public class Test {
  
  public static void main(String[] args) {
     // Pruebas sobre la clase MailClient...
     MailServer servidor = new MailServer();
     MailClient mailClie1 = new MailClient(servidor, "Jorge");
     MailClient mailClie2 = new MailClient(servidor, "Julio");
     MailClient mailClie3 = new MailClient(servidor, "Maikel");
     System.out.println("## Jorge le manda a Julio el mensaje de 18 caracteres 'Hola, ¿cómo estás?' ##");
     mailClie1.sendMailItem("Julio", "Saludos", "Hola, ¿Cómo estás?");
     System.out.println("## Julio no ha enviado mails, y no los ha recibido porque no los ha descargado del servidor ##");
     mailClie2.infoDeMails();
     System.out.println("## Julio descargará el mensaje sin mostrarlo en pantalla ##");
     mailClie2.getNextMailItem(); 
     System.out.println("## Julio no ha enviado mails, pero ha recibido el de Jorge de 18 caracteres ##");
     mailClie2.infoDeMails();
     System.out.println("## Jorge ha enviado un mail y no ha recibido ninguno ##");
     mailClie1.infoDeMails();
     System.out.println("## Julio responde a Jorge con un mensaje de 12 caracteres 'Bien, ¿y tú?'  ##");
     mailClie2.sendMailItem("Jorge", "Saludos", "Bien, ¿y tú?");
     System.out.println("## Jorge descarga el mail pero no lo visualiza y envía una respuesta automática de 68 caracteres que pone 'RE: Respuesta automática. Gracias. Mensaje de Jorge' + el mensaje recibido ##");
     mailClie1.getNextItemAndSendReplay();
     System.out.println("## Jorge ha enviado dos mails (uno automático) y ha recibido uno de 12 caracteres de Julio ##");
     mailClie1.infoDeMails();
     System.out.println("## Julio imprime por pantalla el mensaje recibido de la respuesta automática de Jorge ##");
     mailClie2.printNextMailItem();
     System.out.println("## Julio ha enviado un mail y ha recibido 2 de Jorge, uno de 68 caracteres de Jorge ##");
     mailClie2.infoDeMails();
     System.out.println("## Jorge envía un mail a Julio con la palabra viagra, y se añadirá al spam directamente, pues es una palabra prohibida ##");
     mailClie1.sendMailItem("Julio", "Spam", "Hola, ¿quieres viagra?");
     System.out.println("## Jorge ha enviado tres mails (el automático y el spam incluido) y ha recibido uno de 12 caracteres de Julio ##");
     mailClie1.infoDeMails();
     System.out.println("## Julio imprime por pantalla el mensaje recibido, pero como es spam así lo indicará la terminal ##");
     mailClie2.printNextMailItem();
     System.out.println("## Julio ha enviado un mail y ha recibido 2 de Jorge, uno de 68 caracteres de Jorge. El spam de Jorge no cuenta ##");
     mailClie2.infoDeMails();
     System.out.println("## Maikel envía un mail a Jorge con la palabra regalo, y se añadirá al spam directamente, pues es una palabra prohibida ##");
     mailClie3.sendMailItem("Jorge", "Spam", "No, no quiere ningún regalo.");
     System.out.println("## Maikel ha enviado un mail y no ha recibido ninguno ##");
     mailClie3.infoDeMails();
     System.out.println("## Jorge descargará el mensaje sin mostrarlo en pantalla. El mensaje enviado por Maikel es spam, por lo que no se descarga nada del servidor ##");
     mailClie1.getNextMailItem();
     System.out.println("## Jorge ha enviado tres mails (el automático y el spam incluido) y ha recibido uno de 12 caracteres de Julio. El spam de Maikel no cuenta ##");
     mailClie1.infoDeMails();
     System.out.println("## Maikel envía un mail a Julio de 54 caracteres y Jorge otro de 43 caracteres ##");
     mailClie3.sendMailItem("Julio", "Servidor", "Hola :) Solo quiero probar el método de totalCorreos()");
     mailClie1.sendMailItem("Julio", "Servidor", "Yo también quiero, por eso te mando uno más");
     System.out.println("## Se indicará el número de correos que tiene Julio alojados en el servidor sin descargar, que son dos ##");
     mailClie2.totalCorreos();
     System.out.println("## Julio descarga los dos correos acumulados en el servidor, y los muestra por la terminal ##");
     System.out.println("## Primer mensaje ##");
     mailClie2.printNextMailItem();
     System.out.println("## Segundo mensaje ##");
     mailClie2.printNextMailItem();
     System.out.println("## Se indicará el número de correos que tiene Julio alojados en el servidor sin descargar, que ahora son cero ##");
     mailClie2.totalCorreos();
     System.out.println("## Se mostrará el último mensaje de Jorge recibido ##");
     mailClie1.ultimoCorreoRecibido();
     System.out.println("## Se mostrará el último mensaje de Julio recibido ##");
     mailClie2.ultimoCorreoRecibido();
     System.out.println("## Se mostrará el último mensaje de Maikel recibido. Como a Maikel nadie le manda mails (porque no tiene amigos), no le mostrará ninguno ##");
     mailClie3.ultimoCorreoRecibido();
     System.out.println("## Jorge le manda un mensaje de 94 caracteres a Maikel, pero está encriptado para evitar que Julio lo lea ##");
     mailClie1.sendMailItemEncriptado("Maikel", "Encriptado", "Maikel, quiero contarte un secreto, pero Julio lo va a interceptar, así que te lo encripto.");
     System.out.println("## Maikel imprime el último mail de Jorge encriptado. Si comienza con ?=? significa que el mensaje enviado estaba encriptado ##");
     mailClie3.printNextMailItem();
     System.out.println("## Maikel ha enviado 2 correos (uno spam), y ha recibido un mensaje de Jorge de 94 caracteres (encriptado) ##");
     mailClie3.infoDeMails();
     System.out.println("--------------------------------------------------------------------------------------------------------------");
     System.out.println("--------------------------------------------------------------------------------------------------------------");
     System.out.println("Si lo mostrado en la terminal va acorde a los comentarios, ¡ENHORABUENA! Has pasado el test con éxito. Tu servidor mail funciona fetén");
  }
  
}  
