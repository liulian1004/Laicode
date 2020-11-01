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
    //这里的pre再返回给上一层的时候需要带着走，所以需要用array
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
    //一路走到最小的数
    helper(root.left, pre, wrong);
    //case： 6 2 3  1
    // pre = 6
    if(pre[0] != null && root.key <= pre[0].key){
        if(wrong[0] == null) {
          // wrong[6,2]
          wrong[1] = root;
          wrong[0] = pre[0];
        }else{
          // root走到1的时候还要update
          //这里最多需要replace两次，所以直接return即可
          wrong[1] = root;
          return;
        }
    }
    //把之前的数作为prev
    pre[0] = root;
    helper(root.right, pre, wrong);
  }
  private void swap(TreeNode[] pair){
    int temp = pair[0].key;
    pair[0].key = pair[1].key;
    pair[1].key = temp;
  }
}
