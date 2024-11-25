package student_controller;

import student_service.Student_service;

public class Student_controller {

	public static void main(String[] args) throws Exception {
		Student_service ss = new Student_service();
		ss.insertdata();
		System.out.println("insert data is controlled");
	}

//   {
//    	    Student_service ss= new Student_service();
//		    ss.updatedata();
//	     	System.out.println("update data is controlled");
//     }

//    {
//    	Student_service ss= new Student_service();
//		ss.deletedata();
//		System.out.println("delete data is controlled");
//    }
}