public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    //T: O(v+e); S: O(v+e)
    if(numCourses == 0 || prerequisites == null || prerequisites.length == 0
    || prerequisites[0].length == 0) {
      return true;
    }
    Map<Integer, Integer> map = new HashMap<>();
    //init map
    for(int i = 0; i < numCourses;i++) {
      map.put(i,0);
    }
    //update the map
    for(int[] edge: prerequisites) {
      //pass by value, have to update like this
      //if it's the list, it can be udpate by map.get(i).add...
      map.put(edge[0],map.get(edge[0])+1);
    }
    //init queue
    Queue<Integer> queue = new ArrayDeque<>();
    for(int i = 0; i < numCourses; i++) {
      if(map.get(i) == 0) {
        queue.offer(i);
      }
    }
    while(!queue.isEmpty()) {
      int cur = queue.poll();
      for(int[] edge: prerequisites) {
        if(edge[1] == cur && map.get(edge[0]) != 0) {
              map.put(edge[0],map.get(edge[0])-1);
              if(map.get(edge[0]) == 0 ) {
                queue.offer(edge[0]);
              }
        }
      }
    }
    for(int i = 0; i < numCourses;i++) {
      if(map.get(i) != 0) {
        return false;
      }
    }
    return true;
  }
}
