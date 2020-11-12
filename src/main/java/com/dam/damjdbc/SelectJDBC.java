package com.dam.damjdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1. Registrar el driver MySQL
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Registrar el driver PostgreSQL
		//Class.forName("org.postgresql.Driver");
		
		//2. Obtenemos la conexión para MySQL
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sakila?serverTimezone=Europe/Madrid", "root", "1234.Abcd");
		//Obtenemos una conexión para PostgreSQL
		//Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost/sakila", "postgres", "1234.Abcd");
		
		//3. Creación del statement
		//Statement consulta = conexion.createStatement();
		//3.1. Creación del CallableStatement
		String llamada = "{ call quitar_apellido (?) }";
		CallableStatement consulta = conexion.prepareCall(llamada); 
		consulta.setInt(1, 211);
		
		//4. Ejecutamos el statement
		//ResultSet resultados = consulta.executeQuery("SELECT * FROM actor");
		//4.1. Ejecutar CallableStatement
		consulta.executeUpdate();
		
		//5. Mostramos los resultados
		//while(resultados.next())
		//	System.out.println(resultados.getInt(1) + ", " + resultados.getString(2) + ", " +
		//                       resultados.getString(3) + ", " + resultados.getTimestamp(4));

		//6. Cerramos los objetos
		//resultados.close();
		consulta.close();
		conexion.close();
	}

}
