package lectura;
import java.io.*;
public class Ej4 {
	public static void main(String[] args) {
		File fichero = new File("frutas.txt");
		if (fichero.exists()) {
			try {
				FileReader lector = new FileReader(fichero);
				BufferedReader buffer = new BufferedReader(lector);
				
				String[] frutas = {"Naranja", "Uva", "Plátano", "Manzana", "Mango", "Pomelo", "Nectarina", "Pera","Melón", "Sandía", "Cereza", "Melocotón", "Chirimoya", "Fresa", "Mandarina"} ;
				
				int[] contador = new int[frutas.length] ;
				
				String palabra;
				while ((palabra=buffer.readLine())!=null) {
					for (int i = 0; i < frutas.length; i++) {
						if (palabra.equals(frutas[i])) {
							contador[i]++;
						}
					}
				}
				for (int i = 0; i < frutas.length; i++) {
						System.out.println(frutas[i]+" : "+contador[i]);
					}
				buffer.close();
				lector.close();


			}catch (Exception e) {
				e.getMessage();
			}
		} else {
			System.out.println("El fichero no existe, por favor pruebe de nuevo");
		}
	}
}
