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
  public TreeNode toDoubleLinkedList(TreeNode root) {
    // Write your solution here.
    TreeNode[] pre = new TreeNode[1];
    TreeNode[] head = new TreeNode[1];
    helper(root, pre, head);
    return head[0];
  }
  private void helper(TreeNode root, TreeNode[] pre, TreeNode[] head){
    if(root == null){
      return;
    }
    helper(root.left, pre, head);
    if(pre[0] == null){
      head[0] = root;
    }else{
      //pre[0]是一个没有连到treenode的node，
      //需要先把treenode里面的curnode从原来的tree中断开，否则会有circular
      root.left = pre[0];
      pre[0].right = root;
    }
    pre[0] = root; //这里只是copy当前node到pre，原来的node还是在treenode中，结构没有被破坏
    helper(root.right, pre, head);
  }
}
