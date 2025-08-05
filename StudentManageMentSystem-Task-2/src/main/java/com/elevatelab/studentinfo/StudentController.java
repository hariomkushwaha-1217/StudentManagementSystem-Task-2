package com.elevatelab.studentinfo;

import java.util.Scanner;

public class StudentController {
	static Scanner s=new Scanner(System.in);
	static StudentDao mdao=new StudentDao();
	
	public static void main(String[] args) {
		int choice;
		do {	
			System.out.println("1.add Student");
			System.out.println("2.view Student");
			System.out.println("3.update Student");
			System.out.println("4.delete Student");
			System.out.println("5.Exit ");
			System.out.println("Enter the choise: ");
			choice=s.nextInt();
		
			switch(choice) {
			case 1: addStudent();
				break;
			case 2: viewStudent();
				break;
			case 3: updateStudent();
				break;
			case 4: deleteStudent();
				break;
			case 5:
				System.out.println("Exiting... Thankyou!");
				break;
			default:
				System.err.println("invalid operations please enter the correct operation number !");
				break;
			}
		}
		while(choice!=5);
	}
	private static void addStudent() {
		System.out.print("Enter Student name: ");
		String nm=s.next();
		System.out.print("Enter Student Marks: ");
		double mr=s.nextDouble();
		System.out.print("Enter Student phone: ");
		Long ph=s.nextLong();
		System.out.print("Enter Student email: ");
		String em=s.next();
		
		Student st=new Student();
		st.setName(nm);
		st.setMarks(mr);
		st.setPhone(ph);
		st.setEmail(em);
		
		Student mdb=mdao.addStudent(st);
		System.out.println("Student is saved with an id: "+mdb.getId());
	}
	
	private static void updateStudent() {
		System.out.println("Enter the Student id: ");
		int id=s.nextInt();
		System.out.print("Enter Student name: ");
		String nm=s.next();
		System.out.print("Enter Student Marks: ");
		double mr=s.nextDouble();
		System.out.print("Enter Student phone: ");
		Long ph=s.nextLong();
		System.out.print("Enter Student email: ");
		String em=s.next();
		
		Student st=new Student();
		st.setName(nm);
		st.setMarks(mr);
		st.setPhone(ph);
		st.setEmail(em);

	    Student mdb = mdao.uqdateStudent(id,st);
	    if (mdb != null)
	        System.out.println("Student is updated with id: "+id);
	    else
	        System.err.println("Unable to update Student since id is invalid!");
	}
	
	private static void viewStudent() {
		System.out.println("Enter Student id: ");
		int mid=s.nextInt();
		Student mdb=mdao.viewStudent(mid);
		if(mdb!=null)
			System.out.println(mdb);
		else
			System.err.println("No Student info is found since mid is invalid");
	}
	
	private static void deleteStudent() {
	    System.out.print("Enter Student id to delete: ");
	    int sid = s.nextInt();
	    Student deleted = mdao.deleteStudent(sid);
	    if (deleted != null)
	        System.out.println("Student is deleted with ID: "+sid);
	    else
	        System.err.println("No student found with ID: "+sid);
	}
}
