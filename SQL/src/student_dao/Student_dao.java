package student_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Student_dao {
	public void insertdata() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tejas?useSSL=false", "root",
				"AartiInd@544");
		Statement s = c.createStatement();
		s.executeUpdate("insert into students values(5,'Dnyana',16)");
		System.out.println("dao");
		c.close();
	}

	public void updatedata() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tejas?useSSL=false", "root",
				"AartiInd@544");
		Statement s = c.createStatement();
		s.executeUpdate("update students set stud_age=10 where stud_id=1 ");
		System.out.println("data updated successfully");
		c.close();
	}

	public void deletedata() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tejas?useSSL=false", "root",
				"AartiInd@544");
		Statement s = c.createStatement();
		s.execute("delete from students where stud_id=5");
		System.out.println(" data is deleted");
		c.close();
	}

}