import java.util.Scanner;
import java.net.Socket;

public class Main {
  public static void main(String[] args) {
    System.out.println("Give a name: ");
    Scanner input = new Scanner(System.in);
    String name = input.next();
    Player player = new Player(name);
  }
}
