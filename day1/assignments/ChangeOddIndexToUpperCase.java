package week3.day1.assignments;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		
		String test = "changeme";
		char[] cs = test.toCharArray();
		int size = cs.length;
		for (int i = 0; i < size; i++) {
			if (i%2!=0) {
				cs[i]= Character.toUpperCase(cs[i]);
			}
		System.out.print(cs[i]);
		}

	}

}
