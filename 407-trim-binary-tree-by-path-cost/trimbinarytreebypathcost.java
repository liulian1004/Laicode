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
  public TreeNode trimTree(TreeNode root, int k) {
    //T: O(n) S: O(h)
    //find the deepest depth of the tree
    // if the currect branch of deepeest depth < k, reutrn null
    int height = helper(root, k, 0);
    //corner case:
    // if the deep of the tree < k ==> return null
    if(height < k){
      return null;
    }
   return root;
  }

  private int helper(TreeNode node, final int k, int d) {
    if(node == null){
        return d;
    }
    int leftDepth = helper(node.left, k, d+1);
    int rightDepth = helper(node.right, k, d+1);
    if(leftDepth < k){
      node.left = null;
    }
    if(rightDepth < k){
      node.right = null;
    }
    return Math.max(leftDepth, rightDepth);
  }
}
