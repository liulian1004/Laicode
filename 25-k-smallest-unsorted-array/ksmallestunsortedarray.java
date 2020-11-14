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
  // partition sort
  public int[] kSmallest(int[] array, int k) {
    // T: klogk + h.logk S: o(h)
    // for the recusion part the upper bound will be h.logn
    if(array == null || array.length == 0) {
      return array;
    }
    if(k <= 0) {
      return new int[]{};
    }
    int[] res = new int[k];
    helper(array, 0 , array.length- 1, k, res);
    Arrays.sort(res); //k.logk
    return res;
  }
  private void helper(int[] array, int left, int right, int k, int[] res) {
    int pivot = left + (int)(Math.random()*(right-left+1));
    swap(array, right, pivot);
    int i = left;
    int j = right - 1;
    while(i <= j){
      if(array[i] <= array[right]) {
        i++;
      }else if (array[j] > array[right]) {
        j--;
      }else {
        swap(array, i++, j--);
      }
    }
    swap(array, i, right);
    if(i-left+1 == k) {
      for(int p = left; p <= i; p++) {
        res[p] = array[p];
      }
      return;
    }else if(i-left+1 > k) {
      helper(array, left, i-1, k, res);
    }else {
      for(int p = left; p <= i; p++) {
        res[p] = array[p];
      }
      helper(array, i+1,right, k-(i-left+1),res);
    }
  }
  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
