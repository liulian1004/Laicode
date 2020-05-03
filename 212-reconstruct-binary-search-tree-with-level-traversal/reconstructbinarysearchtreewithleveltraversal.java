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
  public TreeNode reconstruct(int[] level) {
    //T: O(n); S: O(n) -- upper bound
    //bfs
    if(level == null || level.length == 0) {
      return null;
    }
    int index = 0;
    TreeNode root = new TreeNode(level[index++]);
    Queue<Ele> queue = new ArrayDeque<>();
    queue.offer(new Ele(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    while(!queue.isEmpty()) {
      Ele cur = queue.poll();
      // if there is any node in the array we can append to the left child of current tree node
      if(index < level.length && level[index] > cur.min && level[index]< cur.node.key) {
            TreeNode left = new TreeNode(level[index++]);
            cur.node.left = left;
            queue.offer(new Ele(left, cur.min, cur.node.key));
      }
      // if there is any node in the array we can append to the right child of current tree node
      if(index < level.length && level[index] < cur.max && level[index] > cur.node.key) {
        TreeNode right = new TreeNode(level[index++]);
        cur.node.right = right;
        queue.offer(new Ele(right, cur.node.key, cur.max));
      }
    }
    return root;
  }
  static class Ele {
    TreeNode node;
    int min;
    int max;
    Ele(TreeNode node, int min, int max) {
      this.node = node;
      this.min = min;
      this.max = max;
    }

  }
}
