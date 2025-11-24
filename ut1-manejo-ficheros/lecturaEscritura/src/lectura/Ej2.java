package lectura;
import java.io.File;
import java.io.FileReader;
public class Ej2 {
	//Crea un programa que según lo que hemos visto hoy lea un fichero y saque por pantalla
	//el número de caracteres que tiene el fichero y el número de vocales. 
	public static void main(String[] args) {
		File fichero = new File("FicheroEjemploEj1.txt");
		if (fichero.exists()) {
			try {
				FileReader lector = new FileReader(fichero);
				int contenidoV = lector.read(); 
				int contadorCaracteres =0;
				int contadorVocales =0;
	
				
				while (contenidoV!=-1) { //The character read, or -1 if the end of the stream has been reached
						contadorCaracteres++;
						if (((char)contenidoV)=='a' || ((char)contenidoV)=='e' || ((char)contenidoV)=='i' || ((char)contenidoV)=='o' || ((char)contenidoV)=='u') {
							contadorVocales++;
					}
					contenidoV = lector.read();
				}
				lector.close();
				
				System.out.println("El numero de caracteres en nuestro fichero es: "+contadorCaracteres);
				System.out.println("El numero de vocales en nustro fichero es: "+contadorVocales);
				
			}catch (Exception e) {
				e.getMessage();
			}
		} else {
			System.out.println("El fichero no existe, por favor pruebe de nuevo");
		}
	}
}
