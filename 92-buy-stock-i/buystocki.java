public class Solution {
  //dp[i] for the ith. the profit , either seller at last day or inhertance the max profit
  public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int[] dp = new int[prices.length];
        int cost = prices[0];
        for(int i = 1; i < prices.length; i++){
          //the last day has to sell, the cost is the min num from 0 to i-1
            cost = Math.min(cost, prices[i-1]);
            dp[i]= Math.max(dp[i-1], prices[i]-cost);

        }
        return dp[dp.length-1];
    }
}
//my Solution
if(prices == null || prices.length <= 1){
            return 0;
        }
        int profit = prices[1]-prices[0];
        int min = Math.min(prices[0],prices[1]);
        for(int i = 2 ; i < prices.length; i++){
          if(prices[i] > prices[i-1]){
            //如果目前的selling价格比昨天的高。就在今天卖
            //但是要keep the max profit
            profit = Math.max(profit, prices[i] - min);
          }
          min = Math.min(prices[i], min);
        }
        return profit > 0? profit: 0;
      }
