package eg.edu.alexu.csd.datastructure.queue.cs73;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/** Queue Implementation Based On Array. */
public class QueueArray implements IQueue, IArrayBased {
  /** An Array used to implement An ArrayBased quque. */
  private Object[] myQueue;
  /** Pointer t the cell after the las element in the queue. */
  private int r = 0;
  /** Pointer to the front of the queue. */
  private int f = 0;
  /** The array Size. */
  private int n = 0;

  /**
   * Queue Constructor.
   * @param size
   *          Queue Size
   */
  public QueueArray(final int size) {
    n = size + 1;
    myQueue = new Object[n];
  }

  @Override
  public final void enqueue(final Object item) {
    if (size() == n - 1) {
      throw new RuntimeException("Queue is full");
    }
    myQueue[r] = item;
    r = (r + 1) % n;
  }

  @Override
  public final Object dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Queue is Empty");
    }
    Object ret = myQueue[f];
    myQueue[f] = null;
    f = (f + 1) % n;
    return ret;
  }

  @Override
  public final boolean isEmpty() {
    return f == r;
  }

  @Override
  public final int size() {
    return (n - f + r) % n;
  }

}
