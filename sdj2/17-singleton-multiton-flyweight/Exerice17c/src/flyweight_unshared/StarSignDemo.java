package flyweight_shared;

public class StarSignDemo
{
  public static void main(String[] args)
  {
    //Print all the Legal star sign names
    String[] legalStarSignNames = AbstractStarSign.LEGAL_NAMES;
    System.out.println("legal star sign names:");
    for (int i = 0; i < legalStarSignNames.length; i++)
      System.out.println(legalStarSignNames[i]);
    System.out.println();

    //Create list of 10 people
    Person[] list = new Person[10];
    list[0] = new Person("Allan", "Leo");
    list[1] = new Person("Bob", "Scorpio");
    list[2] = new Person("Carl", "Leo");
    list[3] = new Person("Dennis", "Sagittarius");
    list[4] = new Person("Eric", "Leo");
    list[5] = new Person("Franc","Leo");
    list[6] = new Person("Graham", "Sagittarius");
    list[7] = new Person("Hans", "Leo");
    list[8] = new Person("Igor", "Virgo");
    list[9] = new Person("Jens", "Leo");

    //Check all objects and their reference hash
    System.out.println("flyweight_shared.Person objects:");
    for (int i = 0; i < list.length; i++)
    {
      System.out.printf("%-40s %d\n", list[i], list[i].getStarSign().hashCode());
    }
  }
}