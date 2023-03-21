package week3.day1.assignments;

public class AxisBank extends BankInfo{
	
	@Override
	public void deposit() {
		System.out.println("Deposit is now overrided and output from Axis Bank");
	}

	public static void main(String[] args) {
		AxisBank ab = new AxisBank();
		ab.fixed();
		ab.deposit();
		ab.savings();

	}

}
