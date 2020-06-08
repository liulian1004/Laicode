public class Solution {
  public int longestPalindrome(String input) {
    // dp[i][j] present the longest palindrome subsequence for the scope[i,j]
    // for loop : i from down to top, j from left to right(start from base case)
    if(input == null || input.length() == 0) {
      return 0;
    }
    int n = input.length();
    int[][] dp = new int[n][n];
    for(int i = n-1; i >= 0; i--) {
      for(int j = i; j < n; j++ ){
        //base case: only one element
        if(i == j) {
          dp[i][j] = 1;
        // case 1 :  char i == char j
        }else  if(input.charAt(i) == input.charAt(j)) {
          dp[i][j] = dp[i+1][j-1] + 2;
        // case 2: char i != char j
        }else {
          dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        }
      }
    }
    return dp[0][n-1];
  }
}
