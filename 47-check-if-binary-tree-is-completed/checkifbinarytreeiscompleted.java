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
  public boolean isCompleted(TreeNode root) {
    // T： O(n)
    //S: o(n) - 最后一层节点数
    if(root == null) {
      return true;
    }
    boolean res = false;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if(cur.left == null) {
      flag = true;
      } else if(flag == false && cur.left != null) {
        queue.offer(cur.left);
      } else {
        return false;
      }
      if(cur.right == null ) {
        flag = true;
      } else if(flag == false && cur.right != null) {
        queue.offer(cur.right);
      } else  {
        return false;
      }
  }
    return res;
  }
}
