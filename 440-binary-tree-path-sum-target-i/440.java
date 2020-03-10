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
  public boolean exist(TreeNode root, int target) {
    // T: O(n) S: O(h)
    if(root == null) {
      return false;
    }
    int sum = 0;
    return helper(root, target, sum);
  }
  private boolean helper(TreeNode root, int target, int sum) {
    if(root == null) {
      return false;
    }
    sum += root.key;
    //走到left，查看sum的结果是否等于target
    if(root.left == null && root.right == null && sum == target) {
      return true;
    }
    //如果为true 返回左子树结果
    if(root.left != null && helper(root.left, target, sum)) {
      return true;
    }
    //如果为true 返回左子树结果
    if(root.right != null && helper(root.right, target, sum)) {
      return true;
    }
    //返回false
    return false;
  }
}
