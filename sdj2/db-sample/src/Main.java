import database.Database;
import database.PostgreSQLDatabase;
import model.Person;

import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {
    Database database = new PostgreSQLDatabase();

    database.deleteAllData();
    database.setupStructure();
    database.loadSampleData();

    // This is a simple launcher for the methods you can call in class implementing database interface.
    // Example input;

    // add Jan 20
    // remove 7
    // get 7
    // getAllPeople
    // getAllAdults
    // exit

    Scanner kb = new Scanner(System.in); String readLine = "";
    while (!(readLine=kb.nextLine()).equalsIgnoreCase("exit")){
      String[] arguments = readLine.split(" ");
      try{switch (arguments[0].toLowerCase()){
        case "add":
          database.addPerson(arguments[1], Integer.parseInt(arguments[2]));break;
        case "remove":
          database.deletePersonById(Integer.parseInt(arguments[1]));break;
        case "get":
          Person person = database.getPersonById(Integer.parseInt(arguments[1]));
          System.out.println(person);break;
        case "getalladults":
          for (Person p : database.getAllAdults()) { System.out.println(p); } break;
        case "getallpeople":
          for (Person p : database.getAllPeople()) { System.out.println(p); } break;
        default:
          System.out.println("invalid command");break;
      }}catch (Exception e){ System.out.println("error");}
    }
  }
}
