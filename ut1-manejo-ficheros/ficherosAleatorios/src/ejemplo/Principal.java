package ejemplo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Principal {

	public static void main(String[] args) {
		int numeroLista=5; //4 bytes
		String nombre="Pedro"; //Sabemos que un caracter 2 bytes , 10 bytes
		double nota; //8 bytes
		
		try {
			// Creamos el fichero
			File fichero = new File("datos.dat");
			fichero.createNewFile();
			// En el segundo parametro indicamos si r-lectura, w-escritura o rw-lectura escritura
			RandomAccessFile raf = new RandomAccessFile(fichero, "rw");
			
			//Alumnos a mano
			raf.writeInt(numeroLista); //4bytes
			raf.writeChars(nombre); //10bytes
			raf.writeDouble(5.12); //8bytes
			//longitud --> 22bytes 
			
			/* ejemplo numeros
			raf.writeInt(0); // 4 bytes
			raf.writeInt(1);
			raf.writeInt(2);
			//4+4+4-->longitud12
			*/
			
			//Imprimimos la posicion del  puntero
			System.out.println(raf.getFilePointer()); // saber donde esta el puntero
			
			/*ejemplo numeros
			raf.seek(4); //0+4 esto es para posicionar el puntero
			//lee los siguientes 4 bytes
			System.out.println(raf.readInt());
			
			raf.seek(0);
			while (raf.getFilePointer() < raf.length()) {
				System.out.println(raf.readInt());
			}
			*/
			String cadena =""; //concatenas para que quede bien
			raf.seek(0);
			while (raf.getFilePointer() < raf.length()) { //solo puedes leer cantidades fijas de cosas
				System.out.println(raf.readInt());
				for (int i = 0; i < nombre.length(); i++) {
					cadena+=raf.readChar();
				}
				System.out.println(cadena);
				System.out.println(raf.readDouble());
			}
			raf.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
