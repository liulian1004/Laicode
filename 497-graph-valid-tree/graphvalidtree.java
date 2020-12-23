public class Solution {
  public boolean validTree(int n, int[][] edges) {
    // corner case n < 1 no node
    if(n < 1){
      return false;
    }
    Map<Integer, List<Integer>> map = buildGraph(edges, n);
    Set<Integer> set = new HashSet<>();
    Queue<Integer> queue = new ArrayDeque<>();
    //search from node 0
    queue.offer(0);
    while(!queue.isEmpty()){
        int cur = queue.poll();
        // has visted before there is a circual
        if(!set.add(cur)){
          return false;
        }
        List<Integer> list = map.get(cur);
        for(int i: list){
          queue.offer(i);
          //remove the edge
          map.get(i).remove((Integer)(cur));
        }
      }
      // incase, there is two tree that not conected together, so finally check the size of set
      return set.size() == n;
  }
  private boolean search(int start, Set<Integer> set,Map<Integer, List<Integer>> map){
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(start);
    while(!queue.isEmpty()){
        int cur = queue.poll();
        if(!set.add(cur)){
          return false;
        }
        if(map.containsKey(cur)){
          List<Integer> list = map.get(cur);
          for(int i: list){
            queue.offer(i);
          }
        }
      }
    return true;
  }

  private Map<Integer, List<Integer>> buildGraph(int[][] edges, int n){
    Map<Integer, List<Integer>> map = new HashMap<>();
    //给每一个node建map
    for(int i = 0; i < n;i++){
      map.put(i, new ArrayList<>());
    }
    //build edge
    for(int[] pair:edges){
      map.get(pair[0]).add(pair[1]);
      map.get(pair[1]).add(pair[0]);
    }
    return map;
  }
}
