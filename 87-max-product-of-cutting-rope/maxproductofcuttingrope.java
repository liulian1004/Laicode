public class Solution {
  public int maxProduct(int length) {
    // T: O(n^2);  S: O(1)
    //base case: 2m
    //iinduction rule: i米长的绳子，至少切一刀，最大乘积是多少？
    //只要考虑切一刀的情况，分成以前已经碰到到过的情况 4米切一刀，分成1米和3米
    //m[i] keep to max product of length at the i m at least one cut
    //左大段（继续切割/或者不切）和右小段(不需要进行切割) 与 左大段和右大段的 结果一样，都能cover所有的case
    int[] m = new int[length + 1];
    //base case,0 米和1 米情况
    // 以下情况induction rule是不用，可以不用写
    //m[0] = 0;
    m[2] =1;
    for(int i = 3; i <= length; i++) { // i米的情况
      //内层循环是第一道切在哪里，用于分割左大段和右小段
      //内层循环到i-1即可
      for(int j = 1; j < i; j++) {
      //Math.max(m[j],j) 至少切一刀的最大乘积和一刀都不切的最大乘积
      //Math.max(m[i]....)这里的m[i]是指j在不同位置上是产生m[i]
      //和之后产生的m[i]进行对比
       m[i] = Math.max(m[i], Math.max(m[j], j)* (i - j));
      }
    }
    return m[length];
  }
}
//follow up how about at least k cut
public int cutRope(int n, int k) {
//  T: n*n*k S: O(n)
  if(n < 1 || k >= n) {
    return 0;
  }
  int[][] dp = new int[2][n+1];
  //base case: at least 1 meter with 0 cuts
  dp[0][1] = 1;
  for(int i = 0; i <= k;i++) { // cut
    for(int j = i+1; j <= n; j++) { // rope
      //min k = 0
      if(i == 0) {
        // k = 0
        dp[i%2][j] = j;
        // can cut max(n-1)
        for(int k = 1; k < j; k++) {
          dp[i%2][j] = Math.max(dp[i%2][j], dp[i%2][k]*(j-k));
        }
      } else { // k >=1 means at do one cut
        for(int k = 1; k < j; k++) {
          dp[i%2][j] = Math.max(dp[i%2][j], dp[(i-1)%2][k]*(j-k));
        }
      }
    }
  }
  return dp[k%2][n];
}
