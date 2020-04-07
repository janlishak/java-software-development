package client.model;

import com.google.gson.Gson;
import network.NetworkPackage;
import network.NetworkType;
import network.StringPackage;
import network.StudentPackage;
import server.model.Student;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.net.Socket;

public class Mediator implements Model
{
  String host;
  int port;
  Socket socket;
  BufferedReader in;
  PrintWriter out;
  Gson gson;

  public Mediator(String host, int port)
  {
    this.host = host;
    this.port = port;
  }

  public Mediator()
  {
    this("localhost", 9876);
  }

  @Override public void connect()
  {
    try
    {
      socket = new Socket(host, port);
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
    }
    catch (Exception e)
    {
      System.out.println("cannot connect to the server");
    }
  }

  @Override public void disconnect()
  {
    try
    {
      socket.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public Student getStudentByStudyNumber(String studyNumber)
      throws Exception
  {
    return ((StudentPackage)sendPackage(new StringPackage(NetworkType.NUMBER, studyNumber))).getStudent();
  }

  @Override public Student getStudentByName(String name) throws Exception
  {
    return ((StudentPackage)sendPackage(new StringPackage(NetworkType.NAME, name))).getStudent();
  }

  @Override public void addStudent(Student student) throws Exception
  {
    System.out.println("s");
    System.out.println(((StringPackage)sendPackage(new StudentPackage(student))).toString());
    System.out.println("s");
  }

  @Override public void addListener(PropertyChangeListener listener)
  { }

  @Override public void removeListener(PropertyChangeListener listener)
  { }

  public NetworkPackage sendPackage(NetworkPackage networkPackage)
  {
    out.println(gson.toJson(networkPackage));
    try
    {
      String reply = in.readLine();
      System.out.println("got" + reply);
      return gson.fromJson(in.readLine(), NetworkPackage.class);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
