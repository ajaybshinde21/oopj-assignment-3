// try-finally combination.



public class program_3 {
	public static void main(String[] args) {
			try {
				int a = 1/0;
			}finally {
				System.out.println("this will print no matter what");
			}
			
	}
}
