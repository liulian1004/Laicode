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
  public TreeNode mergeBinaryTrees(TreeNode root1, TreeNode root2) {
    // T: O(n + m) S: O(max height of two tree)
    //注意npe root.left, root.right不会npe,root.val会npe
    //所以要先判断当前层是两个root是否为空
    if(root1 == null && root2 == null) {
      return null;
    }

      TreeNode root = null;

      if(root2 == null) {
        root = new TreeNode(root1.key);
        root.left = mergeBinaryTrees(root1.left, null);
        root.right = mergeBinaryTrees(root1.right, null);
      }else if(root1 == null) {
        root = new TreeNode(root2.key);
        root.left = mergeBinaryTrees(null, root2.left);
        root.right = mergeBinaryTrees(null, root2.right);
      }else {
        root = new TreeNode(root1.key + root2.key);
        root.left = mergeBinaryTrees(root1.left, root2.left);
        root.right = mergeBinaryTrees(root1.right, root2.right);
      }
      return root;
  }
}
