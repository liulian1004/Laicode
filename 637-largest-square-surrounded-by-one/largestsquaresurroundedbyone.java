public class Solution {
  public int largestSquareSurroundedByOne(int[][] matrix) {
    // m[i + 1] presenets the longest contiguous 1s from 0-th to 0-th
    // in order to avoid the corner case, like m [i] = m[i-1] + 1 or m[i] = 1
    //T: O(n^2)
    //S: O(n * m)
    int res = 0;
    int row = matrix.length;
    if(row == 0) {
      return res;
    }
    int col = matrix[0].length;
    if(col == 0) {
      return res;
    }
    //left: 从左到右
    //up： 从上到下
    int[][] left = new int[row + 1][col + 1];
    int[][] up = new int[row + 1][col + 1];
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        if(matrix[i][j] == 1) {
          left[i+1][j+1] = left[i+1][j] + 1;
          up[i+1][j+1] = up[i][j+1] + 1;
        }
        //for loop:先查两边的最短距离，然后在查另外两边的具体是不是大于或者等于最短距离
        //left[i+1][j+1]/up[i+1[j+1]在mtrix为同一个位置（左下角）
        for(int maxLength = Math.min(left[i+1][j+1], up[i+1][j+1]); maxLength >= 1; maxLength-- ){
          //left:i+1- maxLength +1 找到 右上的顶点
          //up: j+1-maxLength +1 找到左下的顶点
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
