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
  public int maxPathSum(TreeNode root) {
    // 维护一个globall sum
    // 分开讨论
    // both leaf trea not null, MAX(max(left, right) + root, root()
    //T: O(n); S: O(h)
    int[] max = new int[]{Integer. MIN_VALUE};
    if(root == null || root.left == null && root.right == null) {
      return max[0];
    }
    helper(root, max);
    return max[0];
  }
  private int helper(TreeNode root, int[] max) {
    if(root== null) {
      return 0;
    }
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    if(root.left != null && root.right != null) {
      //update the global max
      // max[0] VS left+ right + root.key
      max[0] = Math.max(max[0], left+ right + root.key);
      return Math.max(left, right) + root.key;
    }
    // root.left == nulll || root.right == null
    // 没有left node to leaf node 的路径
    //直接做 返回的sum of path

    return root.left == null? right + root.key : left + root.key;
  }
}
