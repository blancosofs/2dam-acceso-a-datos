package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/nba";
		String usuario = "root";
		String password = "cfgs";
		Scanner sc = new Scanner(System.in);
		try {
			// le ponemos el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// conexion a bbdd
			Connection conexion = DriverManager.getConnection(url, usuario, password);

			System.out.println("Introduzca la letra a buscar");
			String letra = sc.nextLine() + '%';

			String consulta = "SELECT * FROM jugadores WHERE Nombre LIKE ?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			// las interrogaciones son como arrays. como solo tienes una pues pones un 1 y
			// listo
			sentencia.setString(1, letra);

			// importante elegir la de query pque la otra no da error pero nos devuelve un
			// result que no un tipo de dato
			ResultSet resultado = sentencia.executeQuery();
			while (resultado.next()) {
				int vCodigo = resultado.getInt("codigo"); //tmb puede ser resultado.getInt(0);
				String vNombre = resultado.getString("Nombre");
				String vProcedencia = resultado.getString("Procedencia");
				String vAltura = resultado.getString("Altura");
				int vPeso = resultado.getInt("Peso");
				String vPosicion = resultado.getString("Posicion");
				String vNombre_equipo = resultado.getString("Nombre_equipo");
				System.out.println("codigo: " + vCodigo + ", Nombre: " + vNombre + ", Procedencia: " + vProcedencia
						+ ", Altura: " + vAltura + ", Peso: " + vPeso + ", Posicion: " + vPosicion + ", Nombre_equipo: "
						+ vNombre_equipo);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		sc.close();
	}
}
