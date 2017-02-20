package heap;

import static org.junit.Assert.*;

import java.util.PriorityQueue;
import java.util.Random;

import org.junit.Test;

public class HeapTest {

    @Test
    public void test() {
	PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	MinPriorityQueue<Integer> myQueue = new MinPriorityQueue<Integer>();
	Random rand = new Random();
	for (int i = 0; i < 10000; i++) {
	    int randomNum = rand.nextInt(1000);
	    queue.add(randomNum);
	    myQueue.add(randomNum);
	}
	while (!queue.isEmpty() && !myQueue.isEmpty()) {
	    assertEquals(queue.size(), myQueue.size());
	    assertEquals(queue.peek(), myQueue.getMin());
	    assertEquals(queue.poll(), myQueue.poll());
	    assertEquals(queue.size(), myQueue.size());
	    assertEquals(queue.isEmpty(), myQueue.isEmpty());
	}
    }

}
