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
  public List<List<Integer>> layerByLayer(TreeNode root) {
    // T: O(n) :  遍历这个tree
    //S: O(n) - wrose case O(1) - base case
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
      List<Integer> curLevel = new ArrayList<>();
      int size = queue.size();
      for(int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        curLevel.add(cur.key);
        if(cur.left != null) {
          queue.offer(cur.left);
        }
        if(cur.right != null) {
          queue.offer(cur.right);
        }
      }
      res.add(curLevel);
    }
    return res;
  }
}
