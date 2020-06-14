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
  public boolean isIdentical(TreeNode one, TreeNode two) {
    // T: O(one + two) : S(the short height)
    if(one == null && two == null ) {
      return true;
    }
    if(one == null || two == null) {
      return false;
    }
    if(one.key != two.key) {
      return false;
    }
    return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
  }
}
