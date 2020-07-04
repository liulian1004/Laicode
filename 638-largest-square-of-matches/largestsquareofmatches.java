public class Solution {
  public int largestSquareOfMatches(int[][] matrix) {
    // T: N^3; S: N^2
    // creat the modle: 2D matrix
    // every point is a 2bit(ab) ==> a == 1 has down; b == 1 has right
    //0，无下无右，1右，2下，3，下+ 右
    // left + down, 查右下角只有在顶点的情况
    //和surrounding 1相反，从左上角开始找起
    int res = 0;
    int row = matrix.length;
    if(row == 0) {
      return res;
    }
    int col = matrix[0].length;
    if(col == 0) {
      return res;
    }
    int[][] right = new int[row+1][col +1];
    int[][] down = new int[row+1][col + 1];
    for(int i = row -1; i >= 0; i--) {
      for(int j = col - 1; j >= 0; j--) {
        //right是连续或者down是连续的情况下，相当于等于1的情况下查看连续的数量
        if(hasRight(matrix[i][j])) {
          right[i][j] = right[i][j + 1] + 1;
        }
        if(hasDown(matrix[i][j])) {
          down[i][j] = down[i+1][j] + 1;
        }
        //相当于这个点是有机会成为顶点之一
        if(rightDown(matrix[i][j])) {
          for(int maxLength = Math.min(right[i][j], down[i][j]); maxLength >= 1; maxLength--) {
            //从right找到它下面的点
            //从down找到它右边的点
            if(right[i+ maxLength][j]>= maxLength && down[i][j + maxLength] >= maxLength) {
              res = Math.max(res, maxLength);
              break;
            }
          }
        }
      }
    }
     return res;
  }
  private boolean hasRight(int val) {
      return val == 1 || val == 3;
    }
    private boolean hasDown(int val) {
      return val == 2 || val == 3;
    }
    private boolean rightDown(int val) {
      return val == 3;
    }

}
