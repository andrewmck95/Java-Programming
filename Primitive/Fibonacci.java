package test;

import java.util.Scanner;

public class Fibonacci {
	static int result;
	
	public static int fibonacciSeq(int n){
		if(n==0)
			return 0;
		else if(n == 1)
			return 1;
		else
			// recursion
			result = fibonacciSeq(n-1)+fibonacciSeq(n-2);
			return result;
		}
	
	public static void main(String[] args){
	System.out.println("Enter an integer n for the Fibonacci sequence");
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	sc.close();
	System.out.println(fibonacciSeq(n));
	
	}
	
	
}
