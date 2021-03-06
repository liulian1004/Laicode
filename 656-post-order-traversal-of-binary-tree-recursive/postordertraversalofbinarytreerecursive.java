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
  public List<Integer> postOrder(TreeNode root) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    getValue(root, result);
    return result;
  }
  private void getValue(TreeNode root, List<Integer> result) {
    if (root == null) {//corner case +base case
      return;
    }
    getValue(root.left, result);
    getValue(root.right, result);
    result.add(root.key);
  }
}
