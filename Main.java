import java.net.ServerSocket;
import java.io.IOException;

class Main {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(1234);
      Server server = new Server(serverSocket);
      server.startServer();
    } catch (IOException e) {
      System.out.println("Oops");
    }
  }
}