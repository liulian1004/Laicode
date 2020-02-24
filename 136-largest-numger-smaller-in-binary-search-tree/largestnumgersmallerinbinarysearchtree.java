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
  public int largestSmaller(TreeNode root, int target) {
    // T: O(h) - worst case O(n)-糖葫芦； best case o(logn) - 满二叉树
    //S： O(1)
    if(root == null) {
      return Integer.MIN_VALUE;
    }
    //原始值为最小值
    int result = Integer.MIN_VALUE;
    while(root != null) {
      // > target, 往左找
      if(root.key >= target) {
        root = root.left;
      // < target 跟新reult，往右找
      }else{
        result = root.key;
        root = root.right;
      }
    }
    return result;
  }
}
