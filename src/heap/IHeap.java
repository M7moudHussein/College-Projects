package heap;

public interface IHeap<T extends Comparable<T>> {

    public void add(T object);

    public T getMin();

    public T poll();

    public int size();
    
    public boolean isEmpty();
}
