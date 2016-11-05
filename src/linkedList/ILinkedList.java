package linkedList;

/**
 * @author mahmoud-pc
 */
public interface ILinkedList {
  /**
   * Inserts a specified element at the specified sposition in the list.
   * @param index
   *          index to add the element in
   * @param element
   *          element to be added in index
   */
  void add(int index, Object element);

  /**
   * Inserts the specified element at the end of the list.
   * @param element
   *          element to be added at the end of the list
   */
  void add(Object element);

  /**
   * Returns the element at the specified position in this list.
   * @param index
   *          the specified position in this list
   * @return returns the element at index index
   */
  Object get(int index);

  /**
   * Replaces the element at the specified position in this list with the
   * specified element.
   * @param index
   *          the index of the element which will be relaced
   * @param element
   *          the replacement of the element at index index
   */
  void set(int index, Object element);

  /** Removes all of the elements from this list. */
  void clear();

  /**
   * @return true if this list contains no elements.
   */
  boolean isEmpty();

  /**
   * Removes the element at the specified position in this list.
   * @param index
   *          the index of the element to be removed
   */
  void remove(int index);

  /**
   * @return the number of elements in this list.
   */
  int size();

  /**
   * @param fromIndex
   *          the start index of the subList
   * @param toIndex
   *          the end index of the subList
   * @return a view of the portion of this list between the specified fromIndex
   *         and toIndex, inclusively.
   */
  ILinkedList sublist(int fromIndex, int toIndex);

  /**
   * @param o
   *          an object to check if it's in the List
   * @return true if this list contains an element with the same value as the
   *         specified element.
   */
  boolean contains(Object o);
}
