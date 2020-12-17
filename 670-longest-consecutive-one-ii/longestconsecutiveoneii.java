public class Solution {
  public int longestConsecutiveOnes(int[] nums) {
    // silding window count 0 == 1
    int i =0;
    int j = 0;
    boolean zero = false;
    int res = 0;
    while(j < nums.length){
      if(nums[j] == 0){
          if(zero == false){
            zero = true;
          }else{
            while(i <= j && nums[i] == 1){
              i++;
            }
            // nums[i] = 0
            i++;
          }
      }
      res = Math.max(res, j-i+1);
      j++;
    }
    return res;
  }
}
