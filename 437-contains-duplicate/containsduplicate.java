public class Solution {
  public boolean containsDuplicate(int[] nums) {
    // T:O(n) S: O(n)
    if( nums == null ||nums.length <= 1) {
      return false;
    }
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < nums.length ; i++) {
      if(!set.add(nums[i])) {
        return true;
      }
    }
   return false;
  }
}
