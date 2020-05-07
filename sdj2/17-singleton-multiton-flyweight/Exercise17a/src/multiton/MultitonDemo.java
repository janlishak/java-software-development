package multiton;

public class MultitonDemo
{
  public static void main(String[] args)
  {
    // Project in English
    Project project1 = new Project("multiton.Project 1", "uk");
    project1.addGlossaryItem("Client", "The client part of a client/server " + "application.");
    project1.addGlossaryItem("User", "End user in form of a doctor or a nurse.");
    project1.addGlossaryItem("Account", "A location on the server application " + "storing username, password and phone number.");

    // Project in Danish
    Project project2 = new Project("multiton.Project 2", "dk");
    project2.addGlossaryItem("Client", "Det program der som en del af en Client/Server applikation bliver " + "installeret på computere til læger og sygeplejesker.");
    project2.addGlossaryItem("Bruger", "Bruger af systemet - her en læge " + "eller sygeplejeske.");
    project2.addGlossaryItem("Konto", "Et sted på en server med oplysninger " + "om brugernavn, kodeord og telefonnummer.");

    // Another project in English
    Project project3 = new Project("multiton.Project 3", "uk");
    // this project should have the same glossary as the first one

    System.out.println(project1 + "\n");
    System.out.println(project2 + "\n");
    System.out.println(project3);
  }
}
