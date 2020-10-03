public class Solution {
  public boolean canMerge(String a, String b, String c) {
    // dp[i][j]: the string ends at i-1 and string ends at j-1 can come up with the c
    // base case :
    // i == 0 and j == 0 => true
    // i == 0 ==> check string ends at j-1 can come up with the c or not
    // j == 0 ==> check string ends at i-1 can come up with the c or not
    // induction rule:
    // c.charAt(i+j-1) == a.charAt(i-1) && dp[i-1][j]
    // c.charAt(i+j-1) == b.charAt(j-1) && dp[i][j-1]
    if(a.length()+b.length() != c.length()){
      return false;
    }
    boolean dp[][] = new boolean[a.length()+1][b.length()+1];
    for(int i = 0; i<= a.length();i++){
      for(int j = 0; j<= b.length();j++){
        if(i==0 && j==0){
          dp[i][j] = true;
        }else if(i==0){
          dp[i][j] = (c.charAt(i+j-1)==b.charAt(j-1) && dp[i][j-1]);
        }else if(j ==0){
          dp[i][j] = (c.charAt(i+j-1)== a.charAt(i-1)&&dp[i-1][j]);
        }else{
          dp[i][j] = (c.charAt(i+j-1)==b.charAt(j-1) && dp[i][j-1])
                    || (c.charAt(i+j-1) == a.charAt(i-1)&&dp[i-1][j]);
        }
      }
    }
    return dp[a.length()][b.length()];
  }

}
