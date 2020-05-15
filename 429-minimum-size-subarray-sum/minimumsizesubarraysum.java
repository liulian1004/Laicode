public class Solution {
  public int minSubArrayLen(int num, int[] nums) {
    //T: O(n) S: O(1)
    // sliding windows
    //two pointer
    if(nums == null || nums.length ==0) {
       return 0;
    }
    int i = 0;
    int j = 0;
    int res = nums.length +1;
    int sum = 0;
    while(j < nums.length) {
      sum += nums[j++];
      while(sum >= num){
        res= Math.min(res, j-i);
        sum-=nums[i++];
      }
    }
    return res == nums.length + 1? 0 : res;
  }
}
