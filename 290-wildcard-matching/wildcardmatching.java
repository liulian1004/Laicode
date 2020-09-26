public class Solution {
  public boolean match(String input, String pattern) {
    // dp[i][j] represent the whether match for ending at i-1 and j -1
    // start from 0 which means empty
    //base case:
    //1. pattern and input is empty
    //2. input is empty && pattern is '*'
    //induction rule
    // 1. i-1 == j -1 || j-1 ==?=> dp[i][j] = dp[i-1][j-1]
    //2. j-1 == *
    //case a: * == 0, look the situation of dp[i][j-1]
    //cas2 b: * can be used many time, look the situtation of dp[i-1][j]
    boolean[][] dp = new boolean[input.length()+1][pattern.length()+1];
    for(int i = 0; i <=input.length(); i++){
      for(int j = 0; j <= pattern.length();j++){
        ///base case:
        if(i == 0 && j ==0 || i == 0 && j== 1&& pattern.charAt(j-1) == '*'){
          dp[i][j] = true;
        }else if(j != 0 && i !=0 && (input.charAt(i-1) == pattern.charAt(j-1)
        || pattern.charAt(j-1) == '?'){
          dp[i][j] = dp[i-1][j-1];
        }else if(j != 0 && i != 0 && pattern.charAt(j-1) == '*'){
          dp[i][j] = dp[i][j-1] || dp[i-1][j];
        }
      }
    }
    return dp[input.length()][pattern.length()];
  }
}
