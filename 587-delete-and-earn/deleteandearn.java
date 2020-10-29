public class Solution {
  public int deleteAndEarn(int[] nums) {
    // house robber follow up problem with duplicate num
    // tranfer the nums to int[10000], int[i] = n represent for the value i+1, there are n count
    //induction rule:
    // case1 : choose i, then dp[i] = dp[i-1] + count*num i
    // case 2: not choose i, then dp[i] = dp[i-1]
    // dp[i] = Math.max(case1, case2)
    if(nums.length == 1){
      return nums[0];
    }
    int[] base = new int[10000];
    for(int i: nums){
      base[i-1]++;
    }
    int[] dp = new int[10000];
    dp[0] = base[0]*1;
    dp[1] = Math.max(base[1]*2, base[0]*1);
    for(int i = 2; i < 10000; i++){
      dp[i] = Math.max(dp[i-2] + base[i]*(i+1), dp[i-1]);
    }
    return dp[9999];

  }
}
