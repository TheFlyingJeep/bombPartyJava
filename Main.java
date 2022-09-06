import java.util.Scanner;
import java.net.Socket;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter your username for the chat");
      String username = scanner.nextLine();
      Socket socket = new Socket("flippinnublet.com", 1234);
      Client client = new Client(socket, username);
      client.messageListener();
      client.sendMessage();
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
}