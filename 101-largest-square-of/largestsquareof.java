public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here
    //m[n][n] represent the  largest square of 1s with the right bottom
    // int res is the largest number in the m[n][n]
    if(matrix.length == 0) {
      return 0;
    }
    int n = matrix.length;
    int[][] m = new int[n][n];
    int res = 0;
    for(int i = 0; i < n; i++) {
      for(int j =0; j < n; j++) {
        //在 i == 0 或者 j== 0的两条边上，largest square is 1 or 0
        if(i == 0 || j == 0) {
        m[i][j] =  matrix[i][j] == 1 ? 1 :0;
        } else if (matrix[i][j] == 1) {
          m[i][j] = Math.min(m[i][j-1] +1, m[i-1][j-1]+ 1);
          m[i][j] = Math.min(m[i][j], m[i-1][j]+ 1 );
        }
        res = Math.max(res, m[i][j]);
      }
    }
    return res;
  }
}
