package com.dam.jdbcmultiselect;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

		Scanner scan = new Scanner(System.in);
		int opcion = -1;

		while (opcion!=3) {

			System.out.println("ELIGE UNA OPCIÓN:");
			System.out.println("1. MySQL");
			System.out.println("2. PostgreSQL");
			System.out.println("3. Salir");
			opcion = scan.nextInt();

			switch (opcion) {
			case 1:
                LeerFichero.leerFichero("MySQL");
				break;

			case 2:
                LeerFichero.leerFichero("Postgres");
				break;

			case 3:

				break;

			default:
				break;
			}
		}

	}

}
