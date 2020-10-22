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
    // Write your solution here
    if(root == null){
      return null;
    }
    if(root.key > upper){
      return trimBST(root.left, lower, upper);
    }
    if(root.key < lower){
        return trimBST(root.right, lower, upper);
    }
    root.left = trimBST(root.left, lower, upper);
    root.right = trimBST(root.right, lower,upper);
    return root;
  }
}
