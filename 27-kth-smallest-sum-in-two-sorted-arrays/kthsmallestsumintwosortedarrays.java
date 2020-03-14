public class Solution {
  public int kthSum(int[] A, int[] B, int k) {
    // a, b are sorted
    // k >= 0 && k <= a.length * b.length
    //T: klogk S: O(k)
    PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>(){
      @Override
      public int compare(List<Integer> list1, List<Integer> list2) {
        int s1= A[list1.get(0)] + B[list1.get(1)];
        int s2 = A[list2.get(0)] + B[list2.get(1)];
        if(s1 == s2) {
          return 0;
        }
        return s1 < s2? -1:1;
      }
    });
    Set<List<Integer>> visited = new HashSet<>();
    List<Integer> cur = Arrays.asList(0, 0);
    minHeap.offer(cur);
    visited.add(cur);
    while(k > 0) {
      cur = minHeap.poll();
      List<Integer> tmp = Arrays.asList(cur.get(0)+1, cur.get(1));
      if(cur.get(0) + 1 < A.length && visited.add(tmp)) {
        minHeap.add(tmp);
      }
      tmp = Arrays.asList(cur.get(0), cur.get(1) + 1);
      if(cur.get(1) + 1 < B.length && visited.add(tmp)) {
        minHeap.add(tmp);
      }
      k--;
    }
    return A[cur.get(0)] + B[cur.get(1)];
  }
}
