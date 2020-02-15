public class Solution {
  public int largest(int[][] matrix) {
    // T: O(n^4)
    //2D prefix sum
    int ROW = matrix.length;
        if(ROW == 0) {
            return 0;
        }
       int COL = matrix[0].length;
        if(COL == 0) {
            return 0;
        }
//m[i+1][j+1] represents 2d prefix sum from [(0,0), (i,j)]
        int max = Integer.MIN_VALUE;
        int[][] m = new int[ROW+1][COL+1];// right!
        for(int i = 1; i <= ROW; i++) {
            for(int j = 1; j <= COL; j++) {
                m[i][j] = m[i-1][j] + m[i][j-1] - m[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        //4个for loop确认一个长方形
        for(int i = 1; i <=ROW; i++) {
            for(int j = 1; j <= COL; j++) {
                for(int k = i; k <= ROW ; k++) {
                    for(int p = j; p <= COL ; p++) {
                        int cur = m[k][p] -m[k][j-1] - m[i-1][p] + m[i-1][j-1];
                        max = Math.max(cur, max);
                    }
                }
            }
        }
        return max;

  }

}
