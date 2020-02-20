public class Solution {
  public void rotate(int[][] matrix) {
    // T: O(n * n) S: O(1)
    if(matrix.length == 0 || matrix[0].length == 0) {
      return;
    }
    int n = matrix.length;
    for(int level = 0; level < n/2; level++) {
      int left = level;
      //end before the last element
      int right = n-1-level-1;
      for(int i = left; i <= right; i++) {
        int tmp = matrix[left][i];
        matrix[left][i] = matrix[n-1-i][left];
        matrix[n-1-i][left] = matrix[n-1-left][n-1-i];
        matrix[n-1-left][n-1-i] = matrix[i][n-1-left];
        matrix[i][n-1-left] = tmp;
      }
    }
  }
}
