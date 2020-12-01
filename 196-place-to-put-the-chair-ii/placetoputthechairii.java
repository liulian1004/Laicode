public class Solution {
  public List<Integer> putChair(char[][] gym) {
    // 从每一E出发，计算到每一个cell的距离。
    //cell里面的值累积
    //T: O(k*(m*n)) S: O((m*n))
    int row = gym.length;
    int col = gym[0].length;
    int[][] matrix = new int[row][col];
    for(int i = 0; i < row; i++ ){
      for(int j = 0; j < col; j++){
        if(gym[i][j] == 'E'){
          bfs(row, col,matrix,i,j);
        }
      }
    }
    int cost = matrix[0][0];
    List<Integer> list = new ArrayList<>();
    int x = 0;
    int y = 0;
    for(int i = 0; i < row; i++){
      for(int j = 0 ;j < col; j++){
        if(matrix[i][j] < cost){
          cost = matrix[i][j];
          x = i; y = j;
        }
      }
    }
    list.add(x); list.add(y);
    return list;
  }
  private void bfs(int row, int col, int[][] matrix, int x, int y){
    boolean[][] visited = new boolean[row][col];
    Queue<int[]> queue = new ArrayDeque<>();
    int step = 0;
    queue.offer(new int[]{x,y});
    visited[x][y] = true;
    while(!queue.isEmpty()){
      int size = queue.size();
      for(int k = 0; k < size; k++){
        int[] cur = queue.poll();
        int i = cur[0];
        int j = cur[1];
        matrix[i][j] += step;
        if(i+1 < row && !visited[i+1][j]){
          queue.offer(new int[]{i+1,j});
          visited[i+1][j] = true;
        }
        if(j+1 < col && !visited[i][j+1]){
          queue.offer(new int[]{i,j+1});
          visited[i][j+1] = true;
        }
        if(j-1 >= 0 && !visited[i][j-1]){
          queue.offer(new int[]{i,j-1});
          visited[i][j-1] = true;
        }
         if(i-1 >= 0 && !visited[i-1][j]){
          queue.offer(new int[]{i-1,j});
          visited[i-1][j] = true;
        }
      }
      step++;
    }
  }
}
