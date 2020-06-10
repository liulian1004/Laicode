import java.util.Arrays;

public class Solution {
  public int minJump(int[] array) {
    //Assumpt non-negative integer
    //m[i] represt the min Jump steps from 0 to index i;
    // induction rule: m[i] = 1 + minstep of m[j] j = i-1]
    //T: O(n^2); S: O(n);

    // not reacheable is -1;
    int n = array.length;
    int[] m = new int[n];
  m[0] = 0;
  for(int i = 1; i < n; i++) {
    //in case can't jump to this step
    m[i] = -1;
    for(int j = i - 1; j >= 0; j--) {
      //从j能够跳到i并且j已经被能够跳到
      if(j + array[j] >= i && m[j] != -1) {
        // i要么之前没有被跳过，要么之前跳过的步数比后面可以更新的步数更加大
        //替换成新的步数
          if(m[i] == -1 || m[i] > m[j] + 1) {
            m[i] = m[j] + 1;
          }
      }
    }
  }
  return m[n-1];
}
//my solution jump back the last step
public int minJump(int[] array) {
    // Write your solution here
    if(array == null || array.length <= 1) {
      return 0;
    }
    int[] dp = new int[array.length];
    dp[array.length - 1] = 0;
    for(int i = array.length -2; i >= 0; i--) {
      int min = Integer.MAX_VALUE;
      for(int j = i+1; j <= (i + array[i]) && j <=(array.length - 1); j++) {
        if(dp[j] != -1) {
           min = Math.min(min, dp[j]);
        }
      }
      if(min != Integer.MAX_VALUE) {
        dp[i] = min + 1; // 2
      }else {
        dp[i] = -1;
      }
    }
    return dp[0];
  }
