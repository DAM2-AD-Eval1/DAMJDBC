package com.dam.jdbcmultiselect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectJDBC {

	public static void conexionBD(String driver, String ruta, String usuario, String password) throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);
		
		Connection conexion = DriverManager.getConnection(ruta, usuario, password);
		
		//3. Creación del statement
		Statement consulta = conexion.createStatement();
		
		//4. Ejecutamos el statement
		ResultSet resultados = consulta.executeQuery("SELECT * FROM actor");
		
		//5. Mostramos los resultados
		while(resultados.next())
			System.out.println(resultados.getInt(1) + ", " + resultados.getString(2) + ", " +
		                       resultados.getString(3) + ", " + resultados.getTimestamp(4));

		//6. Cerramos los objetos
		resultados.close();
		consulta.close();
		conexion.close();
	}

}
