public class Solution {
  public int longestConsecutiveOnes(int[] nums, int k) {
    // Write your solution here
    int i = 0;
    int j = 0;
    int distance = 0;
    int count = 0;
    while(j < nums.length) {
      // sliding windows expands
        if(nums[j] == 1) {
           j++;
          distance = Math.max(distance, j - i);
      //sliding window continue expanding even i == 0, because the swap times
      }else if (nums[j] == 0 && count < k) {
        j++;
        count++;
        distance = Math.max(distance, j - i);
      // no swap left, i-- in any condition, count-- when nums[i] = 0
      } else {
        if(nums[i] == 0) {
          count--;
        }
        i++;
      }

    }
    return distance;

  }
}
