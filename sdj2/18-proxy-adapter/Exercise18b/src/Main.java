import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {
    //Create a SeaBear proxy
    VisitSeaBear seaBear = new SeeBearGuard();

    //Tester Program
    Scanner kb = new Scanner(System.in);
    String read = "";
    while(true){
      System.out.print("your visitor type: ");
      String visitorType = kb.nextLine();
      System.out.print("action you want to take? [1: view, 2: pet, 3:feed]: ");
      switch (kb.nextInt()){
        case 1:
          seaBear.view(visitorType);break;
        case 2:
          seaBear.pet(visitorType);break;
        case 3:
          seaBear.feed(visitorType);break;
        default:break;
      }
      kb.nextLine();
    }
  }
}
