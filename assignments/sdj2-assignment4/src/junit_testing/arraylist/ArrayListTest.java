package junit_testing.arraylist;

import flyweight.Valuable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.collection.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest
{
  private ArrayList<Valuable> testArrayList;

  @BeforeEach void setUp()
  {
    testArrayList = new ArrayList<Valuable>();
  }

  @AfterEach void tearDown()
  {
    testArrayList = null;
  }

  @Test void add()
  {
    //Zero

  }

  @Test void testAdd()
  {
  }

  @Test void set()
  {
  }

  @Test void get()
  {
  }

  @Test void remove()
  {
  }

  @Test void testRemove()
  {
  }

  @Test void indexOf()
  {
  }

  @Test void contains()
  {
  }

  @Test void isEmpty()
  {
  }

  @Test void isFull()
  {
  }

  @Test void size()
  {
  }
}