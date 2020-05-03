public class Solution {
  public int longest(int[][] matrix) {
    // DFS
    //T: O 2^(n*m) S: O(n *m)
    if(matrix == null || matrix.length == 0) {
      return 0;
    }
    int ans = 1;
    int row = matrix.length;
    int col = matrix[0].length;
    for(int i = 0; i < row; i++) {
      for(int j = 0; j< col; j++) {
        int[] path = new int[]{1};
        dfs(matrix, i, j, path, 0);
        ans = Math.max(ans, path[0]);
      }
    }
    return ans;
  }
  private void dfs(int[][] matrix, int i, int j, int[] path, int cur) {
    // if(i >= matrix.length || i < 0 || j >= matrix[0].length || j <0 ) {
    //   return;
    // }
    cur++;
    path[0] = Math.max(cur, path[0]);
    if(i+1 < matrix.length && matrix[i][j] < matrix[i+1][j]) {
      // cur++;
      // path[0] = Math.max(cur, path[0]);
      dfs(matrix, i+1,j,path, cur);
    }
    if(i-1 >= 0 && matrix[i][j] < matrix[i-1][j]) {
      // cur++;
      // path[0] = Math.max(cur, path[0]);
      dfs(matrix, i-1,j,path, cur);
    }
    if(j+1 < matrix[0].length && matrix[i][j] < matrix[i][j+1]) {
      // cur++;
      // path[0] = Math.max(cur, path[0]);
      dfs(matrix, i,j+1,path, cur);
    }
    if(j-1>= 0 && matrix[i][j] < matrix[i][j-1]) {
      // cur++;
      // path[0] = Math.max(cur, path[0]);
      dfs(matrix, i,j-1,path, cur);
    }
  }
}
  // DFS + memorization
  //T: O(n*m) S: O(n *m) + call stack
  //时间复杂度等于填memo的时间复杂度，
  if(matrix == null || matrix.length == 0) {
        return 0;
      }
      int ans = 1;
      int row = matrix.length;
      int col = matrix[0].length;
      int[][] dp = new int[row][col];
      for(int i = 0; i < row; i++) {
        for(int j = 0; j< col; j++) {
          // the longest ascending path for the element(i,j)
          if(dp[i][j] == 0) {
            int[] path = new int[]{dp[i][j]};
            dfs(matrix, i, j, path, 0, dp);
            dp[i][j] = path[0];
            ans = Math.max(ans, dp[i][j]);
          }
        }
      }
      return ans;
    }
    private void dfs(int[][] matrix, int i, int j, int[] path, int cur, int[][] dp) {

      if(dp[i][j] != 0) {
        cur += dp[i][j];
        path[0] = Math.max(cur, path[0]);
        return;
      }
      cur++;
      path[0] = Math.max(cur, path[0]);
      if(i+1 < matrix.length && matrix[i][j] < matrix[i+1][j]) {
        dfs(matrix, i+1,j,path, cur, dp);
      }
      if(i-1 >= 0 && matrix[i][j] < matrix[i-1][j]) {
        dfs(matrix, i-1,j,path, cur,dp);
      }
      if(j+1 < matrix[0].length && matrix[i][j] < matrix[i][j+1]) {
        dfs(matrix, i,j+1,path, cur, dp);
      }
      if(j-1>= 0 && matrix[i][j] < matrix[i][j-1]) {
        dfs(matrix, i,j-1,path, cur, dp);
      }

    }
    //DP
    //T: O(m *n log(m*n)) S： O(m *n)
    //先对matrix进行排序，从大到小的排序，然后从打到小的开始扫描matrix
    //时间复杂读没有dfs + memo的soluton 好
  }
