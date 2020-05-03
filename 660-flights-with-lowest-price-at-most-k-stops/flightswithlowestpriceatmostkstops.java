public class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    // build graph
    //travsal graph anh pruning
    //T: O(n ^(k+1)) S: O(n ^(k+1))
    // build graph <cur flight, the nei of cur flight and its cost>
    Map<Integer, List<int[]>> map = new HashMap<>();
    for(int[] edge: flights) {
      if(!map.containsKey(edge[0])) {
        map.put(edge[0], new ArrayList<>());
      }
      map.get(edge[0]).add(new int[]{edge[1],edge[2]});
    }
    //int[] = {cur flight, cost to cur flight};
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{src,0});
    int stop = 0;
    int cost = Integer.MAX_VALUE;
    while(!queue.isEmpty()) {
      //size: the num of possibility for the cur level
      int size = queue.size();
      for(int i = 0; i < size; i++) {
        int[] cur = queue.poll();
        //update the final cost
        if(cur[0] == dst) {
          cost = Math.min(cost, cur[1]);
        }
        List<int[]> neig = map.get(cur[0]);
        // no neighbor
        if(neig == null) {
          continue;
        }
        for(int[] nei : neig) {
          if(cur[1] + nei[1] < cost) {
            queue.offer(new int[]{nei[0],cur[1] + nei[1]});
          }
        }
      }
      if(stop++>k) {
        break;
      }
    }
    return cost != Integer.MAX_VALUE? cost : -1;
  }
}
