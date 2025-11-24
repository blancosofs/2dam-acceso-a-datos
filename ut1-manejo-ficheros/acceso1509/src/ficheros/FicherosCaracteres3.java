package ficheros;
import java.io.*;


public class FicherosCaracteres3 {

	public static void main(String[] args) {
		File fichero = new File("FicheroEjemplo.txt"); 

		if(!fichero.exists()) { 
			try {
				//Crear el ficherp
				fichero.createNewFile();
				
				System.out.println("Nombre fichero....: "+fichero.getName());
				System.out.println("Ruta..............: "+fichero.getPath());
				System.out.println("Ruta absoluta.....: "+fichero.getAbsolutePath());
				System.out.println("Permiso lectura...: "+fichero.canRead());
				System.out.println("Tamaño............: "+fichero.length());
				
				FileWriter escritura = new FileWriter(fichero); //abres por escritura y con buff
				BufferedWriter pw = new BufferedWriter(escritura); // ya lo puedes escribir
				//********* en estas dos llamadas lo bloqueas?? --> estas en modo lectura
				
				for(int i=0; i < 10; i++) {
					pw.write("Linea: "+i); 
					pw.newLine();
					//pw.write(i); *************pque no?
				}
				pw.close(); //******* lo liberas. --> antes estabas en lectura y ahora en escritura
				
				//Devuele caracter a caracter
				FileReader lector = new FileReader(fichero);
				//Lleno el buffer de los caracteres y leo lineas
				BufferedReader buffer = new BufferedReader(lector);
				String linea;
				while ((linea=buffer.readLine())!=null) {
					System.out.println(linea);
				}
				lector.close(); //hay que cerrar, en la lectura no pasa nada pque no lo estas bloqueando
				
				}
			catch (IOException e) {
				e.getMessage();
			}
			
		}
	
	}

}
