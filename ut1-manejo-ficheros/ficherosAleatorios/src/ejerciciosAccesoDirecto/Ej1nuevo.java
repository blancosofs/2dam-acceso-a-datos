package ejerciciosAccesoDirecto;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * Se tiene un programa que escribe los números de la serie 
 * de fibonacci en un fichero binario, ese programa pide al usuario el número de números 
 * a generar mientras los genera los escribe en un fichero binario.
 * 
 * y luego permite recuperar el número de la serie calculado según la posición.
 */

public class Ej1nuevo {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in); 

		try {
			File ficheroBinario = new File("fibonacci.dat");
			ficheroBinario.createNewFile();
			RandomAccessFile raf = new RandomAccessFile(ficheroBinario, "rw");

			System.out.println("Introduzca la longitud de la serie");
			int serie = sc.nextInt();
			int a=0, b=1;

			raf.writeInt(a);
			raf.writeInt(b);

			for (int i = 1; i <= serie; i++) {
				System.out.print(a+" ");

				int aux = a+b;
				raf.writeInt(aux);
				a=b;
				b=aux;
			}
			System.out.println();
			System.out.println("Introduce el numero a recuperar");
			int recuperar = sc.nextInt();
			recuperar = (recuperar -1)*4;
			raf.seek(recuperar);
			System.out.println(raf.readInt());
			raf.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
