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
  public String flattenBinaryTree(TreeNode root) {
    //T: O(n) S: O(h)
    // if node only have left child. ingore the right child when it null
    // if node only have right child. don't ingore the left child even it's null
    StringBuilder sb = new StringBuilder();
    helper(root, sb);
    return sb.toString();
  }
  private void helper(TreeNode root, StringBuilder sb) {
    //base case:
    if(root == null) {
      return;
    }
    sb.append(root.key);
    if(root.left == null && root.right == null) {
      return;
    }
    //left child
    sb.append('(');
    helper(root.left,sb);
    sb.append(')');

    //right child
    if(root.right != null) {
    sb.append('(');
    helper(root.right, sb);
    sb.append(')');
    }
  }
}
