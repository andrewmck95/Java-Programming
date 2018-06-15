//Andrew McKeown

package package2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test2 {
	public static void main(String[] args) {

		// creating an array list of account objects
		ArrayList<Account2> list2 = new ArrayList<Account2>();

		// adding new objects to list
		list2.add(new Account2("Andrew", 1, 2));
		list2.add(new Account2("John", 4, 7.34));
		list2.add(new Account2("Shane", 2, 23.55));
		list2.add(new Account2("Jane", 57, 700));
	    

		// Serialization of object
		try {
			FileOutputStream fileOut = new FileOutputStream("BankAccountDetails2.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(list2);
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
			FileInputStream fileIn = new FileInputStream("BankAccountDetails2.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			// printing out account details stored int BankAccountDetails.txt
			System.out.println("Deserialization successful! Now printing BankAccount Details2:\n\n" + list2);
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
