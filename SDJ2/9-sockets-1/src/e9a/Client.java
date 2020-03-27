package e9a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
  public Client() throws IOException
  {
    Socket mySocket = null;
    try
    {
      mySocket = new Socket("localhost", 5678);
    }
    catch (IOException e)
    {
      System.out.println("Error: Cannot connect to the Server!");
      return;
    }

    System.out.println("You have joined the server.");
    BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
    PrintWriter out = new PrintWriter(mySocket.getOutputStream(), true);

    //Non-blocking reading of new messages
    new Thread(() -> {
      try
      {
        String readLine;
        while ((readLine = in.readLine()) != null)
        {
          System.out.println(readLine);
        }
      }
      catch (Exception e) { }
    }).start();

    //Read and send messages to the server
    Scanner keyboard = new Scanner(System.in);
    String input;
    while (( input = keyboard.nextLine()) != null && !(input.equals("exit")))
    {
      out.println(input);
    }

    mySocket.close();
    System.out.println("Connection closed.");
  }
}