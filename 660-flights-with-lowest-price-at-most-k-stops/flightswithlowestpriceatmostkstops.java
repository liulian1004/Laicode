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
  //dfs my solution time out T: O(n^k) S: O(k) + O(map)
  //因为图可能有环，所以T不是v+E，只能按worse case 每一次branch为n-1
  if(flights == null || flights.length == 0 || flights[0].length == 0) {
            return -1;
        }
        if(dst == src) {
            return 0;
        }
        Map<Integer, List<Pair>> map = builder(flights);
        int res = Integer.MAX_VALUE;
        helper(map, res, 0, k+1,src,dst);
        return res == 0 ?-1 : res;

    }
    private void helper(Map<Integer, List<Pair>> map, int res, int cur, int level,int src, int dst) {
        if(level < 0){
            return;
        }
        if(src == dst) {
            res = Math.min(res,cur);
            return;
        }
        List<Pair> list = map.get(src);
        if(list == null) {
            return;
        }
        for(int i = 0; i < list.size(); i++) {
            if((cur + list.get(i).cost) < res) {
                helper(map, res, cur + list.get(i).cost, level-1,list.get(i).city, dst);
            }
        }
    }
    private Map<Integer, List<Pair>> builder(int[][] flights) {
       Map<Integer, List<Pair>> map = new HashMap<>();
        for(int[] group: flights) {
            if(!map.containsKey(group[0])) {
                map.put(group[0], new ArrayList<>());
            }
        map.get(group[0]).add(new Pair(group[1],group[2]));
        }
        return map;
    }

    static class Pair{
        int city;
        int cost;
        public Pair(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }
}
