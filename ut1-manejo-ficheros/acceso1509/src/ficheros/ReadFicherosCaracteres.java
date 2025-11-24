package ficheros;
import java.io.*;


public class ReadFicherosCaracteres {

	public static void main(String[] args) {
		//Dentro del new file se pone la ruta del archivo o fichero
		File fichero = new File("FicheroEjemplo.txt"); 

		if(fichero.exists()) { 
			//******* puedes ver propiedades pero no leer ni escribir
			System.out.println("Nombre fichero....: "+fichero.getName());
			System.out.println("Ruta..............: "+fichero.getPath());
			System.out.println("Ruta absoluta.....: "+fichero.getAbsolutePath());
			System.out.println("Permiso lectura...: "+fichero.canRead());
			System.out.println("Tamaño............: "+fichero.length());
			//******* porque hay que capturar??? por algo de que es tu fichero 
			try {
				//Devuele caracter a caracter
				FileReader lector = new FileReader(fichero);
				//Lleno el buffer de los caracteres y leo lineas
				BufferedReader buffer = new BufferedReader(lector);
				String linea;
				while ((linea=buffer.readLine())!=null) {
					System.out.println(linea);
				}
				buffer.close();
			} catch (IOException e) {
				e.getMessage();
			}

		}
		else {
			System.out.println("No existe el fichero");
			try {
				fichero.createNewFile();
			} 
			catch (IOException io) {
				io.printStackTrace();
			}


		}

	}

}
