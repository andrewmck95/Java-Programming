//Andrew McKeown

package TCP;

import java.io.*;
import java.net.*;
import java.util.logging.*;

//This multithreaded class connects the client threads
public class Connection implements Runnable {
	private Socket sock;
	private BufferedReader brIn = null;

	// constructor for client thread
	public Connection(Socket client) {
		this.sock = client;
	}

	@Override
	public void run() {
		try {
			// buffered reader assigned to a new client input stream
			brIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));

			// string to choose client to use
			String choice;

			while ((choice = brIn.readLine()) != null) {
				// choosing to upload or download a file using a switch
				// statement
				switch (choice) {
				case "1":
					String file_out;
					while ((file_out = brIn.readLine()) != null) {
						download(file_out);
					}
					break;
				case "2":
					upload();
					break;
				default:
					System.out.println("Wrong option, choose another!");
					break;
				}
				brIn.close();
				break;
			}

		} catch (IOException ex) {
			// Level.severe indicated failure
			Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void download(String fileName) {
		try {
			// handle file read
			File myFile = new File(fileName);
			byte[] mybytearray = new byte[(int) myFile.length()];

			FileInputStream fis = new FileInputStream(myFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			// bis.read(mybytearray, 0, mybytearray.length);

			DataInputStream dis = new DataInputStream(bis);
			dis.readFully(mybytearray, 0, mybytearray.length);

			// handle file send over socket
			OutputStream os = sock.getOutputStream();

			// Sending file name and file size to the server
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(myFile.getName());
			dos.writeLong(mybytearray.length);
			dos.write(mybytearray, 0, mybytearray.length);
			dos.flush();
			System.out.println("File name: " + fileName + " downloaded by the client.");
		} catch (Exception e) {
			System.out.println("Cannot find file!");
		}
	}

	public void upload() {
		try {
			// int used to read bytes
			int read;

			DataInputStream dis = new DataInputStream(sock.getInputStream());

			String filename = dis.readUTF();
			OutputStream out = new FileOutputStream(("Taken from client: " + filename));
			int size = dis.readInt();
			byte[] buffer = new byte[1024];
			while (size > 0 && (read = dis.read(buffer, 0, (int) Math.min(buffer.length, size))) > -1) {
				out.write(buffer, 0, read);
				size -= read;
			}

			out.close();
			dis.close();
			System.out.println("File " + filename + " uploaded by the client.");

		} catch (IOException ex) {
			System.out.println("Connection closed, something went wrong on client side..");
		}
	}
}

