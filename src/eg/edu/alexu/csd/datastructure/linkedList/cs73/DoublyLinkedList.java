package eg.edu.alexu.csd.datastructure.linkedList.cs73;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * @author mahmoud-pc
 */
public class DoublyLinkedList implements ILinkedList {
  /**
   * The head if the linkedList, it's not a dummy node.
   */
  private Link head;
  /**
   * The tail if the linkedList, it's not a dummy node.
   */
  private Link tail;
  /**
   * The size if the linkedList.
   */
  private int size;

  /**
   * @category doubly linked list initialization.
   */
  public DoublyLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  /**
   * @param index
   *          index to add the element in
   * @param element
   *          element to be added at the end of the list
   * @see eg.edu.alexu.csd.datastructure.linkedList.ILinkedList#add(int,
   *      java.lang.Object)
   */
  public final void add(final int index, final Object element) {
    if (index > size || index < 0) {
      throw new RuntimeException("IndexOutOfBound");
    }
    if (index == size) {
      add(element);
      return;
    }
    if (isEmpty()) {
      Link newData = new Link(element);
      head = newData;
      tail = newData;
      size++;
      return;
    }
    if (index == 0) {
      Link newData = new Link(null, element, head);
      head.setPrevious(newData);
      head = newData;
      size++;
      return;
    }
    Link current = head;
    for (int i = 0; i < index - 1; i++) {
      current = current.getNext();
    }
    Link newData = new Link(current, element, current.getNext());
    current.getNext().setPrevious(newData);
    current.setNext(newData);
    size++;
  }

  /**
   * @param element
   *          element to be added at the end of the list
   * @see eg.edu.alexu.csd.datastructure.linkedList.ILinkedList
   *      #add(java.lang.Object)
   */
  public final void add(final Object element) {
    if (isEmpty()) {
      Link newData = new Link(element);
      head = newData;
      tail = newData;
      size++;
      return;
    }
    Link newData = new Link(tail, element, null);
    tail.setNext(newData);
    tail = newData;
    size++;
  }

  /**
   * Returns the element at the specified position in this list.
   * @param index
   *          of an object
   * @return the object in an index
   */
  public final Object get(final int index) {
    if (index < 0 || index >= size) {
      throw new RuntimeException("IndexOutOfBound");
    }
    if (index == size - 1) {
      return tail.getData();
    }
    Link current = head;
    int it = 0;
    while (it < index) {
      current = current.getNext();
      it++;
    }
    return current.getData();
  }

  /**
   * Replaces the element at the specified position in this list with the
   * specified element.
   * @param index
   *          of the object to be set
   * @param element
   *          element to be replaced with the object in index index
   */
  public final void set(final int index, final Object element) {
    if (index >= size || index < 0) {
      throw new RuntimeException("IndexOutOfBound");
    }
    if (index == size - 1) {
      tail.setData(element);
      return;
    }
    Link current = head;
    for (int j = 0; j < index; j++) {
      current = current.getNext();
    }
    current.setData(element);
  }

  /** Removes all of the elements from this list. */
  public final void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  /**
   * @return true if this list contains no elements.
   */
  public final boolean isEmpty() {
    return head == null;
  }

  /**
   * Removes the element at the specified position in this list.
   * @param index
   *          the index of the element to be removed
   */
  public final void remove(final int index) {
    if (index >= size || index < 0) {
      throw new RuntimeException("IndexOutOfBound");
    }
    if (size == 1) {
      clear();
      return;
    }
    if (index == 0) {
      head.getNext().setPrevious(null);
      head = head.getNext();
      size--;
      return;
    }
    if (index == size - 1) {
      tail = tail.getPrevious();
      tail.setNext(null);
      size--;
      return;
    }
    Link current = head;
    for (int i = 0; i < index - 1; i++) {
      current = current.getNext();
    }
    current.getNext().getNext().setPrevious(current);
    current.setNext(current.getNext().getNext());
    size--;
  }

  /**
   * @return the number of elements in this list.
   */
  public final int size() {
    return size;
  }

  /**
   * @param fromIndex
   *          the start index of the subList
   * @param toIndex
   *          the end index of the subList
   * @return a view of the portion of this list between the specified fromIndex
   *         and toIndex, inclusively.
   */
  public final ILinkedList sublist(final int fromIndex, final int toIndex) {
    DoublyLinkedList sub = new DoublyLinkedList();
    if (fromIndex > toIndex || fromIndex >= size || toIndex >= size
        || fromIndex < 0 || toIndex < 0) {
      throw new RuntimeException("IndexOutOfBound");
    }
    Link current = head;
    for (int i = 0; i < fromIndex; i++) {
      current = current.getNext();
    }
    for (int i = fromIndex; i <= toIndex; i++) {
      sub.add(current.getData());
      current = current.getNext();
    }
    return sub;
  }

  /**
   * @param ob
   *          an object to check if it's in the List
   * @return true if this list contains an element with the same value as the
   *         specified element.
   */
  public final boolean contains(final Object ob) {
    Link forward = head;
    Link backward = tail;
    while (forward != backward && forward.getPrevious() != backward) {
      if (forward.getData().equals(ob) || backward.getData().equals(ob)) {
        return true;
      } else {
        forward = forward.getNext();
        backward = backward.getPrevious();
      }
    }
    if (forward.getData().equals(ob) || backward.getData().equals(ob)) {
      return true;
    }
    return false;
  }
}
