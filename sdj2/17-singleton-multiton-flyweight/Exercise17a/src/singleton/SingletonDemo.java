package singleton;

public class SingletonDemo
{
  public static void main(String[] args)
  {
    Project project1 = new Project("singleton.Project 1");

    project1.addGlossaryItem("Client", "The client part of a client/server " + "application.");
    project1.addGlossaryItem("User", "End user in form of a doctor or a nurse.");
    project1.addGlossaryItem("Account", "A location on the server application " + "storing username, password and phone number.");

    System.out.println("singleton.Project 1: Client: " + project1.getDefinition("Client"));
    System.out.println(project1);

    // Danish:
    Project project2 = new Project("singleton.Project 2");
    try
    {
      project2.addGlossaryItem("Client",
          "Det program der som en del af en Client/Server applikation bliver " + "installeret på computere til læger og sygeplejesker.");
    }
    catch (IllegalStateException e) // Using the same phrase as in singleton.Project 1
    {
      System.out.println("Error: " + e.getMessage());
    }
    project2.addGlossaryItem("Bruger", "Bruger af systemet - her en læge " + "eller sygeplejeske.");
    project2.addGlossaryItem("Konto", "Et sted på en server med oplysninger " + "om brugernavn, kodeord og telefonnummer.");


    System.out.println("singleton.Project 2: Client: " + project2.getDefinition("Client"));
    System.out.println(project2);

//    // A new project with the project glossary as in project 1
//    singleton.Project project3 = new singleton.Project("singleton.Project 3");
//    singleton.GlossaryItem[] glossaryItems = project1.getGlossary().getAll();
//    for (int i = 0; i < glossaryItems.length; i++)
//    {
//      project3.addGlossaryItem(glossaryItems[i].getPhrase(), glossaryItems[i].getDefinition());
//    }
//    System.out.println(project3);
  }
}
