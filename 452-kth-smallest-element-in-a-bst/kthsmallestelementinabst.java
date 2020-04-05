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
  public int kthSmallest(TreeNode root, int k) {
    // T: O(k)
    //S: O(1)
    // Assumptuion :  1<= k <= nodes
    if(root == null) {
      return -1;
    }
    TreeNode pre = null;
    Deque<TreeNode> stack = new ArrayDeque<>();
    pushLeft(root, stack);
    while(k > 0) {
      TreeNode cur = stack.pollFirst();
      pre = cur;
      pushLeft(cur.right, stack);
      k--;
    }
    return pre.key;
  }
  private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
    while(root != null) {
      stack.offerFirst(root);
      root = root.left;
    }
  }
}
