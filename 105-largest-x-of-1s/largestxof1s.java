public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here
    // 4 directions diagonal
    // M[i+1][j+1] represent the longest constiguous of 1s from[0-th index, i-th index] from diagonal
    //T: m *n S: m*n

    // corner case
    int row = matrix.length;
  	if(row == 0) {
  	return 0;
    }
    int col = matrix[0].length;
    if(col == 0) {
      return 0;
    }
    //step 1: 4个dircection的pre-fix sum
    // 前后左右多一个0 in case corner case
    // 左到右和从上到下可以合并在一起写
      //右到左和下到上可以合并在一起写
    int[][] left = new int[row+ 2][col + 2];
    int[][] right = new int[row+2][col + 2];
    int[][] up = new int[row+2][col + 2];
    int[][] down = new int[row+2][col + 2];
    int[][] leftUp = leftupbuilder(matrix, left, up);
    int[][] rightDown = rightdownbuilder(matrix, right, down);
    return merge(leftUp, rightDown);
    }

    private int[][] leftupbuilder(int[][] matrix, int[][] left, int[][] up) {
      for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
          if(matrix[i][j] == 1) {
            //be careful about positve diagonal and negative diagonal
          left[i+1][j+1] = left[i+1][j] + 1 ;
          up[i+1][j+1] = up[i][j+1] + 1;
        }
      }
    }
    merge(left, up);
    return left;
  }

    private int[][] rightdownbuilder(int[][] matrix, int[][] right, int[][] down) {
      for(int i = matrix.length - 1; i >= 0; i--) {
        for(int j = matrix[0].length - 1 ; j >= 0; j--) {
          if(matrix[i][j] == 1) {
            //be careful about positve diagonal and negative diagonal
          right[i+1][j+1] = right[i+1][j +2] + 1;
        down[i+1][j+1] = down[i+ 2][j+1] + 1;
          }
        }
      }
    merge(right, down);
    return right;
  }

    private int merge(int[][] a, int[][] b){
      int result = 0;
      for(int i = 0; i < a.length; i++) {
        for(int j = 0; j < a[0].length; j++) {
        int cur = Math.min(a[i][j], b[i][j]);
        //更新a[i][j]的值用于return
        a[i][j] = cur;
        result = Math.max(cur, result);
        }
      }
    return result;

    }

}
