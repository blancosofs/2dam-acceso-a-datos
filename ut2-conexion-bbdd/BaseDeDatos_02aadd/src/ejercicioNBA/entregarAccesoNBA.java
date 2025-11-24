package ejercicioNBA;

import java.util.Scanner;

import java.sql.*;

public class entregarAccesoNBA {
	public static void visualizarJugadores(Connection conexion) {
		try {
			String consulta = "SELECT * FROM jugadores";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			// int numero = 1;
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int codigo = resultado.getInt("codigo");
				String Nombre = resultado.getString("Nombre");
				String Procedencia = resultado.getString("Procedencia");
				String Altura = resultado.getString("Altura");
				int Peso = resultado.getInt("Peso");
				String Posicion = resultado.getString("Posicion");
				String Nombre_equipo = resultado.getString("Nombre_equipo");
				System.out.println("codigo: " + codigo + ", Nombre: " + Nombre + ", Procedencia: " + Procedencia
						+ ", Altura: " + Altura + ", Peso: " + Peso + ", Posicion: " + Posicion + ", Nombre_equipo: "
						+ Nombre_equipo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void consultarDatosPorLetra(Connection conexion, String letra) {
		try {
			String consulta = "SELECT * FROM jugadores WHERE Nombre LIKE ?";

			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			// int numero = 1;
			sentencia.setString(1, letra + "%");

			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int codigo = resultado.getInt("codigo");
				String Nombre = resultado.getString("Nombre");
				String Procedencia = resultado.getString("Procedencia");
				String Altura = resultado.getString("Altura");
				int Peso = resultado.getInt("Peso");
				String Posicion = resultado.getString("Posicion");
				String Nombre_equipo = resultado.getString("Nombre_equipo");
				System.out.println("codigo: " + codigo + ", Nombre: " + Nombre + ", Procedencia: " + Procedencia
						+ ", Altura: " + Altura + ", Peso: " + Peso + ", Posicion: " + Posicion + ", Nombre_equipo: "
						+ Nombre_equipo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pesoMedio(Connection conexion) {
		try {
			String consulta = "SELECT avg(peso) FROM jugadores ";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				int avgPeso = resultado.getInt("avg(peso)");
				System.out.println("El peso medio de los jugadores es: " + avgPeso);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// tienes que hacer una lista con numeros, no tdo de golpe
	public static void listarEquipos(Connection conexion) {
		try {
			String consulta = "SELECT * FROM equipos";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();

			// Mostrar resultados
			while (resultado.next()) {
				String nombre = resultado.getString("Nombre");
				String ciudad = resultado.getString("Ciudad");
				String conferencia = resultado.getString("Conferencia");
				String division = resultado.getString("Division");
				System.out.println("Nombre del equipo: " + nombre + ", Ciudad: " + ciudad + ", Conferencia: "
						+ conferencia + ", Division: " + division);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void integrantes(Connection conexion, String NombreListar) {
		try {
			String consulta = "Select * from jugadores where Nombre_Equipo = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setString(1, NombreListar);
			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {
				int codigo = resultado.getInt("codigo");
				String Nombre = resultado.getString("Nombre");
				String Procedencia = resultado.getString("Procedencia");
				String Altura = resultado.getString("Altura");
				int Peso = resultado.getInt("Peso");
				String Posicion = resultado.getString("Posicion");
				String Nombre_equipo = resultado.getString("Nombre_equipo");
				System.out.println("Codigo jugador: " + codigo + ", Nombre: " + Nombre + ", Procedencia: " + Procedencia
						+ ", Altura: " + Altura + ", Peso: " + Peso + ", Posicion: " + Posicion
						+ ", Nombre del equipo: " + Nombre_equipo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Para obtener el codigo que no es AI SELECT codigo from jugadores order by
	 * codigo desc limit 1 select(max)codigo from jugadores
	 */
	public static int maxCodigoJugador(Connection conexion) {
		int maxCodigo = 0;
		try {
			String consulta = "SELECT codigo from jugadores order by codigo desc limit 1";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {
				maxCodigo = resultado.getInt("codigo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxCodigo;
	}

	public static void insertar(Connection conexion, int maxCodigo, String vjNombre) {
		try {
			String consulta = "INSERT INTO jugadores() values";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setInt(1, maxCodigo + 1);
			sentencia.setString(2, vjNombre);

			int lineas = sentencia.executeUpdate();

			if (lineas > 0) {
				System.out.println("Se han cambiado las lineas");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void insertar2(Connection conexion, int vjCodigo) {
		try {
			String consulta = "INSERT INTO jugadores(codigo) values(?)";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			
			sentencia.setInt(1, vjCodigo);
			int resultado = sentencia.executeUpdate();
			
			if (resultado>0) {
				System.out.println("funciona lol");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void borrarJugador(Connection conexion, int codigoBorrar) {
		
	}

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/nba";
		String usuario = "root";
		String password = "cfgs";
		// String password = "sopita666";
		try {
			// 1. Cargar el drive de la BD
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Crear conexion
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println("Se ha conectado a la base de datos");

			Scanner sc = new Scanner(System.in);
			int opc = 0;
			do {
				System.out.println();
				System.out.println("## ENTREGA: 31/10 ##");
				System.out.println("Elige que quieres consultar sobre los jugadores.....");
				System.out.println("1. Datos por letra");
				System.out.println("2. Peso medio general");
				System.out.println("3. Listar equipos, seleccionar num equipo y ver a sus integrantes");
				System.out.println("4. Insertar un jugador");
				System.out.println();
				System.out.println("0. Salir");
				opc = sc.nextInt();
				sc.nextLine(); // limpiar buffer por si acaso

				switch (opc) {
				case 1:
					System.out.println("1. Función que permite consultar todos los datos de los jugadores que\n"
							+ "empiecen por una letra");

					System.out.println("Introduzca la letra a buscar");
					String letra = sc.next();
					consultarDatosPorLetra(conexion, letra);
					break;
				case 2:
					System.out.println("2. El peso medio (general) de todos los jugadores");
					pesoMedio(conexion);
					break;
				case 3:
					System.out.println("3. Listando los equipos que nos permita seleccionar el número del equipo y\n"
							+ "podamos ver todos los integrantes del equipo seleccionado");

					listarEquipos(conexion);

					System.out.println("Introduce el nombre del euipo a buscar: ");
					String NombreListar = sc.next();

					integrantes(conexion, NombreListar);
					break;
				case 4:
					System.out.println("4. Insertar un jugador");
					System.out.println("Introduzca el codigo del jugador a insertar");
					int vjCodigo = sc.nextInt();
					//insertar(conexion, maxCodigoJugador(conexion), vjNombre);
					insertar2(conexion, vjCodigo);
					break;
				case 12:
					System.out.println("1.2 Borarr un jugador");
					System.out.println("Introduzca el codigo de jugador que quieres borrar");
					int codigoBorrar = sc.nextInt();
					borrarJugador(conexion, codigoBorrar);
					
					break;
				case 666:
					visualizarJugadores(conexion);
					break;
				case 0:
					System.out.println("Saliendo del programa.....");
					break;

				default:
					System.out.println("Opcion incorrecta! (es un int)");
					break;
				}

			} while (opc != 0);

			sc.close();
			conexion.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
