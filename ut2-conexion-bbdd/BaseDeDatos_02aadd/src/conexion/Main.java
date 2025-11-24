package conexion;
import java.sql.*;

public class Main {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/mydb"; // lo ultimo es el nombre de tu bbdd
		String usuario = "root";
		String password = "cfgs";

		try {
			/* 1. Cargar el drive de a BD */
			Class.forName("com.mysql.cj.jdbc.Driver");

			/* 2. Crear la conexion */
			Connection conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println("Se ha conectado con éxito a la base de datos");

			/* 3. Crear un statement 
			Statement sentencia = conexion.createStatement();
			String consulta = "select*form usuario";
			ResultSet resultado = sentencia.executeQuery(consulta);
			*/
			
			/* 3. Crear un statement 2*/
			Statement sentencia = conexion.createStatement();
			String consulta = "select*form usuario where idUSUARIO=1 or 1=1";
			ResultSet resultado = sentencia.executeQuery(consulta);


			/* 4. Mostrar resultados */
			while (resultado.next()) { //devuelve true hasta que sea null
				int idUSUARIO = resultado.getInt("idUSUARIO");
				String nombre = resultado.getString("nombre");
				Date fecha = resultado.getDate("fecha");
				String genero = resultado.getString("genero");
				System.out.println("IdUsuario: "+idUSUARIO+", Nombre: "+nombre+", FechaNacimiento: "+fecha+", Genero: "+genero);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
