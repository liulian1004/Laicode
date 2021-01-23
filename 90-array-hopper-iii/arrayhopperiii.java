public class Solution {
  public int minJump(int[] array) {
    // T: O(n^2) S: O(1)
    // dp[i]: the shorest step that jump to the i
    //case1:
    // can jump out of scope directly from the mid of array
    //case2:
    // if can't jump from mid of array, then jump one more step from last array
    //case2:
    // the last element is 0 or can't reachabout, return -1
    int res = Integer.MAX_VALUE;
    int[] dp = new int[array.length];
    for(int i = 1; i < array.length; i++){
      dp[i] = -1;
      for(int j = i-1; j>=0; j--){
        if(array[j]+j >= i && dp[j] != -1){
          if(dp[i] == -1){
            dp[i] = dp[j]+1;
          }else{
            dp[i] = Math.min(dp[i], dp[j]+1);
          }
          if(array[j]+j >= array.length){
              //在中间的时候，就发现一步能跳到 array的外面
              res= Math.min(res, dp[j]+1);
            }
          }
        }
      }
      //在末尾的时候，查一下是否能从末尾跳到外面
      if(array[array.length-1] != 0 && dp[array.length-1] != -1){
        res = Math.min(res, dp[array.length-1]+1);
      }
      if(res == Integer.MAX_VALUE){
        return -1;
      }
      return res;
    return res;
  }
}
