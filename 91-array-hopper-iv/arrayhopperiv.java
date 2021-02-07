public class Solution {
  public int minJump(int[] array, int index) {
    // bfs
    //T: O(n) S: o(n)
    int level = 0;
    boolean[] visited = new boolean[array.length];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(index);
    visited[index] = true;
    while(!queue.isEmpty()){
      int size = queue.size();
      for(int k = 0 ; k < size; k++){
        int cur = queue.poll();
        if(cur == array.length-1){
          return level;
        }
        for(int i = cur-1; i >= (cur - array[cur]>=0? cur-array[cur]: 0); i--){
          if(!visited[i]){
            queue.offer(i);
            visited[i] = true;
          }
        }
        for(int i = cur +1; i <= (cur+array[cur] < array.length? cur+array[cur]:array.length-1); i++){
          if(!visited[i]){
            queue.offer(i);
            visited[i] = true;
          }
        }
      }
      level++;
    }
    return -1;
  }
}
