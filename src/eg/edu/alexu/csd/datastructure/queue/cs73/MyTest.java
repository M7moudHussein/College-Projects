package eg.edu.alexu.csd.datastructure.queue.cs73;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/** A Junit test implementation to test the queue implementation. */
public class MyTest {
  /** To set the Size of the array based queue. */
  private static final int QUEUESIZE = 500;
  /** magic Number 5. */
  private static final int MAG_500 = 500;
  /** Magic Number 10. */
  private static final int MAG_100 = 100;

  /** A reference to the queue. */
  private IQueue myQueue;

  /** to choose whether to test the array based queue or the linked based. */
  final void testMode() {
    myQueue = new QueueLinked();
    // myQueue = new QueueArray(QUEUESIZE);
  }

  /** Test Size. */
  @Test
  public final void testSize() {
    testEnqueue();
    assertEquals(QUEUESIZE, myQueue.size());
    testMode();
  }

  /** Test Enqueue. */
  @Test
  public final void testEnqueue() {
    testMode();
    for (int i = 0; i < QUEUESIZE; i++) {
      myQueue.enqueue(i);
    }
    assertEquals(QUEUESIZE, myQueue.size());
  }

  /** Test Dequeue. */
  @Test
  public final void testDequeue() {
    testMode();
    for (int i = MAG_500; i < MAG_100; i++) {
      myQueue.enqueue(i);
    }
    for (int i = MAG_500; i < MAG_100; i++) {
      assertEquals(i, myQueue.dequeue());
    }
  }

  /** Test Dequeue From empty queue. */
  @Test(expected = RuntimeException.class)
  public final void testDequeueWhenEmpty() {
    testMode();
    myQueue.dequeue();
  }

  /** Test Enqueue while queue is full. */
  @Test(expected = RuntimeException.class)
  public final void testEnqueueWhenFull() {
    testMode();
    if (IArrayBased.class.isInstance(myQueue)) {
      for (int i = 0; i <= MAG_500; i++) {
        myQueue.enqueue(i);
      }
    } else {
      throw new RuntimeException();
    }
  }

  /** Test isEmpty. */
  @Test
  public final void testIsEmpty() {
    testMode();
    assertEquals(true, myQueue.isEmpty());
    myQueue.enqueue(MAG_500);
    assertEquals(false, myQueue.isEmpty());
  }

}
