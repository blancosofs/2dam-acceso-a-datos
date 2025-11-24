package ejerciciosAccesoDirecto;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ej4 {
	private static int caracteresTitulo = 25;
	private static int caracteresAutor= 20;
	
	private static int tamanyoPosicion = (caracteresTitulo * 2) + (caracteresAutor * 2) + 8;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			File ficheroLibros = new File("libros.dat");
			ficheroLibros.createNewFile();
			RandomAccessFile raf = new RandomAccessFile(ficheroLibros, "rw");
			int opcion = 0;
			do {
				System.out.println("\n****Menu****");
				System.out.println("Selecione una de las siguientes opciones:");
				System.out.println("1. Insertar libros");
				System.out.println("2. Listar libros");
				System.out.println("3. Ordenar por precio");
				System.out.println("4. Filtrar por rango");
				System.out.println("0. Salir el programa");
				opcion = sc.nextInt();

				switch (opcion) {
				case 1:
					System.out.println("Vas a insertat un nuevo libro");
					System.out.println("Introduce un Titulo(string hasta 25)");
					String tituloCase1 = sc.nextLine();
					
					System.out.println("Introduce un Autor(string hasta 20)");
					String autorCase1 = sc.nextLine();
					
					System.out.println("Introduce un Precio(double)");
					double precioCase1 = sc.nextDouble();
					
					raf.seek(raf.length());
					
					raf.writeUTF(tituloCase1);
					raf.writeUTF(autorCase1);
					raf.writeDouble(precioCase1);


					System.out.println(
							"Titulo: " + tituloCase1 + "  , Autor:" + autorCase1 + "  , Precio:" + precioCase1);

					break;
				case 2:
					System.out.println("Vas a visualizar todos los libros");
				
					StringBuilder sbTitulo = new StringBuilder();

					for (int i = 0; i < caracteresTitulo; i++) {
						sbTitulo.append(raf.readChar());
					}

					String tituloCase2 = sbTitulo.toString().trim();
			
					StringBuilder sbAutor = new StringBuilder();

					for (int i = 0; i < caracteresAutor; i++) {
						sbAutor.append(raf.readChar());
					}

					String autorCase2 = sbTitulo.toString().trim();
			
					double precioCase2 = raf.readDouble();
					
					System.out.println("Titulo: " + tituloCase2 + " , Autor:  " + autorCase2 + " , Precio:  " + precioCase2);

				case 3:

					break;
				case 4:

					break;
				case 0:
					System.out.println("Saliendo del programa");
					break;

				default:
					System.out.println("Opcion no valida");
					break;
				}
			} while (opcion != 0);
			raf.close();
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
