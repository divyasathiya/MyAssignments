package week1.day2;

import java.util.Arrays;

public class MissingElementsInAnArray {

	public static void main(String[] args) {
		// Here is the input
				int[] arr = {1,2,3,4,7,6,8};

				int count = arr.length;
		Arrays.sort(arr);
		for (int i=0; i < count; i++) {
			if (i+1!=arr[i]) {
				System.out.println(i+1);
				break;
			}
	}
}
}
