public class Solution {
  public int miniSum(int[][] grid) {
    if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //no need to create another space, use grid to rewrite
        //int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length;i++ ) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }else if(i == 0 && j != 0) {
                    grid[i][j] += grid[i][j-1];
                }else if(j==0 && i !=0) {
                    grid[i][j] += grid[i-1][j];
                }else{
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }

        }
         return grid[grid.length-1][grid[0].length-1];
  }
}
