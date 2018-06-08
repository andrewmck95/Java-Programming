//Andrew McKeown

package UDP;

import java.net.*;

class Server {
	public static void main(String args[]) throws Exception {
		//instantiating server socket
		DatagramSocket servsock = new DatagramSocket(3038);
		
		//both byte streams for receiving and sending
		byte[] receive = new byte[1024];
		byte[] send = new byte[1024];
		
		while (true) {
			//new datagram packet for receiving
			DatagramPacket p_rec = new DatagramPacket(receive, receive.length);
			servsock.receive(p_rec);
			String name = new String(p_rec.getData());
			System.out.println("From client: " + name);
			
			//ip address of packet
			InetAddress IPAddress = p_rec.getAddress();
			
			//port number of packet
			int port = p_rec.getPort();
			
			//sending back name
			send = name.getBytes();
			
			//new datagram packet for sending 
			DatagramPacket p_send = new DatagramPacket(send, send.length, IPAddress, port);
			servsock.send(p_send);
		}
	}
}

