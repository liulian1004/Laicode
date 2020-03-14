public class Solution {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    //  k >= 1 && k <= a.length * b.length * c.length
    //euclidean distance = (x1 - x2) ^2 + (y1- y2) ^ 2 + (z1 - z2) ^ 3
    //initial point {0,0,0}
    // put the initial point into the minHeap, and generate three direction, x, y, z
    // find the kth smallest point, and replace by the real value from a, b,c
    // use set to remove the depulicated element
    //T: klogk
    //S: O(k)
    PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
          @Override
          public int compare(List<Integer> list1, List<Integer> list2) {
            Long distance1 = getDistance(list1, a, b, c);
            Long distance2 = getDistance(list2, a, b, c);
            if(distance1 == distance2) {
              return 0;
            }
            return distance1 < distance2? -1 : 1;
          }
    });
    Set<List<Integer>> visited = new HashSet<>();
    //initialization
    List<Integer> cur = Arrays.asList(0,0,0); // T: O(1)
    minHeap.offer(cur);
    visited.add(cur);
    while(k > 0) {
      cur = minHeap.poll();
      List<Integer> tmp = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
      if(cur.get(0) + 1 < a.length && visited.add(tmp)) {
        minHeap.offer(tmp);
      }
      tmp = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
      if(cur.get(1) + 1 < b.length && visited.add(tmp)) {
        minHeap.offer(tmp);
      }
      tmp = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
      if(cur.get(2)+1 < c.length && visited.add(tmp)) {
        minHeap.offer(tmp);
      }
      k--;
    }
    // cur是第kth小的点，replace by the real value
    cur.set(0, a[cur.get(0)]);
    cur.set(1, b[cur.get(1)]);
    cur.set(2, c[cur.get(2)]);
    return cur;
  }
  private long getDistance(List<Integer> list, int[] a, int[] b, int[] c) {
    int distance = 0;
    distance += a[list.get(0)] * a[list.get(0)];
    distance +=b[list.get(1)] * b[list.get(1)];
    distance += c[list.get(2)] * c[list.get(2)];
    return distance;
  }
}
