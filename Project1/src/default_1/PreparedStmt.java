package default_1;

//use in MainPS

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStmt {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tejas";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "AartiInd@544";

	// Method to establish a connection
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
	}

	// Insert data method
	public void insertData() throws SQLException {
		Connection c = getConnection();
		String query = "INSERT INTO students (id, name) VALUES (?, ?)";
		try (PreparedStatement ps = c.prepareStatement(query)) {
			ps.setInt(1, 1); // Setting the 'id' parameter
			ps.setString(2, "Mauli"); // Setting the 'name' parameter
			ps.executeUpdate();
			System.out.println("Data inserted successfully.");
		} finally {
			c.close();
		}
	}

	// Update data method
	public void updateData() throws SQLException {
		Connection c = getConnection();
		String query = "UPDATE students SET name = ? WHERE id = ?";
		try (PreparedStatement ps = c.prepareStatement(query)) {
			ps.setString(1, "Maulik"); // Setting the 'name' parameter
			ps.setInt(2, 1); // Setting the 'id' parameter
			ps.executeUpdate();
			System.out.println("Data updated successfully.");
		} finally {
			c.close();
		}
	}

	// Delete data method
	public void deleteData() throws SQLException {
		Connection c = getConnection();
		String query = "DELETE FROM students WHERE id = ?";
		try (PreparedStatement ps = c.prepareStatement(query)) {
			ps.setInt(1, 1); // Setting the 'id' parameter
			ps.executeUpdate();
			System.out.println("Data deleted successfully.");
		} finally {
			c.close();
		}
	}

	// Fetch data method
	public void fetchData() throws SQLException {
		Connection c = getConnection();
		String query = "SELECT * FROM students";
		try (PreparedStatement ps = c.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
			}
		} finally {
			c.close();
		}
	}
}
