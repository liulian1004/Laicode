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
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    // return the LCA of set that under the root
    // nodes - > set
    if(root == null || nodes == null) {
      return null;
    }
    // 直接把nodes传入set
    Set<TreeNode> set = new HashSet<>(nodes);
    return helper(root, set);
  }
  private TreeNode helper (TreeNode root, Set<TreeNode> set) {
    if(root == null) {
      return null;
    }
    if(set.contains(root)) {
      return root;
    }
    TreeNode leftLCA = helper(root.left, set);
    TreeNode rightLCA = helper(root.right, set);
    if(leftLCA != null && rightLCA != null) {
      return root;
    }
    return leftLCA == null? rightLCA : leftLCA;
  }


}
