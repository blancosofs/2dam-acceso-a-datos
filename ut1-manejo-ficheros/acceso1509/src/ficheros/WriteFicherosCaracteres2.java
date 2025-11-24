package ficheros;
import java.io.*;


public class WriteFicherosCaracteres2 {

	public static void main(String[] args) {
		File fichero = new File("FicheroEjemplo.txt"); 

		if(!fichero.exists()) { 
			try {
				//Crear el ficherp
				fichero.createNewFile();
			}
			catch (IOException e) {
				e.getMessage();
			}

		}else {
			System.out.println("Nombre fichero....: "+fichero.getName());
			System.out.println("Ruta..............: "+fichero.getPath());
			System.out.println("Ruta absoluta.....: "+fichero.getAbsolutePath());
			System.out.println("Permiso lectura...: "+fichero.canRead());
			System.out.println("Tamaño............: "+fichero.length());
			try {
				//FileWriter escritura = new FileWriter(fichero); 
				BufferedWriter pw = new BufferedWriter(new FileWriter(fichero,true));  //true para no sobreescribir. no lo machaca si no que va escribiendo debajo

				for(int i=0; i < 10; i++) {
					pw.write("Linea: "+i); 
					pw.newLine();
				}
				pw.close();

				FileReader lector = new FileReader(fichero);
				BufferedReader buffer = new BufferedReader(lector);

				String linea;
				while ((linea=buffer.readLine())!=null) {
					System.out.println(linea);
				}
				lector.close();

			}catch (IOException e) {
				e.printStackTrace();

			}finally {
				System.out.println("Adios");
			}
		}




	}

}
