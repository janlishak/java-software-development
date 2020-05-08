import Drinks.Drink;

public class BarGuest
{
  public void order(String drinkName)
  {
    System.out.println("wait for the drink to be made..");
    Drink drink = DrinkFactory.getDrink(drinkName);
    try { Thread.sleep(2345); } catch (Exception e) { }
    System.out.println("you got " + drink);
    System.out.println("you are drinking your drink..");
    try { Thread.sleep(2345); } catch (Exception e) { }
    System.out.println("you have drank you drink");
    System.out.println("you are waiting for the bartender..");
    try { Thread.sleep(1234); } catch (Exception e) { }
  }
}
