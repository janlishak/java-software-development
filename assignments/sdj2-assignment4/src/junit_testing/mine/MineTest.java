package junit_testing.mine;

import flyweight.Mine;
import flyweight.Valuable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MineTest
{

  @Test void getValuable()
  {
    Valuable valuable1 = Mine.getValuable("ruby");
    System.out.println(valuable1);
  }

  @Test void getSameValuables()
  {
    Valuable valuable1 = Mine.getValuable("nugget");
    Valuable valuable2 = Mine.getValuable("nugget");
    assertEquals(valuable1.hashCode(), valuable2.hashCode());
  }

}