package server.mediator;

import com.google.gson.Gson;
import server.model.Model;
import network.NetworkPackage;
import network.NetworkType;
import network.StringPackage;
import network.StudentPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable
{
  Model model;
  Socket socket;
  BufferedReader in;
  PrintWriter out;
  boolean running;
  Gson gson;

  public ClientHandler(Socket socket, Model model, ThreadGroup threadGroup)
  {
    try
    {
      this.model = model;
      this.socket = socket;
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
      running = true;
      gson = new Gson();
    }
    catch (Exception e)
    {
      System.out.println("clienthandler start error");
    }
  }

  @Override public void run()
  {
    try
    {
      String readline = in.readLine();
      NetworkPackage networkPackage = gson.fromJson(readline, NetworkPackage.class);
      NetworkPackage reply = null;
      switch (networkPackage.getType()){
        case NAME:
          reply = new StudentPackage(model.getStudentByName(((StringPackage)networkPackage).getValue()));break;
        case NUMBER:
          reply = new StudentPackage(model.getStudentByStudyNumber(((StringPackage)networkPackage).getValue()));break;
        case STUDENT:
          try
          {
            StudentPackage studentPackage = (StudentPackage) networkPackage;
            System.out.println("got new student!");
            model.addStudent(studentPackage.getStudent());
            reply = new StringPackage(NetworkType.NAME,
                studentPackage.getStudent().getName());
          }catch (Exception e){
            reply = new StringPackage(NetworkType.ERROR, e.getMessage());
          }break;
        default:
          System.out.println("switch error");break;
      }
      out.println(gson.toJson(reply));
    }
    catch (Exception e)
    {
      System.out.println("clienthandler runtime error");
    }

  }
}
