package lectura;
import java.io.*;
public class Ej3 {
	public static void main(String[] args) {
		//Dado el fichero restaurantes muestra el fichero de la siguiente forma campo:valor 
		File fichero = new File("Restaurants (1).csv");
		if (fichero.exists()) {
			try {
				FileReader lector = new FileReader(fichero);
				BufferedReader buffer = new BufferedReader(lector);
				
				String linea = buffer.readLine();
				String[] arrayCampos = linea.split(",");
				linea = buffer.readLine(); //salta
				
				while (linea!=null) {
					String[] arrayValores = linea.split(",");
					for (int i = 0; i < arrayCampos.length; i++) {
						System.out.println(arrayCampos[i]+ " : " +arrayValores[i]);
					}
					System.out.println();
					linea = buffer.readLine(); //limpia
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
