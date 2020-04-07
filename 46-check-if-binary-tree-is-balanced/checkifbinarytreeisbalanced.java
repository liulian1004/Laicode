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
  public boolean isBalanced(TreeNode root) {
    // 把boolean和heigth融合在一起
    // 1. expect from left/right child : the height or the  -1 if not balanced
    // 2. current layer, return -1 if either side is - 1 or the height different is bigger than -1
    //3. return to parent max(leftH, rightH) + 1 or -1 if not balance
   //T: O(n) S: O(h)
    int height = helper(root);
    if(height == -1) {
      return false;
    }
    return true;
  }
  private int helper(TreeNode root) {
      if(root == null) {
        return 0;
      }
      int leftH = helper(root.left);
      int rightH = helper(root.right);
      //leftH == -1 / rightH == -1 说明已经不balance了
      if(leftH == -1 || rightH == -1 || Math.abs(leftH-rightH) > 1) {
        //step 3 return -1 if not balanced
        return -1;
      }
      return Math.max(leftH, rightH) + 1;
  }
}
