package default_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JEE1 {

	public static void main(String[] args) throws Exception {
		// Register JDBC driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Establish connection to the MySQL database
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tejas", "root", "AartiInd@544");

		// Create a statement object to execute queries
		Statement s = c.createStatement();

		// Insert data into the students table
		s.executeUpdate("INSERT INTO students VALUES(1, 'Mauli')");

		// Print success message
		System.out.println("Data inserted successfully.");

		// Execute a SELECT query to fetch all rows from the students table
		ResultSet rs = s.executeQuery("SELECT * FROM students");

		// Print the results from the SELECT query
		while (rs.next()) {
			System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
		}

		// Close resources..
		rs.close();
		s.close();
		c.close();
	}
}
