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
  public List<Integer> rightView(TreeNode root) {
    // T: O(n) S: O(n) → the last level of tree -> upper bound is n
    //scan right child, then scan left child
    List<Integer> list = new ArrayList<>();
    if(root == null) {
      return list;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
      TreeNode first = queue.peek();
      list.add(first.key);
      int size = queue.size();
      for(int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        if(cur.right != null) {
              queue.offer(cur.right);
        }
        if(cur.left != null) {
          queue.offer(cur.left);
        }
      }
    }
    return list;
  }
  //left view只要先traversal左边即可
}
