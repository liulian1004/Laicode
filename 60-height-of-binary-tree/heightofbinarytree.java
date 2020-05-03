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
  public int findHeight(TreeNode root) {
    // S: O(h); T: O(n) "n = totoal number of node"
    if (root == null) {
      return 0;
    }
    return Math.max(findHeight(root.left), findHeight(root.right)) + 1 ;

  }
}
