package week3.day1.assignments;


public class RemoveDuplicates {

	public static void main(String[] args) {
		
		String text = "We learn java basics as part of java sessions in java week1";
		String[] spl = text.split(" ");
			
		int no = spl.length;
		int count=0;
		for (int i = 0; i < no ; i++) 
		{
			for (int j = i+1; j < no; j++) 
			{
				if (spl[i].equalsIgnoreCase(spl[j]))
				{
					spl[j]="";
					
				}
				
			}
			
		if (i>=count) {
				
				System.out.println(spl[i]);
		}
		}
		
		
	}

}
