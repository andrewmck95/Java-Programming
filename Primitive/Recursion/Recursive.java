import java.util.Scanner;

public class Recursive {
	

	static int i = 10;
	static int j = 1;
	static String choice;

	static Scanner sc = new Scanner(System.in);

	// Recursively count down from i
	public static boolean countdown(int a) {
		if (a < 1)
			return false;
		System.out.println(a);
		return countdown(a - 1);

	}

	// Recursively count up to 10
	public static boolean countup(int a) {
		if (a > 10)
			return false;
		System.out.println(a);
		return countup(a + 1);
	}

	public static void main(String[] args) {
		System.out.println("Enter choice of function to execute!");
		System.out.println("--------\nOptions:\n--------\n*countdown\n*countup\n*exit");

		// Switch case
		while (true) {
			choice = sc.nextLine();
			switch (choice) {
			case "countdown":
				countdown(i);
				break;
			case "countup":
				countup(j);
				break;
			case "exit":
				// shut down program
				System.out.println("exiting program...");
				System.exit(1);
			default:
				System.out.println("Invalid choice!");
				break;
			}
		}
	}
}
