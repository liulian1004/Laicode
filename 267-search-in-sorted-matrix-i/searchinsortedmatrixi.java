public class Solution {
  public int[] search(int[][] matrix, int target) {
    // find the first target that equal to the target
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[]{-1, -1};
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int left = 0;
    int right = row*col -1;
    while(left < right-1) {
        int m = left + (right - left) / 2;
        int i = m/col;
        int j = m%col;
        if(matrix[i][j] >= target) {
          right = m;
        }else {
          left = m+1;
        }
    }
    int i = left/col;
    int j = left%col;
    if(matrix[i][j] == target) {
      return new int[]{i,j};
    }
    i = right/col;
    j = right%col;
    if(matrix[i][j] == target) {
      return new int[]{i,j};
    }
    return new int[]{-1,-1};
  }
}
