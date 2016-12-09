package eg.edu.alexu.csd.datastructure.linkedList.cs73;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/** An implementation of the singlyLinked list. */
public class SinglyLinkedList implements ILinkedList {
  /** The head of the list,It's not a dummy head. */
  private Node head = null;
  /** The size of the linkedList. */
  private int size = 0;

  /**
   * Inserts a specified element at the specified sposition in the list.
   * @param index
   *          to add element in.
   * @param element
   *          Element to be added in the index
   */
  public final void add(final int index, final Object element) {
    if (index > size || index < 0) {
      throw new RuntimeException("IndexOutOfBound");
    }
    Node newdata = new Node(element);
    if (index == 0) {
      newdata.setNext(head);
      head = newdata;
      size++;
      return;
    }
    Node current = head;
    for (int i = 1; i < index; i++) {
      current = current.getNext();
    }
    newdata.setNext(current.getNext());
    current.setNext(newdata);
    size++;
  }

  /**
   * Inserts the specified element at the end of the list.
   * @param element
   *          Element to be added at the end if the array
   */
  public final void add(final Object element) {
    if (head == null) {
      head = new Node(element);
    } else {
      Node current = head;
      Node newdata = new Node(element);
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newdata);
    }
    size++;
  }

  /**
   * Returns the element at the specified position in this list.
   * @param index
   *          to get the data from
   * @return the object in that index
   */
  public final Object get(final int index) {
    if (index < 0 || index >= size) {
      throw new RuntimeException("IndexOutOfBound");
    }
    Node current = head;
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
   *          index to set its data
   * @param element
   *          an object to be added instead of that at index "index"
   */
  public final void set(final int index, final Object element) {
    if (index >= size || index < 0) {
      throw new RuntimeException("IndexOutOfBound3");
    }
    Node current = head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    current.setData(element);
  }

  /** Removes all of the elements from this list. */
  public final void clear() {
    head = null;
    size = 0;
  }

  /**
   * Returns true if this list contains no elements.
   * @return true if the list is empty and false if it's not
   */
  public final boolean isEmpty() {
    return head == null;
  }

  /**
   * Removes the element at the specified position in this list.
   * @param index
   *          to be removed from the list
   */
  public final void remove(final int index) {
    if (index == 0) {
      head = head.getNext();
      size--;
      return;
    }
    if (index >= size || index < 0) {
      throw new RuntimeException("IndexOutOfBound");
    }
    Node current = head;
    for (int i = 0; i < index - 1; i++) {
      current = current.getNext();
    }
    current.setNext(current.getNext().getNext());
    size--;
  }

  /**
   * @return the size of the list
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
    SinglyLinkedList sub = new SinglyLinkedList();
    if (fromIndex > toIndex || fromIndex >= size || toIndex >= size
        || fromIndex < 0 || toIndex < 0) {
      throw new RuntimeException("IndexOutOfBound");
    }
    Node current = head;
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
    Node current = head;
    while (current != null) {
      if (current.getData().equals(ob)) {
        return true;
      }
      current = current.getNext();
    }
    return false;
  }

  /** Sorts A Linked List using bubble sort. */
  public final void sort() {
    for (int i = 0; i < size; i++) {
      Node current = head;
      for (int j = 0; j < size - 1; j++) {
        if (current == null) {
          break;
        }
        Point t1 = new Point((Point) current.getData());
        Point t2 = new Point((Point) current.getNext().getData());
        if (t2.y > t1.y) {
          current.setData(t2);
          current.getNext().setData(t1);
        }
        current = current.getNext();
      }
    }
  }

}
