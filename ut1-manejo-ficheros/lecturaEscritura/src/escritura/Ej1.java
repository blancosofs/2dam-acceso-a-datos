
package escritura;
import java.io.*;
public class Ej1 {
	public static void main(String[] args) {
		File fichero = new File("primos.txt");
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			}
			catch (IOException e) {
				e.getMessage();
			}
			
		} else {
			try {
				
				BufferedWriter pw = new BufferedWriter(new FileWriter(fichero));
				for (int num = 2; num < 501; num++) {
					boolean esPrimo = true; //asumes que es primo
					for (int i = 2; i < num; i++) { //desde 2 si es menor al num comparas si se divide entre 0
						if (num%i==0) {
							esPrimo = false; //si puede dividirse entre 0 deja de ser primo (primo, divisible entre 1 y si mismo)
						}
					}
					
					if (esPrimo) { // si lo es lo escribes
						pw.write(String.valueOf(num));
						pw.newLine();
					}
					
				}
				
				//impr
				pw.close();
				FileReader lector = new FileReader(fichero);
				BufferedReader buffer = new BufferedReader(lector);
				String linea;
				while ((linea=buffer.readLine())!=null) {
					System.out.println(linea);
				}
				lector.close();
				
			}catch (IOException e) {
				e.getMessage();
			}
		}
	}
}
