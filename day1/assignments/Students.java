package week3.day1.assignments;

public class Students {
	
	public void getStudentInfo(int id) {
		System.out.println("Student ID:" + id);
	}
	
	public void getStudentInfo(int id, String name) {
		System.out.println("Student ID:" + id);
		System.out.println("Student Name: " + name);
	}
	
	public void getStudentInfo(String email, long mobno ) {
		System.out.println("Student Email: " + email);
		System.out.println("Student mobile no.: " + mobno);
	}

	public static void main(String[] args) {
		Students obj = new Students();
		obj.getStudentInfo(12);
		obj.getStudentInfo(23,"Divya");
		obj.getStudentInfo("test123@gmail.com",1234567890);
	}

}
