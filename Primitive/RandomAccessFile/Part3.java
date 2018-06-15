//Andrew McKeown
package package3;

import java.io.File;
import java.io.RandomAccessFile;


public class Part3 {
	

	public static void append(String file, String in) throws Exception{
		File a=new File(file);
		//needs to be type long
		long fileLength=a.length();
		RandomAccessFile rafile=new RandomAccessFile(a,"rw");
		rafile.seek(fileLength);//set to end of file
		rafile.writeBytes(in);
		rafile.close();
	}
	public static void main(String[] args) throws Exception{
		append("append.txt","file appended ");
	}
}
