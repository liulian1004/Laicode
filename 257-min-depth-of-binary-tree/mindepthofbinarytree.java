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
  public int minDepth(TreeNode root) {
    // Write your solution here
    //T：O(n) S: O(h)
    if(root == null) {
      return 0;
    }
    if(root.left == null && root.right == null) {
      return 1;
    }
    if(root.left == null) {
      return minDepth(root.right) + 1;
    }
    if(root.right == null) {
      return minDepth(root.left) + 1;
    }
    //因为Math.min里面不能比较null,所以必须先要判定root.right 和root.left不能为null
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }
}
