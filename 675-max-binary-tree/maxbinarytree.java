/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    // T: O(n*h) S:O(h)
    //每一层的时间复杂度是O(n),层高是h ==> t = n*h
    return helper(nums, 0, nums.length-1);
  }
  private TreeNode helper(int[] nums, int left, int right){
      if(left > right){
        return null;
      }
      //max[max, maxIndex]
      int[] max = getMax(nums, left, right);
      TreeNode root = new TreeNode(max[0]);
      root.left = helper(nums, left, max[1]-1);
      root.right = helper(nums,max[1]+1, right);
      return root;
  }
  private int[] getMax(int[] array, int left, int right){
    int[] res = new int[2];
    res[0] = array[left];
    res[1] = left;
    for(int i = left+1; i <= right; i++){
      if(res[0] < array[i]){
        res[0] = array[i];
        res[1] = i;
      }
    }
    return res;
  }

}
