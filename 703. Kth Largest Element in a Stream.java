/** 703. Kth Largest Element in a Stream
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
  */

import java.util.PriorityQueue;
class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
       
        this.minHeap = new PriorityQueue<>(k);
        this.k = k;

        for (int num : nums) {
            add(num);
        }
    }
    public int add(int val) {
      
        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

