package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.UserBean;
import connection.SingleConnection;

public class UserDao extends SingleConnection {
	private Connection connection;

	public UserDao() {
		connection = SingleConnection.getConnection();
	}

	public boolean login(String email, String password) throws Exception {
		String sql = "select * from users where email = ? and password = ?";
		PreparedStatement pst = this.connection.prepareStatement(sql);
		try {
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet resultSet = pst.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	// Get all register in database
	public ArrayList<UserBean> getAll() {
		ArrayList<UserBean> users = new ArrayList<>();
		String sql = "select * from users order by name";
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				users.add(new UserBean(id, name, email, null));
			}
			return users;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Create a new register in database
	public void create(UserBean user) {
		try {
			String sql = "Insert into users (name, email, password) values (?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			pst.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public UserBean getUserByEmail(String emailParam) {
		try {
			String sql = "select * from users where email = ? LIMIT 1";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, emailParam);
			ResultSet rs = pst.executeQuery();
			UserBean user = new UserBean(null, null, null, null);
			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
			}
			return user;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public void getUser(UserBean user) {
		String sql = "select * from users where id = ?";
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, user.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void update(UserBean user) {
		try {
			String sql = "update users set name=?, email=?, password=? where id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			pst.setInt(4, user.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	public void delete(UserBean user) {
		String sql = "delete from users where id = ?";
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, user.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
