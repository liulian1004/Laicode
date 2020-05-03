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
  public List<Integer> inOrder(TreeNode root) {
    // T: O(n) S:O(h),最多为左边一条子树
    List<Integer> res = new ArrayList<>();
    if(root == null) {
      return res;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    while(cur !=null || !stack.isEmpty()) {
        if(cur != null) {
          stack.offerFirst(cur);
          cur = cur.left;
        } else {
          //cur == null
          cur = stack.pollFirst();
          res.add(cur.key);
          cur = cur.right;
        }
    }
    return res;
  }
}
