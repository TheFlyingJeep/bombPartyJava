import java.net.Socket;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class ClientHandler implements Runnable {

  public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
  private Socket socket;
  private BufferedReader bufferedReader;
  private BufferedWriter bufferedWriter;
  private String username;
  
  public ClientHandler(Socket socket) {
    try {
      this.socket = socket;
      this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      this.username = bufferedReader.readLine();
      clientHandlers.add(this);
      broadcastMessage("SERVER: " + username + " has joined");
    } catch (IOException e) {
      closeEverything(socket, bufferedReader, bufferedWriter);
    }
  }

  @Override
  public void run() {
    String clientMessage;
    while (socket.isConnected()) {
      try {
        clientMessage = bufferedReader.readLine();
        broadcastMessage(clientMessage);
      } catch (IOException e) {
        closeEverything(socket, bufferedReader, bufferedWriter);
        break;
      } 
    }
  }

  public void broadcastMessage(String messageSending) {
    for (ClientHandler clientHandler: clientHandlers) {
      try {
        if (!clientHandler.username.equals(username)) {
          clientHandler.bufferedWriter.write(messageSending);
          clientHandler.bufferedWriter.newLine();
          clientHandler.bufferedWriter.flush();
        }
      } catch (IOException e) {
        closeEverything(socket, bufferedReader, bufferedWriter);
      } 
    }
  }

  public void removeClientHandler() {
    clientHandlers.remove(this);
    broadcastMessage("SERVER: " + username + " has left");
  }

  public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
    removeClientHandler();
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