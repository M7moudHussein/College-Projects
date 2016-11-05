package stack.cs73;

import linkedList.cs73.DoublyLinkedList;
import stack.IStack;

/**
 * Implementation for the stack data structure bases on a linked list
 * implementation.
 * @author Mahmoud Mohammed Hussein.
 */
public class MyStack implements IStack {
  /**
   * Doubly Linked list used to implement the stack.
   */
  private DoublyLinkedList stack = new DoublyLinkedList();

  /**
   * Inserts a specified element at the specified position in the list.
   * @param index
   *          zero-based index
   * @param element
   *          object to insert
   */
  public final void add(final int index, final Object element) {
    stack.add(index, element);
  }

  /**
   * Removes the element at the top of stack and returns that element.
   * @return top of stack element, or through exception if empty
   */
  public final Object pop() {
    Object ret = stack.get(stack.size() - 1);
    stack.remove(size() - 1);
    return ret;
  }

  /**
   * Get the element at the top of stack without removing it from stack.
   * @return top of stack element, or through exception if empty
   */
  public final Object peek() {
    return stack.get(stack.size() - 1);
  }

  /**
   * Pushes an item onto the top of this stack.
   * @param element
   *          to insert
   */
  public final void push(final Object element) {
    stack.add(element);
  }

  /**
   * Tests if this stack is empty.
   * @return true if stack empty
   */
  public final boolean isEmpty() {
    return stack.isEmpty();
  }

  /**
   * Returns the number of elements in the stack.
   * @return number of elements in the stack
   */
  public final int size() {
    return stack.size();
  }
}
