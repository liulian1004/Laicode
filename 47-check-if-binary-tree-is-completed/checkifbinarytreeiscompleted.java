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
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if(cur.left == null) {
        res = true;
        //之前已经有null出现了，后面又出现node
      }else if(cur.left != null && res == true) {
        return false;
      } else {
       queue.offer(cur.left);
      }
      if(cur.right == null) {
        res = true;
        //以下这种写法也可以
      } else if(res == true) {
        return false;
      } else {
        queue.offer(cur.right);
      }
    }
    return res;
  }
}
