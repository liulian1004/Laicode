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
  public int countNodes(TreeNode root) {
    // Write your solution here
    if (root == null) {
      return 0;
    }
    return countNodes(root.left) + countNodes(root.right) + 1;
  }
}
