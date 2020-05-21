public class Solution {
  public int maximalSquare(int[][] matrix) {
    // dp[i][j] presents the length of largest square that as[i][j] is the bottom - right corner
    //T: O(n^2) S: O(n^2)
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int res = 0;
    int[][] dp = new int[row + 1][col + 1];
    for(int i = 0; i < row; i++) {
      dp[i][0] = matrix[i][0];
    }
    for(int i = 0; i < col; i++) {
      dp[0][i] = matrix[0][i];
    }
    for(int i = 1; i < row; i++) {
      for(int j = 1; j < col; j++) {
        if(matrix[i][j] == 1) {
          dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j])) + 1;
          res = Math.max(res, dp[i][j]);
        }

      }
    }
    return res * res;
  }
}
