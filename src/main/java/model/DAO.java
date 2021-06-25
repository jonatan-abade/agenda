package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

	//Create
	public void create(JavaBeans contato) {
		String insert = "Insert into contatos (nome, fone, email) values (?, ?, ?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
