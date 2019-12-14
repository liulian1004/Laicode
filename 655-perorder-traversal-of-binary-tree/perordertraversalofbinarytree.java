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
  public List<Integer> preOrder(TreeNode root) {
    // Write your solution here
    if (root == null) {
    return new ArrayList<>() ;
  }
  List<Integer> result = new ArrayList<>();
  getValue(root, result);
  return result;
  }
  private void getValue(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    result.add(root.key);
    getValue(root.left, result);
    getValue(root.right, result);
  }
}
