public class Solution {
  public long kth(int k) {
    //Assume: k > = 1
    // minHeap, find the smallest and from that point generate three direction
    //initial : k ==1
    // S: O(k); T: O(klogk)
    //data type is long, just in case it's over the scope
    PriorityQueue<Long> minHeap = new PriorityQueue<>();
    Set<Long> visited = new HashSet<>();
    minHeap.add(3*5*7l);
    visited.add(3*5*7l);
    while(k > 1) {
       long current = minHeap.poll(); // logk
       //x
       //set中没有重复值，加入成功
      if(visited.add(current * 3)) {
        minHeap.offer(current * 3);
      }
      // y
      if(visited.add(current * 5)) {
        minHeap.offer(current * 5);
      }
      //z
      if(visited.add(current * 7)) {
        minHeap.offer(current * 7);
      }
      k--;
    }
    return minHeap.poll();
  }
}
