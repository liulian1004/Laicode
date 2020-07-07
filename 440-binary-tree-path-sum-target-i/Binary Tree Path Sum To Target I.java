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
  public boolean exist(TreeNode root, int target) {
    // T: O(n) S: O(h)
    if(root == null) {
      return false;
    }
    return helper(root, target);
  }
  private boolean helper(TreeNode root, int target,) {
    if(root == null) {
      return target == 0;
    }
    target -= root.key;
    //这里需要先判断左右子树是否为空
    // in case 以下情况
    //      0
    //    /
    //   5
    if(root.left == null ) {
      return helper(root.right, target);
    }
    if(root.right == null ) {
      return helper(root.left, target);
    }
    return helper(root.left, target) || helper(root.right, target);
  }
}
