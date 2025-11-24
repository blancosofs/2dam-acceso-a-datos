package escritura;
import java.io.*;
import java.util.Scanner;
public class Ej2 {
	public static void main(String[] args) {
		File fichero = new File("registroDeUsuario.txt");
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
				Scanner sc = new Scanner(System.in);
				String contenido = " ";
				while (!contenido.equals("fin")) {
					System.out.println("Introduzca una frase");
					contenido = sc.nextLine();
					
					//tienes que usar el equalsIgnoreCase()
					if (!contenido.equals("fin")) {
						pw.write(contenido);
						pw.newLine();
					}
				}
				pw.close();
				sc.close();
			}catch (IOException e) {
				e.getMessage();
			}
		}
	}
}
