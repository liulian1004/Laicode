public class Solution {
  public int whiteObjects(int[][] matrix) {
    // T: O(n*m)
    int res = 0;
    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[0].length; j++){
        if(matrix[i][j] == 0){
          res++;
          dfs(matrix,i,j);
        }
      }
    }
    return res;
  }
  private void dfs(int[][] matrix, int i, int j){
    if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 1){
      return;
    }
    matrix[i][j] = 1;
    dfs(matrix,i+1,j);
    dfs(matrix,i-1,j);
    dfs(matrix,i,j+1);
    dfs(matrix,i,j-1);
  }
}
