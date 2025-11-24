package lectura;
import java.io.*;
public class Ej1 {
	public static void main(String[] args) {
		//Crea un fichero de texto con el nombre y contenido que tu quieras, editarlo a mano. 
		//Ahora crea una aplicación que lea este fichero de texto carácter a carácter y muestre su contenido por pantalla sin espacios 
			File fichero = new File("FicheroEjemploEj1.txt");
		if (fichero.exists()) {
			try {
				FileReader lector = new FileReader(fichero);
				int contenidoV = lector.read();
				while (contenidoV!=-1) { //The character read, or -1 if the end of the stream has been reached
					if (((char)contenidoV)!=' ') {
						System.out.print(((char)contenidoV));
					}
					contenidoV = lector.read(); 
				}
				lector.close();
			}catch (Exception e) {
				e.getMessage();
			}
		} else {
			System.out.println("El fichero no existe, por favor pruebe de nuevo");
		}
	}
}
