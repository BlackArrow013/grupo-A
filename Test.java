public class Test {
  
  public static void main(String[] args) {
     // Pruebas sobre la clase MailClient...
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
     System.out.println("## Julio responde a Jorge con un mensaje de 12 caracteres 'Bien, �y t�?'  ##");
     mailClie2.sendMailItem("Jorge", "Saludos", "Bien, �y t�?");
     System.out.println("## Jorge descarga el mail pero no lo visualiza y env�a una respuesta autom�tica de 68 caracteres que pone 'RE: Respuesta autom�tica. Gracias. Mensaje de Jorge' + el mensaje recibido ##");
     mailClie1.getNextItemAndSendReplay();
     System.out.println("## Jorge ha enviado dos mails (uno autom�tico) y ha recibido uno de 12 caracteres de Julio ##");
     mailClie1.infoDeMails();
     System.out.println("## Julio imprime por pantalla el mensaje recibido de la respuesta autom�tica de Jorge ##");
     mailClie2.printNextMailItem();
     System.out.println("## Julio ha enviado un mail y ha recibido 2 de Jorge, uno de 68 caracteres de Jorge ##");
     mailClie2.infoDeMails();
     System.out.println("## Jorge env�a un mail a Julio con la palabra viagra, y se a�adir� al spam directamente, pues es una palabra prohibida ##");
     mailClie1.sendMailItem("Julio", "Spam", "Hola, �quieres viagra?");
     System.out.println("## Jorge ha enviado tres mails (el autom�tico y el spam incluido) y ha recibido uno de 12 caracteres de Julio ##");
     mailClie1.infoDeMails();
     System.out.println("## Julio imprime por pantalla el mensaje recibido, pero como es spam as� lo indicar� la terminal ##");
     mailClie2.printNextMailItem();
     System.out.println("## Julio ha enviado un mail y ha recibido 2 de Jorge, uno de 68 caracteres de Jorge. El spam de Jorge no cuenta ##");
     mailClie2.infoDeMails();
     System.out.println("## Maikel env�a un mail a Jorge con la palabra regalo, y se a�adir� al spam directamente, pues es una palabra prohibida ##");
     mailClie3.sendMailItem("Jorge", "Spam", "No, no quiere ning�n regalo.");
     System.out.println("## Maikel ha enviado un mail y no ha recibido ninguno ##");
     mailClie3.infoDeMails();
     System.out.println("## Jorge descargar� el mensaje sin mostrarlo en pantalla. El mensaje enviado por Maikel es spam, por lo que no se descarga nada del servidor ##");
     mailClie1.getNextMailItem();
     System.out.println("## Jorge ha enviado tres mails (el autom�tico y el spam incluido) y ha recibido uno de 12 caracteres de Julio. El spam de Maikel no cuenta ##");
     mailClie1.infoDeMails();
     System.out.println("## Maikel env�a un mail a Julio de 54 caracteres y Jorge otro de 43 caracteres ##");
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
     System.out.println("## Se mostrar� el �ltimo mensaje de Jorge recibido ##");
     mailClie1.ultimoCorreoRecibido();
     System.out.println("## Se mostrar� el �ltimo mensaje de Julio recibido ##");
     mailClie2.ultimoCorreoRecibido();
     System.out.println("## Se mostrar� el �ltimo mensaje de Maikel recibido. Como a Maikel nadie le manda mails (porque no tiene amigos), no le mostrar� ninguno ##");
     mailClie3.ultimoCorreoRecibido();
     System.out.println("## Jorge le manda un mensaje de 94 caracteres a Maikel, pero est� encriptado para evitar que Julio lo lea ##");
     mailClie1.sendMailItemEncriptado("Maikel", "Encriptado", "Maikel, quiero contarte un secreto, pero Julio lo va a interceptar, as� que te lo encripto.");
     System.out.println("## Maikel imprime el �ltimo mail de Jorge encriptado. Si comienza con ?=? significa que el mensaje enviado estaba encriptado ##");
     mailClie3.printNextMailItem();
     System.out.println("## Maikel ha enviado 2 correos (uno spam), y ha recibido un mensaje de Jorge de 94 caracteres (encriptado) ##");
     mailClie3.infoDeMails();
     System.out.println("--------------------------------------------------------------------------------------------------------------");
     System.out.println("--------------------------------------------------------------------------------------------------------------");
     System.out.println("Si lo mostrado en la terminal va acorde a los comentarios, �ENHORABUENA! Has pasado el test con �xito. Tu servidor mail funciona fet�n");
  }
  
}  
