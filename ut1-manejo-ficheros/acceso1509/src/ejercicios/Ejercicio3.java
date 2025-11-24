package ejercicios;
import java.io.*;
import java.util.Scanner;

public class Ejercicio3 {
	// Crea un programa que cree un fichero dentro de un directorio (ambos nombres son introducidos por el usuario por teclado)

	public static void main(String[] args) {
		//pedir nombres por teclado
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ruta del directorio");
		String dirRuta= sc.nextLine();		 

		//objeto directorio 
		File ficheroDir= new File(dirRuta);

		if (ficheroDir.exists()) {
			System.out.println("Introduce el nombre del fichero");
			String ficheroName= sc.nextLine();		

			File ficheroNew = new File(ficheroDir, ficheroName);  //para que este dentro del directorio
			try {
				ficheroNew.createNewFile();	
				System.out.println("Fichero creado con exito!");
			}catch (IOException e) {
				e.getMessage();
			}		
		} else {
			System.out.println("Introduce lel nombre del fichero");
			String ficheroName2= sc.nextLine();	
			ficheroDir.mkdir();
			File ficheroNewSinDir = new File(ficheroDir, ficheroName2); 
			try {
				ficheroNewSinDir.createNewFile();	
				System.out.println("Fichero creado con exito!");
			}catch (IOException e) {
				e.getMessage();
			}	
			System.out.println("No existia el directorio que buscas, se ha creado uno");
		}
		sc.close();
	}

}
