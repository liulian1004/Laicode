public class Solution {
  public int maxProfit(int[] prices) {
    //T: O(n) S: O(n)
    //dp[i][0]: the max profit that I don't have stock at i day
        //dp[i][1]: the max profit that I have stock at i day
        // if I don't have at i day
        //case1 : I sell stock at i day dp[i][0] = dp[i-1][1] + price[i]
        // case2: I don't have stock at i day dp[i][0] = dp[i-1][0]
        // if I have stock at i day
        //case1 : I buy stock at i day(one day for cooldown after selling) dp[i][1] = dp[i-2][1] - price[i]
        // case2: I have stock at i-1 day dp[i][1] = dp[i-1][1]

        //invalid case
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        // corner case , only 2 days
        if(prices.length == 2) {
            return prices[0] < prices[1] ? prices[1] - prices[0] : 0;
        }
        int[][] dp = new int[prices.length][2];
        //base case for day one and day two
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][0]-prices[1], dp[0][1]);

        for(int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0]-prices[i]);
        }
        return dp[prices.length-1][0];
  }
}
