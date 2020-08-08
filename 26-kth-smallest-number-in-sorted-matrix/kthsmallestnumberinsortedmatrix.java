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
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new EqualComparator());
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
  private static class EqualComparator implements Comparator<Cell> {
	@Override
	public int compare(Cell c1, Cell c2) {
    if(c1.value == c2.value) {
      return 0;
    }
    return c1.value < c2.value ? -1 :1;
  }
}
}
// my solution : row + k*logk
//S: O(1)
public int kthSmallest(int[][] matrix, int k) {
    // Write your solution here
    if(matrix == null || matrix.length == 0) {
      return -1;
    }
    PriorityQueue<Node> min = new PriorityQueue<>(new MyCompare());
    for(int i = 0; i < matrix.length; i++) {
        min.offer(new Node(i,0,matrix[i][0]));
    }
    Node node = null;
    while(k > 0) {
      node = min.poll();
      if(node.y + 1 <  matrix[0].length) {
        min.offer(new Node(node.x, node.y+1, matrix[node.x][node.y+1]));
      }
      k--;
    }
    return node.value;
  }
  static class Node{
    int x;
    int y;
    int value;
    Node(int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }
  }
  static class MyCompare implements Comparator<Node> {
    @Override
    public int compare(Node n1, Node n2) {
      if(n1.value == n2.value){
        return 0;
      }
      return n1.value < n2.value? -1 : 1;
    }
  }
//follow up : kth min products in two sorted Array
private int kthProduct(int[] a1, int[] a2, k){
  int[][] matrix = buildMatrix(a1,a2);
  PriorityQueue<Node > min = new PriorityQueue<>();
  min.offer(new Node(0,0,matrix[0][0]));
  int res = 0;
  boolean[][] visited = new boolean[matrix.length][matrix[0].length];
  while(k > 0) {
    Node cur  = min.poll();
    res = cur.value;
    if(cur.x+1 < matrix.length && !visited[cur.x+1][cur.y]){
      cur.offer(new Node(cur.x+1,cur.y, matrix[cur.x+1][cur.y]));
      visited[cur.x+1][cur.y] = true;
    }
    if(cur.y+1 < matrix[0].length && !visited[cur.x][cur.y+1]){
      cur.offer(new Node(cur.x,cur.y+1, matrix[cur.x][cur.y+1]));
      visited[cur.x][cur.y+1] = true;
    }
    k--;
  }
  return res;

  }
  private int[][] buildMatrix(int[]a1, int[] a2) {
    int[][] matrix = new int[a1.length][a2.length];
    for(int i = 0; i <a1.length; i++){
      for(int j = 0; j < a2.length; j++) {
        matrixx[i][j] = a1[i]*a2[j];
      }
    }
    return matrix;
  }
}
