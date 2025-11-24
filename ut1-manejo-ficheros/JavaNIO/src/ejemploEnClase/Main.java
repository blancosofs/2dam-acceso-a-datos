package ejemploEnClase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class Main {
	/* Lectura con la clase Files de Java.NIO */
	public static void LeerFiles() {
		// parametros URL o ruta
		Path ruta = Paths.get("planetas (1).txt");
		try {
			// Leo todo el contenido del fichero 
			String contenido = Files.readString(ruta);
			System.out.println(contenido);
			System.out.println("--------------------");

			// Leer linea por linea de un fichero 
			List<String> listaContenido = Files.readAllLines(ruta);
			for (String linea : listaContenido) {
				System.out.println("linea: " + linea);
			}
		} catch (IOException e) {
			e.getMessage();
		}
	}
	/* Escritura con la clase Files de Java.NIO */
	public static void EscrituraFiles() {
		Path ruta = Paths.get("FicheroEscritura.txt");
		try {
			String contenido = "Hola esta es mi primera escritura";
			// (StandardCharsets.UTF_8) traduce a bytes, es para que te lo tire bien (spuede obviar pero mejor q no)
			Files.write(ruta, contenido.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.WRITE); //***********
//APPEND ES PARA AÑADI, AHORA LO ESTAMOS SOBREESCRIBIENDO
		} catch (IOException e) {
			e.printStackTrace();;
		}
	}
	/* Copiar con la clase Files de Java.NIO */
	public static void Copiar() {
		Path rutaOrigen = Paths.get("FicheroEscritura.txt");
		Path rutaDestino = Paths.get("FicheroCopia.txt");
		try {
			Files.copy(rutaOrigen, rutaDestino, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*Lista los contenidos de un directorio*/
	public static void listarContenidos() {
		//Path.of = Path.get
		Path directorio = Path.of(".");
		try {
			Stream<Path> flujo = Files.list(directorio);
			flujo.forEach(archivo-> System.out.println(archivo.getFileName())); //esto es como un for each de forma corta(archivo:flujo y es sysout dentro)
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* Lee las propiedades de un archivo */
	public static void PropiedadesFichero() {
		Path ruta = Path.of("primos.txt");
		System.out.println("Fichero existe: "+Files.exists(ruta));
		
		System.out.println("Fichero es directorio: "+Files.isDirectory(ruta));
	}
	
	/*Borra un archivo*/
	public static void BorrarFichero() {
		Path ruta = Path.of("FicheroCopia.txt");
		try {
			Files.deleteIfExists(ruta);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		//LeerFiles();
		//EscrituraFiles();
		//Copiar();
		//listarContenidos();
		BorrarFichero();
	}

}
