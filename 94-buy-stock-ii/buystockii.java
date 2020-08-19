public class Solution {
  public int maxProfit(int[] prices) {
    // T: O(n^2)
        int res = 0;
        for(int i = 0; i < prices.length; i++) {
            int p1 = getProfit(0,i,prices);
            int p2 = getProfit(i+1,prices.length-1,prices);
            res = Math.max(res,p1+p2);
        }
        return res;
    }
    private int getProfit(int i, int j, int[] array) {
        if(i >= j){
            return 0;
        }
        int profit = 0;
        int cost = Integer.MAX_VALUE;
        for(int k = i; k<=j; k++){
            cost = Math.min(cost, array[k]);
            profit = Math.max(profit, array[k]-cost);
        }
        return profit;
    }
}
