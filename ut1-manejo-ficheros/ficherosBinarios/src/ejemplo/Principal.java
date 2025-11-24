package ejemplo;

import java.io.*;
import java.util.ArrayList;

public class Principal {
	//principal utilidad
	public static void EscrituraPersonas(ArrayList<Persona> personas) {
		String fichero = "personas.dat";
		File ficheroEscritura = new File(fichero);

		if (!ficheroEscritura.exists()) {
			try {
				ficheroEscritura.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else  {
			//array solo en tiempo de ejecucion asi que con esto no le sacas objeto a objeto. sacas todos los objetos de golpe
			if (ficheroEscritura.isFile()) {
				try {
					//Lo abro para escritura y escribo un flujo de datos
					FileOutputStream  fos = new FileOutputStream(ficheroEscritura);
					//El tipo de dato que tiene que transformar es un objeto en bytes
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					//Escribe el array entero de personas
					oos.writeObject(personas);
					oos.close();

				} catch (IOException e) {
					e.printStackTrace();
				}

			}else {
				System.out.println("Fichero es directorio y no se puede escribir");
			}
		}
	}

	public static void LecturaPersonas() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personas.dat"));
			//
			ArrayList<Persona> personas = (ArrayList<Persona>) ois.readObject(); // ois.readObject(); te tira objeto y hay que castearlo
			System.out.println("Las personas almacenadas en el fichero son: ");
			for (Persona p : personas) {
				System.out.println(p);
			}

		} catch (IOException|ClassNotFoundException e) { //|ClassNotFoundException para el cast
			e.printStackTrace();
		}
	}

	//leer otro tipo de datos
	public static void EscrituraDatos() {
		File ficheroDatos = new File("datos.bin");
		try {
			if (!ficheroDatos.exists()) {
				ficheroDatos.createNewFile();
			}
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(ficheroDatos));
			//tienes que saber el orden escrito para poder recuperarlo
			dos.writeInt(2);
			dos.writeDouble(1.2);
			dos.writeBoolean(false);
			dos.writeUTF("Hola como vas?");
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void LecturaDatos() {
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream("datos.bin"));
			int entero = dis.readInt();
			double numero = dis.readDouble();
			boolean booleano = dis.readBoolean();
			String frase = dis.readUTF();
			
			System.out.println("Entero: "+entero+" Double: "+numero+" Booleano: "+booleano+" Frase: "+frase);

			dis.close();
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		ArrayList<Persona> personas = new ArrayList<>();
		personas.add(new Persona("n1", 20));
		personas.add(new Persona("n2", 21));
		personas.add(new Persona("n3", 22));

		EscrituraPersonas(personas);
		LecturaPersonas();
		
		EscrituraDatos();
		LecturaDatos();
	}

}
