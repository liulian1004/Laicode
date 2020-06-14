public class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    // T: O(n) S: O(n)
    if(nums == null || nums.length == 0 || k <= 0) {
      return false;
    }

    Set<Integer> set = new HashSet<>();
    int i = 0;
    int j = 0;
    while(j < nums.length) {
      if(!set.add(nums[j])) {
          return true;
      }
      j++;
      if((j-i) > k) {
          set.remove(nums[i]);
          i++;
      }

    }
    return false;
  }
}
