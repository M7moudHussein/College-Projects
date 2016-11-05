package linkedList.cs73;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import linkedList.ILinkedList;

/**
 * Junit Test class.
 */
public class JunitTest {
  /**
   * An object to make our test.
   */
  private ILinkedList obj;
  /** Just A Magic Number. */
  private static final int NUM3 = 3;
  /** Just A Magic Number. */
  private static final int NUM4 = 4;
  /** Just A Magic Number. */
  private static final int NUM5 = 5;
  /** Just A Magic Number. */
  private static final int NUM6 = 6;
  /** Just A Magic Number. */
  private static final int NUM9 = 9;
  /** Just A Magic Number. */
  private static final int NUM10 = 10;
  /** Just A Magic Number. */
  private static final int NUM20 = 20;
  /** Just A Magic Number. */
  private static final int NUM30 = 30;
  /** Just A Magic Number. */
  private static final int NUM50 = 50;
  /** Just A Magic Number. */
  private static final int NUM90 = 90;
  /** Just A Magic Number. */
  private static final int NUM99 = 99;

  /**
   * Initialization function.
   */
  @Before
  public final void init() {
    obj = new SinglyLinkedList();
    // obj = new DoublyLinkedList();
  }

  /**
   * A function to test the corner cases.
   */
  @Test(expected = RuntimeException.class)
  public final void cornerTest() {
    obj.add(0, NUM10);
    obj.add(1, NUM20);
    obj.add(1, NUM30);
    obj.add(-1 * NUM10, NUM90);
    obj.add(NUM90, NUM50);
    obj.get(-1 * NUM90);
    obj.set(-1 * NUM3, NUM50);
    obj.set(NUM99, NUM90);
    obj.remove(-1);
    obj.clear();
    obj.remove(0);
    obj.add(0);
    obj.add(1);
    obj.add(2);
    obj.sublist(-1, 2);
    obj.sublist(2, 1);
    obj.sublist(-1, NUM3);
    obj.sublist(0, NUM5);
  }

  /**
   * Test Function get.
   */
  @Test
  public final void testget() {
    obj.add(0, NUM10);
    obj.add(1, NUM30);
    obj.add(NUM20);
    assertEquals(NUM10, (int) obj.get(0));
    assertEquals(NUM10, (int) obj.get(0));
    assertEquals(NUM20, (int) obj.get(2));
  }

  /**
   * Test Function remove.
   */
  @Test
  public final void testRemove() {
    obj.add(0, NUM10);
    obj.add(1, NUM30);
    obj.add(NUM20);
    obj.remove(1);
    assertEquals(NUM20, obj.get(1));
  }

  /**
   * Test Function clear.
   */
  @Test
  public final void testclear() {
    obj.add(0, NUM10);
    obj.add(1, NUM30);
    obj.add(NUM20);
    obj.clear();
    assertEquals(0, obj.size());
    assertEquals(true, obj.isEmpty());
  }

  /**
   * Test Function size.
   */
  @Test
  public final void testSize() {
    obj.add(0, NUM10);
    obj.add(1, NUM30);
    obj.add(NUM20);
    assertEquals(NUM3, obj.size());
    obj.add(NUM30);
    obj.add(1, obj.size());
    assertEquals(NUM5, obj.size());
    obj.remove(2);
    assertEquals(NUM4, obj.size());
    obj.clear();
    assertEquals(0, obj.size());
  }

  /**
   * Test Function set.
   */
  @Test
  public final void testSet() {
    obj.add(0, NUM10);
    obj.add(1, NUM30);
    obj.add(NUM20);
    obj.set(1, -1);
    assertEquals(-1, obj.get(1));
  }

  /**
   * Test Function sublist.
   */
  @Test
  public final void testsub() {
    for (int i = 1; i <= NUM9; i++) {
      obj.add(i);
    }
    SinglyLinkedList sub = new SinglyLinkedList();
    sub = (SinglyLinkedList) obj.sublist(2, NUM5);
    int[] arr = new int[NUM4];
    for (int i = 0; i <= NUM3; i++) {
      arr[i] = (int) sub.get(i);
    }
    int[] real = {NUM3, NUM4, NUM5, NUM6};
    assertArrayEquals(real, arr);
    assertEquals(NUM4, sub.size());
    sub.clear();
    sub = (SinglyLinkedList) obj.sublist(NUM5, NUM5);
    assertEquals(1, sub.size());
    assertEquals(NUM6, (int) sub.get(0));
    assertEquals(NUM3, (int) obj.get(2));
  }

}
