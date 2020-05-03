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
  public TreeNode construct(int[] level) {
    // T: O(n) S: O(n)
    if(level == null || level.length == 0){
      return null;
    }
    int i = 0;
    TreeNode root = new TreeNode(level[i++]);
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while(i < level.length) {
        TreeNode cur = queue.poll();
        cur.left = new TreeNode(level[i++]);
        queue.offer(cur.left);
        if(i < level.length) {
          cur.right = new TreeNode(level[i++]);
          queue.offer(cur.right);
        }
    }
    return root;
  }
}
