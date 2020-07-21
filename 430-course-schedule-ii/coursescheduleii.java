public class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    // Topological sort
    //有向无环图-Directed Acyclic Graph (DAG)
    //T: O(n) S: O(indegress + queue) --> O(n)
    //把queue里面的所有course打印出来，如果在同一层里面，打印顺序无所谓
    List<Integer> list = new ArrayList<>();
    if(numCourses == 0 || prerequisites == null || prerequisites.length == 0
    || prerequisites[0].length == 0) {
      return new int[]{};
    }
    //travsel the graph
    //input: {{1,0},{2,0},{3,1},{3,2}}
    //indegress: {0,1,1,2}
    //index = course
    // val = number of depency courses
    int[] indegress = new int[numCourses];
    for(int[] edge: prerequisites) {
        indegress[edge[0]]++;
    }
  // init the queue with no prerequisities course
    Queue<Integer> queue = new ArrayDeque<>();
    for(int i = 0; i < indegress.length; i++) {
      if(indegress[i] == 0) {
        queue.offer(i);
      }
    }
    //BFS
    while(!queue.isEmpty()) {
      int cur = queue.poll();
      list.add(cur);
      for(int[] edge : prerequisites) {
        //移除dependency
        if(edge[1] == cur){
          indegress[edge[0]]--;
        if(indegress[edge[0]] == 0) {
          queue.offer(edge[0]);
        }
      }
    }
  }
    //post-process
    //check whether the result is vaild
    // the valid result is the all the courses have been travseral
    // the size of list is num of course
    int[] array = new int[numCourses];
    if(list.size() == numCourses) {
      for(int i = 0 ; i<numCourses;i++) {
        array[i] = list.get(i);
      }
      return array;
    }
    return new int[]{};
  }
  //Standard solution --> use map to check indegress
  //S: O(v+e) vertreix: the size of queue; edge: the size of map
  //T: O(n*m) : n : number of cousese; m: the length of prerequisites
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    // Write your solution here
    List<Integer> list = new ArrayList<>();
    if(numCourses == 0 || prerequisites == null || prerequisites.length == 0
    || prerequisites[0].length == 0) {
      return new int[]{};
    }
    //Map< course, depenency of course>
    //init map
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < numCourses; i++) {
      map.put(i,0);
    }
    for(int[] edge : prerequisites) {
      map.put(edge[0], map.get(edge[0]) + 1);
    }
    Queue<Integer> queue = new ArrayDeque<>();
    for(int i =0; i <map.size(); i++) {
      if(map.get(i) == 0) {
        queue.offer(i);
      }
    }
    int[] res = new int[numCourses];
     int index = 0;
    while(!queue.isEmpty()) {
      int cur = queue.poll();
      res[index] = course;
      index++;
      for(int[] edge : prerequisites) {
        if(edge[1] == cur) {
          map.put(edge[0], map.get(edge[0])-1);
          if(map.get(edge[0]) == 0) {
            queue.offer(edge[0]);
          }
        }
      }
    }
    if(index < numCourses) {
      return new int[]{};
    }
    return res
  }
}
