public class Solution {
  public int searchInsert(int[] nums, int target) {
    //T: O(logn); S: O(1)
    if(nums == null || nums.length == 0) {
        return 0;
    }
    int i = 0;
    int j = nums.length-1;
    while(i < j -1) {
      int m = i + (j-i)/ 2;
      if(nums[m] >= target) {
        j = m;
      }else {
        i = m + 1;
      }
    }
    if(nums[i] >= target) {
      return i;
    }
    if(nums[j] >= target) {
        return j;
    }
    return nums.length;
  }
}
