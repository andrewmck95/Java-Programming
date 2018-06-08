//Andrew McKeown

package TCP;

import java.io.*;
import java.net.*;
import java.util.logging.*;

public class Client {

	private static Socket sock;
	private static BufferedReader brIn;
	private static PrintStream out;
	private static String filename;

	public static void main(String[] args) throws IOException {
		try {
			sock = new Socket("127.0.0.1", 5572);
			brIn = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
			System.out.println("Connection failed! Retry!");
			System.exit(1);
		}

		out = new PrintStream(sock.getOutputStream());

		try {
			switch (Integer.parseInt(options())) {
			case 1:
				out.println("1");
				System.out.print("Enter file name: ");
				filename = brIn.readLine();
				out.println(filename);
				download(filename);
				break;
			case 2:
				out.println("2");
				upload();
				break;
			}
		} catch (Exception e) {
			System.out.println("Wrong! choose another input!");
		}

		sock.close();
	}

	public static String options() throws IOException {
		System.out.println("Press 1 to download");
		System.out.println("Press 2 to upload");
		System.out.println("---------------------------");
		System.out.print("Choose option: ");

		return brIn.readLine();
	}

	public static void download(String fileName) {
		try {
			int bytesRead;
			InputStream in = sock.getInputStream();

			DataInputStream dis = new DataInputStream(in);

			fileName = dis.readUTF();
			OutputStream out = new FileOutputStream(("downloaded from server " + fileName));
			int size = dis.readInt();
			byte[] buffer = new byte[1024];
			// reading all the bytes, then writing them again for the output
			while (size > 0 && (bytesRead = dis.read(buffer, 0, (int) Math.min(buffer.length, size))) > -1) {
				out.write(buffer, 0, bytesRead);
				size -= bytesRead;
			}

			out.close();
			in.close();

			System.out.println("File: " + fileName + " downloaded from the Server.");
		} catch (IOException ex) {
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void upload() {
		try {
			System.out.print("Enter file name: ");
			// std.in.readLine() used instead of Scanner
			filename = brIn.readLine();

			File myFile = new File(filename);
			byte[] mybytearray = new byte[(int) myFile.length()];

			FileInputStream fis = new FileInputStream(myFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			// bis.read(mybytearray, 0, mybytearray.length);

			DataInputStream dis = new DataInputStream(bis);
			dis.readFully(mybytearray, 0, mybytearray.length);

			OutputStream os = sock.getOutputStream();

			// Sending file name and file size to the server
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(myFile.getName());
			dos.writeLong(mybytearray.length);
			dos.write(mybytearray, 0, mybytearray.length);
			dos.flush();
			System.out.println("File " + filename + " sent to Server.");
		} catch (Exception e) {
			System.out.println("Cannot find file!");
		}
	}
}
