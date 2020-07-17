public class Solution {
  public int leastInsertion(String input) {
    // base case: i == j == > dp[i][j] = 0;
    //induction rule:
    // if letter i == letter j ==> dp[i][j] = dp[i+1][j-1]
    // if  letter i != letter j dp[i][j] = Min(dp[i+1][j], dp[i][j-1])
    // for loop from col grows from left to right and row grows from bottom to up
    if(input == null || input.length() <= 1) {
      return 0;
    }
    int[][] dp = new int[input.length()][input.length()];
    for(int i = input.length()-1; i >= 0; i--) {
      for(int j = i; j < input.length(); j++) {
        if(i == j) {
          dp[i][j] = 0;
        }else if (input.charAt(i) == input.charAt(j)) {
            dp[i][j] = dp[i+1][j-1];
        }else {
          dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1])+1;
        }
      }
    }
    return dp[0][input.length()-1];
  }
}
