public class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
         // try to find the lowest tree as possible
         //topology algorithm
         // start from node(degree ==1)
         // bfs, until find all the left node are degree == 1
         // the result will be max 2 nodes
         // case 1: 中心点只有一个node
         //case 2: 中心点有两个node
        List<Integer> list = new ArrayList<>();
        if(n <= 2){
            for(int i = 0; i < n; i++){
                list.add(i);
            }
            return list;
        }
        Map<Integer, List<Integer>> map = buildMap(edges, n);
        Queue<Integer> queue = new ArrayDeque<>();
         //start from the node
        for(int i = 0; i < n; i++){
            if(map.get(i).size() == 1){
                queue.offer(i);
            }
        }
        int left = n;
        while(left > 2){
             int size = queue.size();
            //跟新剩余node的数量
             left -= size;
            for(int i =0 ; i < size; i++){
                int cur = queue.poll();
                int remove = map.get(cur).get(0);
                map.get(remove).remove((Integer)cur);
                if(map.get(remove).size() == 1){
                    queue.offer(remove);
                }
            }
        }
        while(!queue.isEmpty()){
            list.add(queue.poll());
        }
        return list;
    }
    private Map<Integer, List<Integer>> buildMap(int[][] edges, int n){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] pair: edges){
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        return map;
    }
}
