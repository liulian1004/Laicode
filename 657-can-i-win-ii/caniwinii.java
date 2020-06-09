public class Solution {
  public int canWin(int[] nums) {
    //朋友总是拿大的，如果两边一样大，朋友从右边拿
    //case1 :
    // I pick up from left, my friend alwasy pick up the bigger pizza
    // array[i+1] > array[j], friend pick up i+1
    // dp[i][j] = array[i] + subarray sum(i+2,j) - dp[i+2][j]
    // else dp[i][j] = array[i] + subarray sum(i,j-1) - dp[i][j-1]，
    if(nums == null || nums.length == 0) {
      return 0;
    }
    int n = nums.length;
    int[][] dp = new int[n][n];
    // 填表顺序： i 从down to top ; j from left to right
    for(int i = n - 1; i >= 0; i--) {
      for(int j = i; j < n ; j++) {
        //base case 1 : only one pizza left
        if(i == j){
          dp[i][j] = nums[i];
          // base case 2 : only two pizza left
        } else if(i == j - 1) {
          dp[i][j] = nums[i] > nums[j]? nums[i] : nums[j];
        }else {
          int left = nums[i] + (nums[i+1] > nums[j] ? dp[i+2][j] : dp[i+1][j-1]);
          int right = nums[j] + (nums[i] > nums[j-1] ? dp[i+1][j-1] : dp[i][j-2]);
          dp[i][j] = Math. max(left, right);
        }
      }
    }
    return dp[0][n-1];
  }
}
