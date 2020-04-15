public class Solution {
  public int[] productExceptSelf(int[] nums) {
    // T: O(n) S: O(n)
    //ex: 1234
    // creat left/right to track the left/right side product
    //left : 1,2,6,24
    //right : 24,12,4,1
    // res[i] = left[i-1] * right[i+1]
    int[] left = new int[nums.length];
        left[0] = nums[0];
        int[] right = new int[nums.length];
        right[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1; i < nums.length;i++) {
            left[i] = left[i-1] * nums[i];
        }
        for(int i = nums.length - 2; i >=0 ;i--) {
            right[i] = right[i+1] * nums[i];
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length ;i++) {
            if(i == 0) {
                res[i] = right[i+1];
            }else if(i == nums.length - 1) {
                res[i] = left[nums.length - 2];
            }else {
                res[i] = left[i-1] * right[i+1];
            }
        }
        return res;
  }
}
