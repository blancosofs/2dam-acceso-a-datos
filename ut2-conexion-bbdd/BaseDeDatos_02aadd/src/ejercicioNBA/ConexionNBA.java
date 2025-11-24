package ejercicioNBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ConexionNBA {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/nba";
		String usuario = "root";
		String password = "cfgs";
		
		try {
			Scanner sc = new Scanner(System.in);
			// 1. Cargar el drive de la BD
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Crear conexion
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println("Se ha conectado a la base de datos");

			// 3.2 crear un PreparedStatement (consulta especifica)
			String consulta = "Select * from jugadores where nombre like ?";
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			
			// 
			System.out.println("Introduce la letra a buscar");
			String letraBuscar = sc.next();
			sentencia.setString(1, letraBuscar + "%");

			ResultSet resultado = sentencia.executeQuery();

			while (resultado.next()) {
				int codigo = resultado.getInt("codigo");
				String nombre = resultado.getString("Nombre");
				String procedencia = resultado.getString("Procedencia");
				String altura = resultado.getString("Altura");
				int peso = resultado.getInt("Peso");
				String posicion = resultado.getString("Posicion");
				String nombre_equipo = resultado.getString("Nombre_equipo");
				
				System.out.println("Código: " + codigo + ", Nombre: " + nombre + ", Procedencia: " + procedencia
						+ ", Altura: " + altura + ", Peso: " + peso + ", Posicion: " + posicion + ", Nombre equipo: "
						+ nombre_equipo);
			}
			
			sc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
