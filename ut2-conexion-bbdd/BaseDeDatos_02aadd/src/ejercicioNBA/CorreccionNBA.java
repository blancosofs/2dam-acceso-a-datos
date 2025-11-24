package ejercicioNBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CorreccionNBA {
	// otra forma de try/catch. te tira el error arriba y ya se gestionara
	// va arriba como dentro de la clae
	public static Connection ConexionBD(String url, String usuario, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, usuario, password);
	}

	/*-----------------------------------------------------------------------------*/
	/* 02.1 */
	/* ejercicio 1.1 */
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* ejercicio 1.2 */
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

	/* ejercicio 1.3 */
	public static void listarEquipos(Connection conexion) {
		ArrayList<String> opciones = new ArrayList<>();
		try {
			String consulta = "SELECT DISTINCT nombre_equipo FROM jugadores";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			ResultSet resultado = sentencia.executeQuery();
			int contador = 0;
			// Mostrar resultados
			while (resultado.next()) {
				String nombre_equipo = resultado.getString("nombre_equipo");
				contador++;
				System.out.println(contador + ". " + nombre_equipo + "");

				opciones.add(nombre_equipo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void integrantes(Connection conexion, int numE) {
		try {
			String consulta = "Select * from jugadores where Nombre_Equipo = ?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setInt(1, numE);
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

	/* ejercicio 1.4 */
	public static void insertarJugador(Connection conexion, int codigo, String nombre, String procedencia,
			String altura, int peso, String posicion, String nombre_equipo) {
		try {
			String consulta = "INSERT INTO jugadores VALUES (?,?,?,?,?,?,?)";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setInt(1, codigo);
			sentencia.setString(2, nombre);
			sentencia.setString(3, procedencia);
			sentencia.setString(4, altura);
			sentencia.setInt(5, peso);
			sentencia.setString(6, posicion);
			sentencia.setString(7, nombre_equipo);

			int resultado = sentencia.executeUpdate();

			if (resultado > 0) {

				System.out.println("---\nCodigo:" + codigo + " Nombre: " + nombre + " Procedencia: " + procedencia
						+ " Altura: " + altura + " Peso: " + peso + " Posición: " + posicion + " Nombre del equipo: "
						+ nombre_equipo + "\n-----");

			} else {

				System.out.println("No se pudo insertar el jugador");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*-----------------------------------------------------------------------------*/
	/* 02.2 */

	/* ejercicio 2.1 */
	public static void borrarJugador(Connection conexion, int codigoBorrar) {
		int lineas = 0;
		try {
			// no hay borrado en cascada por lo tanto necesito borrar a mano
			String consulta = "SELECT * FROM estadisticas where jugador=? ";
			PreparedStatement sentencia1 = conexion.prepareStatement(consulta);
			sentencia1.setInt(1, codigoBorrar);

			if (sentencia1.execute()) {
				String consultaBorradoEst = "DELETE FROM estadisticas WHERE jugador=?";
				PreparedStatement sentencia2 = conexion.prepareStatement(consultaBorradoEst);
				sentencia2.setInt(1, codigoBorrar);
				lineas = sentencia2.executeUpdate();
			}
			if (lineas > 0) {
				System.out.println("Se han borrado todas las estadisticas");
			}

			/* BORRADO */ // primero mira que la sentencia sql funciona
			String consultaBorrado = "DELETE FROM jugadores WHERE codigo=?";
			PreparedStatement sentencia3 = conexion.prepareStatement(consultaBorrado);
			sentencia3.setInt(1, codigoBorrar);
			lineas = sentencia3.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* Ejercicio 2.2 */
	public static void insertarJugadorEquipo(Connection conexion, int codigoE, String nombreE, String procedenciaE,
			String alturaE, int pesoE, String posicionE, int numEquipoFichar) {
		try {
			String consulta = "INSERT INTO jugadores VALUES (?,?,?,?,?,?,?)";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);

			sentencia.setInt(1, codigoE);
			sentencia.setString(2, nombreE);
			sentencia.setString(3, procedenciaE);
			sentencia.setString(4, alturaE);
			sentencia.setInt(5, pesoE);
			sentencia.setString(6, posicionE);
			sentencia.setInt(7, numEquipoFichar);

			int resultado = sentencia.executeUpdate();

			if (resultado > 0) {

				System.out.println("---\nCodigo:" + codigoE + " Nombre: " + nombreE + " Procedencia: " + procedenciaE
						+ " Altura: " + alturaE + " Peso: " + pesoE + " Posición: " + posicionE + " Nombre del equipo: "
						+ numEquipoFichar + "\n-----");

			} else {

				System.out.println("No se pudo insertar el jugador");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* Ejercicio 2.3 */

	/* Ejercicio 2.4 */
	

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/nba";
		String usuario = "root";
		String password = "cfgs";
		// String password = "sopita666";

		try (Connection conexion = ConexionBD(url, usuario, password)) {
			Scanner sc = new Scanner(System.in);
			int opc = 0;
			do {
				System.out.println();
				System.out.println("## CORRECCION CLASE ##");
				System.out.println("Elige que quieres consultar sobre los jugadores.....");
				System.out.println("11. Datos por letra");
				System.out.println("12. Peso medio general");
				System.out.println("13. Listar equipos, seleccionar num equipo y ver a sus integrantes");
				System.out.println("14. Insertar un jugador");
				System.out.println("-----------------------------------------------------------------");
				System.out.println("21. Borrar jugador por codigo");
				System.out.println("22. Fichar");
				System.out.println("23. Insertar partido");
				System.out.println("24. Estadisticas por num de equipo");
				System.out.println("-----------------------------------------------------------------");
				System.out.println("666. Visualizar jugadores");
				System.out.println("0. Salir");
				opc = sc.nextInt();
				sc.nextLine(); // limpiar buffer por si acaso

				switch (opc) {
				case 11:
					System.out.println("1.1. Función que permite consultar todos los datos de los jugadores que\n"
							+ "empiecen por una letra");

					System.out.println("Introduzca la letra a buscar");
					String letra = sc.next();
					consultarDatosPorLetra(conexion, letra);
					break;
				case 12:
					System.out.println("1.2. El peso medio (general) de todos los jugadores");
					pesoMedio(conexion);
					break;
				case 13:
					System.out.println("1.3. Listando los equipos que nos permita seleccionar el número del equipo y\n"
							+ "podamos ver todos los integrantes del equipo seleccionado");
					listarEquipos(conexion);
					System.out.println("Introduce el numero del equipo a buscar: ");
					int numE = sc.nextInt();
					integrantes(conexion, numE);
					break;
				case 14:
					System.out.println("1.4. Insertar un jugador");
					System.out.println("Introduzca los siguientes datos:");
					System.out.println("Codigo: ");
					int codigo = sc.nextInt();
					System.out.println("Nombre: ");
					String nombre = sc.nextLine();
					System.out.println("Procedencia: ");
					String procedencia = sc.nextLine();
					System.out.println("Altura: ");
					String altura = sc.nextLine();
					System.out.println("Peso: ");
					int peso = sc.nextInt();
					System.out.println("Posicion: ");
					String posicion = sc.nextLine();
					System.out.println("Nombre de su equipo: ");
					String nombre_equipo = sc.nextLine();

					insertarJugador(conexion, codigo, nombre, procedencia, altura, peso, posicion, nombre_equipo);

					break;
				case 21:
					System.out.println("2.1 Borarr un jugador");
					System.out.println("Introduzca el codigo de jugador que quieres borrar");
					int codigoBorrar = sc.nextInt();
					borrarJugador(conexion, codigoBorrar);

					break;
				case 22:
					System.out.println(
							"2.2 Fichar un jugador en un equipo, los equipos aparecen en una lista donde el\r\n"
									+ "usuario inserta el número de equipo controlado y de ahí se inserta en la base\r\n"
									+ "de datos");
					listarEquipos(conexion);
					System.out.println("Introduzca el num del equipo que va a fichar un jugador");
					int numEquipoFichar = sc.nextInt();
					System.out.println("-- Introduzca los datos del jugador a fichar --");
					System.out.println("En este orden: Codigo, nombre, procedencia, altura, peso, posicion");
					int codigoE = sc.nextInt();
					String nombreE = sc.nextLine();
					String procedenciaE = sc.nextLine();
					String alturaE = sc.nextLine();
					int pesoE = sc.nextInt();
					String posicionE = sc.nextLine();
					insertarJugadorEquipo(conexion, codigoE, nombreE, procedenciaE, alturaE, pesoE, posicionE,
							numEquipoFichar);
					break;
				case 23:
					System.out.println(
							"2.3. Insertar un partido utilizando parte de la funcionalidad anterior para no tener\r\n"
									+ "que insertar los nombres de los jugadores");
					System.err.println("AVISO!! FALTA POR IMPLEMENTAR");
					break;
				case 24:
					System.out.println("2.4. Dado un equipo por número (como el procedimiento anterior) conocer las\r\n"
							+ "estadísticas de todos sus jugadores");
					listarEquipos(conexion);
					System.out.println("Introduzca el num del equipo del que se quiere saber sus estadisticas");
					int numEquipoEstadisticas = sc.nextInt();
					System.err.println("AVISO!! FALTA POR IMPLEMENTAR");
					break;
				case 666:
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

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
