package junit_testing.arraylist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.collection.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest
{
  private ArrayList<String> emptyArray;
  private ArrayList<String> sizeTenArray;


  private String string1;
  private String string2;

  @BeforeEach void setUp()
  {
    string1 = "one";
    string2 = "two";
    emptyArray = new ArrayList<String>();
    sizeTenArray = new ArrayList<String>();

    for (int i = 0; i < 10; i++)
    {
      sizeTenArray.add(string1);
    }
  }

  @AfterEach void tearDown()
  {
    emptyArray = null;
  }


  // --- ZERO --- //
  @Test void emptyArray()
  {
    assertEquals(emptyArray.isEmpty(), true);
  }

  @Test void zeroItemsInArray()
  {
    emptyArray.add(string1);
    emptyArray.remove(0);
    assertEquals(emptyArray.size(), 0);
  }

  // --- ONE --- //

  @Test void addOneItem()
  {
    emptyArray.add(string1);
    assertEquals(emptyArray.size(), 1);
  }

  @Test void listNotEmpty()
  {
    emptyArray.add(string1);
    assertEquals(emptyArray.isEmpty(), false);
  }

  // --- MANY --- //

  @Test void addMultipleItems()
  {
    emptyArray.add(string1);
    emptyArray.add(string2);
    assertEquals(emptyArray.size(), 2);
  }

  // --- BOUNDARY ---- //

  @Test void getFirst()
  {
    emptyArray.add(0, string1);
    assertEquals(emptyArray.get(0), string1);
  }

  @Test void getLast()
  {
    sizeTenArray.add(9, string2);
    assertEquals(sizeTenArray.get(9), string2);
  }

  @Test void getMiddleElement()
  {
    sizeTenArray.set(4, string2);
    assertEquals(sizeTenArray.get(4), string2);
  }

  @Test void getOutsideIndexFront()
  {
    assertThrows(IllegalStateException.class, () -> sizeTenArray.get(-1));
  }

  @Test void getOutsideIndexBack()
  {
    assertThrows(IllegalStateException.class, () -> sizeTenArray.get(10));
  }

  // -- EXCEPTIONS --- //

  @Test void setOutsideIndexFront()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> sizeTenArray.set(-1, string1));
  }

  @Test void setOutsideIndexBack()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> sizeTenArray.set(10, string1));
  }

 @Test void checkingException()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> sizeTenArray.add(10, string1));
  }


}