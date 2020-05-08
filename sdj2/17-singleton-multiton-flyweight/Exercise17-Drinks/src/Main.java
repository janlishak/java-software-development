import Drinks.Drink;

import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {
    //well you are an object in java, everybody is.. just deal with it
    BarGuest you = new BarGuest();

    //Let's say you walked into a bar and the bartender starts finally to notice you
    Scanner kb = new Scanner(System.in);
    String readLine = "";
    while (true){
      System.out.println("What would you like to drink? Menu: " + DrinkFactory.getReadableList());
      if((readLine = kb.nextLine()).equals("bye"))
        break;
      you.order(readLine);
    }
  }
}
