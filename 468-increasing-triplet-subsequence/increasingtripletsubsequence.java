public class Solution {
  public boolean increasingTriplet(int[] nums) {
    // T: O(n)
    int one = Integer.MAX_VALUE;
    int two = Integer.MAX_VALUE;
    for(int i : nums){
      if(i <= one){
        one = i;
      }else if(i <= two){
        two = i;
      }else{
        return true;
      }
    }
    return false;

  }
}
