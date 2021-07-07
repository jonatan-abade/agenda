package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.TaskBean;
import connection.SingleConnection;

public class TaskDao extends SingleConnection {
	private Connection connection;

	public TaskDao() {
		connection = SingleConnection.getConnection();
	}

	// Get all register in database
	public ArrayList<TaskBean> getAll() {
		ArrayList<TaskBean> tasks = new ArrayList<>();
		String sql = "select * from tasks";
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String title = rs.getString(2);
				String description = rs.getString(3);
				String status = rs.getString(4);
				tasks.add(new TaskBean(id, title, description, status));
			}
			return tasks;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// Create a new register in database
	public void create(TaskBean task) {
		try {
			String sql = "Insert into tasks (title, description, status) values (?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, task.getTitle());
			pst.setString(2, task.getDescription());
			pst.setString(3, task.getStatus());
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

	public void getTask(TaskBean task) {
		String sql = "select * from tasks where id = ?";
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, task.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				task.setId(rs.getInt(1));
				task.setTitle(rs.getString(2));
				task.setDescription(rs.getString(3));
				task.setStatus(rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void update(TaskBean task) {
		try {
			String sql = "update tasks set title=?, description=?, status=? where id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, task.getTitle());
			pst.setString(2, task.getDescription());
			pst.setString(3, task.getStatus());
			pst.setInt(4, task.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	public void delete(TaskBean task) {
		String sql = "delete from tasks where id = ?";
		try {
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, task.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
