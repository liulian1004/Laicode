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
  public int longestUnivaluePath(TreeNode root) {
    // T:O(n) S: o(h)
    if(root == null){
      return 0;
    }
    //min res = 1
    int[] res = new int[]{1};
    helper(root,res);
    return res[0];
  }
  private int helper(TreeNode root,int[] res){
    if(root == null || root.left == null && root.right == null ){
      return 1;
    }
    int left = helper(root.left,res);
    int right = helper(root.right,res);
    //左右node值与root相等
    if(root.left != null && root.right != null && root.key == root.left.key && root.key == root.right.key) {
      res[0] = Math.max(res[0], left+right+1);
      return Math.max(right,left)+1;
    }
    //右node值与root相等
    if(root.right != null && root.key == root.right.key){
        res[0] = Math.max(res[0],right+1);
        return right+1;
    }
    //左node的值与root相等
    if(root.left != null && root.key == root.left.key ){
        res[0] = Math.max(res[0], left+1);
        return left+1;
    }
    return 1;

  }
}
