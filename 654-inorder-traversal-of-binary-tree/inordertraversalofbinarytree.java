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
  public List<Integer> inOrder(TreeNode root) {
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
    result.add(root.key);
    getValue(root.right, result);
  }
}
