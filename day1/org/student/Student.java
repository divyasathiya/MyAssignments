package stud;

import depart.Department;

public class Student extends Department {
	
	public void studentName() {
		System.out.println("Student Name is: Divya S");
	}
	
	public void studentDept() {
		System.out.println("Student department is: ECE");
	}
	
	public void studentID() {
		System.out.println("Student ID: 01");
	}

	public static void main(String[] args) {
		Student s = new Student();
		s.collegeName();
		s.collegeCode();
		s.collegeRank();
		s.deptName();
		s.studentName();
		s.studentID();
		s.studentDept();

	}

}
