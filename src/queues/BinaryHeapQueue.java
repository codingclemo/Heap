// file: heap/queues/Heap.java
package queues;
import java.util.ArrayList;
import queues.Heap;
import java.util.Collections;

public class BinaryHeapQueue<T extends Comparable<T>> extends Heap {

	public BinaryHeapQueue() {
		super();
	}

	public BinaryHeapQueue(BinaryHeapQueue<T> bhq) { // "copy constructor"
		super();
		values = bhq.copyValues();
	}

	public void insertUnordered(int elem) {
		values.add(elem);
	}

	public void insertUnordered(int[] elemArray) {
		for (int i = 0; i < elemArray.length; i++) {
		values.add(values.size(), elemArray[i]);
		}
	}

	public void heapify() {
		int lastIndex = values.size() - 1; // get the index of the last element in the array
		for (int i = lastIndex / 2; i >= 0; i--) { // decrement "up" the heap parent = (i-1)/2
		checkPos(i, lastIndex);
		}

		for (int i = lastIndex; i > 0; i--){
		Collections.swap(values, 0, i);
		lastIndex--;
		checkPos(0, lastIndex);
		}
	}

	// index of the successor and the newly added index on the last position are checked
	public void checkPos(int succ, int lastIndex) {
		int leftChild = left(succ);  // changed method to protected to work here
		int rightChild = right(succ);
		int thisPos = succ;

		if (leftChild <= lastIndex && (Integer) values.get(leftChild) < (Integer) values.get(thisPos))
			thisPos = leftChild;
		if (rightChild <= lastIndex && (Integer) values.get(rightChild) < (Integer) values.get(thisPos))
			thisPos = rightChild;
		if (thisPos != succ) {
			Collections.swap(values, succ, thisPos);
			checkPos(thisPos, lastIndex);
		}
	}

	public void insert(int elem) {
		// assert isHeap();
		insertUnordered(elem);
		heapify();
		// assert isHeap();
	}

	public int max() {
		if (values.isEmpty())
			throw new IllegalStateException("max() queue is empty");
		return (Integer) values.get(0);
	}

	public int removeMax() {
		if (values.isEmpty())
			throw new IllegalStateException("removeMax() queue is empty");
		return (Integer) dequeue();
	}

	public int[] nLargest(int n) {
		if(values.size() < n) 
			throw new IllegalArgumentException("nLargest(int n) not enough values stored in queue");
		
			BinaryHeapQueue<T> temp = new BinaryHeapQueue<T>(this);
			int[] result = new int[n];
			for (int i = 0; i < n; i++) {
				result[i] = (Integer) values.get(i);
			}
		return result;
	}

	private ArrayList<T> copyValues() {
        ArrayList<T> temp = new ArrayList<T>(values.size());
        temp.addAll(values);
        return temp; 
    }
}