package eg.edu.alexu.csd.datastructure.linkedList.cs73;

/**
 * Single Linked List Node.
 */
class Node {
  /** Node Data. */
  private Object data = null;
  /** A reference to the next node. */
  private Node next = null;

  /**
   * A constructor to initially set the node Data.
   * @param myData
   *          the node data
   */
  Node(final Object myData) {
    data = myData;
  }

  /**
   * @param myNext
   *          the next of the current node
   */
  public void setNext(final Node myNext) {
    next = myNext;
  }

  /**
   * @param myData
   *          the data of the node
   */
  public void setData(final Object myData) {
    data = myData;
  }

  /** @return the node data */
  public Object getData() {
    return data;
  }

  /** @return A reference to the next node */
  public Node getNext() {
    return next;
  }
}
