package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	/** Módulo de conexão **/
	// Parâmetros de conexão
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://127.0.0.1/dbagenda?userTimezone=true&sereverTimezone=UTC";
	// "jdbc:postgresql://localhost/lpIII2021a?user=postgres&password=postgres"
	private String user = "postgres";
	private String password = "123456";

	// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Teste de conexão
	public void testeCon() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
