package escritura;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class Ej3 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Introduce la ruta del fichero a escribir:");
			String ruta = sc.nextLine();		
			File fichero = new File(ruta+"/"+"ficheroEj3.txt");
			System.out.println("Introduce una cantidad de numero enteros positivos a escribir en el fichero");
			int cantidadNum = sc.nextInt();	
			Random rand = new Random();
			BufferedWriter pw = new BufferedWriter(new FileWriter(fichero));
			for (int i = 0; i < cantidadNum; i++) {
				int numAleatorio = rand.nextInt(100);
				pw.write(String.valueOf(numAleatorio));
				pw.newLine();
			}
			pw.close();
			sc.close();
		}catch (IOException e) {
			e.getMessage();
		}
	}
}
