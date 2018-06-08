//Andrew McKeown

package UDP;

import java.io.*;
import java.net.*;

class Client {
	public static void main(String args[]) throws Exception {
		System.out.println("Enter your name:");
		BufferedReader bfIn = new BufferedReader(new InputStreamReader(System.in));

		// instantiate datagram socket
		DatagramSocket sock = new DatagramSocket();

		// hostname
		InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
		byte[] receive = new byte[1024];
		byte[] send = new byte[1024];

		// reads a line of text
		String s = bfIn.readLine();
		send = s.getBytes();

		// sending the datagram packet contents and receiving them again
		DatagramPacket sendPacket = new DatagramPacket(send, send.length, IPAddress, 3038);
		sock.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receive, receive.length);
		sock.receive(receivePacket);

		// printing out the name again after it comes back from the server
		String data = new String(receivePacket.getData());
		System.out.println("Input back from server:\n" + data);

		// close socket when finished
		sock.close();
	}
}

