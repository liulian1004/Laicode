public class Solution {
  public boolean isSymmetric(TreeNode root) {
    // 这里是判断半棵树，Time = O(n/2)； Space= O(h); worse case O(n)
    //best case: t： O(h)
    if(root == null) {
      return true;
    }
    return isSymmetric(root.left, root.right);
  }
  private boolean isSymmetric(TreeNode one, TreeNode two) {
    if(one == null && two == null) {
      return true;
    } else if(one == null || two == null) {
      return false;
    } else if(one.key != two.key) {
      return false;
    }
    return isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
  }
}
