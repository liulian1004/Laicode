public class Solution {
  public int sumRegion(int[][] matrix, int row1, int col1, int row2, int col2) {
    // T: O(n^2) S: O(n^2)
    if(row1 == row2 && col1 == col2) {
      return matrix[row1][col1];
    }
    int[][] prefixSum = new int[matrix.length][matrix[0].length];
    for(int i = 0; i < matrix.length; i++ ) {
      for(int j = 0; j< matrix[0].length; j++) {
        if(i == 0 && j == 0) {
          prefixSum[i][j] = matrix[i][j];
        } else if( i == 0 && j !=0) {
          prefixSum[i][j] = prefixSum[i][j-1] + matrix[i][j];
        }else if(i != 0 && j ==0) {
          prefixSum[i][j] = prefixSum[i-1][j] + matrix[i][j];
        }else{
          prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + matrix[i][j];
        }
      }
    }
    return prefixSum[row2][col2] -prefixSum[row1-1][col2] - prefixSum[row2][col1-1] + prefixSum[row1-1][col1-1];
  }
}
