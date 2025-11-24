package ejercicios;
import java.io.*;
import java.util.Scanner;

public class Ejercicio5 {
	// Crea un programa que dado un fichero (hay que comprobar que existe primero) 
	//compruebe los permisos que tiene y los muestre de la siguiente manera rwx o _wx (como el Linux). 
	//Si tiene todos los permisos tiene que dar la opción al usuario de cambiarlos tecleando r,w,x (las demás opciones dan error)


	public static void main(String[] args) {
		//pedir nombres por teclado
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del fichero");
		String ficheroNombre= sc.nextLine();		 

		//objeto 
		File ficheroDado= new File(ficheroNombre);

		if (ficheroDado.exists()) { //comprueba si es existe!
			
			//comprueba y muestra permisos
			String comprobar="";
			if (ficheroDado.canRead()) {
				comprobar+="r";
			}else {
				comprobar+="_";
			}
			if (ficheroDado.canWrite()) {
				comprobar+="w";
			}else {
				comprobar+="_";
			}
			if (ficheroDado.canExecute()) {
				comprobar+="e";
			}else {
				comprobar+="_";
			}
			
			System.out.println("permisos del archivo: "+comprobar);

			//si tiene todos los permisos
			if (ficheroDado.canRead()&&ficheroDado.canWrite()&&ficheroDado.canExecute()) {
				System.out.println("cambio de permisos");
				System.out.println("Introduce el permiso a cambiar: r, w, x");
				char opc= sc.next().charAt(0);
				switch (opc) {
				case 'r':
					ficheroDado.setReadable(false);
					break;
				case 'w':
					ficheroDado.setWritable(false);
					break;

				case 'x':
					ficheroDado.setExecutable(false);
					break;

				default:
					System.out.println("opcion no valida");
					break;
				}
			}
		} else {
			System.out.println("No existe el fichero que buscas");
		}
		sc.close();
	}

}
