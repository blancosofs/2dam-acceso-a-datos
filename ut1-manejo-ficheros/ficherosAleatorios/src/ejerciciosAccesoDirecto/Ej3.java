package ejerciciosAccesoDirecto;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ej3 {
	private static int caracteresNombre = 20;
	private static int posicion = (caracteresNombre * 2) + 4; // 44bytes

	public static void main(String[] args) {
		try {
			while (true) {

				File ficheroPersonas = new File("personas.dat");
				ficheroPersonas.createNewFile();
				RandomAccessFile raf = new RandomAccessFile(ficheroPersonas, "rw");

				System.out.println("Vas a visualizar a todas las personas");
				raf.seek(0);

				StringBuilder sbNombre = new StringBuilder();

				for (int i = 0; i < caracteresNombre; i++) {
					sbNombre.append(raf.readChar());
				}

				String nombre = sbNombre.toString().trim();
				int edad = raf.readInt();
				System.out.println("Nombre: " + nombre + " , edad:  " + edad + "  .  ");

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
