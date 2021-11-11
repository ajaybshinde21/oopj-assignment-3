
public class CheckingAccount extends InsufficientFundsException{
	private double balance;
	public CheckingAccount(double balance) {
		this.balance = balance;
	}

	
	public void withdraw(double balance) throws InsufficientFundsException {
		if(this.balance <= 0) {
			throw new InsufficientFundsException(this.balance);
		}
		this.balance-=balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
}
