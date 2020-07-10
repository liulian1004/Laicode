public class Solution {
  public int maxTrapped(int[][] matrix) {
    // BFS2
    //1. 先把matrix周围一圈的pillar 放入 priorityqueue里
    //2. poll出最小的pillar
    //3. 从最小的pillar 里找到比他矮的nei，就能计算出比他矮的那个nei的蓄水能力
    //3. 把nei放入priorityqueue中等待下一次generate
    int row = matrix.length;
    int col = matrix[0].length;
    int res = 0;
    //不valid输入，至少要3*3才能建立3d水库
    if(row < 3 || col < 3) {
      return res;
    }
    //gnerate矮的，是相当于在2d 水库里，已经比较了左右边界，选一个比较矮的那一边
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(new MyCompare());
    boolean[][] visited = new boolean[row][col];
    buildQueue(matrix, minHeap, visited, row, col);
    while(!minHeap.isEmpty()) {
      Pair cur = minHeap.poll();
      List<Pair> list = getNei(cur, matrix, row,col);
      for(Pair nei: list) {
        //第一次走这边，相当于把整个水库的外围都排除掉，因为水库的外围是不蓄水的
        if(visited[nei.row][nei.col] == true){
          continue;
        }
        visited[nei.row][nei.col] = true;
        //cur相当于从0index开始，这里计算的是nei的蓄水量
        res += Math.max(cur.height - nei.height,0);
        //跟新较矮的那一边的的max bound
        nei.height = Math.max(cur.height, nei.height);
        minHeap.offer(nei);
      }
    }
    return res;
  }
  static class Pair {
    int row;
    int col;
    int height;
    Pair(int row, int col, int height) {
      this.row = row;
      this.col = col;
      this.height = height;
    }
  }
  static class MyCompare implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
      if(p1.height == p2.height) {
        return 0;
      }
      if(p1.height < p2.height) {
        return -1;
      }
      return 1;
    }
  }
  private void buildQueue(int[][] matrix, PriorityQueue<Pair> minHeap,
                          boolean[][] visited, int row, int col) {
      for(int i = 0; i < col; i++) {
        minHeap.offer(new Pair(0,i,matrix[0][i]));
        minHeap.offer(new Pair(row-1,i, matrix[row-1][i]));
        visited[0][i] = true;
        visited[row-1][i] = true;
      }
      //这里需要把头尾的去掉，因为在加row的时候已经计算过了
      for(int i = 1; i < row-1; i++) {
        minHeap.offer(new Pair(i,0,matrix[i][0]));
        minHeap.offer(new Pair(i,col-1, matrix[i][col-1]));
        visited[i][0] = true;
        visited[i][col-1] = true;
      }
    }
  private List<Pair> getNei(Pair cur, int[][] matrix,int row, int col) {
    List<Pair> list = new ArrayList<>();
    int i = cur.row;
    int j = cur.col;
    if(i+1 < row) {
      list.add(new Pair(i+1,j, matrix[i+1][j]));
    }
    if(i-1 >= 0) {
      list.add(new Pair(i-1,j, matrix[i-1][j]));
    }
    if(j+1 < col) {
      list.add(new Pair(i,j+1, matrix[i][j+1]));
    }
    if(j-1 >= 0) {
      list.add(new Pair(i,j-1, matrix[i][j-1]));
    }
    return list;
  }
}
