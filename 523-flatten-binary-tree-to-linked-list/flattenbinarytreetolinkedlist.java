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
  public TreeNode flatten(TreeNode root) {
    //T: O(n), S:O(h)
    // reverse pre-order
     //先右后左
    //from down to up
    TreeNode[] preRoot = new TreeNode[1];
    helper(root, preRoot);
    //直接返回root
    //就是在原本的root上操作
    return root;
  }
  private void helper(TreeNode root, TreeNode[] preRoot) {
     // post-order travsersal, 从 右开始往左扫
    // 最新进入treenode的是最右边的节点
    if(root == null) {
      return;
    }
    helper(root.right, newRoot);
    helper(root.left, newRoot);
    //最先poll出来的root的最右边的
    //root 左右两边接好
    root.left = null;
    root.right = preRoot[0];
    //跟新preRoot
    preRoot[0] = root;
  }
}
//preorder, from top to down
 private void helper(TreeNode root, TreeNode[] pre) {
   if(root == null) {
     return;
   }
   //这里要把left,right node先存下来
   //因为这里reconstrue之后，node.left会指向null, 丢失了原来的指向
   TreeNode left = root.left;
   TreeNode right = root.right;
   if(pre[0] != null){
     pre[0].right = root;
   }
   pre[0] = root;
   pre[0].left = null;
   helper(left, pre);
   helper(right, pre);

 }
