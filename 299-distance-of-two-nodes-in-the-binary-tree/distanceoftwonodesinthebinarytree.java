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
  public int distance(TreeNode root, int k1, int k2) {
    // T: O(n) S: O(h)
    // find the lca of k1 && k2
    // find the distance between lca and k1,k2 separately
    TreeNode anc = lca(root, k1,k2);
    if(anc == null) {
      return -1;
    }
    return helper(anc,k1,0) + helper(anc,k2,0);
  }
  private TreeNode lca(TreeNode root, int k1, int k2) {
    if(root == null ||root.key == k1 || root.key == k2) {
      return root;
    }
    TreeNode left = lca(root.left, k1, k2);
    TreeNode right = lca(root.right, k1,k2);
    if(left != null && right != null) {
      return root;
    }
    return left != null? left : right;
  }
  private int helper(TreeNode root, int k, int level) {
    // didn't find it, return -1
    if(root == null) {
      return -1;
    }
    // find it, return level
    if(root.key == k) {
      return level;
    }
    int d = helper(root.left, k, level+1);
    // if find the target on the left subtree, just return
    if(d != -1) {
      return d;
    }
    // if not find the left, must be find in the right subtree
    return helper(root.right, k, level+1);
  }

}
