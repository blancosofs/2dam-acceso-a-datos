package lectura;
import java.io.*;
import java.util.ArrayList;
public class Ej5 {
	public static void main(String[] args) { 
		File fichero = new File("planetas.txt");
		if (fichero.exists()) {
			try {
				FileReader lector = new FileReader(fichero);
				BufferedReader buffer = new BufferedReader(lector);
				ArrayList<String> arrayPlanetas = new ArrayList<>();
				String palabra;
				while ((palabra=buffer.readLine())!=null) {
					arrayPlanetas.add(palabra);
				}
				//usa el sort
				
				//burbuja
				boolean ordenado;
				String aux;
				do {
					ordenado = true;
					for (int i = 0; i < arrayPlanetas.size() - 1; i++) {
						if (arrayPlanetas.get(i).compareTo(arrayPlanetas.get(i + 1)) > 0) { //.get() the element at the specified position in this list
							aux = arrayPlanetas.get(i);
							arrayPlanetas.set(i, arrayPlanetas.get(i + 1));
							arrayPlanetas.set(i + 1, aux);
							ordenado = false;
						}
					}
				} while (!ordenado);
				for (int i = 0; i < arrayPlanetas.size(); i++) {
					System.out.println(arrayPlanetas.get(i));
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
