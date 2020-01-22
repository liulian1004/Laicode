public class Solution {
  public int[] kSmallest(int[] array, int k) {
    // max heap
    // S: O(k)
    //Time: O(k.logk +(n-k)logk+ klogK) -> O((n+k)log k)
    if(array == null || array.length == 0 || k == 0) {
      return new int[0];
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<> (k, new ReverseComparator());
    for(int i = 0; i < array.length; i++) {
      if(i < k) {
        // T: klogk
        maxHeap.offer(array[i]);
      } else if( /*i >= k 这个情况走到这里一定是 i >=k && */  array[i] < maxHeap.peek()) {
        //T： 2(n-k)logk = (n-k)logk
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
    }
    int[] res = new int[k];
    //因为是max，所以这里要反向倒入res
    //T： klogk
    for(int i = k -1; i >= 0; i--) {
        res[i] = maxHeap.poll();
    }
    return res;
  }
  private static class ReverseComparator implements Comparator<Integer> {
     @Override
     public int compare(Integer a, Integer b) {
       if(a.equals(b)) {
   return 0;
   }
   return a > b? -1 : 1;
   }
  }
}
