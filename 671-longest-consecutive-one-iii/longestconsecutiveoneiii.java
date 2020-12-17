public class Solution {
  public int longestConsecutiveOnes(int[] nums, int k) {
    // silidng window:
    // i,j之间的count 0 <= k, update length
    // i,j之间的0 >k, 移动i直到0<=k为止
    int i = 0;
    int j = 0;
    int count = 0;
    int res = 0;
    while(j<nums.length){
      if(nums[j] == 0){
        count++;
      }
      if(count > k){
        while(i<=j && nums[i]==1){
          i++;
        }
        i++;
        count--;
      }
      res = Math.max(res, j-i+1);
      j++;
    }
    return res;
  }
}
