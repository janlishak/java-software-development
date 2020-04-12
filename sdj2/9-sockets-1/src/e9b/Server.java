package e9b;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.GregorianCalendar;

public class Server
{
  public static void main(String[] args) throws IOException
  {
    final int PORT = 9876;
    System.out.println("starting server..");
    DatagramSocket serverSocket = new DatagramSocket(PORT);

    while(true)
    {
      System.out.println("waiting for a client..");

      byte[] receiveData = new byte[1024];
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

      serverSocket.receive(receivePacket);
      String sentence = new String(receivePacket.getData()).trim();

      InetAddress IPAdress = receivePacket.getAddress();
      int port = receivePacket.getPort();

      System.out.println("Client>" + sentence);
      byte[] sendData = new byte[1024];
      if(sentence.equals("/time")){
        sendData = String.valueOf(GregorianCalendar.getInstance().getTimeInMillis()).getBytes();
      }else
      {
        sendData = sentence.toUpperCase().getBytes();
      }

      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
          IPAdress, port);

      serverSocket.send(sendPacket);
    }
  }
}
