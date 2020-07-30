public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    // T: O(n *m) S: O(1)
    List<Integer> res = new ArrayList<>();
    // m = 0; n = 0
    int row = matrix.length;
    int col = matrix[0].length;
    if(row == 0 || col == 0) {
      return res;
    }
    int left = 0;
    int right = col - 1;
    int up = 0;
    int down = row - 1;
    //The for loop include the last element of row
    while(left < right && up < down) {
      for(int i = left; i<= right; i++) {
        res.add(matrix[up][i]);
      }
      // not inculide the top and last element of col
      for(int i = up + 1; i <= down - 1; i++) {
        res.add(matrix[i][right]);
      }
      for(int i = right; i >= left; i--) {
        res.add(matrix[down][i]);
      }
      for(int i = down - 1; i>= up + 1; i--) {
        res.add(matrix[i][left]);
      }
      left++;
      up++;
      right--;
      down--;
    }
    //base case
    //1. null(left>right or up > down). 2. only one col; 3. only one row
    if(left > right || up > down) {
      return res;
    } else if(left == right) {
      for(int i = up; i <= down; i++) {
        res.add(matrix[i][left]);
      }
    }else {
      for(int i = left; i<= right; i++) {
        res.add(matrix[up][i]);
      }
    }
    return res;
  }
  // recursion
  List<Integer> res = new ArrayList<>();
    // m = 0, n = 0
    if(matrix.length == 0 || matrix[0].length == 0) {
      return res;
    }
    int left = 0;
    int right = matrix[0].length - 1;
    int up = 0;
    int down = matrix.length - 1;
    helper(matrix, left, right, up, down, res);
    return res;
    }
    private void helper (int[][] matrix, int left, int right, int up, int down, List<Integer> res) {
    if(left > right || up > down) {
      return;
    } else if(left == right) {
      for(int i = up; i <= down; i++) {
        res.add(matrix[i][left]);
      }
      return;
    } else if(up == down) {
      for(int i = left; i<= right; i++) {
      res.add(matrix[up][i]);
      }
      return;
    }
    for(int i = left;  i <= right; i++) {
      res.add(matrix[up][i]);
    }
    for(int i = up + 1; i< down; i++) {
      res.add(matrix[i][right]);
    }
    for(int i = right; i>=left; i--) {
      res.add(matrix[down][i]);
    }
    for(int i = down - 1 ; i> up; i--) {
      res.add(matrix[i][left]);
    }
    helper(matrix, left + 1, right - 1, up + 1, down - 1, res);
    }

    // my soution
    public List<Integer> spiral(int[][] matrix) {
    // T: O(n^2) S: O(n)
    List<Integer> list = new ArrayList<>();
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return list;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    helper(matrix,list, 0, row, col);
    return list;
  }
  private void helper(int[][] matrix, List<Integer> list, int offset, int row, int col) {
    if(offset == row / 2) {
      if(row % 2 == 1) {
        for(int i = offset; i < col - offset; i++ ) {
          list.add(matrix[offset][i]);
        }
      }
      return;
    }
    if(offset == col/2) {
      if(col %2 == 1) {
        for(int i = offset; i < row-offset; i++) {
          list.add(matrix[i][offset]);
        }
      }
      return;
    }
    for(int i = offset; i < col- 1-offset; i++) {
      list.add(matrix[offset][i]);
    }
    for(int i = offset; i < row- 1-offset; i++) {
      list.add(matrix[i][col-1-offset]);
    }
    for(int i = col - 1- offset; i > offset; i--) {
      list.add(matrix[row-1-offset][i]);
    }
    for(int i =row - 1- offset; i> offset; i--) {
      list.add(matrix[i][offset]);
    }
    helper(matrix,list,offset+1,row, col);
  }

}



}
