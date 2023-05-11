package Java.Assignment;

public class UserMain {

	    public static void main(String[] args) {
	        Account account = new Account();
	        account.calculateInterest();
	        account.addToAccount(); // Output: Interest of 100.0 added to account.

	        SavingsAccount savingsAccount = new SavingsAccount();
	        savingsAccount.calculateInterest();
	        savingsAccount.addToAccount(); // Output: Interest of 200.0 added to account.

	        CurrentAccount currentAccount = new CurrentAccount();
	        currentAccount.calculateInterest();
	        currentAccount.addToAccount(); // Output: Interest of 50.0 added to account.
	    }


}
