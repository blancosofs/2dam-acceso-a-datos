package ejerciciosLecturaEscritura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ejercicio1base {

	public static void main(String[] args) {
		// Crea un fichero de texto con el nombre y contenido que tu quieras,editarlo a mano.
		//Ahora crea una aplicación que lea este fichero de texto
		//carácter a carácter y muestre su contenido por pantalla sin espacios

		File fichero = new File("FicheroEjemploEj1.txt");

		if (fichero.exists()) {
			try {
				FileReader lector = new FileReader(fichero);
				BufferedReader buffer = new BufferedReader(lector);
				String linea;
				while ((linea=buffer.readLine())!=null) { //*******apunta!
					System.out.println(linea.trim());
				}
				buffer.close();
			}catch (Exception e) {
				e.getMessage();
			}
		} else {
			System.out.println("El fichero no existe, por favor pruebe de nuevo");
		}
	}

}
