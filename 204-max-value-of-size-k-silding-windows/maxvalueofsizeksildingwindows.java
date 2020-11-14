public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    // deque only keep the index of currently max or could be the max in the future
    // if array[i] > deque.left, poll last
    // if deque.size > k, poll deque.first
    // max = peekfirst

    //T: O(n); S: O(k)
    List<Integer> list = new ArrayList<>();
    if(array == null || array.length == 0) {
      return list;
    }
    Deque<Integer> deque = new ArrayDeque<>();
    for(int i = 0; i< array.length; i++) {
        while(!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
          deque.pollLast();
        }
        // the index of element is out of the scope of current sliding window
        if(!deque.isEmpty() && deque.peekFirst() <= i - k) {
          deque.pollFirst();
        }
        deque.offerLast(i);
        if(i >= k -1 ) {
          int max = array[deque.peekFirst()];
          list.add(max);
        }
    }
    return list;
  }
}
