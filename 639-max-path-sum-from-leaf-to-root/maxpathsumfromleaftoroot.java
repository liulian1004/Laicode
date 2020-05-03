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
  public int maxPathSumLeafToRoot(TreeNode root) {
    // 从底走到头
    //return the biggest prefix sum

    //T: O(n); S: O(h)
    if(root == null) {
      return 0;
    }
    //base case
    //3种情况
     if(root.left == null) {
       return root.key + maxPathSumLeafToRoot(root.right);
     }
    if (root.right == null) {
      return root.key + maxPathSumLeafToRoot(root.left);
    }
    //因为Math.min里面不能比较null,所以必须先要判定root.right 和root.left不能为null
     return Math.max(maxPathSumLeafToRoot(root.left),maxPathSumLeafToRoot(root.right)) + root.key;
   }
}
