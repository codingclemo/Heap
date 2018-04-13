package tests;

import java.util.Random;

import queues.BinaryHeapQueue;

public class PQueueTest {

  public static void main(String[] args) {
    BinaryHeapQueue<Integer> h = new BinaryHeapQueue<Integer>();
    System.out.println(h);
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

    System.out.println(h);

    h.heapify();
    h.insert(66);
    System.out.println(h);
    System.out.println("max is: " + h.max());
    h.removeMax();
    System.out.println(h);

    // while (!h.isEmpty()) {
    //   System.out.println(h.dequeue());
    // }
    // System.out.println(h);

    

  }

}