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
    System.out.println(h);

    while (!h.isEmpty()) {
      System.out.println(h.dequeue());
    }
    System.out.println(h);
  }

}