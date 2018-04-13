package tests;

import java.util.Random;

import queues.BinaryHeapQueue;

public class PQueueTest {

	public static void main(String[] args) {
	BinaryHeapQueue<Integer> h = new BinaryHeapQueue<Integer>();

	System.out.println("Empty BinaryHeapQueue:\t" + h);
	h.enqueue(1);
	System.out.println(h);
	h.enqueue(2);
	System.out.println(h);

	Random r = new Random();
	for (int i = 0; i<10; i++) {
		h.enqueue(r.nextInt(10));
	}

	h.insertUnordered(11);
	h.insertUnordered(22);
	h.insertUnordered(33);

	int[] testArray = new int[5];
	for (int i = 0; i < 5; i++) {
		testArray[i] = i*10;
	}

	h.insertUnordered(testArray);
	System.out.println("InsertUnordered(testArray):\t" + h);
	h.heapify();
	h.insert(66);
	System.out.println("insert(66):\t\t\t" + h);
	System.out.println("max(): " + h.max());
	h.removeMax();
	System.out.println("RemoveMax(): \t\t" + h);
	h.removeNLargest(3);
	System.out.println("RemoveNLargest(3): \t\t" + h);
	System.out.println("size(): " + h.size());

	BinaryHeapQueue<Integer> bh = new BinaryHeapQueue<Integer>();
	for (int i = 0; i < 5; i++) {
		testArray[i] = (i+6)*10 + 9;
	}
	bh.insertUnordered(testArray);
	h.merge(bh);
	System.out.println("merge(testArray):\t\t" + h);


	// while (!h.isEmpty()) {
	//   System.out.println(h.dequeue());
	// }
	// System.out.println(h);



	}

}