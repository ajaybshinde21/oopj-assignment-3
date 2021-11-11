import java.util.InputMismatchException;
import java.util.Scanner;

// try-catch-finally combination.

public class Program_2 {

	public static void main(String[] args) {
		try {
			method1();
		}catch(InputMismatchException e) {
			System.out.println("Incorrect input");
		}finally {
			System.out.println("in finally");
		}
	}
	
	public static void method1() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a integer value");
		int value = input.nextInt();
		System.out.println("Entered value: "+value);
	}

}
