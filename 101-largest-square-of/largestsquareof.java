public class Solution {
  public int largest(int[][] matrix) {
    // Write your solution here
    //m[i+1][j+1] represent the size of 1s square  with  i, j as the the  bottom right corner
    // T: n^2 , S n^2
    //my soultion
    
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
      int n = matrix.length;
      int[][] sum = new int[n+1][n+1];
      int largest = 0;
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
          if(matrix[i][j] == 1) {
          sum[i+1][j+1] = Math.min(sum[i+1][j] + 1 , sum[i][j+1] +1);
          sum[i+1][j+1] = Math.min(sum[i+1][j+1], sum[i][j] + 1);
          largest = Math.max(sum[i+1][j+1], largest);
        }
      }
    }
    return largest;

  }
    // standard Solution
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
