// Andrew McKeown

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	/*
	 * Key is the second parameter and is the element to be found, NOT
	 * the index number. Min value of array is the third parameter.
	 * Max value of the array is the fourth parameter.
	 */
	public static int bSearch(int[] sortedArr, int key, int min, int max) {
		int index = Integer.MAX_VALUE;
		int numGuesses = 0;

		while (min <= max) {
			int guess = (min + max) / 2;
			numGuesses++;
			// print element inside index
			System.out.println("Current midpoint at element: " + sortedArr[guess]);
			if (sortedArr[guess] < key) {
				System.out.println("Index number: " + guess + "\nKey is larger than current midpoint!\n");
				min = guess + 1;
			} else if (sortedArr[guess] > key) {
				System.out.println("Index number: " + guess + "\nKey is smaller than current midpoint!\n");
				max = guess - 1;
			} else if (sortedArr[guess] == key) {
				index = guess;
				System.out.println("Key found at index: " + index);
				System.out.println("Number of guesses until success: " + numGuesses + "\n");
				break;
			}
		}
		if (min > max) {
			System.out.println(key + " not found in array! Input another number:\n");
		}
		return index;
	}

	public static void main(String[] args) {
		// sorted integer array
		int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Enter a key to search for in the primes array (first 10 prime numbers), enter -1 to exit program");

		// continue to receive user input until input equals -1
		while (true) {
			int key = sc.nextInt();

			if (key != -1) {
				System.out.println("Primes array = " + Arrays.toString(primes) + "\nSearching for:" + key
						+ "\n---------------------------------------------------\n");
				
				bSearch(primes, key, 0, 9);
			} else if (key == -1) {
				System.out.println("Exiting program..");
				sc.close();
				System.exit(1);
			}
		}
	}
}
