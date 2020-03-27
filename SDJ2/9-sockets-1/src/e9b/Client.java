package e9b;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client
{
  public static void main(String[] args) throws IOException
  {
    final int port = 9876;
    final String HOST = "localhost";

    Scanner input = new Scanner(System.in);
    DatagramSocket client = new DatagramSocket();

    InetAddress IPAddress = InetAddress.getByName(HOST);
    byte[] sendData = new byte[1024];
    byte[] receiveData = new byte[1024];

    while (true)
    {
      System.out.print("Write a line for the server: ");
      String sentence = input.nextLine();
      if (sentence.equals("exit"))
        break;
      System.out.println("Client> " + sentence);

      sendData = sentence.getBytes();
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
      client.send(sendPacket);
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      client.receive(receivePacket);
      String response = new String(receivePacket.getData()).trim();
      System.out.println("Server> " + response);
    }
    client.close();
  }
}
