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
    // 直上直下： 从底走到头
    //return the biggest prefix sum

    //T: O(n); S: O(h)

    //base case
    if(root == null) {
      return 0;
    }
      //recursion rule
      //4种情况
     if(root.left == null && root.right == null){
       return root.key;
     }
     if(root.left == null) {
       return root.key + maxPathSumLeafToRoot(root.right);
     }
    if (root.right == null) {
      return root.key + maxPathSumLeafToRoot(root.left);
    }
     return Math.max(maxPathSumLeafToRoot(root.left),maxPathSumLeafToRoot(root.right)) + root.key;
   }
}
