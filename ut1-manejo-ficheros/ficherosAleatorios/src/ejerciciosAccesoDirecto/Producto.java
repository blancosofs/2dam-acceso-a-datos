package ejerciciosAccesoDirecto;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;


public class Producto {
	int id ;
	int cantStock;
	double precio;

	public Producto() {

	}

	public Producto(int id, int cantStock, double precio) {
		super();
		this.id = id;
		this.cantStock = cantStock;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantStock() {
		return cantStock;
	}

	public void setCantStock(int cantStock) {
		this.cantStock = cantStock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id:").append(getId()).append(" , ");
		sb.append("Cantidad Stock:").append(getId()).append(" , ");
		sb.append("Precio:").append(getId()).append(" , ");
		return sb.toString();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			File ficheroProductos = new File("productos.dat");
			ficheroProductos.createNewFile();
			RandomAccessFile raf = new RandomAccessFile(ficheroProductos, "rw");

			ArrayList<Producto> arrayList= new ArrayList<Producto>();

			int opcion=0;
			do {
				System.out.println("****Menu****");
				System.out.println("Selecione una de las siguientes opciones:");
				System.out.println("1. Almacenar productos");
				System.out.println("2. Visualizar productos (la lista entera)");
				System.out.println("3. Visualizar los datos de un producto concreto basado en su ID");
				System.out.println("4. Borrar productos dado un ID");
				System.out.println("5. Modificar los campos de un producto (Cantidad y precio)");
				System.out.println("0. Salir el programa");
				opcion = sc.nextInt();

				switch (opcion) {
				case 1:
					System.out.println("Vas a almacenar un nuevo producto");
					System.out.println("Introduce un ID(int)");
					//id = sc.nextInt();
					System.out.println("Introduce una Cantidad en stock(int)");
					//cantStock= sc.nextInt();
					System.out.println("Introduce un Precio(double)");
					//precio= sc.nextDouble();
					break;
				case 2:
					/*for () {

					}
					 */
					break;
				case 3:
		
					break;
				case 4:


					break;
				case 5:


					break;
				case 0:
					System.out.println("Saliendo del programa");
					break;

				default:
					System.out.println("Opcion no valida");
					break;
				}
			}while(opcion!=0);
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
