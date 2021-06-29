package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.ContactBean;
import connection.SingleConnection;

public class ContactDao {
	private Connection connection;

	public ContactDao() {
		connection = SingleConnection.getConnection();
	}

	// Create
	public void create(ContactBean contact) {
		String insert = "Insert into contacts (name, phone, email) values (?, ?, ?)";
		try {
			PreparedStatement pst = connection.prepareStatement(insert);
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getPhone());
			pst.setString(3, contact.getEmail());
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Get all
	public ArrayList<ContactBean> getAll() {
		ArrayList<ContactBean> contacts = new ArrayList<>();
		String selectAll = "select * from contacts order by name";
		try {
			PreparedStatement pst = connection.prepareStatement(selectAll);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				contacts.add(new ContactBean(id, name, phone, email));
			}
			return contacts;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void getContact(ContactBean contact) {
		String getContactQuery = "select * from contacts where id = ?";
		try {
			PreparedStatement pst = connection.prepareStatement(getContactQuery);
			pst.setInt(1, contact.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contact.setId(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setPhone(rs.getString(3));
				contact.setEmail(rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void update(ContactBean contact) {
		String sql = "update contacts set name=?, phone=?, email=? where id = ?";
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getPhone());
			pst.setString(3, contact.getEmail());
			pst.setInt(4, contact.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void delete(ContactBean contact) {
		String sql = "delete from contacts where id = ?";
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, contact.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
