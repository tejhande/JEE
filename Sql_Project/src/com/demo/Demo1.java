package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo1 {

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
		String query = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
		try (PreparedStatement ps = c.prepareStatement(query)) {
			System.out.println("Inserting Data into table");

			// Get input from user
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter id: ");
			int id = scanner.nextInt();
			System.out.print("Enter name: ");
			String name = scanner.next();
			System.out.print("Enter age: ");
			int age = scanner.nextInt(); // Prompting for age

			// Set parameters
			ps.setInt(1, id); // Setting the 'id' parameter
			ps.setString(2, name); // Setting the 'name' parameter
			ps.setInt(3, age); // Setting the 'age' parameter

			ps.executeUpdate(); // Execute the insert
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
			System.out.println("Updating Data in table");

			// Use scanner to take input
			Scanner mScanner = new Scanner(System.in);
			System.out.print("Enter name: ");
			String name = mScanner.nextLine();
			System.out.print("Enter id: ");
			int id = mScanner.nextInt();

			ps.setString(1, name); // Setting the 'name' parameter
			ps.setInt(2, id); // Setting the 'id' parameter

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
			System.out.println("Deleting Data from table");

			Scanner mScanner = new Scanner(System.in);
			System.out.print("Enter id: ");
			int id = mScanner.nextInt();
			ps.setInt(1, id); // Setting the 'id' parameter

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
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age"); // Fetching age as well
				System.out.println(id + " - " + name + " - " + age); // Print id, name, and age
			}
		} finally {
			c.close();
		}
	}

	public static void main(String[] args) throws SQLException {
		Demo1 ps = new Demo1();
		Scanner mScanner = new Scanner(System.in);

		boolean keepRunning = true;

		// Main loop to keep the program running until the user exits
		while (keepRunning) {
			System.out.println("\nEnter Your Choice:");
			System.out.println("1- Insert Data");
			System.out.println("2- Update Data");
			System.out.println("3- Delete Data");
			System.out.println("4- Fetch Data");
			System.out.println("5- Exit");
			System.out.println("Select an option:");

			int userInput = mScanner.nextInt();

			// Using switch case for operations
			switch (userInput) {
			case 1:
				ps.insertData();
				break;
			case 2:
				ps.updateData();
				break;
			case 3:
				ps.deleteData();
				break;
			case 4:
				ps.fetchData();
				break;
			case 5:
				System.out.println("Exiting the program.");
				keepRunning = false; // Exit the loop if user chooses 5
				break;
			default:
				System.out.println("Invalid input. Please try again.");
			}
		}

		// Closing the scanner after the operations are complete
		mScanner.close();
	}
}
