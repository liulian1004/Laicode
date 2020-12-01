public class Solution {
  public int[] missingNumber(int[] nums) {
    // Write your solution here
    int dup = -1;
    int miss = -1;
    Set<Integer> set = new HashSet<>();
    for(int i: nums){
      if(!set.add(i)){
        dup = i;
      }
    }
    for(int i =1; i <= nums.length; i++){
      if(!set.contains(i)){
        miss = i;
        break;
      }
    }
    return new int[]{dup, miss};
  }
}
