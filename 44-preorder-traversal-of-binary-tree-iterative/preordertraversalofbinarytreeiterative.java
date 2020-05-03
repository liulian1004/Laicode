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
  public List<Integer> preOrder(TreeNode root) {
    // T： O(n);S: O(h)
    List<Integer> res = new ArrayList<>();
    if(root == null) {
      return res;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.offerFirst(root);
    while(!stack.isEmpty()) {
    TreeNode cur = stack.pollFirst();
    if(cur.right != null) {
    stack.offerFirst(cur.right);
    }
    if(cur.left != null) {
    stack.offerFirst(cur.left);
    }
    res.add(cur.key);
    }
    return res;
  }
}
