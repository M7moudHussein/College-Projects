package queue;

/** A queue Interface. */
public interface IQueue {
  /**
   * Inserts an item at the queue front.
   * @param item
   *          an Item to be enqueued
   */
  void enqueue(final Object item);

  /**
   * Removes the object at the queue rear and returns it.
   * @return the object that has been dequeued
   */
  Object dequeue();

  /**
   * Tests if this queue is empty.
   * @return true if the queue is empty else false
   */
  boolean isEmpty();

  /**
   * @return the number of elements in the queue
   */
  int size();
}