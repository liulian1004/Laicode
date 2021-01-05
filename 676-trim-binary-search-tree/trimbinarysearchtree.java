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
  public TreeNode trimBST(TreeNode root, int lower, int upper) {
    // 这里basecase里面不能写root < lower || root > upper
    // 需要走到底
    if(root == null){
      return null;
    }
    TreeNode left = trimBST(root.left, lower, upper);
    TreeNode right = trimBST(root.right, lower, upper);
    if(root.key < lower || root.key > upper){
      return left == null? right: left;
    }
    root.left = left;
    root.right = right;
    return root;
  }
}
