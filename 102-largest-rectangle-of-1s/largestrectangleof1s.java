public class Solution {
  public int largest(int[][] matrix) {
    //O(m^2) S: O(n)
    //build the continuce one from the top to bottom for each row
    //change the question to find the biggest rectangle for each row
    // update the global max
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int row = matrix.length;
    int col = matrix[0].length;
    int[] array = new int[col];
    int size = 0;
    for(int  i = 0 ; i < row;i++) {
      for(int j = 0 ; j < col; j++) {
          if(matrix[i][j] == 1) {
            array[j]++;
          }else {
            array[j] = 0;
          }
      }
      int cur = helper(array);
      size = Math.max(size, cur);
    }
    return size;
  }
  private int helper(int[] array) {
    int size = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for(int i = 0; i <= array.length; i++) {
      int rightBoundHeight = i < array.length? array[i] : 0;
      while(!stack.isEmpty() && array[stack.peekFirst()] >= rightBoundHeight) {
        int height = array[stack.pollFirst()];
        int right = i;
        int left = !stack.isEmpty()? stack.peekFirst()+1:0;
        size = Math.max(size, height * (right - left));
      }
      stack.offerFirst(i);
    }
    return size;
  }

}
