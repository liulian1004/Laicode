public class Solution {
  public double maxAverage(int[] nums, int k) {
    // T:O(n) S: O(1)
    double res = Integer.MIN_VALUE*1.0;
    int sum = 0;
    for(int i = 0; i < nums.length; i++){
      if(i < k){
        sum += nums[i];
      }else{
        res = Math.max(res, sum*1.0/k);
        sum -= nums[i-k];
        sum += nums[i];
      }
    }
    res = Math.max(res, sum*1.0/k);
    return res;
  }
}
