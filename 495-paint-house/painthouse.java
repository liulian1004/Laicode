public class Solution {
  public int minCost(int[][] costs) {
    //T: O(n^2) S: O(1)
    // dp[i][0] the min cost for painting the first i houses with the i-th house is color 0
    //only need to know the result of last row of dp ==> %2(the cur row + the last row)
    if(costs == null||costs.length == 0||costs[0].length == 0) {
      return 0;
    }
    int[][] dp = new int[2][3];
    //base case
    for(int i = 0; i<3; i++) {
      dp[1][i] = costs[0][i];
    }
    for(int i = 2; i<= costs.length;i++) {
      dp[i%2][0] = costs[i-1][0] + Math.min(dp[(i-1)%2][1], dp[(i-1)%2][2]);
      dp[i%2][1] = costs[i-1][1] + Math.min(dp[(i-1)%2][0], dp[(i-1)%2][2]);
      dp[i%2][2] = costs[i-1][2] + Math.min(dp[(i-1)%2][0], dp[(i-1)%2][1]);
    }
    return Math.min(Math.min(dp[costs.length%2][0],dp[costs.length%2][1]),dp[costs.length%2][2]);
  }
}
