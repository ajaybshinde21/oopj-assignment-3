
public class Program_1_multiple_catch {

	public static void main(String[] args) {

		try {
		// perform ClassCast Exception	
		method1();
		
			
		// Arithmetic exception
//		method2();	
			
		}catch(ClassCastException e) {
			System.out.println(e.getClass());
			
		}catch(ArithmeticException e) {
			System.out.println(e);
			
		}
	}

	
	
	public static void method1() {
		Object x = new String("abc");
	     System.out.println((Integer)x);
	}
	
	public static void method2() {
		throw new ArithmeticException("divide by zero");
	}
}
