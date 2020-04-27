public class Solution {
  public int minCostII(int[][] costs) {
    // T: O(n^k) S: O(k)
    if(costs == null || costs.length == 0|| costs[0].length == 0) {
      return 0;
    }
    int[][] dp = new int[2][costs[0].length];
    //base case
    for(int i = 0; i < costs[0].length;i++) {
      dp[1][i] = costs[0][i];
    }
    // travseral each house
    for(int i = 2; i <= costs.length; i++) {
       int[] set  = findMin(dp[(i-1)%2]);
       int minColor = set[0];
       int minCost = set[1];
       int secondCost = set[2];
      //traversal each color
      for(int j = 0; j< costs[0].length;j++) {
        int min =(j == minColor? secondCost:minCost);
        dp[i%2][j] = costs[(i-1)][j] + min;
      }
    }
    int ans = dp[costs.length %2][0];
    for(int i = 1; i < costs[0].length; i++) {
      ans = Math.min(ans, dp[costs.length % 2][i]);
    }
    return ans;
  }
  private int[] findMin(int[] array) {
    int minColor = -1;
    int minCost = Integer.MAX_VALUE;
    int secondColorCost = Integer.MAX_VALUE;
    for(int i = 0; i < array.length ;i++) {
      if(array[i] < minCost) {
        // if(minCost < secondColorCost) { ===> not sure it's need to add this condition
        //   secondColorCost = minCost;
        // }
       secondColorCost = minCost;
        minColor = i;
        minCost = array[i];
      }else if(array[i] < secondColorCost) {
        secondColorCost = array[i];
      }
    }
    return new int[]{minColor, minCost, secondColorCost};
  }
}
