package eg.edu.alexu.csd.datastructure.linkedList.cs73;

/**
 * The node of the doubly linked list.
 */
class Link {
  /**
   * Node Data.
   */
  private Object data;
  /**
   * A reference to the next Node.
   */
  private Link next;
  /**
   * A reference to the previous node.
   */
  private Link previous;

  /**
   * Constructor to Set Node Data.
   * @param myData
   *          Node data
   */
  Link(final Object myData) {
    previous = null;
    next = null;
    data = myData;
  }

  /**
   * A getter function to get the next node.
   * @return A reference to the next node
   */
  public Link getNext() {
    return next;
  }

  /**
   * A getter function to get the previous node.
   * @return A reference to the previous node
   */
  public Link getPrevious() {
    return previous;
  }

  /**
   * @param myNext
   *          link to the next node.
   */
  public void setNext(final Link myNext) {
    next = myNext;
  }

  /**
   * @return Node Data
   */
  public Object getData() {
    return data;
  }

  /**
   * A data setter.
   * @param myData
   *          Node new Data
   */
  public void setData(final Object myData) {
    data = myData;
  }

  /**
   * @param myPrevious
   *          link to the previous node.
   */
  public void setPrevious(final Link myPrevious) {
    previous = myPrevious;
  }

  /**
   * Constructor to set node data , next and previous references.
   * @param myPrevious
   *          A reference to the previous node
   * @param myData
   *          The node data
   * @param myNext
   *          A reference to the next node
   */
  Link(final Link myPrevious, final Object myData, final Link myNext) {
    previous = myPrevious;
    data = myData;
    next = myNext;
  }
}
