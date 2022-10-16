import java.net.Socket;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class Client implements Runnable {

  private Socket socket;
  private BufferedReader bufferedReader;
  private BufferedWriter bufferedWriter;
  public String data = "";

  public Client(Socket socket) {
    try{
      this.socket = socket;
      this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    } catch (IOException e) {
      closeEverything(socket, bufferedReader, bufferedWriter);
    }
  }

  public void sendGuess(String guess) {
    try {
      bufferedWriter.write(guess);
      bufferedWriter.newLine();
      bufferedWriter.flush();
    } catch (IOException e) {
      closeEverything(socket, bufferedReader, bufferedWriter);
    }
  }

  public void run() {
    System.out.println("Thread is running on client");
    String messageGotten = "";
    while (socket.isConnected()) {
      try {
        messageGotten = bufferedReader.readLine();
        if (messageGotten != null && !messageGotten.equals("")) {
          System.out.println(messageGotten);
        }
        this.data = messageGotten;
      } catch (IOException e) {
        closeEverything(socket, bufferedReader, bufferedWriter);
      }
    }
  }

  public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
    try {
      if (bufferedReader != null) {
        bufferedReader.close();
      }
      if (bufferedWriter != null) {
        bufferedWriter.close();
      }
      if (socket != null) {
        socket.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
