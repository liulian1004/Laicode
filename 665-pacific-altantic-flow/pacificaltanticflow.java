public class Solution {
  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    // find all the reachable nodes of p and a
    // start from 0，0 && （length - 1， length-1）
    //T: O(m+n)*m*n
    List<List<Integer>> list = new ArrayList<>();
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return list;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    boolean[][] p = new boolean[row][col];
    boolean[][] a = new boolean[row][col];
    //traversal each row
    //倒着流
    for(int i = 0; i < row; i++) {
      //from pacifica (top left )
      dfs(matrix, p, i, 0, Integer.MIN_VALUE);
      //from altantic(top right)
      dfs(matrix, a, i, col-1, Integer.MIN_VALUE);
    }
    //traversal each col
    for(int i = 0; i < col; i++) {
      //from pacifica (top left )
      dfs(matrix, p, 0, i, Integer.MIN_VALUE);
      //from altantic(top right)
      dfs(matrix, a, row - 1, i, Integer.MIN_VALUE);
    }
    // find the common true of p and a
    for(int i = 0; i < row;i++) {
      for(int j = 0; j < col; j++) {
        if(p[i][j] == true && a[i][j] == true) {
          list.add(Arrays.asList(i, j));
        }
      }
    }
    return list;
  }
  //h表示前一个位置的高度
  //这里h初始化为min_integer in case the high is negative
  private void dfs(int[][] matrix, boolean[][] visited, int i, int j, int h) {
    int row = matrix.length;
    int col = matrix[0].length;
    if(i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || matrix[i][j] < h) {
      return;
    }
    visited[i][j] = true;
    //traversal 4 direction
    dfs(matrix, visited, i-1,j,matrix[i][j]);
    dfs(matrix, visited, i, j -1, matrix[i][j]);
    dfs(matrix, visited, i+1, j, matrix[i][j]);
    dfs(matrix, visited, i, j+1, matrix[i][j]);
  }

}
