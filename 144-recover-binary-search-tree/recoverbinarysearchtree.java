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
  public TreeNode recover(TreeNode root) {
    // Write your solution here
    TreeNode[] wrong = new TreeNode[2];
    TreeNode[] pre = new TreeNode[1];
    helper(root, pre, wrong);
    TreeNode[] key = new TreeNode[]{root};
    swap(wrong);
    return root;
  }
  private void helper (TreeNode root, TreeNode[] pre, TreeNode[] wrong){
    if(root == null){
      return;
    }
    helper(root.left, pre, wrong);
    if(pre[0] != null && root.key <= pre[0].key){
        if(wrong[0] == null) {
          wrong[1] = root;
          wrong[0] = pre[0];
        }else{
          wrong[1] = root;
          return;
        }
    }
    pre[0] = root;
    helper(root.right, pre, wrong);
  }
  private void swap(TreeNode[] pair){
    int temp = pair[0].key;
    pair[0].key = pair[1].key;
    pair[1].key = temp;
  }
}
