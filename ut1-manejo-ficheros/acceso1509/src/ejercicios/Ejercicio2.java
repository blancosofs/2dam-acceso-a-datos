package ejercicios;
import java.io.*;
import java.util.Scanner;

public class Ejercicio2 {
	// Crea un programa que compruebe que existe un fichero y si existe que lo borre.

	public static void main(String[] args) {
		//pedir ruta por teclado
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta del el fichero a comprobar");
		String ficheroRuta = sc.nextLine();		 

		//objeto files 
		File ficheroName= new File(ficheroRuta);

		//existe?
		if (ficheroName.exists()) {
			//borrar contenido
			if (ficheroName.delete()) {
				System.out.println("Fichero borrado con exito");
			}else {
				System.out.println("Fichero no borrado");
			}

		}else {
			System.out.println("No existe el fichero que buscas");
		}
		sc.close();
	}

}
