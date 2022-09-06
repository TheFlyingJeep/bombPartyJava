import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

public class Server {

  private ServerSocket serverSocket;

  public Server(ServerSocket serverSocket) {
    this.serverSocket = serverSocket;
  }

  public void startServer() {

    try {

      while (!serverSocket.isClosed()) {

        Socket socket = serverSocket.accept();
        System.out.println("A new user has connected");
        ClientHandler clientHandler = new ClientHandler(socket);
        Thread thread = new Thread(clientHandler);
        thread.start();
        
      }
      
    } catch (IOException ex) {
      closeServer();
    }
    
  }

  public void closeServer() {
    try {
      if (serverSocket != null) {
        serverSocket.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}