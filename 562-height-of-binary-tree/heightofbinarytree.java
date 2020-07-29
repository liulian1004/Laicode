public class Solution {
  public int getHeight(TreeNode root) {
    // Write your solution here
    if(root == null) {
      return 0;
    }
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
}
