public class Solution {
  public int maxProfit(int[] prices, int k) {
    if(k == 0 || prices.length <= 1){
       return 0;
   }
   //case 1: k is unlimited ==> change the problem to sell stock II
   if(2*k >=  prices.length){
       return sell(prices);
   }
   //case2: find the max profit with k transtractions
   //when you buy stock, it considers one transation
   //dp[i][j][0]: at the ith day, finished j transation, the max profit when not holding a stock
   //dp[i][j][1]: at the ith day, finished j transation, the max profit when holding a stock
   //return dp[length][k][0];
   int[][][] dp = new int[prices.length][k+1][2];
   //we need to inital the array, because some value of array can't be generated due to the transctions resctrion
   //ie. the first day, the max  transction is only for 1
   //here choose inital -10power(6) because the max value for prices 10(5).
   //If we choose min value, it might have overflow if -price[i]
    for (int i = 0; i < prices.length; i++) {
       for (int j = 0; j <= k; j++) {
           dp[i][j][0] = (int)Math.pow(10.00, 6.00) * -1;
           dp[i][j][1] = (int) Math.pow(10.00, 6.00) * -1;
       }
   }
   //base case: day 1
   dp[0][0][0] = 0;
   dp[0][1][1] = -prices[0];
   for(int i = 1; i < prices.length;i++) {
           for(int j = 0; j<=k ; j++){
               //今天没有股票 max(昨天没有股票，昨天有股票+今天卖了)
           dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i]);
               //今天有股票 max(昨天有股票，昨天没有股票+今天买了)
           if(j > 0){
               dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] -prices[i]);
           }

       }
   }
   int res = 0;
   for(int j = 0; j <= k; j++){
       res = Math.max(res, dp[prices.length-1][j][0]);
   }
   return res;
}
private int sell(int[] prices){
   int[][] dp = new int[prices.length][2];
   dp[0][0] = 0;
   dp[0][1] = -prices[0];
   for(int i = 1; i < prices.length;i++){
     dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+ prices[i]);
     dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
   }
   return dp[prices.length - 1][0];
}

}
