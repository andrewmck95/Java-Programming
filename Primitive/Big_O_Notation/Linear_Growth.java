// Andrew McKeown
public class Linear_Growth {

	public static int sum(int[] arr) {
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		return total;
	}

	public static long timing(int[] arr) {
		// calling sum function
		long startTime = System.nanoTime();
		int x = sum(arr);
		long stopTime = System.nanoTime();
		long runtime = stopTime - startTime;
		System.out.println("Sum of array is: " + x);
		System.out.println("Runtime for arraysize " + arr.length + " is: " + runtime + " nanoseconds");
		return runtime;
	}

	public static void populateArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
	}

	public static void run(int[] arr) {
		populateArr(arr);
		timing(arr);
		System.out.println("");
	}

	public static void main(String args[]) {
		int[] nums1 = new int[10];
		int[] nums2 = new int[1000];
		int[] nums3 = new int[10000];
		int[] nums4 = new int[100000];
		run(nums1);
		run(nums2);
		run(nums3);
		run(nums4);

	}
}
