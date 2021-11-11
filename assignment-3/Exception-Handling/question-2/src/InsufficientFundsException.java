
public class InsufficientFundsException extends Exception {
	
	public InsufficientFundsException() {
		this(0.0);
	}
	public InsufficientFundsException(double balance) {
		super("balnce :" + balance);
	}
	
}
