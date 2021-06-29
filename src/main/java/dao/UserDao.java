package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;

public class UserDao {
	private Connection connection;

	public UserDao() {
		connection = SingleConnection.getConnection();
	}

	public boolean login(String email, String password) throws Exception {
		String sql = "select * from users where email = '" + email + "' and password ='" + password + "'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}

}
