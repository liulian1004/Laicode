public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    //T: 4n + 4(n-2) + 4(n-4) + ...4 * 1 = 4 * n ^2 = n^2
    //S: O(h) = O(n/2) = O(n)
    List<Integer>  res = new ArrayList<>();
    int size = matrix.length;
    //offset= col / row
    int offset = 0;
    helper(matrix, res, 0, size);
    return res;
  }
  private void helper(int[][] matrix, List<Integer> res, int offset, int size) {
      if(size == 0) {
        return;
      }
      if(size == 1) {
        res.add(matrix[offset][offset]);
        return;
      }
      //四条边travserl,有规律
        //之前的j是后面的i，最后一一个j是第一个的i
      for(int i = 0; i < size -1; i++) {
        res.add(matrix[offset][offset + i]);
      }
      for(int i = 0; i < size - 1; i++) {
        res.add(matrix[offset + i][offset + size - 1]);
      }
      for(int i = size - 1; i >= 1 ;i--){
        res.add(matrix[offset + size -1][offset + i]);
      }
      for(int i =size -1; i >= 1; i--) {
        res.add(matrix[offset + i][offset]);
      }
      helper(matrix, res, offset + 1, size - 2);

  }

  // my Solution
  public List<Integer> spiral(int[][] matrix) {
    // T: O(n) S: O(n)
    List<Integer> list = new ArrayList<>();
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return list;
    }
    helper(matrix, matrix.length, 0, list);
    return list;
  }
  private void helper(int[][] matrix, int n, int offset, List<Integer> list) {
    if(offset == n/2) {
      if(n%2 == 1) {
        list.add(matrix[offset][offset]);
      }
      return;
    }
    for(int i = offset; i < n -1 - offset; i++) {
      list.add(matrix[offset][i]);
    }
    for(int i = offset; i < n -1- offset; i++) {
      list.add(matrix[i][n-1-offset]);
    }
    for(int i = n-1-offset; i > offset ; i--) {
      list.add(matrix[n-1-offset][i]);
    }
    for(int i = n-1-offset; i > offset; i--) {
      list.add(matrix[i][offset]);
    }
    helper(matrix, n, offset+1,list);
  }
}
