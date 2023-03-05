package week1.day1;

public class Fibbinocci 
{

	public static void main(String[] args) 
	{
		int i=0;
		int firstNum = 0, secNum = 1, sum=0;
		System.out.println("The Fibo series is: \n"+firstNum);
		System.out.println(secNum);
		for(i=2;i<11;i++)
		{
			sum = firstNum+secNum;
			System.out.println(sum);
			firstNum = secNum;
			secNum = sum;
			
		}

	}

}
