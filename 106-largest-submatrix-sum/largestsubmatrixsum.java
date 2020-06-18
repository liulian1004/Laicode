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
// travaserl the m
        int max = Integer.MIN_VALUE;
        int[][] m = new int[ROW+1][COL+1];// right!
        for(int i = 1; i <= ROW; i++) {
            for(int j = 1; j <= COL; j++) {
                m[i][j] = m[i-1][j] + m[i][j-1] - m[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        //4个for loop确认一个2D subArray in the m
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
//T: O(n^3) Solution
public int largest(int[][] matrix) {
    //T：O(n^3)
    //拍扁， 计算区间[i,j]的submatrix sum
    //matrix[i,j] ==> prefix sum [],   其中sum[0] = matrix[i][0]+...matrix[j][0]
    int res = Integer.MIN_VALUE;
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return res;
    }

    int row = matrix.length;
    int col= matrix[0].length;

    for(int i = 0; i < row; i++){
      //inital the prefix sum array
      int[] prefixSum  = new int[col];
      // pick up an row"j", expand from i to the bottom
      //可以遍历出所有的不同row的组合
      for(int j = i; j < row; j++) {
        //累计一行行加
        add(prefixSum, matrix[j]);
        res = Math.max(res, findMax(prefixSum));
      }
    }
    return res;
  }
  private void add(int[] prefixSum, int[] array){
    for(int i = 0; i < prefixSum.length; i++) {
      prefixSum[i] += array[i];
    }
  }
  // find the max subarray sum
  private int findMax(int[] prefixSum) {
    int res = prefixSum[0];
    int curMax = prefixSum[0];
    for(int i = 1; i <prefixSum.length; i++) {
      curMax = Math.max(prefixSum[i], curMax+prefixSum[i]);
      res = Math.max(res, curMax);
    }
    return res;
  }
