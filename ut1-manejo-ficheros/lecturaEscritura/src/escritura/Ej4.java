package escritura;
import java.io.*;
import java.util.Scanner;
public class Ej4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Introduce la ruta del primer fichero de origen:");
			String ruta1 = sc.nextLine();		
			File fichero1 = new File(ruta1);
			System.out.println("Introduce la ruta del segundo fichero de origen:");
			String ruta2 = sc.nextLine();		
			File fichero2 = new File(ruta2);
			System.out.println("Introduce la ruta del fichero de destino:");
			String rutaDestino = sc.nextLine();
			
			String nombre1 = fichero1.getName();
			String nombre2 = fichero2.getName();
			File ficheroFinal = new File(rutaDestino + "/"+nombre1+"_"+nombre2);
			ficheroFinal.createNewFile();
			
			BufferedWriter pw = new BufferedWriter(new FileWriter(ficheroFinal));
			
			FileReader lector = new FileReader(fichero1);
			BufferedReader buffer = new BufferedReader(lector);
			String linea;
			while ((linea=buffer.readLine())!=null) {
				pw.write(linea);
				pw.newLine();
			}
			lector.close();
			
			FileReader lector2 = new FileReader(fichero2);
			BufferedReader buffer2 = new BufferedReader(lector2);
			String linea2;
			while ((linea2=buffer2.readLine())!=null) {
				pw.write(linea2);
				pw.newLine();
			}
			lector2.close();
			
			pw.close();
			
			sc.close();
			
		}catch (IOException e) {
			e.getMessage();
		}
	}
}

