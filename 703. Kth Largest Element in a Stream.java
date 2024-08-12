/** 703. Kth Largest Element in a Stream
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

