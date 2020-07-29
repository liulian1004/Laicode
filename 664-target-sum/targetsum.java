public class Solution {
  public int waysToTargetSum(int[] nums, int target) {
    // T: n^2 S: O(n)
    int cur = 0;
    int level = 0;
    int[] res = new int[1];
    helper(nums, target, cur, level, res);
    return res[0];
  }
  private void helper(int[] nums, int target, int cur, int level, int[] res) {
    if(nums == null || level == nums.length) {
      if(cur == target) {
        res[0]++;
      }
      return;
    }
    helper(nums, target, cur + nums[level], level+1, res);
    helper(nums, target, cur - nums[level],level+1, res);
  }
}
