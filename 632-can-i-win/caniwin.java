public class Solution {
  public boolean canWin(int[] nums) {
    //你和你朋友的策略相同，都是想拿对自己最优的情况
    // 你先走
    // dp[][] row从后往前，col从左往右
    //T：O(n^2) S: O(n^2)
    //dp[i,j]: 对array[i,j],先走的人最多拿到的pizza
    //case 1，我先从右边拿
    // dp[i][j] = array[i](右边的pizza数量) + （prefixsum[i+1][j] - dp[i+1][j](朋友先走拿到的最多的pizza数量)
    //我先走拿到的pizza数量dp[i][j] = index i的pizza数量 + [(i+1,j)的sum - 朋友先走拿到的数量dp[i+1][i]]]
    //base case是当i == j的时候，在dp[][]里面，这就是一条从左上到右下的对角线。这决定了我们要从这条对角线上开始填值。所以每一行都是由j = i开始填。
    //计算prefix sum
    int[] prefixSum = new int[nums.length];
    prefixSum[0] = nums[0];
    for(int i = 1; i < nums.length ;i++){
      prefixSum[i] = prefixSum[i-1] + nums[i];
    }
    int[][] dp = new int[nums.length][nums.length];
    for(int i = nums.length - 1; i >= 0; i--){
      for(int j = i; j < nums.length; j++) {
        //base case
        if(i == j){
          dp[i][j] = nums[i];
        //找从左边拿或者从右边拿最大的数量
        }else {
          dp[i][j] = Math.max(nums[i] + getSum(prefixSum,i+1,j) - dp[i+1][j],
                              nums[j] + getSum(prefixSum,i,j-1) - dp[i][j-1]);
        }
      }
    }
    //返回 sum - dp < dp?
    //不能这么写，有可以 presume是奇数
    //return dp[0][nums.length-1] >= prefixSum[nums.length -1] / 2;
    return dp[0][nums.length-1] >= prefixSum[nums.length -1] - dp[0][nums.length - 1];
  }
  private int getSum(int[] sum, int i ,int j) {
    if(i < 1) {
      return sum[j];
    }
    return sum[j] - sum[i-1];
  }
}
