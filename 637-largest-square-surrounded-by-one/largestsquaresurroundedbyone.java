public class Solution {
  public int largestSquareSurroundedByOne(int[][] matrix) {
    // m[i + 1] presenets the longest contiguous 1s from 0-th to 0-th
    // in order to avoid the corner case, like m [i] = m[i-1] + 1 or m[i] = 1
    int res = 0;
    int row = matrix.length;
    if(row == 0) {
      return res;
    }
    int col = matrix[0].length;
    if(col == 0) {
      return res;
    }
    int[][] left = new int[row + 1][col + 1];
    int[][] up = new int[row + 1][col + 1];
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        if(matrix[i][j] == 1) {
          left[i+1][j+1] = left[i+1][j] + 1;
          up[i+1][j+1] = up[i][j+1] + 1;
        }
        //for loop:先查两边的最短距离，然后在查另外两边的具体是不是大于或者等于最短距离
        for(int maxLength = Math.min(left[i+1][j+1], up[i+1][j+1]); maxLength >= 1; maxLength-- ){
          //i+1- maxLength +1/j+1-maxLength +1 是找到下一个顶点的左边
          if(left[i+1-maxLength + 1][j+1] >= maxLength && up[i+1][j+1-maxLength +1] >= maxLength) {
            res = Math.max(res, maxLength);
            break;
          }
        }
      }
    }
    return res;
  }
}
