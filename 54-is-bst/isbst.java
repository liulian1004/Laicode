public class Solution {
  public boolean isBST(TreeNode root) {
    //Time: O(n) ->n: #of node Space O(height)
    if (root == null) {
        return true;
      }
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  private boolean isBST(TreeNode root, int min, int max) {
    if(root == null) {
      return true;
    }
    if(root.key <= min || root.key >= max) {
      return false;
    }
    return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
  }
