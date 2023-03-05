package week1.day1;

public class IsPrime {

	public static void main(String[] args) {
		int i, n =17;
	     boolean isprime = true;

	     // 0 and 1 are not prime numbers also, negative numbers are not prime
	     if (n < 2)
	       {
	          isprime = false;
	       }
	     else
	       {
	          for (i = 2; i < n; i++)
	           {
	            if (n % i == 0)
	             {
	              isprime = false;
	                  break;
	                }
	        }
	       }

	     String result = isprime ? "Prime" : "not Prime";
	     System.out.println ("The number " + n + " is : " + result);

	}

}
