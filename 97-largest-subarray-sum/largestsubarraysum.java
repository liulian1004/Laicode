public class Solution {
  public int largestSum(int[] array) {
    // T: O(n); S: O(1)
    // cur = cur largest subArray sum;
    // res: overall largest subArray sum
    //subarray must contain one elementl the largest subarray can consider the first one
    int cur = array[0];
    int res = array[0];
    for(int i = 1; i < array.length; i++) {
      //subArray is continouse
      // the largest Sum for the current subArray is pre + cur value || cur value(pre is negative)
      cur = Math.max(cur+array[i], array[i]);
      res = Math.max(cur, res);
    }
    return res;
  }
}
