public class Solution {
  public int negNumber(int[][] matrix) {
    // T: logm*logn
    if(matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int res = 0;
    int rowNeg = findFirstNegRow(row,matrix);
    for(int i = 0; i <= rowNeg; i++) {
        res +=findFirstNegCol(i,col,matrix);
    }
    return res;
  }
  private int findFirstNegRow(int row, int[][] matrix) {
    int left = 0;
    int right = row -1;
    while(left < right -1) {
      int mid = left + (right - left) / 2;
      if(matrix[mid][0] < 0) {
        left = mid;
      }else {
        right = mid - 1;
      }
    }
    if(matrix[right][0] < 0) {
      return right;
    }
    if(matrix[left][0] < 0) {
      return left;
    }
    return -1;
  }
    private int findFirstNegCol(int row, int col, int[][] matrix) {
    int left = 0;
    int right = col -1;
    while(left < right -1) {
      int mid = left + (right - left) / 2;
      if(matrix[row][mid] < 0) {
        left = mid;
      }else {
        right = mid - 1;
      }
    }
    if(matrix[row][right] < 0) {
      return right+1;
    }
    if(matrix[row][left] < 0) {
      return left+1;
    }
    return -1;
  }
}
