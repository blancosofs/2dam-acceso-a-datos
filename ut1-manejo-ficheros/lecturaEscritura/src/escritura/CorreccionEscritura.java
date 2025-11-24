package escritura;

import java.io.*;
import java.util.Scanner;

public class CorreccionEscritura {

	public static boolean esPrimo(int numero){
		boolean primo = true;
		if (numero>2) {
			for (int i = 2; i <= Math.sqrt(numero); i++) {
				if (numero%i==0) {
					primo=false;
				}
			}
		}
		return primo;
	}
	public static void Ej1() {
		String rutaFicheroString = "primos.txt";
		File fichero = new File(rutaFicheroString);
		try {
			//En el caso de no existir el fichero
			if (!fichero.exists()) {
				fichero.createNewFile();
			}
			//Se que existe el fichero
			FileWriter aperturaEscritura = new FileWriter(fichero);
			BufferedWriter ficheroEscritura = new BufferedWriter(aperturaEscritura);

			for (int i = 2; i <= 500; i++) {
				if (esPrimo(i)) {
					ficheroEscritura.write(i+" ");
					ficheroEscritura.newLine();
				}
			}
			ficheroEscritura.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}
	public static void escribirFicheros(String linea, File ficheroEscritura) {
		//5.1 Abrir ficero para escritura
		try {
			FileWriter fE = new FileWriter(ficheroEscritura,true);//el true par decirle que no te sobreescriba
			BufferedWriter Escritura = new BufferedWriter(fE);

			Escritura.write(linea);
			//salto de linea
			Escritura.newLine();

			Escritura.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void lecturaFicheros(File fichero, File ficheroEscritura) {
		try {
			//abro primer fichero para lectura
			FileReader Lecturaf1 = new FileReader(fichero);
			BufferedReader bufferLectura = new BufferedReader(Lecturaf1);

			String linea;
			while ((linea=bufferLectura.readLine())!=null) {
				//leo las lineas
				System.out.println(linea);
				//5. La llamada a la escritura del fichero
				escribirFicheros(linea,ficheroEscritura);
			}
			bufferLectura.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Ej4() {
		//Crea una aplicación que pida la ruta de dos ficheros de texto y de una ruta de destino (solo la ruta, sin fichero al final). Debes copiar el contenido de los dos ficheros en uno, este tendrá el nombre de los dos ficheros separados por un guion bajo

		Scanner sc = new Scanner(System.in);
		//1. Pido los datos al usuario 
		System.out.println("Introduce el nombre primer fichero de origen:");
		String fichero1 = sc.nextLine();
		System.out.println("Introduce el nombre  del segundo fichero de origen:");		
		String fichero2 = sc.nextLine();
		System.out.println("Introduce el nombre de la ruta");
		String ruta = sc.nextLine();

		//2. Comprobar que el directorio existe
		File directorio = new File(ruta);

		//3. Comprobar que ficheros existen y crean el nuevo fichero
		if (directorio.isDirectory() && directorio.exists()) {
			//3.1 Creamos los objetos del tipo File
			File fichero1Prog = new File(directorio, fichero1);
			File fichero2Prog = new File(directorio, fichero2);

			String nombreNuevo = fichero1+"_"+fichero2;

			File ficheroNuevo = new File(directorio, nombreNuevo);

			//3.2  Comprobar que el fichero1 y fichero2 existen y son archivos
			if (fichero1Prog.exists() && fichero1Prog.isFile() && fichero2Prog.exists() && fichero2Prog.isFile()) {
				try {
					//3.3 Creamos el nuevo fichero
					if (!ficheroNuevo.exists()) {
						ficheroNuevo.createNewFile();
						//4. Abro fichero para lectura
						lecturaFicheros(fichero1Prog,ficheroNuevo);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("Los ficheros no existen o son directorios");
			}
		}else {
			System.out.println("El directorio introducido no existe");
		}
		sc.close();

	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("Seleccione una opcion del menu:");
			System.out.println("0. Salir del programa");
			System.out.println("1. Primos");
			System.out.println("2. Escribir y guardar");
			System.out.println("3. Num Aleatorios");
			System.out.println("4. Dos ficheros");
			System.out.println("42 ");
			System.out.println("5. ");
			System.out.println("6. ");
			System.out.println("***********");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				Ej1();
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:
				Ej4();
				break;
			case 42:

				break;
			case 5:

				break;
			case 6:

				break;
			case 0:
				System.out.println("Saliendo del programa.....");
				break;

			default:
				System.out.println("Opción no valida");
				break;
			}
		} while (opcion!=0);
		sc.close();
	}

}
