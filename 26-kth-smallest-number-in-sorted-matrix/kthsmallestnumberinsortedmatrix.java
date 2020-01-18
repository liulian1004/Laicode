public class Solution {
  static class Cell {
      int row;
      int column;
      // the value of cell
      int value;
      Cell(int row, int column, int value) {
          this.row = row;
          this.column = column;
          this.value = value;
      }
  }

  public int kthSmallest(int[][] matrix, int k) {
    // T：k * log k（K = heap的size）
    //S： row * column ( boolean[][]), hashset 的解法： O(k)
    if(matrix == null) {
      return -1;
    }
    int row = matrix.length;
    int column = matrix[0].length;
    PriorityQueue<Cell> minHeap = new PriorityQueue(k, new Comparator<Cell>()  {
      @Override
      public int compare(Cell c1, Cell c2) {

        if(c1.value == c2.value) {
          return 0;
        }
        return c1.value < c2.value ? -1: 1;
      }
    });
    boolean[][] visited = new boolean[row][column];
    visited[0][0] = true;
    minHeap.offer(new Cell(0,0, matrix[0][0]));
    //第一个元素已经进去了，所有循环 k-1个
    for(int i = 0; i < k -1; i++) {
      Cell cur = minHeap.poll();
      //没有出边界 && 没有被扫描过
      if(cur.row + 1 < row && !visited[cur.row +1][cur.column]) {
        minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row +1][cur.column]));
        visited[cur.row + 1][cur.column] = true;
      }
      if(cur.column + 1 < column && !visited[cur.row][cur.column + 1]) {
        minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
        visited[cur.row][cur.column + 1] = true;
      }
    }
    //已经把前k-1个小的元素给pop出去了，所以minHeap的最小元素是kth大元素
    return minHeap.peek().value;
}
}
