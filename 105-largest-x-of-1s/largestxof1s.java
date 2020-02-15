public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here
    // 4 directions
    // M[i][j] represent the longest constiguous of 1s from[0-th index, i-th index] from diagonal
    //T: m *n S: m*n
    int row = matrix.length;
    if(row == 0) {
      return 0;
    }
    int col = matrix[0].length;
    if(col == 0) {
      return 0;
    }
    // step 1, 4 direction
    int[][] leftUp = leftUp(matrix, row, col);
    int[][] rightDown = rightDown(matrix, row, col);
    return merge(leftUp, rightDown, row, col);
  }
  private int[][] leftUp(int[][] matrix, int row, int col) {
    int[][] left = new int[row][col];
    int[][]  up = new int[row][col];
    for(int i = 0; i < row; i++) {
      for(int j =0; j < col; j++) {
        if(matrix[i][j] == 1) {
          // negative diagonal
        left[i][j] = diagonal(left, i -1, j -1, row, col) + 1;
        // positive diagonal
        up[i][j] = diagonal(up, i-1, j + 1 , row, col) + 1;
        }
      }
    }
    merge(left, up, row, col);
    return left;
  }
  private int[][] rightDown(int[][] matrix, int row, int col) {
    int[][] right = new int[row][col];
    int[][] down = new int[row][col];
    for(int i = row - 1; i >= 0; i--) {
      for(int j = col - 1; j >= 0; j--) {
        if(matrix[i][j] == 1) {
           // negative diagonal
        right[i][j] = diagonal(right, i+1, j+1, row, col)  +1;
        //positive diagonal
        down[i][j] = diagonal(down, i+1, j - 1, row, col) + 1;
        }
      }
    }
    merge(right, down, row, col);
    return right;
  }
  private int diagonal(int[][] a, int i, int j, int row, int col) {
    //判断在四个顶点的情况，相当于在m[0]的时候
    if(i <0 || i >= row || j<0 || j >= col) {
      return 0;
    }
    return a[i][j];
  }
  private int merge(int[][] a, int[][] b, int row, int col) {
    int max = 0;
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        a[i][j] = Math.min(a[i][j], b[i][j]);
        max = Math.max(a[i][j], max);
      }
    }
    return max;
  }
}
