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
      int length = 0;
   for(int i = 0; i < row; i++) {
     for(int j = col - 1; j >= 0; j--) {
       if(matrix[i][j] == 1) {
         up[i+1][j+1] = up[i][j+2] + 1;
       }
     }
   }
   for(int i = row - 1; i >= 0; i--) {
     for(int j = 0; j < col; j++) {
       if(matrix[i][j] == 1) {
         down[i+1][j+1] = down[i+2][j] + 1;
       }
     }
   }
    for(int i = row - 1; i >= 0; i--) {
     for(int j = col-1; j >= 0; j--) {
       if(matrix[i][j] == 1) {
         right[i+1][j+1] = right[i+2][j+2] + 1;
       }
     }
    }
    for(int i = 0; i < row; i++) {
     for(int j = 0; j < col; j++) {
       if(matrix[i][j] == 1) {
         left[i+1][j+1] = left[i][j] + 1;
         int t1= Math.min(right[i+1][j+1], left[i+1][j+1]);
         int t2 = Math.min(up[i+1][j+1], down[i+1][j+1]);
         length = Math.max(length, Math.min(t1,t2));
       }
     }
   }
   return length;
  }
}
