public class Solution {
  public int numOfTrees(int n) {
    // dp[i]: represent the number of bst generated  on the n，start from 0
    // 0 means no node
    if(n <= 1){
      return 1;
    }
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2; i <= n; i++){
      for(int j = 0; j <= i-1; j++){
        //j is the pointer represents the number of sub tree
        dp[i] += dp[j]*dp[i-1-j];
      }
    }
    return dp[n];
  }
}
