package default_1;

//use in MainMethod

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

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
		Statement s = c.createStatement();
		s.executeUpdate("INSERT INTO students (id, name) VALUES (1, 'Mauli')");
		System.out.println("Data inserted successfully.");
		s.close();
		c.close();
	}

	// Update data method
	public void updateData() throws SQLException {
		Connection c = getConnection();
		Statement s = c.createStatement();
		s.executeUpdate("UPDATE students SET name='Maulik' WHERE id=1");
		System.out.println("Data updated successfully.");
		s.close();
		c.close();
	}

	// Delete data method
	public void deleteData() throws SQLException {
		Connection c = getConnection();
		Statement s = c.createStatement();
		s.executeUpdate("DELETE FROM students WHERE id=1");
		System.out.println("Data deleted successfully.");
		s.close();
		c.close();
	}

	// Fetch data method
	public void fetchData() throws SQLException {
		Connection c = getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM students");
		while (rs.next()) {
			System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
		}
		rs.close();
		s.close();
		c.close();
	}
}
