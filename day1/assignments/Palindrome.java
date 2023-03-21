package week3.day1.assignments;

public class Palindrome {

	public static void main(String[] args) {
		
		String name = "madam";
		char[] array = name.toCharArray();
		String rev = "";
		int len = array.length;
		
		for (int i = len-1 ; i >=0 ; i--) {
			rev = rev + array[i];
		}
		System.out.println(rev);
		if (name.contains(rev)) {
			System.out.println("The given array is a Palindrome");
		}
		else {
			System.out.println("The given array is not a Palindrome");
		}
	}

}
