package client.view;

import client.model.Model;
import server.model.Student;

import java.util.Scanner;

public class SimpleClientConsoleView
{
  private Model model;

  public SimpleClientConsoleView(Model model)
  {
    this.model = model;
  }

  public void start()
  {
    try
    {
      Scanner scanner = new Scanner(System.in);
      boolean running = true;
      while (running)
      {
        System.out.println("1) Get student by number");
        System.out.println("2) Get student by name");
        System.out.println("3) Add student");
        System.out.println("0) Exit");
        int choice = scanner.nextInt();
        switch (choice)
        {
          case 1:
            scanner.nextLine();
            System.out.print("Enter study number: ");
            String value = scanner.nextLine();
            Student student = model.getStudentByStudyNumber(value);
            System.out.println("Client model: " + student);
            break;
          case 4:
            System.out.println("connecting to server");
            model.connect();
            break;
          case 2:
            scanner.nextLine();
            System.out.print("Enter name: ");
            value = scanner.nextLine();
            student = model.getStudentByName(value);
            System.out.println("Client model: " + student);
            break;
          case 3:
            scanner.nextLine();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter study number: ");
            String number = scanner.nextLine();
            try
            {
              model.addStudent(new Student(name, number));
              System.out.println("Client model: ADDED");
            }
            catch (Exception e)
            {
              System.out.println(e.getMessage());
            }
            break;
          default:
            running = false;
            break;
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
