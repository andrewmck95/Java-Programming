//Andrew McKeown
package programming3_assignment3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {

		// creating an array list of account objects
		ArrayList<Account> list = new ArrayList<Account>();

		// adding new objects to list
		list.add(new Account("Andrew", 1, 2));
		list.add(new Account("John", 4, 7.34));
		list.add(new Account("Shane", 2, 23.55));
		list.add(new Account("Jane", 57, 700));

		// Serialization of object
		try {
			FileOutputStream fileOut = new FileOutputStream("BankAccountDetails.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(list);
			fileOut.close();
			fileOut.close();
			System.out.println("Serialization successful!\n");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Deserialization of object
		try {
			FileInputStream fileIn = new FileInputStream("BankAccountDetails.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			// printing out account details stored int BankAccountDetails.txt
			System.out.println("Deserialization successful! Now printing BankAccount Details:\n\n" + list);
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
