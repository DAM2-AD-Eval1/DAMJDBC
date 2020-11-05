package com.dam.jdbcmultiselect;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.stream.Stream;

public class LeerFichero {
	
	static String driver, ruta, usuario, password;
	
	public static void leerFichero(String gestor) throws IOException, ClassNotFoundException, SQLException {
		
		String dr = "driver" + gestor;
		String r = "ruta" + gestor;
		String usu = "usuario" + gestor;
		String pass= "password" + gestor;
		
		Path fichero = Paths.get("D:\\PRUEBAS\\gestores.properties");
		BufferedReader br = Files.newBufferedReader(fichero);
		Stream<String> lineas = br.lines();
		
		lineas.forEach(l -> {
			String[] valores = l.split(" ");
			if (valores[0].equals(dr))
				driver = valores[1];
			else if (valores[0].equals(r))
				ruta = valores[1];
			else if (valores[0].equals(usu))
				usuario = valores[1];
			else if (valores[0].equals(pass))
				password = valores[1];
			
		});
		
		SelectJDBC.conexionBD(driver, ruta, usuario, password);
		
	}

}
