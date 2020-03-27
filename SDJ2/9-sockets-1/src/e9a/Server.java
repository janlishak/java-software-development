package e9a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  // TODO: 3/27/20 Add support for multiple clients to join at once
  public static void main(String[] args) throws IOException
  {
    //Start the server on port 5678
    ServerSocket serverSocket = new ServerSocket(5678);

    while (true)
    {
      System.out.println("waiting for a new client..");
      Socket client = serverSocket.accept();

      BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      PrintWriter out = new PrintWriter(client.getOutputStream(), true);
//      String req;
//      while ((req = in.readLine()) != null)
//      {
//        if (req.equals("connect"))
//        {
//          out.println("connected");
//        }
//        else
//        {
//          out.println("disconnected");
//          break;
//        }
//      }
      String firstMessage;
      if((firstMessage = in.readLine()).equals("connect")){
        System.out.println("Client " + client.getInetAddress().getHostAddress() + " wants to connect");
        out.println("username?");
        System.out.println("username: " + in.readLine());
        out.println("password?");
        System.out.println("password: " + in.readLine());
        System.out.println("client has been approved");
        out.println("approved");

        String message;
        while((message = in.readLine()) != null){
          System.out.println("client wrote: " + message);
          out.println("I got your message: '" + message + "'");
        }
      }else{
        System.out.println("client " + client.getInetAddress().getHostAddress() + " wrote " + firstMessage + " and has been disconnected");
        out.println("disconnected");
      }
      client.close();
    }
  }
}