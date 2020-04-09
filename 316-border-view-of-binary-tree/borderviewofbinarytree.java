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
  public List<Integer> borderView(TreeNode root) {
    // T: O(n); S: O(height)
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    res.add(root.key);
    helper(root.left, true, false, res);
    helper(root.right, false, true, res);
    return res;
  }

  private void helper(TreeNode node, boolean leftbd, boolean rightbd, List<Integer> res) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {
      res.add(node.key);
      return;
    }
    if (leftbd) {
      res.add(node.key);
    }
    helper(node.left, leftbd && (node.left!=null), rightbd && (node.right==null), res);
    helper(node.right, leftbd && (node.left==null), rightbd && (node.right!=null), res);
    if (rightbd) {
      res.add(node.key);
    }
  }// end of helper
}
