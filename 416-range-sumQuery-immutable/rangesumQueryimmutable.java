public class Solution {
  public int sumRange(int[] nums, int i, int j) {
    // T： O(n); S: O(n)
    // m[i] represent the sum from 0-th to i-th
    int[] m = new int[nums.length];
    m[0] = nums[0];
    for(int k = 1; k < nums.length; k++) {
      m[k] = m[k-1] + nums[k];
    }
    // 这里其实是m[j] - m[i-1],但是以下写法就不需要考虑i=0的情况了
    return m[j] - m[i] + nums[i];
  }
}
