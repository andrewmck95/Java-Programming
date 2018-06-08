//Andrew McKeown

package TCP;

import java.net.*;
import java.io.*;

public class Server {

  private static ServerSocket servsock;
  private static Socket sock = null;

  public static void main(String[] args) throws IOException {

      try {
      	//instantiating new server socket
          servsock = new ServerSocket(5572);
          System.out.println("Server running...");
      } catch (Exception e) {
          System.out.println("Cannot use this port!");
          System.exit(1);
      }

      while (true) {
          try {
              sock = servsock.accept();
              System.out.println("Connected! " + sock);
              //instantiates and starts a new thread from the Connection class
              Thread thread = new Thread(new Connection(sock));
              thread.start();

          } catch (Exception e) {
              System.out.println("Cannot connect!");
          }
      }
  }
}

