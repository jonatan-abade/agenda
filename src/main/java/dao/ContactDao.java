package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.ContactBean;

public class ContactDao {
	/** Módulo de conexão **/
	// Parâmetros de conexão
	private String driver = "org.postgresql.Driver";
	// private String url =
	private String url = "jdbc:postgresql://127.0.0.1:5432/dbagenda?userTimezone=true&sereverTimezone=UTC";

	private String user = "postgres";
	private String password = "123456";

	// Método de conexão
	private Connection conect() {
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

	// Create
	public void create(ContactBean contact) {
		String insert = "Insert into contacts (name, phone, email) values (?, ?, ?)";
		try {
			Connection con = conect();
			PreparedStatement pst = con.prepareStatement(insert);
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getPhone());
			pst.setString(3, contact.getEmail());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Get all
	public ArrayList<ContactBean> getAll() {
		ArrayList<ContactBean> contacts = new ArrayList<>();
		String selectAll = "select * from contacts order by name";
		try {
			Connection con = conect();
			PreparedStatement pst = con.prepareStatement(selectAll);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				contacts.add(new ContactBean(id, name, phone, email));
			}
			con.close();
			return contacts;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void getContact(ContactBean contact) {
		String getContactQuery = "select * from contacts where id = ?";
		try {
			Connection con = conect();
			PreparedStatement pst = con.prepareStatement(getContactQuery);
			pst.setInt(1, contact.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contact.setId(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setPhone(rs.getString(3));
				contact.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void update(ContactBean contact) {
		String sql = "update contacts set name=?, phone=?, email=? where id = ?";
		try {
			Connection con = conect();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getPhone());
			pst.setString(3, contact.getEmail());
			pst.setInt(4, contact.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void delete(ContactBean contact) {
		String sql = "delete from contacts where id = ?";
		try {
			Connection con = conect();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, contact.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
