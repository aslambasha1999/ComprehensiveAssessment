package Java.Assignment;

public class Account {

	protected double interest;

	public void calculateInterest() {
		
		// calculate interest for savings account and set it to interest variable

		interest = 100.0;
	}

	public void addToAccount() {
		
		// add the given amount to the account balance
		System.out.println("Interest of " + interest + " added to account.");
	}
}
class SavingsAccount extends Account {

	@Override
	public void calculateInterest() {
		
		// calculate interest for savings account and set it to interest variable
		interest = 200.0;
	}

	

}

class CurrentAccount extends Account {
	@Override
	public void calculateInterest() {
		
		// Calculate interest for current account
		interest = 50.0;
	}
}