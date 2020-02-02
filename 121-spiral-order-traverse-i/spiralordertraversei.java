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
}
