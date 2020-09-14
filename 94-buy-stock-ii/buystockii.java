public class Solution {
  public int maxProfit(int[] prices) {
    // T: O(n^2)
    // partition
    // at most 2 transaction， 所以可以假设如果两端的profit<0 可以不交易，返回0
    // XXX KKKK 分成计算他们的max profit
    int res = 0;
    //这里i要走到底，in case这个array只有两个元素
    //在helperfunction里检查该段partition是否有效
    for(int i = 1; i < prices.length; i++){
      int p1 = getProfit(0,i,prices);
      int p2 = getProfit(i+1, prices.length-1, prices);
      res = Math.max(res, p1+p2);
    }
    return res;
    }
    private int getProfit(int i, int j, int[] array){
    //如果这一段元素个数小于1，直接返回
    //用于该段partition<= 1的情况
    if(i>=j){
      return 0;
    }
    //先买后卖，先跟新cost
    //profit是当天的价格-最小cost
    int cost = Integer.MAX_VALUE;
    int profit= 0;
    for(int k = i; k<=j; k++){
      cost = Math.min(cost, array[k]);
      profit = Math.max(profit, array[k]-cost);
    }
    return profit;
    }
}
