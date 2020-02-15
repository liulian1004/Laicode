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
  public TreeNode reverse(TreeNode root) {
    // T: O(1/2)n; S: O(h)
    //类似于reverse link
    //reverse left tree and left node.right connect to the right node(ie 3 -> 4)
    if(root == null || root.left == null) {
      return root;
    }
    //newRoot一旦赋值不能变，就像reverseLinkedList
    TreeNode newRoot = reverse(root.left);
    root.left.right = root.right;
    root.left.left = root;
    //断开链接
    root.left = null;
    root.right = null;
    return newRoot;
  }
}
