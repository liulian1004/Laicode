public class Solution {
  public int maxProfit(int[] array) {
    if(array == null || array.length == 0){
      return 0;
    }
    //dp[i][0]: at ith, the max profit after buying the stock
    //dp[i][1]: at ith day, the max profict after selling the stock
    int n = array.length;
    int[][] dp = new int[n][2];
    dp[0][0] = -array[0];
    dp[0][1] = 0;
    for(int i = 1; i < n; i++){
      dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - array[i]);
      dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + array[i]);
    }
    return dp[n-1][1];
  }
}
