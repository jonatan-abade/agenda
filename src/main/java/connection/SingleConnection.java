package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://127.0.0.1:5433/dbagenda?userTimezone=true&sereverTimezone=UTC";
	private static String user = "postgres";
	private static String password = "postgres";
	private static Connection connection = null;

	static {
		conect();
	}

	private static void conect() {
		try {
			if (connection == null) {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao conectar com o banco de dados");
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
