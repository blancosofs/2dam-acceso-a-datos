package ejercicios;
import java.io.*;
import java.util.Scanner;

public class Ejercicio6 {
	// Crea un programa que permita al usuario introducir el nombre del fichero que quiere crear, que el programa compruebe que existe, si existe muestra la ruta dónde está.
	//Sino le cambia los permisos para solo lectura.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce lel nombre del fichero");
		String ficheroName= sc.nextLine();		

		File ficheroNew = new File(ficheroName); 	

		if (ficheroNew.exists()) { 
			System.out.println(ficheroNew.getAbsolutePath());
		} else {
			System.out.println("No existe el fichero que buscas, crea uno nuevo ");
			System.out.println("Introduce el nombre del fichero");
			String ficheroName2= sc.nextLine();		

			File ficheroNuevo = new File(ficheroName2); 
			try {
				ficheroNuevo.createNewFile();	
				System.out.println("Fichero creado con exito!");
			}catch (IOException e) {
				e.getMessage();
			}		
			ficheroNuevo.setReadOnly();
		}
		sc.close();
	}

}
