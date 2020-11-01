public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    //T: O(v+e); S: O(v+e)
    //bfs + map<course, the number of pre>
  //把0 pre的courses放入queue， 然后expande+generate
  //每一次expand，就把the number of pre--
  //queue is Empty, check wether the value is nono
  // invaild example: 有环 1 <-> 0
  //题目变形： 有没有环，用toplogy算法
  //qualified grad: DAG： Directed Acyclic Graph
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
    //不能像以下这么做
    //因为这会导致只对有作为pre的course建图，会漏course
    //会导致34行npe
    //for(int[] pair: pre) {
    //   map.put(pair[0],map.getOrDefault(pair[0],0) + 1);
    // }
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
        //check whether it have prerequisites in the map
        if(edge[1] == cur && map.get(edge[0]) != 0) {
          // remove the pre from the map
              map.put(edge[0],map.get(edge[0])-1);
              // it means that all the pre class have taken, can put in the queue
              if(map.get(edge[0]) == 0 ) {
                queue.offer(edge[0]);
              }
        }
      }
    }
    //check whether all the require pre courses have taken
    for(int i = 0; i < numCourses;i++) {
      if(map.get(i) != 0) {
        return false;
      }
    }
    return true;
  }
}
