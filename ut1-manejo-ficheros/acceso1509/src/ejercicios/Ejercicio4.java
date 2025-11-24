package ejercicios;
import java.io.*;
import java.util.Scanner;

public class Ejercicio4 {
	// Crea un programa que dado un directorio (compruebe primero que es un directorio y si lo es) liste todos los ficheros y directorios que contiene.

	public static void main(String[] args) {
		//pedir nombres por teclado
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta del directorio");
		String dirRuta= sc.nextLine();		 

		//objeto directorio 
		File ficheroDir= new File(dirRuta);

		if (ficheroDir.isDirectory()) { //comprueba si es directorio!
			//obtener contenido
			File[] arrayMostrar = ficheroDir.listFiles();   

			for (int i = 0; i < arrayMostrar.length; i++) {
				System.out.println(arrayMostrar[i].getName());
			}
		} else {
			System.out.println("No existe el directorio que buscas");
		}
		sc.close();
	}

}
