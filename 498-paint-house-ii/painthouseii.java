public class Solution {
  public int minCostII(int[][] costs) {
    // T: O(n*k^2) S: O(n*k)
    //dp[i][j] represents the  min cost for the house i paints the j color
    // record the last interation of the index of  min cost and the index of second cost
    //base case : i == 0
    if(costs == null || costs.length == 0|| costs[0].length == 0) {
      return 0;
    }

           int row = costs.length;
           int col = costs[0].length;
           int[][] dp = new int[row][col];
           int first =0;
           int second =0;
           for(int i = 0; i < row; i++) {
               for(int j = 0 ; j < col; j++) {
                   if(i == 0) {
                       dp[i][j] = costs[i][j];
                   }else  if ( j == first) {
                       dp[i][j] = costs[i][j] + dp[i-1][second] ;
                   }else {
                       dp[i][j] = costs[i][j] + dp[i - 1][first];
                   }
               }
               int[] ans = getMin(dp[i]);
               first = ans[0];
               second = ans[1];
           }
           return dp[row-1][first];
       }
       private int[] getMin(int[] array ) {
           int minIndex = 0;
           int secIndex = 0;
           int min = Integer.MAX_VALUE;
           int sec = Integer.MAX_VALUE;
           for(int i = 0 ; i < array.length; i++) {
               if(array[i] < min){
                   secIndex = minIndex;
                   minIndex = i;
                   sec = min;
                   min = array[i];
               }else if(array[i] < sec){
                   secIndex = i;
                   sec = array[i];
               }
           }
           return new int[]{minIndex,secIndex};
       }
}
