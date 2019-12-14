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
  public boolean isBalanced(TreeNode root) {
    // Write your solution here
    return getHeightOrUnbalanced(root) >= 0;
  }
  private int getHeightOrUnbalanced(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = getHeightOrUnbalanced(root.left);
    int right = getHeightOrUnbalanced(root.right);
    if (left < 0 || right < 0) {
      return -1;
    }
    if (Math.abs(left - right) > 1) {
      return -1;
    }
    return Math.max (left, right) + 1;
  }
}
