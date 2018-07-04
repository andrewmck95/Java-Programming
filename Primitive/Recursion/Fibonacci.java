// Andrew McKeown

public class Fibonacci {
	public static int fibonacci(int num) {
		if (num == 0) {
			return 0;
		} else if (num == 1) {
			return 1;
		} else
			return fibonacci(num - 1) + fibonacci(num - 2);
	}

	public static void main(String args[]) {
		// want to print sequence
		for (int i = 0; i < 10; i++) {
			int f = fibonacci(i);
			System.out.println(f);
		}
	}
}
