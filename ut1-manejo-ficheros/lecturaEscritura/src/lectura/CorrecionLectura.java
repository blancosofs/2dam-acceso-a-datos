package lectura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorrecionLectura {
	public static void visualizar(ArrayList<String> palabra, ArrayList<Integer> veces) {
		int i = 0;
		while (i < palabra.size()) {
			System.out.println(palabra.get(i) + ": " + veces.get(i));
		}
		i++;
	}

	public static void lecturaEj4() {
		ArrayList<String> palabra = new ArrayList<>();
		ArrayList<Integer> veces = new ArrayList<>();

		try (BufferedReader ficheroFrutas = new BufferedReader(new FileReader("frutas.txt"))) {
			String linea;
			while ((linea = ficheroFrutas.readLine()) != null) {
				// En cada linea tenemos una palabra, igualar todas las palabras independiente
				// de como esten
				String fruta = linea.trim().toLowerCase();

				// Si existe devuelve la posicion, si no devuelve -1
				int indice = palabra.indexOf(fruta);

				if (indice == -1) {
					// primera vez que encuentro una palabra
					palabra.add(fruta);
					veces.add(1);
				} else {
					// palabra esta en el array e incremento las vecs que
					int cantidad = veces.get(indice) + 1;
					veces.set(indice, cantidad);
				}

			}
			visualizar(palabra, veces);
		} catch (IOException e) {

		}

	}

	public static void lecturaEj1() {
		try (FileReader fichero = new FileReader("FicheroEjemploEj1.txt")) {
			int caracter;
			while ((caracter = fichero.read()) != -1) {
				if (caracter != 32) {
					System.out.print((char) caracter);
				}
			}
		} catch (Exception e) {

		}
	}

	public static void lecturaEj2() {
		String texto = "Texto para pasar la expresion regular";
		texto = texto.toLowerCase();
		// expresion regular, crear un patron a algo que estas buscando
		Pattern patron = Pattern.compile("[aeiou]");
		Matcher match = patron.matcher(texto); // una clase para buscar dentr de un pattern

		int aes = 0, es = 0, ies = 0, oes = 0, ues = 0;

		while (match.find()) {
			String letra = match.group();
			System.out.println(letra + "****");
			if (letra == "a") {
				aes++;
			}
			if (letra == "e") {
				es++;
			}
			if (letra == "i") {
				ies++;
			}
			if (letra == "o") {
				oes++;
			}
			if (letra == "u") {
				ues++;
			}
		}
		System.out.println("A: " + aes + "E: " + es + "I: " + ies + "O: " + oes + "U: " + ues); // match.group() Returns
		// the input subsequence
		// matched by the
		// previous match.
	}

	public static void lecturaEj22() {
		int total = 0;
		int vocales = 0;
		Pattern patron = Pattern.compile("[aeiouAEIOU]");
		try (BufferedReader bf = new BufferedReader(new FileReader("FicheroEjemploEj1.txt"))) {
			String linea;
			while ((linea = bf.readLine()) != null) {
				total += linea.length();
				Matcher match = patron.matcher(linea);
				while (match.find()) {
					vocales++;
				}
			}
			System.out.println("Total caracteres: " + total + " vocales: " + vocales);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void lecturaEj3() {
		try (BufferedReader br = new BufferedReader(new FileReader("Restaurants (1).csv"));) {
			String linea = br.readLine();
			String[] encabezados;
			// Primera lectura para leer los encabezados
			linea = br.readLine();
			encabezados = linea.split(",");

			//con indexOf y substring
			while ((linea = br.readLine()) != null) {
				// Caso estandar
				String[] partes = linea.split(",");
				for (int i = 0; i < encabezados.length; i++) {
					System.out.println("-" + encabezados[i] + ": "+partes[i]);
				}
				System.out.println("--------------");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			System.out.println();
			System.out.println("Seleccione una opcion del menu:");
			System.out.println("0. Salir");
			System.out.println("1. Fichero a mano, mostrar sin espacios");
			System.out.println("2. Contar caracteres y vocales");
			System.out.println("22. pt2 Contar caracteres y vocales");
			System.out.println("3. Restaurante");
			System.out.println("4. Frutas");
			System.out.println("5. Planetas");
			System.out.println("***********");
			System.out.println();
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				lecturaEj1();
				break;
			case 2:
				lecturaEj2();
				break;
			case 22:
				lecturaEj22();
				break;
			case 3:
				lecturaEj3();
				break;
			case 4:
				lecturaEj4();
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
		} while (opcion != 0);
		sc.close();

	}

}
