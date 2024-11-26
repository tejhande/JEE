package student_service;

import student_dao.Student_dao;

public class Student_service {
	public void insertdata() throws Exception {
		Student_dao sd = new Student_dao();
		sd.insertdata();
		System.out.println(" data inserted successfully");
	}

	public void updatedata() throws Exception {
		Student_dao sd = new Student_dao();
		sd.updatedata();
		System.out.println(" data updated successfully");
	}

	public void deletedata() throws Exception {
		Student_dao sd = new Student_dao();
		sd.deletedata();
		System.out.println(" data deleted successfully");
	}

}