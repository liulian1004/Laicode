public class Solution {
  public int maxProduct(int[] nums) {
    // T: O(n*logn)
    //find the top three elements and two smallest elements
    Arrays.sort(nums);
    int a1 = nums[nums.length-1]* nums[nums.length-2]*nums[nums.length-3];
    int a2= nums[nums.length-1]*nums[0]*nums[1];
    return Math.max(a1,a2);

  }
}
