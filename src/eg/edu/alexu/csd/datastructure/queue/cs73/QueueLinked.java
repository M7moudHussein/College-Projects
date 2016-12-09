package eg.edu.alexu.csd.datastructure.queue.cs73;

import eg.edu.alexu.csd.datastructure.linkedList.cs73.DoublyLinkedList;
import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/** Queue Implementation Based On DOublyLinked list. */
public class QueueLinked implements IQueue, ILinkedBased {
  /**
   * A Linkedlist used to implement the queue.
   */
  private DoublyLinkedList myQueue = new DoublyLinkedList();

  @Override
  public final void enqueue(final Object item) {
    myQueue.add(item);
  }

  @Override
  public final Object dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Queue is Empty");
    }
    Object ret = myQueue.get(0);
    myQueue.remove(0);
    return ret;
  }

  @Override
  public final boolean isEmpty() {
    return myQueue.isEmpty();
  }

  @Override
  public final int size() {
    return myQueue.size();
  }

}
