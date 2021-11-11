
public class Main {

	public static void main(String[] args) {

		// normal account
		CheckingAccount c1 = new CheckingAccount(800);
		System.out.println("Current Balance is " + c1.getBalance());
		System.out.println(); // for decoration *_*
		
		// withdraw 400 on each iteration
		for (int i = 0; i < 4; i++) {
			try {
				System.out.println("WithDrawing 400");
				c1.withdraw(400);
				System.out.println("After withdraw Balance is " + c1.getBalance());
			} catch (InsufficientFundsException e) {
				System.out.println(e);
			}
			System.out.println(); // for decoration *_*
		}

	}

}
