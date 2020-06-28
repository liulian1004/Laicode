public class Solution {
  public void rotate(int[][] matrix) {
    // T: O(n * n) S: O(1)
    //clockwise 90 main diagonal+ y axle
    // ant-closkwise 90 second diagonal + x axle
    // 180  y axle + x axle
    if(matrix.length == 0 || matrix[0].length == 0) {
      return;
    }
    int n = matrix.length;
    flipDigonal(matrix,n);
    flipY(matrix,n);

  }
  private void flipDigonal(int[][] matrix, int n) {
   for(int i =0; i < n; i++) {
     for(int j = i+1; j < n; j++) {
       swap(matrix, i, j, j, i);
     }
   }
  }
  private void flipY(int[][] matrix, int n) {
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n/2; j++) {
        swap(matrix, i, j, i, n-1-j);
      }
    }
  }
  private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
    int temp = matrix[x1][y1];
    matrix[x1][y1] = matrix[x2][y2];
    matrix[x2][y2] = temp;
  }
}
