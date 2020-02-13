public class Solution {
  public int largest(int[][] matrix) {
    // T: O(n * n) S: O(m *n)
    int row = matrix.length;
    if(row == 0) {
      return 0;
    }
    int col = matrix[0].length;
    if(col == 0) {
      return 0;
    }
    //以下这么写会有NPE出现（如果row = 0）
    // int col = matrix[0].length;

    // if(row == 0 || col == 0) {
    //   return 0;
    // }

    // step 1 : 4个direction都扫描一遍
    // 左到右和从上到下可以合并在一起写
    //右到左和下到上可以合并在一起写
    int[][] leftUp = leftUp(matrix, col, row);
    int[][] rightDown = rightDown(matrix, col, row);
    //step 2: 把4个direction合并在一起，找到最小值，返回global max
    return merge(leftUp, rightDown, col, row);
  }

  private int[][] leftUp(int[][] matrix, int col, int row) {
      int[][] left = new int[row][col];
      int[][] up = new int[row][col];
      for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
          //这里不需要考虑matrix == 0的情况，因为二维数组默认值为0；
          if(matrix[i][j] == 1) {
            if(i == 0 && j == 0) {
                left[i][j] = 1;
                up[i][j] = 1;
            } else if (i == 0) {
              up[i][j] = 1;
              left[i][j]= left[i][j-1] + 1;
            } else if(j == 0) {
              left[i][j] = 1;
              up[i][j] = up[i-1][j] + 1;
            } else {
              left[i][j]= left[i][j-1] + 1;
              up[i][j] = up[i-1][j] + 1;
            }
          }
        }
      }
      merge(left, up, col, row);
      return left;
  }

  private int[][] rightDown(int[][] matrix, int col, int row) {
    int[][] right = new int[row][col];
    int[][] down = new int[row][col];
    for(int i = row - 1; i >=0; i--) {
      for (int j = col - 1; j >=0; j--) {
        if(matrix[i][j]== 1) {
          if(i == row - 1&& j == col - 1) {
            right[i][j] = 1;
            down[i][j] = 1;
          } else if(i == row -1) {
            down[i][j] = 1;
            right[i][j] = right[i][j+1] +1;
          } else if (j == col - 1) {
            right[i][j] = 1;
            down[i][j] = down[i+1][j] + 1;
          } else {
            right[i][j] = right[i][j+1] +1;
            down[i][j] = down[i+1][j] + 1;
          }
        }
      }
    }
    merge(right, down ,col, row);
    return right;
  }

  private int merge(int[][] a, int[][] b, int col, int row) {
    int max = 0;
    for(int i =0; i < row; i++) {
      for(int j = 0; j < col; j++) {
         a[i][j] = Math.min(a[i][j], b[i][j]);
         max = Math.max(a[i][j], max);
      }
    }
    return max;
  }
}
