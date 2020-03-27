package e9a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  public static void main(String[] args) throws IOException
  {
    ServerSocket serverSocket = new ServerSocket(5678);

    while(true){
      System.out.println("waiting for new client..");

      Socket client = serverSocket.accept();
      BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      PrintWriter out = new PrintWriter(client.getOutputStream(), true);

      String req = in.readLine();
      if(req.equals("connect")){
        out.println("connected");
      }
      else {
        out.println("disconnected");
      }
    }

  }
}
